package com.example.apirglog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirglog.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}