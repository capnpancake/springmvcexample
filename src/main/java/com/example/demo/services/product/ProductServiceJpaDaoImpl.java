package com.example.demo.services.product;

import com.example.demo.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpa")
public class ProductServiceJpaDaoImpl implements ProductService {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public List<Product> listAll() {
        EntityManager em = emf.createEntityManager();
        List<Product> products = em.createQuery("from Product", Product.class).getResultList();
        em.close();
        return products;
    }

    @Override
    public Product getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Product product = em.find(Product.class, id);
        em.close();
        return product;
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Product savedProduct = em.merge(domainObject);
        em.getTransaction().commit();
        em.close();

        return savedProduct;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
        em.close();
    }
}
