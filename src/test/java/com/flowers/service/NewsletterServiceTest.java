package com.flowers.service;


import com.flowers.dtos.NewsletterDto;
import com.flowers.models.Newsletter;
import com.flowers.reposiory.NewsletterRepository;
import com.flowers.services.Impl.NewsletterServiceImpl;
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
public class NewsletterServiceTest {

    @InjectMocks
    private NewsletterServiceImpl newsletterService;

    @Mock
    private NewsletterRepository newsletterRepository;

    @Test
    public void should_save_one_newsletter() {
        Newsletter newsletter = new Newsletter();
        newsletter.setId(1L);
        newsletter.setCode("NEWS1");
        newsletter.setCustomerEmail("mail1@gmail.com");
        newsletter.setDateInscription(new Date());

        when(newsletterRepository.save(any(Newsletter.class))).thenReturn(newsletter);

        NewsletterDto newsletterDto = newsletterService.save(NewsletterDto.fromEntityToDto(new Newsletter()));

        Newsletter newsletterResult = NewsletterDto.fromDtoToEntity(newsletterDto);

        assertThat(newsletterResult).usingRecursiveComparison().isEqualTo(newsletter);
        verify(newsletterRepository, times(1)).save(any(Newsletter.class));
        verifyNoMoreInteractions(newsletterRepository);
    }

    @Test
    public void should_find_and_return_one_newsletter() {
        Newsletter newsletter = new Newsletter();
        newsletter.setId(2L);
        newsletter.setCode("NEWSById");
        newsletter.setCustomerEmail("mail2@gmail.com");
        newsletter.setDateInscription(new Date());

        when(newsletterRepository.findById(anyLong())).thenReturn(Optional.of(newsletter));

        NewsletterDto newsletterDtoResult = newsletterService.findById(anyLong());

        Newsletter newsletterResult = NewsletterDto.fromDtoToEntity(newsletterDtoResult);

        assertThat(newsletterResult).usingRecursiveComparison().isEqualTo(newsletter);
        verify(newsletterRepository, times(1)).findById(anyLong());
        verifyNoMoreInteractions(newsletterRepository);
    }

    @Test
    public void should_update_newsletter() {
        Newsletter newsletter = new Newsletter();
        newsletter.setId(3L);
        newsletter.setCode("NEWSUpdated");
        newsletter.setCustomerEmail("mail3@gmail.com");
        newsletter.setDateInscription(new Date());

        when(newsletterRepository.findById(anyLong())).thenReturn(Optional.of(newsletter));

        NewsletterDto newsletterDtoResult = newsletterService.findById(anyLong());
        newsletterDtoResult.setCode("Newsletter002");
        newsletterService.save(newsletterDtoResult);

        Newsletter newsletterResult = NewsletterDto.fromDtoToEntity(newsletterDtoResult);

        assertThat(newsletterResult).usingRecursiveComparison().isNotEqualTo(newsletter);
        assertThat(newsletterResult.getCode()).isEqualTo("Newsletter002");

    }


    @Test
    public void should_find_and_return_all_newsletters() {
        Newsletter newsletter = new Newsletter();
        newsletter.setId(4L);
        newsletter.setCode("NEWSAll");
        newsletter.setCustomerEmail("mail4@gmail.com");
        newsletter.setDateInscription(new Date());

        when(newsletterRepository.findAll()).thenReturn(singletonList(newsletter));

        List<NewsletterDto> newsletterList = newsletterService.findAll();

        assertThat(newsletterList).isNotNull();
        assertThat(newsletterList).hasSize(1);
        verify(newsletterRepository, times(1)).findAll();
        verifyNoMoreInteractions(newsletterRepository);
    }

    @Test
    public void should_find_and_return_all_newsletters_by_Id_desc() {
        Newsletter newsletter = new Newsletter();
        newsletter.setId(4L);
        newsletter.setCode("NEWSAll");
        newsletter.setCustomerEmail("mail4@gmail.com");
        newsletter.setDateInscription(new Date());

        when(newsletterRepository.findByOrderByIdDesc()).thenReturn(singletonList(newsletter));

        List<NewsletterDto> newsletterList = newsletterService.findByOrderByIdDesc();

        assertThat(newsletterList).isNotNull();
        assertThat(newsletterList).hasSize(1);
        verify(newsletterRepository, times(1)).findByOrderByIdDesc();
        verifyNoMoreInteractions(newsletterRepository);
    }

    @Test
    public void should_delete_one_newsletter() {
        doNothing().when(newsletterRepository).deleteById(anyLong());

        newsletterService.delete(anyLong());
        verify(newsletterRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(newsletterRepository);
    }


}
