package com.colak.springjparepositorytutorial.repository;

import com.colak.springjparepositorytutorial.jpa.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findProductsAbovePriceCustomMethod(int threshold) {
        return entityManager.createQuery("SELECT p FROM Product p WHERE p.price > :threshold", Product.class)
                .setParameter("threshold", threshold)
                .getResultList();
    }
}
