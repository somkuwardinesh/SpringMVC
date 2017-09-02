package spring.multiselect.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


public class Student {

	private long id;
	private String name;
	private int age;
	private String city;
	
	private long course[];
	
	private long movies[];
	
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long[] getCourse() {
		return course;
	}
	public void setCourse(long[] course) {
		this.course = course;
	}
	public long[] getMovies() {
		return movies;
	}
	public void setMovies(long[] movies) {
		this.movies = movies;
	}
	
	
	
}
