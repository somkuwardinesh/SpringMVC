package spring.oneTomany.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

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

	@OneToMany(cascade=CascadeType.ALL)
	private List<Images> imageList;
	
	@Transient
	private CommonsMultipartFile 	fleUpload[];
	
	public MyUser() {
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



	public List<Images> getImageList() {
		return imageList;
	}



	public void setImageList(List<Images> imageList) {
		this.imageList = imageList;
	}



	public CommonsMultipartFile[] getFleUpload() {
		return fleUpload;
	}



	public void setFleUpload(CommonsMultipartFile[] fleUpload) {
		this.fleUpload = fleUpload;
	}

	
}
