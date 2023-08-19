package com.mc.micro.controller;

import com.mc.micro.model.Product;
import com.mc.micro.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> listarProducto(){
        return productRepository.findAll();
    }
    /*
    @GetMapping
    public ResponseEntity<List<Product>>  listarProducto(){
        List<Product> products = productRepository.findAll();
        ResponseEntity<List<Product>> responseEntity= new ResponseEntity<>(products,HttpStatus.OK);
        return responseEntity;
    }
    * */
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void crearProducto(@RequestBody Product product){
        productRepository.save(product);
    }
}
