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

    protected void loadDomainObjects(){
        domainMap = new HashMap<>();

        Product p1 = new Product();
        p1.setId(1);
        p1.setDescription("product 1");
        p1.setPrice(new BigDecimal("12.99"));
        p1.setImageUrl("http://example.com/p1");

        domainMap.put(1, p1);

        Product p2 = new Product();
        p2.setId(2);
        p2.setDescription("product 2");
        p2.setPrice(new BigDecimal("13.99"));
        p2.setImageUrl("http://example.com/p2");

        domainMap.put(2, p2);

        Product p3 = new Product();
        p3.setId(3);
        p3.setDescription("product 3");
        p3.setPrice(new BigDecimal("10.99"));
        p3.setImageUrl("http://example.com/p3");

        domainMap.put(3, p3);
    }
}
