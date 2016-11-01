/**
 * [gs-accessing-data-jpa-initial] hello.models.StudentRelaCourse.java
 * 
 * created at 2016年10月25日 by kevin_zhu
 */
package in.choich.entities.jpa;

import java.io.Serializable;

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
@Table(name = "studentrelacourse") // 尽量都小写，驼峰写法studentRelaCourse后台解析的表名student_rela_course
public class StudentRelaCourseModel implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
	@Column(nullable=false)
	private String sno;
	@Column(nullable=false)
	private String cno;
	@Column(nullable=false)
	private float score;

	public StudentRelaCourseModel(){
		
	}
	
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}



	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
	
}
