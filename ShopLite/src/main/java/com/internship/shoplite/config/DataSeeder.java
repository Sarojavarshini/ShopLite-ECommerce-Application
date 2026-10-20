package com.internship.shoplite.config;
import com.internship.shoplite.model.Product;import com.internship.shoplite.repository.ProductRepository;import org.springframework.boot.CommandLineRunner;import org.springframework.context.annotation.*;import java.math.BigDecimal;import java.util.List;
@Configuration public class DataSeeder {@Bean CommandLineRunner seed(ProductRepository repo){return args->{if(repo.count()==0)repo.saveAll(List.of(
new Product("Everyday Backpack","Lightweight backpack for college, work, and travel.",new BigDecimal("1299.00"),15,"https://images.unsplash.com/photo-1553062407-98eeb64c6a62?auto=format&fit=crop&w=800&q=80","Accessories"),
new Product("Wireless Headphones","Comfortable over-ear headphones for everyday listening.",new BigDecimal("2199.00"),12,"https://images.unsplash.com/photo-1505740420928-5e560c06d30e?auto=format&fit=crop&w=800&q=80","Electronics"),
new Product("Classic Sneakers","Versatile casual sneakers with a clean everyday design.",new BigDecimal("1799.00"),20,"https://images.unsplash.com/photo-1542291026-7eec264c27ff?auto=format&fit=crop&w=800&q=80","Footwear"),
new Product("Minimal Wrist Watch","A simple everyday watch with a minimal dial.",new BigDecimal("2499.00"),8,"https://images.unsplash.com/photo-1523275335684-37898b6baf30?auto=format&fit=crop&w=800&q=80","Accessories"),
new Product("Ceramic Coffee Mug","A reusable ceramic mug for your desk or kitchen.",new BigDecimal("399.00"),30,"https://images.unsplash.com/photo-1514228742587-6b1558fcca3d?auto=format&fit=crop&w=800&q=80","Home"),
new Product("Desk Lamp","Compact lamp for a comfortable study or work setup.",new BigDecimal("899.00"),10,"https://images.unsplash.com/photo-1507473885765-e6ed057f782c?auto=format&fit=crop&w=800&q=80","Home")));};}}
