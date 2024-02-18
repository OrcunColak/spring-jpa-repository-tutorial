package com.colak.springjparepositorytutorial.repository;

import com.colak.springjparepositorytutorial.jpa.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
@Slf4j
class ProductRepositoryExistsTest {


    @Autowired
    private ProductRepository repository;

    @Test
    void testExists() {
        Assertions.assertTrue(repository.existsByName("Laptop"));
        Assertions.assertFalse(repository.existsByName("Laptopppp"));
    }

}
