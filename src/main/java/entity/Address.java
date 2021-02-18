package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
@NamedQuery(name = "Address.findAll", query = "SELECT d FROM Address d")

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "street")
	private String street;

	@Column(name = "codepostal")
	private Integer codepostal;

	@Column(name = "country")
	private String country;

	@OneToOne(mappedBy = "address")
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address() {
	}

	public Address(String street, Integer codepostal, String country) {

		this.street = street;
		this.codepostal = codepostal;
		this.country = country;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(Integer codepostal) {
		this.codepostal = codepostal;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", codepostal=" + codepostal + ", country=" + country
				+ ", user=" + user + "]";
	}

}
