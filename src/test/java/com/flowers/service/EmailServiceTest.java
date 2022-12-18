package com.flowers.service;


import com.flowers.dtos.EmailDto;
import com.flowers.models.Email;
import com.flowers.reposiory.EmailRepository;
import com.flowers.reposiory.EmailRepository;
import com.flowers.services.Impl.EmailServiceImpl;
import com.flowers.services.Impl.EmailServiceImpl;
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
public class EmailServiceTest {

    @InjectMocks
    private EmailServiceImpl emailService;

    @Mock
    private EmailRepository emailRepository;

    @Test
    public void should_send_email_to_manager() {
        return;
    }

    @Test
    public void should_find_and_return_one_Email() {
        return;
    }

    @Test
    public void should_update_Email() {
        return;
    }


    @Test
    public void should_find_and_return_all_countries() {
        return;
    }

    @Test
    public void should_find_and_return_all_countries_by_Id_desc() {
        return;
    }

    @Test
    public void should_delete_one_Email() {
        return;
    }


}
