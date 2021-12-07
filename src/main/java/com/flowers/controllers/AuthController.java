package com.flowers.controllers;

import com.flowers.controllers.api.AuthApi;
import com.flowers.enums.RoleName;
import com.flowers.exceptions.ResourceNotFoundException;
import com.flowers.message.request.LoginForm;
import com.flowers.message.request.SignUpForm;
import com.flowers.message.response.JwtsResponse;
import com.flowers.models.Role;
import com.flowers.models.Utilisateur;
import com.flowers.reposiory.RoleRepository;
import com.flowers.reposiory.UtilisateurRepository;
import com.flowers.security.jwt.JwtsProvider;
import com.flowers.security.services.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@Transactional
public class AuthController implements AuthApi {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtsProvider jwtsProvider;

    @Override
    public ResponseEntity<?> authenticateUser(LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtsProvider.generatedJwtToken(authentication);

        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        List<String> roles = userPrinciple.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(userPrinciple.getId());
        Utilisateur utilisateur = optionalUtilisateur.get();
    /*    UtilisateurDto utilisateurDto = UtilisateurDto.fromEntityToDto(utilisateur);
        HistoriqueLoginDto historiqueLoginDto = new HistoriqueLoginDto();
        historiqueLoginDto.setUtilisateurDto(utilisateurDto);
        historiqueLoginDto.setAction("Connection");
        historiqueLoginDto.setStatus("Valider");
        historiqueLoginDto.setCreatedDate(new Date());
        historiqueLoginService.saveHistoriqueLogin(historiqueLoginDto);*/

        return ResponseEntity.ok(new JwtsResponse(jwt,
                userPrinciple.getId(),
                userPrinciple.getUsername(),
                userPrinciple.getEmail(),
                roles));
    }

    @Override
    public ResponseEntity<?> signUp(SignUpForm signUpForm) {
        if (utilisateurRepository.existsByUsername(signUpForm.getUsername())) {
            throw new ResourceNotFoundException("Fail -> Error: Username is already taken!");
        }
        if (utilisateurRepository.existsByEmail(signUpForm.getEmail())) {
            throw new ResourceNotFoundException("Error: Email is already in use!");
        }

        // Create new user's account
        Utilisateur utilisateur = new Utilisateur(
                signUpForm.getName(),
                signUpForm.getUsername(),
                signUpForm.getEmail(),
                encoder.encode(signUpForm.getPassword()
                )
        );

        String[] strRoles = signUpForm.getRoles();
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

                case "user":
                    roles.add(roleRepository.findByName(RoleName.ROLE_USER).get());
                    break;

                default:
                    roles.add(roleRepository.findByName(RoleName.ROLE_USER).get());
                    //    return ResponseEntity.badRequest().body("Specified role not found");

            }
        }

        utilisateur.setRoles(roles);
        return ResponseEntity.ok(utilisateurRepository.save(utilisateur));
    }

    @Override
    public ResponseEntity<?> registerUser(SignUpForm signUpForm) {
        if (utilisateurRepository.existsByUsername(signUpForm.getUsername())) {
            throw new ResourceNotFoundException("Fail -> Error: Username is already taken!");
        }
        if (utilisateurRepository.existsByEmail(signUpForm.getEmail())) {
            throw new ResourceNotFoundException("Error: Email is already in use!");
        }
        // Create new user's account
        Utilisateur utilisateur = new Utilisateur(
                signUpForm.getUsername(),
                signUpForm.getEmail(),
                encoder.encode(signUpForm.getPassword()
                )
        );
        String[] strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            roles.add(roleRepository.findByName(RoleName.ROLE_USER).get());
        }

        for (String role : strRoles) {
            switch (role.toLowerCase()) {
                case "admin":
                    roles.add(roleRepository.findByName(RoleName.ROLE_ADMIN).get());
                    break;

                case "manager":
                    roles.add(roleRepository.findByName(RoleName.ROLE_MANAGER).get());
                    break;

                case "user":
                    roles.add(roleRepository.findByName(RoleName.ROLE_USER).get());
                    break;

                default:
                    return ResponseEntity.badRequest().body("Specified role not found");

            }
        }

        utilisateur.setRoles(roles);
        return ResponseEntity.ok(utilisateurRepository.save(utilisateur));
    }

    @Override
    public String getcurrentUserName(Principal principal) {
        return null;
    }

    @Override
    public String getcurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        System.out.println("CurrentUser " + currentUserName);
        return currentUserName;
    }


}
