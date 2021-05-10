package com.example.adminproject.repository;

import com.example.adminproject.model.entity.Category;
import com.example.adminproject.model.entity.Partner;
import com.example.adminproject.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    List<Partner> findByCategory(Category category);
}
