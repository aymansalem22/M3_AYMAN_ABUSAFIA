package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")


public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="first_name")
	private String firstname;
	
	@Column(name ="last_name")
	private String lastname;
	
	@Column(name ="age")
	private Integer age;
	
	@Column(name ="nif")
	private String nif;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="password")
	private String password;
	
	@Column(name ="marital_status")
	private String maritalstatus ;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_address") 
	private Address address;
	
	
	public User() {}

	





	public User( String firstname, String lastname, Integer age, String nif, String email, String password,
			String maritalstatus, Address address) {
		
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.nif = nif;
		this.email = email;
		this.password = password;
		this.maritalstatus = maritalstatus;
		this.address = address;
	}







	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public String getNif() {
		return nif;
	}



	public void setNif(String nif) {
		this.nif = nif;
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



	public String getMaritalstatus() {
		return maritalstatus;
	}



	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}







	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", nif="
				+ nif + ", email=" + email + ", password=" + password + ", maritalstatus=" + maritalstatus
				+ ", address=" + address + "]";
	}





	

	
}
