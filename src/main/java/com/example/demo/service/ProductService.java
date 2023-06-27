package com.example.demo.service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public void regiterProduct(ProductRequest productRequest) {
        Product product=new Product();
        product.setQuantity(productRequest.getQuantity());
        product.setProductName(productRequest.getProductName());
        productRepository.save(product);
    }


    public List<ProductResponse> getProducts() {

        List<Product> productEntityList=productRepository.findAll();
        List<ProductResponse> productResponseList=new ArrayList<>();

        for(int i=0;i<productEntityList.size();i++ ){
            ProductResponse productResponse=new ProductResponse();
            productResponse.setProductNo(productEntityList.get(i).getProductNo());
            productResponse.setProductName(productEntityList.get(i).getProductName());
            productResponse.setQuantity(productEntityList.get(i).getQuantity());
            productResponseList.add(productResponse);
        }

       return productResponseList;
    }

    public ProductResponse getProductById(Integer id) {
        Product productEntity=productRepository.findById(id).get();
        ProductResponse productResponse=new ProductResponse();
        productResponse.setProductNo(productEntity.getProductNo());
        productResponse.setQuantity(productEntity.getQuantity());
        productResponse.setProductName(productEntity.getProductName());

        return productResponse;
    }
}
