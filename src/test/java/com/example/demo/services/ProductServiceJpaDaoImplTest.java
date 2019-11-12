package com.example.demo.services;

import com.example.demo.config.JpaIntegrationConfig;
import com.example.demo.model.Product;
import com.example.demo.services.product.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JpaIntegrationConfig.class)
@ActiveProfiles("jpa")
public class ProductServiceJpaDaoImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void testList() throws Exception{
        List<Product> products = (List) productService.listAll();

        assert products.size() == 3;
    }

    @Test
    public void testFetch() throws Exception{
        Integer id = 1;
        Product product = productService.getById(id);
        assertEquals(product.getId(), id);
    }

    @Test
    public void testMerge() throws Exception{
        Product product = productService.saveOrUpdate(new Product());
        assertEquals(product, productService.getById(product.getId()));
    }
}
