package com.devsuperior.dsvendas.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.dto.SellerDTO;
import com.devsuperior.dsvendas.services.SellerService;

@RestController

//indica o caminho do recurso web
@RequestMapping(value = "/sellers")
public class SellerController {
	
	// o controlador depende do serviço 
	@Autowired
	private SellerService service;
	
	// endpoint com método de resposta do Spring retornando uma lista SellerDTO, 
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll(){
		List<SellerDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}

}
