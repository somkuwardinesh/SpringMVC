package spring.fileUpload.model;


import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class MyUser {

	private long id;

	private String name;

	private long mobileNo;

	private String city;

	
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


	public CommonsMultipartFile[] getFleUpload() {
		return fleUpload;
	}


	public void setFleUpload(CommonsMultipartFile[] fleUpload) {
		this.fleUpload = fleUpload;
	}
	
	
	

}
