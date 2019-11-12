package com.example.demo.bootstrap;

import com.example.demo.model.Customer;
import com.example.demo.model.Product;
import com.example.demo.services.customer.CustomerService;
import com.example.demo.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SpringJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ProductService productService;
    @Autowired
    private CustomerService customerService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
        loadCustomers();
    }

    public void loadProducts(){
        Product p1 = new Product();
        p1.setId(1);
        p1.setDescription("product 1");
        p1.setPrice(new BigDecimal("12.99"));
        p1.setImageUrl("http://example.com/p1");
        productService.saveOrUpdate(p1);

        Product p2 = new Product();
        p2.setId(2);
        p2.setDescription("product 2");
        p2.setPrice(new BigDecimal("13.99"));
        p2.setImageUrl("http://example.com/p2");
        productService.saveOrUpdate(p2);

        Product p3 = new Product();
        p3.setId(3);
        p3.setDescription("product 3");
        p3.setPrice(new BigDecimal("10.99"));
        p3.setImageUrl("http://example.com/p3");
        productService.saveOrUpdate(p3);
    }


    public void loadCustomers(){
        Customer c1 = new Customer();
        c1.setId(1);
        c1.setFname("Andrew");
        c1.setLname("Patrick");
        c1.setEmail("apatrick@email.com");
        c1.setAddress1("366 Old Mill Rd");
        c1.setAddress2("Apt 908");
        c1.setCity("Cartersville");
        c1.setState("Georgia");
        c1.setZip("30120");
        customerService.saveOrUpdate(c1);

        Customer c2 = new Customer();
        c2.setId(2);
        c2.setFname("Ericka");
        c2.setLname("Patrick");
        c2.setEmail("epatrick@email.com");
        c2.setAddress1("366 Old Mill Rd");
        c2.setAddress2("Apt 908");
        c2.setCity("Cartersville");
        c2.setState("Georgia");
        c2.setZip("30120");
        customerService.saveOrUpdate(c2);

        Customer c3 = new Customer();
        c3.setId(3);
        c3.setFname("Julian");
        c3.setLname("Murillo");
        c3.setEmail("jmurillo@email.com");
        c3.setAddress1("123 Sesame St");
        c3.setAddress2("Apt 456");
        c3.setCity("Lawrenceville");
        c3.setState("Georgia");
        c3.setZip("30043");
        customerService.saveOrUpdate(c3);
    }

}
