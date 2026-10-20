package com.internship.shoplite.controller;
import com.internship.shoplite.dto.CheckoutRequest;import com.internship.shoplite.model.CustomerOrder;import com.internship.shoplite.service.ShopService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;import java.util.List;
@RestController @RequestMapping("/api/orders") public class OrderController {private final ShopService service;public OrderController(ShopService s){service=s;}
@PostMapping public CustomerOrder checkout(@Valid @RequestBody CheckoutRequest req){return service.checkout(req);}@GetMapping public List<CustomerOrder> list(){return service.getOrders();}@GetMapping("/{id}") public CustomerOrder get(@PathVariable Long id){return service.getOrder(id);}}
