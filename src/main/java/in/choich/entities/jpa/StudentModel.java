/**
 * [gs-accessing-data-jpa-initial] hello.models.StudentModel.java
 * 
 * created at 2016年10月25日 by kevin_zhu
 */
package in.choich.entities.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kevin_zhu
 *
 */
@Entity
@Table(name = "student")
public class StudentModel {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
	@Column(name="firstname")
	private String firstName ;
	@Column(name="lastname")
	private String lastName ;
	@Column(nullable=false)
	private int age ;
	@Column(nullable=false)
	private String gender ;
	// 学号
	@Column(nullable=false)
	private String sno ;
	
	public StudentModel(){
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	
	
}
