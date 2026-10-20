package com.internship.shoplite.service;
import com.internship.shoplite.dto.CheckoutRequest; import com.internship.shoplite.model.*; import com.internship.shoplite.repository.*; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional; import java.math.BigDecimal; import java.util.List;
@Service public class ShopService {
 private final ProductRepository products; private final CustomerOrderRepository orders;
 public ShopService(ProductRepository p,CustomerOrderRepository o){products=p;orders=o;}
 public List<Product> getProducts(String search){return search==null||search.isBlank()?products.findAll():products.findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(search,search);}
 @Transactional public CustomerOrder checkout(CheckoutRequest req){CustomerOrder order=new CustomerOrder();order.setCustomerName(req.customerName().trim());order.setCustomerEmail(req.customerEmail().trim());order.setPaymentStatus("SIMULATED_SUCCESS");order.setOrderStatus("CONFIRMED");BigDecimal total=BigDecimal.ZERO;
 for(CheckoutRequest.Item item:req.items()){Product p=products.findById(item.productId()).orElseThrow(()->new IllegalArgumentException("Product not found: "+item.productId()));int q=item.quantity();if(p.getStock()<q)throw new IllegalArgumentException("Insufficient stock for "+p.getName());BigDecimal line=p.getPrice().multiply(BigDecimal.valueOf(q));total=total.add(line);p.setStock(p.getStock()-q);products.save(p);order.addItem(new OrderItem(p.getId(),p.getName(),q,p.getPrice(),line));}order.setTotalAmount(total);return orders.save(order);}
 public List<CustomerOrder> getOrders(){return orders.findAllByOrderByCreatedAtDesc();} public CustomerOrder getOrder(Long id){return orders.findById(id).orElseThrow(()->new IllegalArgumentException("Order not found: "+id));}
}
