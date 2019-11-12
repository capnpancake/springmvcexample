package com.example.demo.services.product;

import com.example.demo.model.Product;
import com.example.demo.services.AbstractMapService;
import com.example.demo.services.product.ProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@Profile("map")
public class ProductServiceImpl extends AbstractMapService implements ProductService {

    // inherits domainMap, listAll(), and delete()

    @Override
    public Product getById(Integer id) { return (Product) super.getById(id); }
    @Override
    public Product saveOrUpdate(Product domainObject) { return (Product) super.saveOrUpdate(domainObject); }

}
