package com.colak.springjparepositorytutorial.controller;

import com.colak.springjparepositorytutorial.dto.ProductResponse;
import com.colak.springjparepositorytutorial.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/products")

@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // http://localhost:8080/api/v1/products/getall?pageNo=1&pageSize=2&sortBy=id&sortDir=ASC
    @GetMapping(path = "getall")
    public ProductResponse getAllPost(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ) {
        return productService.getAllProducts(pageNo, pageSize, sortBy, sortDir);
    }
}
