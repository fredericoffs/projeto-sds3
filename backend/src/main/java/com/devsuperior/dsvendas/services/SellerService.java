package com.devsuperior.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;

	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();

		/*
		 *  converter a lista de Seller para lista de SellerDTO - usa o construtor
		 *  SellerDTO(entity) criado na classe SellerService
		 */
		
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList()); // converte o stream de novo
																						// para lista
	}

}
