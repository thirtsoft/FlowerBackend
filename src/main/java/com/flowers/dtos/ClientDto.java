package com.flowers.dtos;

import com.flowers.models.Client;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
public class ClientDto {

    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String email;

    @NotNull
    private String mobile;

    public ClientDto(Long id, String firstName,
                     String lastName, String email, String mobile) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
    }

    public static ClientDto fromEntityToDto(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .email(client.getEmail())
                .mobile(client.getMobile())
                .build();
    }

    public static Client fromDtoToEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
        }

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setEmail(clientDto.getEmail());
        client.setMobile(clientDto.getMobile());

        return client;
    }

}
