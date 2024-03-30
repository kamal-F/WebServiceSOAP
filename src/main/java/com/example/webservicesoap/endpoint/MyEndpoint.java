package com.example.webservicesoap.endpoint;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.webservicesoap.model.Product;
import com.example.webservicesoap.repository.ProductRepository;


import com.example.demo.GetAllProductsRequest;
import com.example.demo.GetAllProductsResponse;
import com.example.demo.MyRequest;
import com.example.demo.MyResponse;


//digenerate jaxb

@Endpoint
public class MyEndpoint {
    
    @Autowired
    private ProductRepository productRepository;

    @PayloadRoot(namespace = "http://example.com/demo", localPart = "MyRequest")
    @ResponsePayload
    public MyResponse myMethod(@RequestPayload MyRequest request) {
        MyResponse response = new MyResponse();
        response.setResponseMessage("This is a response to: " + request.getRequestMessage());
        return response;
    } 

    @PayloadRoot(namespace = "http://example.com/demo", localPart = "GetAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request) {
        GetAllProductsResponse response = new GetAllProductsResponse();
        List<Product> products = productRepository.findAll();
        List<com.example.demo.Product> responseProducts = new ArrayList<>();
        for (Product product : products) {
            com.example.demo.Product responseProduct = new com.example.demo.Product();
            responseProduct.setId(product.getId());
            responseProduct.setName(product.getName());
            responseProduct.setPrice(product.getPrice());
            responseProducts.add(responseProduct);
           // System.out.println("Product: " + product.getName());
            
        }
        response.getProduct().addAll(responseProducts);
        





        return response;
    }
      
}

