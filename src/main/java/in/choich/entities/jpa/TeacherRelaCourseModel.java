/**
 * [gs-accessing-data-jpa-initial] hello.models.TeacherRelaCourse.java
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
@Table(name = "teacherrelacourse")
public class TeacherRelaCourseModel implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",nullable=false)
    private Integer id ;
	
	private String tno;
	
	private String cno;

	
	public TeacherRelaCourseModel(){
		
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



	/**
	 * @return the tno
	 */
	public String getTno() {
		return tno;
	}

	/**
	 * @param tno the tno to set
	 */
	public void setTno(String tno) {
		this.tno = tno;
	}

	/**
	 * @return the cno
	 */
	public String getCno() {
		return cno;
	}

	/**
	 * @param cno the cno to set
	 */
	public void setCno(String cno) {
		this.cno = cno;
	}
	
	
}
