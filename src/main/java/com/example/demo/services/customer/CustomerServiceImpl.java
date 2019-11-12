package com.example.demo.services.customer;

import com.example.demo.model.Customer;
import com.example.demo.services.AbstractMapService;
import com.example.demo.services.customer.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    // inherits domainMap, listAll(), and delete()

    @Override
    public Customer getById(Integer id) { return (Customer) super.getById(id); }
    @Override
    public Customer saveOrUpdate(Customer domainObject) { return (Customer) super.saveOrUpdate(domainObject); }

}
