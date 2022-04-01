package com.citi.projeto.controller;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.citi.projeto.model.Account;
import com.citi.projeto.service.AccountService;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

	private final AccountService AccountService;
	
	public AccountController(AccountService AccountService) {
		this.AccountService = AccountService;
	}
	
	@GetMapping
	public ResponseEntity<Page<Account>> getALL(Pageable pageable){
		Page<Account> listAccount = AccountService.findAll(pageable);		
		return ResponseEntity.ok().body(listAccount);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getById(@PathVariable Long id) {
		Account account = AccountService.getById(id);
		return ResponseEntity.ok(account);
	}
	
	@PostMapping
	public ResponseEntity<Account> create(@RequestBody Account account){
		Account p = AccountService.create(account);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(p.getId()).toUri();
		
		return ResponseEntity.created(location).body(p);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Account> update(@RequestBody Account account, @PathVariable Long id){
		account = AccountService.update(account, id);
		//return ResponseEntity.noContent().build();
		return ResponseEntity.ok().body(account);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Account> delete(@PathVariable Long id){
		AccountService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
