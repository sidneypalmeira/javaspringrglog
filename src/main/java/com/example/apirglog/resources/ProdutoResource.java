package com.example.apirglog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirglog.models.Produto;
import com.example.apirglog.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/produtos")
@Api(value = "API REST RGLOG Teste")
@CrossOrigin(origins = "*")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;

	@GetMapping()
	@ApiOperation(value="Retorna uma lista dos Produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}

	@GetMapping(path = "{id}")
	@ApiOperation(value="Retorna um único produto a partir o se ID")
	public Produto listaProduto(@PathVariable(value = "id") long id) {
		return produtoRepository.findById(id).get();
	}

	@PostMapping()
	@ApiOperation(value="Insere um novo produto no banco de dados")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping(path = "{id}")
	@ApiOperation(value="Apaga um produto no banco de dados a partir do seu ID")
	public void deleteProduto(@PathVariable(value = "id") long id) {
		produtoRepository.deleteById(id);
	}

	@PutMapping()
	@ApiOperation(value="Atualiza os dados de um produto específico.")
	public Produto alteraProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}