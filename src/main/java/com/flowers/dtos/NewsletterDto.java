package com.flowers.dtos;

import com.flowers.models.Newsletter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsletterDto {

    private Long id;

    private String code;

    @NotNull
    private String customerEmail;

    private String subject;

    private String message;

    private Date dateInscription;

    public static NewsletterDto fromEntityToDto(Newsletter newsletter) {
        if (newsletter == null) {
            return null;
        }
        return NewsletterDto.builder()
                .id(newsletter.getId())
                .code(newsletter.getCode())
                .customerEmail(newsletter.getCustomerEmail())
                .subject(newsletter.getSubject())
                .message(newsletter.getMessage())
                .dateInscription(newsletter.getDateInscription())
                .build();
    }

    public static Newsletter fromDtoToEntity(NewsletterDto newsletterDto) {
        if (newsletterDto == null) {
            return null;
        }

        Newsletter newsletter = new Newsletter();
        newsletter.setId(newsletterDto.getId());
        newsletter.setCode(newsletterDto.getCode());
        newsletter.setCustomerEmail(newsletterDto.getCustomerEmail());
        newsletter.setSubject(newsletterDto.getSubject());
        newsletter.setMessage(newsletterDto.getMessage());
        newsletter.setDateInscription(newsletterDto.getDateInscription());

        return newsletter;
    }
}
