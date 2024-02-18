package com.colak.springjparepositorytutorial.repository;

import com.colak.springjparepositorytutorial.jpa.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
@Slf4j
class ProductRepositoryPageTest {


    @Autowired
    private ProductRepository repository;

    @Test
    void testPaging() {
        int pageNumber = 0;
        int pageSize = 2;
        while (true) {
            Pageable pageable = PageRequest.of(
                    pageNumber,
                    pageSize,
                    Sort.by(Sort.Direction.ASC, "id")
            );

            Page<Product> page = repository.findAll(pageable);
            if (page.getNumberOfElements() == 0) {
                log.info("Page : {} has no elements", pageNumber);
                break;
            }
            log.info("Got page : {}", pageNumber);
            printPage(page);
            pageNumber++;
        }
    }

    private void printPage(Page<Product> page) {
        // Iterate over the products in the page
        for (Product product : page) {
            // Process each product as needed
            log.info("Product : {}", product);
        }
    }
}
