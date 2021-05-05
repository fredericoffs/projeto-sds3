package com.devsuperior.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.dto.SaleSuccessDTO;
import com.devsuperior.dsvendas.dto.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	// buscar os vendedores na memória
	@Autowired
	private SellerRepository sellerRepository;

	// busca paginada (pageable) de vendas - paginação; readOnly - para fazer select
	// e não dar lock no banco
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {

		// buscar os vendedores na memória
		sellerRepository.findAll();

		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x)); // converte o stream de novo
	}

	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}

	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}

}
