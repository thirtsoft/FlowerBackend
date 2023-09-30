package com.flowers.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowers.controllers.AddressController;
import com.flowers.dtos.AddressDto;
import com.flowers.services.AddressService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static com.flowers.utils.Constants.APP_ROOT;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AddressController.class)
public class AddressControllerTest {

    @MockBean
    private AddressService addressService;

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private AddressController addressController;

    private AddressDto address;

    private List<AddressDto> addressList;


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    public void setup() {
        address = new AddressDto();
        address.setRue("SN");
        address.setZipcode("Dakar");
        address.setCity("SENEGAL");
        mockMvc = MockMvcBuilders.standaloneSetup(addressController).build();
    }

    @AfterEach
    void tearDown() {
        address = null;
    }

}
