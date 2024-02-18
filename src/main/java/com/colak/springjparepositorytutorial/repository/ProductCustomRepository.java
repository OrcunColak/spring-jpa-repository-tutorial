package com.colak.springjparepositorytutorial.repository;

import com.colak.springjparepositorytutorial.jpa.Product;

import java.util.List;

public interface ProductCustomRepository {

    List<Product> findProductsAbovePriceCustomMethod(int threshold);
}
