package spring.model;

public class Student {

	private long id;
	private String name;
	private String city;
	private String age;
	
	public Student() {
		super();
	}

	public Student(long id, String name, String city, String age) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.age = age;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	
	
}
