package com.example.demo.controllers;

import com.example.demo.model.Customer;
import com.example.demo.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;

    @BeforeEach // (dep. @Before) -- called before each test
    // @BeforeAll (dep. @BeforeClass) -- called at class instantiation
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testList() throws Exception {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());

        when(customerService.listAll()).thenReturn((List) customers);

        mockMvc.perform(get("/customer/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/list"))
                .andExpect(model().attribute("customers", hasSize(2)));
    }

    @Test
    public void testShow() throws Exception{
        Integer id = 1;

        when(customerService.getById(id)).thenReturn(new Customer());

        mockMvc.perform(get("/customer/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/show"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void testEdit() throws Exception {
        Integer id = 1;

        when(customerService.getById(id)).thenReturn(new Customer());

        mockMvc.perform(get("/customer/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customerform"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void testNew() throws Exception{

        verifyNoInteractions(customerService);

        mockMvc.perform(get("/customer/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("customer/customerform"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)));
    }

    @Test
    public void testSaveOrUpdate() throws Exception{
        Integer id = 1;
        String fname = "andrew";
        String lname = "patrick";
        String email = "ap@test.com";
        String address1 = "123 test street";
        String address2 = "apt 100";
        String city = "town";
        String state = "georgia";
        String zip = "12345";

        Customer c = new Customer();
        c.setId(id);
        c.setFname(fname);
        c.setLname(lname);
        c.setEmail(email);
        c.setAddress1(address1);
        c.setAddress2(address2);
        c.setCity(city);
        c.setState(state);
        c.setZip(zip);

        when(customerService.saveOrUpdate(any())).thenReturn(c);

        mockMvc.perform(post("/customer")
        .param("id", "1")
        .param("fname", "andrew")
        .param("lname", "patrick")
        .param("email", "ap@test.com")
        .param("address1", "123 test street")
        .param("address2", "apt 100")
        .param("city", "town")
        .param("state", "georgia")
        .param("zip", "12345"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customer/show/1"))
                .andExpect(model().attribute("customer", instanceOf(Customer.class)))
                .andExpect(model().attribute("customer", hasProperty("id", is(id))))
                .andExpect(model().attribute("customer", hasProperty("fname", is(fname))))
                .andExpect(model().attribute("customer", hasProperty("lname", is(lname))))
                .andExpect(model().attribute("customer", hasProperty("email", is(email))))
                .andExpect(model().attribute("customer", hasProperty("address1", is(address1))))
                .andExpect(model().attribute("customer", hasProperty("address2", is(address2))))
                .andExpect(model().attribute("customer", hasProperty("city", is(city))))
                .andExpect(model().attribute("customer", hasProperty("state", is(state))))
                .andExpect(model().attribute("customer", hasProperty("zip", is(zip))));

        ArgumentCaptor<Customer> boundCustomer = ArgumentCaptor.forClass(Customer.class);
        verify(customerService).saveOrUpdate(boundCustomer.capture());

        assertEquals(id, boundCustomer.getValue().getId());
        assertEquals(fname, boundCustomer.getValue().getFname());
        assertEquals(lname, boundCustomer.getValue().getLname());
        assertEquals(email, boundCustomer.getValue().getEmail());
        assertEquals(address1, boundCustomer.getValue().getAddress1());
        assertEquals(address2, boundCustomer.getValue().getAddress2());
        assertEquals(city, boundCustomer.getValue().getCity());
        assertEquals(state, boundCustomer.getValue().getState());
        assertEquals(zip, boundCustomer.getValue().getZip());
    }

    @Test
    public void testDelete() throws Exception{
        Integer id = 1;

        mockMvc.perform(get("/customer/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/customer/list"));

        verify(customerService).delete(id);
    }
}
