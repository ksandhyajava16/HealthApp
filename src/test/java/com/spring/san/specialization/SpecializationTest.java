package com.spring.san.specialization;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.spring.san.spec.entity.Specialization;
import com.spring.san.spec.repo.SpecializationRepo;

@DataJpaTest(showSql = true)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SpecializationTest {
	@Autowired
	SpecializationRepo repo;

	@Test
	@Order(1)
	void testSpecCreate() {
		Specialization spec = new Specialization(null, "IMM", "Anesthesiologists",
				"They treat immune system disorders such as asthma");
		Specialization output = repo.save(spec);

		assertNotNull(output.getId(), "not created");

	}

	@Test
	@Order(2)
	void testGetAllSpec() {
		List<Specialization> specList = repo.findAll();
		assertNotNull(specList);

		if (specList.isEmpty()) {
			fail("Data not existing");
		}
	}
}
