package com.rainpet.petclinic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
@Table(name="OWNER")
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="SURNAME")
	private String surname;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="MAIL")
	private String mail;
	

	
	//Bir owner tablosu ile user tablosunu bağlıyoruz
	//user_id column ile user tablosuna bağlandığımızı ve null olmaması gerektiğini söylüyoruz.
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID",nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;

	
	public Owner( String name, String surname, String address, String phoneNumber, String mail,
			User user) {
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.mail = mail;
		this.user = user;
	}

	public Owner() {}
	

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
	

}
