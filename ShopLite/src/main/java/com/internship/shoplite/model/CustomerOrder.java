package com.internship.shoplite.model;
import jakarta.persistence.*; import java.math.BigDecimal; import java.time.LocalDateTime; import java.util.ArrayList; import java.util.List;
@Entity @Table(name="customer_orders")
public class CustomerOrder {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=120) private String customerName;
 @Column(nullable=false,length=180) private String customerEmail;
 @Column(nullable=false,precision=10,scale=2) private BigDecimal totalAmount;
 @Column(nullable=false,length=30) private String paymentStatus;
 @Column(nullable=false,length=30) private String orderStatus;
 @Column(nullable=false) private LocalDateTime createdAt;
 @OneToMany(mappedBy="order",cascade=CascadeType.ALL,orphanRemoval=true) private List<OrderItem> items=new ArrayList<>();
 public CustomerOrder(){} @PrePersist public void beforeSave(){if(createdAt==null)createdAt=LocalDateTime.now();}
 public void addItem(OrderItem item){items.add(item);item.setOrder(this);}
 public Long getId(){return id;} public String getCustomerName(){return customerName;} public String getCustomerEmail(){return customerEmail;} public BigDecimal getTotalAmount(){return totalAmount;} public String getPaymentStatus(){return paymentStatus;} public String getOrderStatus(){return orderStatus;} public LocalDateTime getCreatedAt(){return createdAt;} public List<OrderItem> getItems(){return items;}
 public void setCustomerName(String v){customerName=v;} public void setCustomerEmail(String v){customerEmail=v;} public void setTotalAmount(BigDecimal v){totalAmount=v;} public void setPaymentStatus(String v){paymentStatus=v;} public void setOrderStatus(String v){orderStatus=v;}
}
