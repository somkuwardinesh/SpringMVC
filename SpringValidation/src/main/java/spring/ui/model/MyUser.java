package spring.ui.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class MyUser {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String name;

	@Column
	private long mobileNo;

	@Column
	private String city;

	public MyUser() {
	}

	public MyUser(long id, String name, long mobileNo, String city) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
		this.city = city;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
