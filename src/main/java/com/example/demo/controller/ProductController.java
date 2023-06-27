package com.example.demo.controller;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("reg-product")
    public void registerProduct(@RequestBody ProductRequest productRequest){

        productService.regiterProduct(productRequest);
    }

    @GetMapping("get-product/list")
    public List<ProductResponse> getProducts(){

       return productService.getProducts();
    }

    @GetMapping("get-product/{id}")
    public ProductResponse getProductById(@PathVariable Integer id){

        return productService.getProductById(id);
    }




}
