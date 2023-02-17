package com.spring.san.spec.service;

import java.util.List;

import com.spring.san.spec.entity.Specialization;

public interface ISpecializationService {

	void createSpec(Specialization spec);

	List<Specialization> getAllSpec();

	void deleteSpec(Integer id);

	void editSpec(Integer id);

}
