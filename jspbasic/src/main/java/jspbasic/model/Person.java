package jspbasic.model;
import java.io.Serializable;

// 
public class Person implements Serializable{

	// 직렬화버전 ID를 생성
	private static final long serealVersionUID = 2312402187412803L;
	
	// private 멤버변수
	private String name;
	private int age;
	
	// public 기본 생성자
	public Person() {
		
	}
	
	// 파라미터 있는 생성자
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// getter/ setter
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
