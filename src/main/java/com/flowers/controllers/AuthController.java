package com.flowers.controllers;

import com.flowers.controllers.api.AuthApi;
import com.flowers.dtos.HistoriqueLoginDto;
import com.flowers.dtos.UtilisateurDto;
import com.flowers.enums.RoleName;
import com.flowers.message.request.LoginForm;
import com.flowers.message.request.SignUpForm;
import com.flowers.message.response.JwtResponse;
import com.flowers.message.response.ResponseMessage;
import com.flowers.models.Role;
import com.flowers.models.Utilisateur;
import com.flowers.reposiory.RoleRepository;
import com.flowers.reposiory.UtilisateurRepository;
import com.flowers.security.jwt.JwtsProvider;
import com.flowers.security.services.UserPrinciple;
import com.flowers.services.HistoriqueLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"https://fleurpourtous.com", "https://portail.fleurpourtous.com"})
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthController implements AuthApi {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UtilisateurRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtsProvider jwtProvider;
    @Autowired
    private HistoriqueLoginService historiqueLoginService;


    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generatedJwtToken(authentication);
        //    UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        UserPrinciple userDetails = (UserPrinciple) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        Optional<Utilisateur> optionalUtilisateur = userRepository.findById(userDetails.getId());
        Utilisateur utilisateur = optionalUtilisateur.get();
        UtilisateurDto utilisateurDto = UtilisateurDto.fromEntityToDto(utilisateur);
        HistoriqueLoginDto historiqueLogin = new HistoriqueLoginDto();
        historiqueLogin.setUtilisateurDto(utilisateurDto);
        historiqueLogin.setAction("SE CONNECTER");
        historiqueLogin.setCreatedDate(new Date());
        historiqueLoginService.saveHistoriqueLogin(historiqueLogin);

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    public ResponseEntity<?> signUp(SignUpForm signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Utilisateur user = new Utilisateur(signUpRequest.getName(),
                signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        // Set<String> strRoles = signUpRequest.getRole();
        String[] strRoles = signUpRequest.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = (roleRepository.findByName(RoleName.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found.")));
            roles.add(userRole);

        }

        for (String role : strRoles) {
            switch (role.toLowerCase()) {
                case "admin":
                    roles.add(roleRepository.findByName(RoleName.ROLE_ADMIN).get());
                    break;

                case "manager":
                    roles.add(roleRepository.findByName(RoleName.ROLE_MANAGER).get());
                    break;

                case "vendor":
                    roles.add(roleRepository.findByName(RoleName.ROLE_VENDOR).get());
                    break;

                case "user":
                    roles.add(roleRepository.findByName(RoleName.ROLE_USER).get());
                    break;

                default:
                    roles.add(roleRepository.findByName(RoleName.ROLE_USER).get());
            }
        }

        user.setRoles(roles);
        user.setActive(true);
        user.setCreatedDate(new Date());

        userRepository.save(user);

        return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<?> registerUser(SignUpForm signUpForm) {
        return null;
    }

    @Override
    public String getcurrentUserName(Principal principal) {
        return null;
    }

    @Override
    public String getcurrentUser() {
        return null;
    }

    public Optional<Utilisateur> getUserByUsername(@PathVariable("username") String username) {
        return userRepository.findByUsername(username);
    }

}
