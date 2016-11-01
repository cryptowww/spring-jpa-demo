/**
 * [gs-accessing-data-jpa-initial] hello.models.CourseModel.java
 * 
 * created at 2016年10月25日 by kevin_zhu
 */
package in.choich.entities.jpa;

import java.io.Serializable;

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
@Table(name = "course")
public class CourseModel implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;

	// 课程号
	private String cno ;
	// 课时
	private int classHour ;
	// 学分
	private float scoure ;
	
	public CourseModel(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public int getClassHour() {
		return classHour;
	}

	public void setClassHour(int classHour) {
		this.classHour = classHour;
	}

	public float getScoure() {
		return scoure;
	}

	public void setScoure(float scoure) {
		this.scoure = scoure;
	}
	
	
	
	
}
