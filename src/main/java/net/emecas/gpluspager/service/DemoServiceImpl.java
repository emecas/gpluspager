package net.emecas.gpluspager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.emecas.gpluspager.data.DTO;
import net.emecas.gpluspager.data.DemoRepository;

@Service
public class DemoServiceImpl implements DemoService {

	 @Autowired
	 private DemoRepository demoRepository;
	 
	 public Optional<DTO> findById(long id){
		 return demoRepository.findById(id);
		 
	 }
}
