package com.flowers.dtos;

import com.flowers.models.Newsletter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
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
    @Email
    private String customerEmail;

    private Date dateInscription;

    private int actif;

    public void setActif(boolean actif) {
        if (actif == true)
            this.actif = 1;
        else
            this.actif = 0;
    }

    public boolean isActif() {
        if (actif == 1)
            return true;
        else
            return false;
    }

    public static NewsletterDto fromEntityToDto(Newsletter newsletter) {
        if (newsletter == null) {
            return null;
        }
        return NewsletterDto.builder()
                .id(newsletter.getId())
                .code(newsletter.getCode())
                .customerEmail(newsletter.getCustomerEmail())
                .dateInscription(newsletter.getDateInscription())
                .actif(newsletter.getActif())
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
        newsletter.setDateInscription(newsletterDto.getDateInscription());
        newsletter.setActif(newsletterDto.isActif());
        return newsletter;
    }
}
