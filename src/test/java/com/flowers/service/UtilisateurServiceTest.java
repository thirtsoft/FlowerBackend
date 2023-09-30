package com.flowers.service;


import com.flowers.dtos.UtilisateurDto;
import com.flowers.models.Utilisateur;
import com.flowers.reposiory.UtilisateurRepository;
import com.flowers.services.Impl.UtilisateurServiceImpl;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class UtilisateurServiceTest {

    @InjectMocks
    private UtilisateurServiceImpl utilisateurService;

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @Test
    public void should_save_one_utilisateur() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(1L);
        utilisateur.setName("Tairou");
        utilisateur.setUsername("Zale");
        utilisateur.setMobile("58794632");

        when(utilisateurRepository.save(any(Utilisateur.class))).thenReturn(utilisateur);

        UtilisateurDto utilisateurDto = utilisateurService.saveUtilisateur(UtilisateurDto.fromEntityToDto(new Utilisateur()));

        Utilisateur utilisateurResult = UtilisateurDto.fromDtoToEntity(utilisateurDto);

        assertThat(utilisateurResult).usingRecursiveComparison().isEqualTo(utilisateur);
        verify(utilisateurRepository, times(1)).save(any(Utilisateur.class));
        verifyNoMoreInteractions(utilisateurRepository);
    }

    @Test
    public void should_find_and_return_one_utilisateur() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(2L);
        utilisateur.setName("TairouUser");
        utilisateur.setUsername("Zale1");
        utilisateur.setMobile("587946372");

        when(utilisateurRepository.findById(anyLong())).thenReturn(Optional.of(utilisateur));

        UtilisateurDto utilisateurDtoResult = utilisateurService.findUtilisateurById(anyLong());

        Utilisateur utilisateurResult = UtilisateurDto.fromDtoToEntity(utilisateurDtoResult);

        assertThat(utilisateurResult).usingRecursiveComparison().isEqualTo(utilisateur);
        verify(utilisateurRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(utilisateurRepository);
    }

    @Test
    public void should_update_utilisateur() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(3L);
        utilisateur.setName("TairouUserUp");
        utilisateur.setUsername("Zale2");
        utilisateur.setMobile("5879463872");

        when(utilisateurRepository.findById(anyLong())).thenReturn(Optional.of(utilisateur));

        UtilisateurDto utilisateurDtoResult = utilisateurService.findUtilisateurById(anyLong());
        utilisateurDtoResult.setName("Bignona");
        utilisateurService.saveUtilisateur(utilisateurDtoResult);

        Utilisateur utilisateurResult = UtilisateurDto.fromDtoToEntity(utilisateurDtoResult);

        assertThat(utilisateurResult).usingRecursiveComparison().isNotEqualTo(utilisateur);
        assertThat(utilisateurResult.getName()).isEqualTo("Bignona");

    }


    @Test
    public void should_find_and_return_all_utilisateurs() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(4L);
        utilisateur.setName("TairouUserAll");
        utilisateur.setUsername("Zale4");
        utilisateur.setMobile("58794638742");

        when(utilisateurRepository.findAll()).thenReturn(singletonList(utilisateur));

        List<UtilisateurDto> utilisateurList = utilisateurService.findAllActiveUtilisateurs();

        assertThat(utilisateurList).isNotNull();
        assertThat(utilisateurList).hasSize(1);
        verify(utilisateurRepository, times(1)).findAll();
        verifyNoMoreInteractions(utilisateurRepository);
    }

    @Test
    public void should_find_and_return_all_utilisateurs_by_Id_desc() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(5L);
        utilisateur.setName("TairouUserAllById");
        utilisateur.setUsername("Zale5");
        utilisateur.setMobile("587946308742");
        when(utilisateurRepository.findByOrderByIdDesc()).thenReturn(singletonList(utilisateur));

        List<UtilisateurDto> utilisateurList = utilisateurService.findAllActiveUtilisateurs();

        assertThat(utilisateurList).isNotNull();
        assertThat(utilisateurList).hasSize(1);
        verify(utilisateurRepository, times(1)).findByOrderByIdDesc();
        verifyNoMoreInteractions(utilisateurRepository);
    }

    @Test
    public void should_delete_one_utilisateur() {
        doNothing().when(utilisateurRepository).deleteById(anyLong());

        utilisateurService.deleteUtilisateur(anyLong());
        verify(utilisateurRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(utilisateurRepository);
    }


}
