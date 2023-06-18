package com.flowers.dtos;

import com.flowers.models.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {

    private Long id;

    private String customerName;

    private String recipient;

    private String subject;

    private String message;

    private Date createDate;

    private FournisseurDto fournisseurDto;

    private NewsletterDto newsletterDto;

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

    public static EmailDto fromEntityToDto(Email email) {
        if (email == null) {
            return null;
        }

        return EmailDto.builder()
                .id(email.getId())
                .customerName(email.getCustomerName())
                .recipient(email.getRecipient())
                .subject(email.getSubject())
                .message(email.getMessage())
                .createDate(email.getCreateDate())
                .actif(email.getActif())
                .fournisseurDto(FournisseurDto.fromEntityToDto(email.getFournisseur()))
                .newsletterDto(NewsletterDto.fromEntityToDto(email.getNewsletter()))
                .build();
    }

    public static Email fromDtoToEntity(EmailDto emailDto) {
        if (emailDto == null) {
            return null;
        }

        Email email = new Email();
        email.setId(emailDto.getId());
        email.setCustomerName(emailDto.getCustomerName());
        email.setRecipient(emailDto.getRecipient());
        email.setSubject(emailDto.getSubject());
        email.setMessage(emailDto.getMessage());
        email.setCreateDate(emailDto.getCreateDate());
        email.setActif(emailDto.isActif());
        email.setFournisseur(FournisseurDto.fromDtoToEntity(emailDto.getFournisseurDto()));
        email.setNewsletter(NewsletterDto.fromDtoToEntity(emailDto.getNewsletterDto()));
        return email;
    }
}
