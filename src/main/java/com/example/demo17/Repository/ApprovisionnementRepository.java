package com.example.demo17.Repository;

import com.example.demo17.Models.ApprovisionnementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovisionnementRepository extends JpaRepository <ApprovisionnementModel, Integer> {
}
