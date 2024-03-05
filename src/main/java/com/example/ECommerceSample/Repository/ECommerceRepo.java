package com.example.ECommerceSample.Repository;

import com.example.ECommerceSample.Model.ECommerceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ECommerceRepo extends JpaRepository<ECommerceModel,Integer> {
}
