package com.Secuirty.secuirtyproject.Repository;

import java.util.List;

import com.Secuirty.secuirtyproject.Entities.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<product,Integer>{

    List<product> findByProductNameContainingIgnoreCase(String name);

}
