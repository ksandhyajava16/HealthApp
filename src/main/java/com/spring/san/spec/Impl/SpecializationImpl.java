package com.spring.san.spec.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.san.spec.entity.Specialization;
import com.spring.san.spec.repo.SpecializationRepo;
import com.spring.san.spec.service.ISpecializationService;

@Service
public class SpecializationImpl implements ISpecializationService {

	@Autowired
	SpecializationRepo repo;

	@Override
	public void createSpec(Specialization spec) {
		repo.save(spec);

	}

	@Override
	public List<Specialization> getAllSpec() {

		return repo.findAll();
	}

	@Override
	public void deleteSpec(Integer id) {
		repo.deleteById(id);

	}

	@Override
	public void editSpec(Integer id) {
		// TODO Auto-generated method stub

	}

}
