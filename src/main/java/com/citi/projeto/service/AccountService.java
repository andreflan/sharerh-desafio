package com.citi.projeto.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citi.projeto.model.Account;
import com.citi.projeto.repository.AccountRepository;
import com.citi.projeto.service.exception.RecursoNaoEncontradoException;

@Service
public class AccountService {

	private AccountRepository accountRepository;	
	
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	//paginado
	public Page<Account> findAll(Pageable pageable){ 
		Page<Account> list = accountRepository.findAll(pageable);
		return list;
	}	
	
	public Account getById(Long id) {
		Optional<Account> account = accountRepository.findById(id);
		Account p = account.orElseThrow(() -> new RecursoNaoEncontradoException("Conta não encontrada"));
		return p;
	}
	
	public Account create (Account account) {
		Account p = new Account();
		p.setnameOwner(account.getnameOwner());
		p.setagencyCode(account.getagencyCode());
		p.setnumberAccount(account.getnumberAccount());
		p.setdigitVerification(account.getdigitVerification());
		p.setagencyCode(account.getagencyCode());
		
		accountRepository.save(p);
		
		return p;
		
	}
	
	@Transactional
	public Account update(Account account, Long id) {
		try {
			Optional<Account> p = accountRepository.findById(id);
			p.get().setnameOwner(account.getnameOwner());
			p.get().setagencyCode(account.getagencyCode());
			p.get().setnumberAccount(account.getnumberAccount());
			p.get().setdigitVerification(account.getdigitVerification());
			p.get().setregisterId(account.getregisterId());
			accountRepository.save(p.get());
			return p.get();
			
		}catch(EntityNotFoundException e ) {
			throw new RecursoNaoEncontradoException("Id: "+id+" não foi encontrado");
		}catch(NoSuchElementException e ) {
			throw new RecursoNaoEncontradoException("Id: "+id+" não foi encontrado");
		}
	}
	
	@Transactional
	public void delete(Long id) {
		try {
			accountRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException("Id: "+id+" não foi encontrado");
		//}catch(DataIntegrityViolationException e) {
		//	throw new AccountException("Integridade violada");
		}
	}
}
