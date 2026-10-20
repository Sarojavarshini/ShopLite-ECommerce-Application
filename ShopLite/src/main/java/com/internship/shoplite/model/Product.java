package com.internship.shoplite.model;
import jakarta.persistence.*; import java.math.BigDecimal;
@Entity @Table(name="products")
public class Product {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,length=120) private String name;
 @Column(nullable=false,length=600) private String description;
 @Column(nullable=false,precision=10,scale=2) private BigDecimal price;
 @Column(nullable=false) private Integer stock;
 @Column(length=500) private String imageUrl;
 @Column(nullable=false,length=60) private String category;
 public Product() {}
 public Product(String n,String d,BigDecimal p,Integer s,String i,String c){name=n;description=d;price=p;stock=s;imageUrl=i;category=c;}
 public Long getId(){return id;} public String getName(){return name;} public String getDescription(){return description;} public BigDecimal getPrice(){return price;} public Integer getStock(){return stock;} public String getImageUrl(){return imageUrl;} public String getCategory(){return category;}
 public void setId(Long v){id=v;} public void setName(String v){name=v;} public void setDescription(String v){description=v;} public void setPrice(BigDecimal v){price=v;} public void setStock(Integer v){stock=v;} public void setImageUrl(String v){imageUrl=v;} public void setCategory(String v){category=v;}
}
