package com.irfan.mubasyir.demo.repository;

import com.irfan.mubasyir.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
