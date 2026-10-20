package com.internship.shoplite.controller;
import com.internship.shoplite.model.Product; import com.internship.shoplite.repository.ProductRepository; import com.internship.shoplite.service.ShopService; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/api/products") public class ProductController {private final ShopService service;private final ProductRepository repo;public ProductController(ShopService s,ProductRepository r){service=s;repo=r;}
@GetMapping public List<Product> list(@RequestParam(required=false) String search){return service.getProducts(search);}
@GetMapping("/{id}") public Product get(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new IllegalArgumentException("Product not found: "+id));}}
