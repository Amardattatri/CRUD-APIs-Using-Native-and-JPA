package com.carelon.managment.controller;

import com.carelon.managment.entity.EmployeeInfoEntity;
import com.carelon.managment.repository.EmployeeRepository;
import com.carelon.managment.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles
class EmployeeControllerTest {

    MockMvc mvc;
    @Value("${server.servlet.context-path}")
    String contextPath;

    @Autowired
    MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private EmployeeController employeeController;

    @Autowired
    private EmployeeRepository employeeRepository;

    @MockBean
    EmployeeService employeeService;

    @BeforeEach
    void setup() {
        initializeMvc();
    }

    void initializeMvc() {
        this.mvc = MockMvcBuilders.standaloneSetup(employeeController)
                .setMessageConverters(mappingJackson2HttpMessageConverter)
                .build();
    }

    @Test
    @Disabled
    void testCreateEmployeeInfo() {
    }

    @Test
    void testGetEmployeeInfoUseId() throws Exception {
        EmployeeInfoEntity eIe=new EmployeeInfoEntity();
        eIe.setFirstName("Amar");
        eIe.setAge(22);
        eIe.setdOb("22/05/2001");
        eIe.setEmpId(1);

        Mockito.when(employeeService.getEmployeeById(eIe.getEmpId())).thenReturn(eIe);

        this.mvc.perform(MockMvcRequestBuilders.get(contextPath+"/api"+"/use-jpa/employee-details" +"/1")
                .contextPath(contextPath)
                .contentType(MediaType.APPLICATION_JSON).accept(APPLICATION_JSON)).andExpect(status().isOk()
        );
    }

    @Test
    @Disabled
    void updateEmployeeInfoName() {
    }

    @Test
    @Disabled
    void deleteEmployeeInfo() {
    }
}