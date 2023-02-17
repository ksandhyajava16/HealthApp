package com.spring.san.spec.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.san.spec.entity.Specialization;

public interface SpecializationRepo extends JpaRepository<Specialization, Integer> {

}
