package com.flowers.service;


import com.flowers.dtos.FournisseurDto;
import com.flowers.models.Fournisseur;
import com.flowers.reposiory.FournisseurRepository;
import com.flowers.services.Impl.FournisseurServiceImpl;
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
public class FournisseurServiceTest {

    @InjectMocks
    private FournisseurServiceImpl fournisseurService;

    @Mock
    private FournisseurRepository fournisseurRepository;

    @Test
    public void should_save_one_fournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(1L);
        fournisseur.setFirstName("Tairou");
        fournisseur.setLastName("Diallo");
        fournisseur.setReference("FORU01");

        when(fournisseurRepository.save(any(Fournisseur.class))).thenReturn(fournisseur);

        FournisseurDto fournisseurDto = fournisseurService.saveFournisseur(FournisseurDto.fromEntityToDto(new Fournisseur()));

        Fournisseur fournisseurResult = FournisseurDto.fromDtoToEntity(fournisseurDto);

        assertThat(fournisseurResult).usingRecursiveComparison().isEqualTo(fournisseur);
        verify(fournisseurRepository, times(1)).save(any(Fournisseur.class));
        verifyNoMoreInteractions(fournisseurRepository);
    }

    @Test
    public void should_find_and_return_one_fournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(2L);
        fournisseur.setFirstName("TairouByID");
        fournisseur.setLastName("DialloById");
        fournisseur.setReference("FOURById");

        when(fournisseurRepository.findById(anyLong())).thenReturn(Optional.of(fournisseur));

        FournisseurDto fournisseurDtoResult = fournisseurService.findFournisseurById(anyLong());

        Fournisseur fournisseurResult = FournisseurDto.fromDtoToEntity(fournisseurDtoResult);

        assertThat(fournisseurResult).usingRecursiveComparison().isEqualTo(fournisseur);
        verify(fournisseurRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(fournisseurRepository);
    }

    @Test
    public void should_update_fournisseur() {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(3L);
        fournisseur.setFirstName("TairouUpdate");
        fournisseur.setLastName("DialloUpdate");
        fournisseur.setReference("FOURUpdate");

        when(fournisseurRepository.findById(anyLong())).thenReturn(Optional.of(fournisseur));

        FournisseurDto fournisseurDtoResult = fournisseurService.findFournisseurById(anyLong());
        fournisseurDtoResult.setReference("Fournisseur002");
        fournisseurService.saveFournisseur(fournisseurDtoResult);

        Fournisseur fournisseurResult = FournisseurDto.fromDtoToEntity(fournisseurDtoResult);

        assertThat(fournisseurResult).usingRecursiveComparison().isNotEqualTo(fournisseur);
        assertThat(fournisseurResult.getReference()).isEqualTo("Fournisseur002");

    }


    @Test
    public void should_find_and_return_all_fournisseurs() {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(4L);
        fournisseur.setFirstName("TairouAll");
        fournisseur.setLastName("DialloAll");
        fournisseur.setReference("FOURAll");

        when(fournisseurRepository.findAll()).thenReturn(singletonList(fournisseur));

        List<FournisseurDto> fournisseurList = fournisseurService.findAllFournisseurs();

        assertThat(fournisseurList).isNotNull();
        assertThat(fournisseurList).hasSize(1);
        verify(fournisseurRepository, times(1)).findAll();
        verifyNoMoreInteractions(fournisseurRepository);
    }

    @Test
    public void should_find_and_return_all_countries_by_Id_desc() {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(5L);
        fournisseur.setFirstName("TairouAllById");
        fournisseur.setLastName("DialloAllById");
        fournisseur.setReference("FOURAllById");

        when(fournisseurRepository.findByOrderByIdDesc()).thenReturn(singletonList(fournisseur));

        List<FournisseurDto> fournisseurList = fournisseurService.findFournisseurByOrderByIdDesc();

        assertThat(fournisseurList).isNotNull();
        assertThat(fournisseurList).hasSize(1);
        verify(fournisseurRepository, times(1)).findByOrderByIdDesc();
        verifyNoMoreInteractions(fournisseurRepository);
    }

    @Test
    public void should_delete_one_fournisseur() {
        doNothing().when(fournisseurRepository).deleteById(anyLong());

        fournisseurService.deleteFournisseur(anyLong());
        verify(fournisseurRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(fournisseurRepository);
    }


}
