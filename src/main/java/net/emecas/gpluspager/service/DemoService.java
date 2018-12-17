package net.emecas.gpluspager.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import net.emecas.gpluspager.data.DTO;

public interface DemoService {
	public Optional<DTO> findById(long id);
}
