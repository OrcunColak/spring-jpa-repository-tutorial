package com.colak.springjparepositorytutorial.service;

import com.colak.springjparepositorytutorial.dto.ProductDto;
import com.colak.springjparepositorytutorial.dto.ProductResponse;
import com.colak.springjparepositorytutorial.jpa.Product;
import com.colak.springjparepositorytutorial.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    // Pagination and sorting example
    public ProductResponse getAllProducts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> page = repository.findAll(pageable);

        List<Product> productList = page.getContent();

        List<ProductDto> productDtoList = productList.stream()
                .map(ProductDto::new)
                .toList();

        ProductResponse postResponse = new ProductResponse();
        postResponse.setContent(productDtoList);
        postResponse.setPageNo(page.getNumber());
        postResponse.setPageSize(page.getSize());
        postResponse.setTotalElements(page.getTotalElements());
        postResponse.setTotalPages(page.getTotalPages());
        postResponse.setLast(page.isLast());
        return postResponse;

    }
}
