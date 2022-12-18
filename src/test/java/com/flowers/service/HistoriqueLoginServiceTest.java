package com.flowers.service;


import com.flowers.dtos.HistoriqueLoginDto;
import com.flowers.models.HistoriqueLogin;
import com.flowers.models.Utilisateur;
import com.flowers.reposiory.HistoriqueLoginRepository;
import com.flowers.reposiory.UtilisateurRepository;
import com.flowers.services.Impl.HistoriqueLoginServiceImpl;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class HistoriqueLoginServiceTest {

    @InjectMocks
    private HistoriqueLoginServiceImpl historiqueLoginService;

    @Mock
    private HistoriqueLoginRepository historiqueLoginRepository;

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @Test
    public void should_save_one_historique_utilisateur() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setName("Tairou");
        utilisateur.setUsername("thir");
        utilisateur.setMobile("779440310");
        utilisateurRepository.save(utilisateur);

        HistoriqueLogin historiqueLogin = new HistoriqueLogin();
        historiqueLogin.setId(1L);
        historiqueLogin.setAction("AJOUT Utilisateur");
        historiqueLogin.setUtilisateur(utilisateur);
        historiqueLogin.setCreatedDate(new Date());

        when(historiqueLoginRepository.save(any(HistoriqueLogin.class))).thenReturn(historiqueLogin);

        HistoriqueLoginDto historiqueLoginDto = historiqueLoginService.saveHistoriqueLogin(HistoriqueLoginDto.fromEntityToDto(new HistoriqueLogin()));

        HistoriqueLogin historiqueLoginResult = HistoriqueLoginDto.fromDtoToEntity(historiqueLoginDto);

        assertThat(historiqueLoginResult).usingRecursiveComparison().isEqualTo(historiqueLogin);
        verify(historiqueLoginRepository, times(1)).save(any(HistoriqueLogin.class));
        verifyNoMoreInteractions(historiqueLoginRepository);
    }

    @Test
    public void should_find_and_return_one_historiqueLogin() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setName("Tairou");
        utilisateur.setUsername("thirByID");
        utilisateur.setMobile("7794740310");
        utilisateurRepository.save(utilisateur);

        HistoriqueLogin historiqueLogin = new HistoriqueLogin();
        historiqueLogin.setId(2L);
        historiqueLogin.setAction("AJOUT Utilisateur");
        historiqueLogin.setUtilisateur(utilisateur);
        historiqueLogin.setCreatedDate(new Date());
        when(historiqueLoginRepository.findById(anyLong())).thenReturn(Optional.of(historiqueLogin));

        HistoriqueLoginDto historiqueLoginDtoResult = historiqueLoginService.findHistoriqueLoginById(anyLong());

        HistoriqueLogin historiqueLoginResult = HistoriqueLoginDto.fromDtoToEntity(historiqueLoginDtoResult);

        assertThat(historiqueLoginResult).usingRecursiveComparison().isEqualTo(historiqueLogin);
        verify(historiqueLoginRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(historiqueLoginRepository);
    }

    @Test
    public void should_update_historiqueLogin() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setName("TairouUpdated");
        utilisateur.setUsername("thirUpdated");
        utilisateur.setMobile("77794740310");
        utilisateurRepository.save(utilisateur);

        HistoriqueLogin historiqueLogin = new HistoriqueLogin();
        historiqueLogin.setId(3L);
        historiqueLogin.setAction("AJOUT Utilisateur");
        historiqueLogin.setUtilisateur(utilisateur);
        historiqueLogin.setCreatedDate(new Date());

        when(historiqueLoginRepository.findById(anyLong())).thenReturn(Optional.of(historiqueLogin));

        HistoriqueLoginDto historiqueLoginDtoResult = historiqueLoginService.findHistoriqueLoginById(anyLong());
        historiqueLoginDtoResult.setAction("HistoriqueLogin002");
        historiqueLoginService.saveHistoriqueLogin(historiqueLoginDtoResult);

        HistoriqueLogin historiqueLoginResult = HistoriqueLoginDto.fromDtoToEntity(historiqueLoginDtoResult);

        assertThat(historiqueLoginResult).usingRecursiveComparison().isNotEqualTo(historiqueLogin);
        assertThat(historiqueLoginResult.getAction()).isEqualTo("HistoriqueLogin002");

    }


    @Test
    public void should_find_and_return_all_historiqueLogins() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setName("TairouAll");
        utilisateur.setUsername("thirAll");
        utilisateur.setMobile("779574740310");
        utilisateurRepository.save(utilisateur);

        HistoriqueLogin historiqueLogin = new HistoriqueLogin();
        historiqueLogin.setId(4L);
        historiqueLogin.setAction("AJOUT Utilisateur");
        historiqueLogin.setUtilisateur(utilisateur);
        historiqueLogin.setCreatedDate(new Date());

        when(historiqueLoginRepository.findAll()).thenReturn(singletonList(historiqueLogin));

        List<HistoriqueLoginDto> historiqueLoginList = historiqueLoginService.findAllHistoriqueLogins();

        assertThat(historiqueLoginList).isNotNull();
        assertThat(historiqueLoginList).hasSize(1);
        verify(historiqueLoginRepository, times(1)).findAll();
        verifyNoMoreInteractions(historiqueLoginRepository);
    }

    @Test
    public void should_find_and_return_all_historiqueLogin_by_Id_desc() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setName("TairouAllById");
        utilisateur.setUsername("thirAllById");
        utilisateur.setMobile("77957474031022");
        utilisateurRepository.save(utilisateur);

        HistoriqueLogin historiqueLogin = new HistoriqueLogin();
        historiqueLogin.setId(5L);
        historiqueLogin.setAction("AJOUT Utilisateur");
        historiqueLogin.setUtilisateur(utilisateur);
        historiqueLogin.setCreatedDate(new Date());

        when(historiqueLoginRepository.findByOrderByIdDesc()).thenReturn(singletonList(historiqueLogin));

        List<HistoriqueLoginDto> historiqueLoginList = historiqueLoginService.findAllHistoriqueLoginsOrderDesc();

        assertThat(historiqueLoginList).isNotNull();
        assertThat(historiqueLoginList).hasSize(1);
        verify(historiqueLoginRepository, times(1)).findByOrderByIdDesc();
        verifyNoMoreInteractions(historiqueLoginRepository);
    }

    @Test
    public void should_delete_one_historiqueLogin() {
        doNothing().when(historiqueLoginRepository).deleteById(anyLong());

        historiqueLoginService.deleteHistoriqueLogin(anyLong());
        verify(historiqueLoginRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(historiqueLoginRepository);
    }


}
