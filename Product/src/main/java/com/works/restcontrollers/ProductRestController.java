package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductRestController {

    final ProductService productService;
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("save")
    public Product save(@Valid @RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping("saveAll")
    public List<Product> saveAll(@Valid @RequestBody List<Product> products) {
        return productService.saveAll(products);
    }

    @GetMapping("list")
    public Page<Product> list(@RequestParam(defaultValue = "0") int pageNumber) {
        return productService.findAll(pageNumber);
    }

    @GetMapping("search")
    public Page<Product> search(
            @RequestParam(defaultValue = "") String q,
            @RequestParam(defaultValue = "0") int pageNumber
    ) {
        return productService.search(q, pageNumber);
    }

}
