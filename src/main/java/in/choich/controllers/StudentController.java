/**
 * [spring-jpa-demo] in.choich.controllers.StudentController.java
 * 
 * created at 2016年10月31日 by kevin_zhu
 */
package in.choich.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.choich.entities.jpa.StudentModel;
import in.choich.services.StudentService;



/**
 * @author kevin_zhu
 *
 */
@RestController
@RequestMapping("/student")
public class StudentController {

	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentService;
	
	public StudentController(){
		
	}
	
	@RequestMapping("/all")
	public List<StudentModel> providAll(){
		//studentService.retriveAllStudentList();
		log.info("request--from /student/all");
		return studentService.retriveAll();
	}
	
	@RequestMapping("/top2")
	public List<StudentModel> providTop2(){
		//studentService.retriveAllStudentList();
		log.info("request--from /student/top2");
		return studentService.retriveTop2();
	}
	@RequestMapping("/trans")
	public String transaction(){
		String rv = "success transaction";
		try {
			studentService.choiceCourceForaNewStudent();
		} catch (Exception e) {
			// TODO: handle exception
			rv = "failed transaction";
		}
		return rv;
	}
	
	@RequestMapping("/transRela")
	public String transactionRela(){
		String rv = "success transaction";
		try {
			studentService.relaTransaction();
		} catch (Exception e) {
			// TODO: handle exception
			rv = "failed transaction";
		}
		return rv;
	}
	
	@RequestMapping("/multidata")
	public String multiData(){
		String rv = "success multidatasource";
		try {
			log.info("Now Searching for MultiData...");
			studentService.multiDataSource();
		} catch (Exception e) {
			// TODO: handle exception
			rv = "failed multidatasource";
		}
		return rv;
	}
	
	@RequestMapping("/multidatatran")
	public String multiDataTran(){
		String rv = "success multidataTransource";
		boolean isSucc = true;
		try {
			log.info("Now Excuting for multidataTransource...");
			isSucc = studentService.multiDataSourceTransaction();
			
		} catch (Exception e) {
			// TODO: handle exception
			log.info("Sorry Ex : "+e.getMessage());
			isSucc = false;
			rv = "failed multidataTransource";
		}
		return isSucc?"success multidataTransource":"failed multidataTransource";
//		return rv;
	}
}