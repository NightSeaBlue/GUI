package B_info;

public class PersonVO {
	
	private String name;
	private String ID;
	private String tel;
	private String sex;
	private int age;
	private String home;
	
	// 기본 생성자 생성
	public PersonVO() {}
	
	// 생성자 생성
	public PersonVO(String name, String iD, String tel, String sex, int age, String home) {
		super();
		this.name = name;
		ID = iD;
		this.tel = tel;
		this.sex = sex;
		this.age = age;
		this.home = home;
	}
	
	
	// Setter and Getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}

	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", ID=" + ID + ", tel=" + tel + ", sex=" + sex + ", age=" + age + ", home="
				+ home + "]\n";
	}
	
	
	

}
