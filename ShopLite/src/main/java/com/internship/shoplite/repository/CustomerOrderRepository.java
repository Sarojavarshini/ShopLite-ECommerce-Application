package com.internship.shoplite.repository;
import com.internship.shoplite.model.CustomerOrder; import org.springframework.data.jpa.repository.JpaRepository; import java.util.List;
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long>{List<CustomerOrder> findAllByOrderByCreatedAtDesc();}
