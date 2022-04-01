package com.citi.projeto.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tb_account")
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name_owner",length = 50)
	private String nameOwner;
	@Column(name="agency_code",length = 4)
	private String agencyCode;
	@Column(name="number_account",length = 8)
	private String numberAccount;
	@Column(name="digit_verification  ",length = 3)
	private String digitVerification;
	@Column(name="register_id",length = 20, unique = true)
	private String registerId;
	
	public Account( ) {		
	}

	public Account(String nameOwner, String agencyCode, String numberAccount, String digitVerification,	String registerId) {
		this.nameOwner = nameOwner;
		this.agencyCode = agencyCode;
		this.numberAccount = numberAccount;
		this.digitVerification = digitVerification;
		this.registerId = registerId;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getnameOwner() {
		return nameOwner;
	}

	public void setnameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}

	public String getagencyCode() {
		return agencyCode;
	}

	public void setagencyCode(String agencyCode) {
		this.agencyCode = agencyCode;
	}
	
	public String getnumberAccount() {
		return numberAccount;
	}

	public void setnumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}	

	public String getdigitVerification() {
		return digitVerification;
	}

	public void setdigitVerification(String digitVerification) {
		this.digitVerification = digitVerification;
	}
	
	public String getregisterId() {
		return registerId;
	}

	public void setregisterId(String registerId) {
		this.registerId = registerId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
