package net.emecas.gpluspager.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.emecas.gpluspager.data.DTO;
import net.emecas.gpluspager.data.DemoRepository;

@RestController
@RequestMapping("/demo")
public class DemoController  {

    @Autowired
    private DemoRepository transactionRepository;

    
    @GetMapping("{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
    	Optional<DTO> dto = transactionRepository.findById(Long.parseLong(id));
    	return  dto.isPresent()?ResponseEntity.ok(dto.get().toString()):ResponseEntity.notFound().build();
    }
}
