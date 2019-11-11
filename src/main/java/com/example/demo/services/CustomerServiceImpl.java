package com.example.demo.services;

import com.example.demo.model.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl extends AbstractMapService implements CustomerService{

    // inherits domainMap, listAll(), and delete()

    @Override
    public Customer getById(Integer id) { return (Customer) super.getById(id); }
    @Override
    public Customer saveOrUpdate(Customer domainObject) { return (Customer) super.saveOrUpdate(domainObject); }

    protected void loadDomainObjects(){
        domainMap = new HashMap<>();

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
        domainMap.put(1, c1);

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
        domainMap.put(2, c2);

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
        domainMap.put(3, c3);
    }
}
