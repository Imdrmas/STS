package com.dvd.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=3, max = 50)
    private String name;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;
    
    @NotBlank
    @Size(min=3, max = 50)
	private String nameOnCard;
	
    @NotBlank
    @Size(min=3, max = 50)
	private String cardNumber;
	
	@NotBlank
	@Size(min=3, max = 50)
    private String expMonth;
    
    private int cvv;

    @NotBlank
    @Size(min=3, max = 50)
    private String expYear;

    @NotBlank
    @Size(min=3, max = 50)
    private String address;
    
    @NotBlank
    @Size(min=3, max = 50)
    private String city;
    
    private int zip;
   
    @NotBlank
    @Size(min=2, max = 50)
    private String state;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    
    @Column(columnDefinition="tinyint(1) default 1")
    private Boolean active = true;
 
    public User() {}

	public User(String name, String username, String email, String password, String nameOnCard, String cardNumber,
			String expMonth, int cvv, String expYear, String address, String city, int zip, String state, Boolean active) {
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.nameOnCard = nameOnCard;
		this.cardNumber = cardNumber;
		this.expMonth = expMonth;
		this.cvv = cvv;
		this.expYear = expYear;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.state = state;
		this.active = active;
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


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNameOnCard() {
		return nameOnCard;
	}


	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}


	public String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getExpMonth() {
		return expMonth;
	}


	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}


	public int getCvv() {
		return cvv;
	}


	public void setCvv(int cvv) {
		this.cvv = cvv;
	}


	public String getExpYear() {
		return expYear;
	}


	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public int getZip() {
		return zip;
	}


	public void setZip(int zip) {
		this.zip = zip;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

    
}