package net.emecas.gpluspager.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import net.emecas.gpluspager.data.DTO;
import net.emecas.gpluspager.data.DemoRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DemoRepositoryIntegrationTest {
	
	@Autowired
	DemoRepository target;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testNotNull() {
		assertNotNull(target);
	}
		
	@Test
	public void testFindByIdFound() {
		Optional<DTO> res = target.findById(1L);
		assertTrue(res.isPresent());
		DTO expected = new DTO();
		expected.setId(1L);
		expected.setName("Name1");
		expected.setPassportNumber("PN1234567");
		DTO actual = res.get();
		assertEquals(actual,expected);
	}
	
	@Test
	public void testFindByIdNotFound() {
		Optional<DTO> res = target.findById(3L);
		assertFalse(res.isPresent());
	}
	
	@Test
	public void testFindAll() {
		Iterable<DTO> res = target.findAll();
		assertEquals(3,res.spliterator().estimateSize());
	}
}
