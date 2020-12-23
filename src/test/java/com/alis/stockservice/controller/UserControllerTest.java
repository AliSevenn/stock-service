package com.alis.stockservice.controller;

import com.alis.stockservice.TestMain;
import com.alis.stockservice.entity.*;
import com.alis.stockservice.model.request.UserSaveRequest;
import com.alis.stockservice.service.AddressService;
import com.alis.stockservice.service.RegionService;
import com.alis.stockservice.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = TestMain.class)
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
public class UserControllerTest {
    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;
    @Autowired
    RegionService regionService;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Test Save User SuccessFully")
    void testSaveUserSuccessFully() throws JsonProcessingException, Exception {

        RegionEntity region = new RegionEntity();
        region.setName("kadikoy");
        region.setPostalCode(3400);
        region.setRegionType(RegionType.CITY);
        region = regionService.save(region);

        AddressEntity address = new AddressEntity();
        address.setCountry("izmir");
        address.setDescription("nees");
        address.setRegion(region);
        address = addressService.save(address);

        UserEntity user = new UserEntity();
        user.setAddress(address);
        user.setName("Ali");
        user.setPassword("1234");
        user.setPhoneNumber(5446223539l);
        user.setPhoneCode("+90");
        user.setRoles(Set.of("update-roles"));
        user.setUserType(UserType.CUSTOMER);
        user.setModifyUser("adadsa");
        user.setModifyTime(LocalDateTime.now());

        user = userService.save(user);

        var query = new UserSaveRequest(user.getName(), user.getPassword(), user.getPhoneNumber(), user.getPhoneCode(),
                UserType.CUSTOMER.toString());

        mockMvc.perform(
                post("/user/register").contentType("application/json").content(objectMapper.writeValueAsString(query)))
                .andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("Ali"));
    }


}
