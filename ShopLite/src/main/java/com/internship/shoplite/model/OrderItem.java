package com.internship.shoplite.model;
import com.fasterxml.jackson.annotation.JsonIgnore; import jakarta.persistence.*; import java.math.BigDecimal;
@Entity @Table(name="order_items")
public class OrderItem {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(fetch=FetchType.LAZY,optional=false) @JoinColumn(name="order_id",nullable=false) @JsonIgnore private CustomerOrder order;
 @Column(nullable=false) private Long productId; @Column(nullable=false,length=120) private String productName; @Column(nullable=false) private Integer quantity;
 @Column(nullable=false,precision=10,scale=2) private BigDecimal unitPrice; @Column(nullable=false,precision=10,scale=2) private BigDecimal lineTotal;
 public OrderItem(){} public OrderItem(Long id,String name,Integer q,BigDecimal price,BigDecimal total){productId=id;productName=name;quantity=q;unitPrice=price;lineTotal=total;}
 public Long getId(){return id;} public Long getProductId(){return productId;} public String getProductName(){return productName;} public Integer getQuantity(){return quantity;} public BigDecimal getUnitPrice(){return unitPrice;} public BigDecimal getLineTotal(){return lineTotal;} public void setOrder(CustomerOrder v){order=v;}
}
