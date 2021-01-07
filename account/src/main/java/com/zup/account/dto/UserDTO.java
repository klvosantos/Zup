package com.zup.account.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.zup.account.entities.User;
import com.zup.account.services.validation.UserInsertValid;

@UserInsertValid
public class UserDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@Size(min = 4, max = 60, message="Campo deve ter entre 4 e 60 caracteres")
	@NotBlank(message = "Campo obrigatório")
	private String name;
	
	@Email(message = "Favor entrar com um e-mail válido")
	private String email;
	
	@Pattern(regexp = "(\\d{3}.?\\d{3}.?\\d{3}-?\\d{2})", message = "Favor inserir um CPF válido")
	private String cpf;
	
	@PastOrPresent(message = "A data de nascimento não pode ser futura")
	private Date birthDate;
	
	public UserDTO() {		
	}

	public UserDTO(Long id, String name, String email, String cpf, Date birthDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpf = cpf;
		this.birthDate = birthDate;
	}
	
	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		cpf = entity.getCpf();
		birthDate = entity.getBirthDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
