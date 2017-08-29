package spring.oneTomany.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "images")
public class Images {

	@Id
	@GeneratedValue
	private long id;
	@Column
	private String imageName;

	@ManyToOne
	@JoinColumn(name = "u_id")
	private MyUser myUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public MyUser getMyUser() {
		return myUser;
	}

	public void setMyUser(MyUser myUser) {
		this.myUser = myUser;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	
}
