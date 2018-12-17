package net.emecas.gpluspager.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends CrudRepository<DTO, String>{

	public Optional<DTO> findById(long id);

}
