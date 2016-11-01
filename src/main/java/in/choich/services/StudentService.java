/**
 * [gs-accessing-data-jpa-initial] hello.services.StudentService.java
 * 
 * created at 2016年10月25日 by kevin_zhu
 */
package in.choich.services;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.choich.entities.jpa.StudentModel;
import in.choich.entities.jpa.StudentRelaCourseModel;
import in.choich.entities.jpa2.CityModel;
import in.choich.repositories.jpa.StudentRelaCourseRepository;
import in.choich.repositories.jpa.StudentRepository;
import in.choich.repositories.jpa2.CityModelRepository;



/**
 * @author kevin_zhu
 *
 */
@Service
public class StudentService {
	private static final Logger log = LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private StudentRelaCourseRepository stuRelaRepository;
	
	@Autowired
	private CityModelRepository cityRepository;
	
	public StudentService(){
		
	}
	
	
	public StudentModel retriveOneStudent(int id){
		return studentRepository.findOne(id);
	}
	
	public List<StudentModel> retriveAll(){
		List<StudentModel> list = null;
		try {
			list = studentRepository.findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<StudentModel> retriveTop2(){
		List<StudentModel> list = null;
		try {
			list = studentRepository.findTop5ByOrderByAgeDesc();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 如果要保持多条更新语句的事务一致性，需要增加注解：
	 * @Transactional
	 * 
	 * 没有此注解，事务独立
	 */
	@Transactional
	public void choiceCourceForaNewStudent(){
		StudentModel stu = new StudentModel();
		
		StudentRelaCourseModel stuRela = new StudentRelaCourseModel();
		try {
			stu.setFirstName("killy");
			stu.setLastName("teq");
			stu.setAge(17);
			// 不给male字段赋值，导致更新失败，因有@Transactional保证事务一致性，stuRela的更新操作也会失败
			// 如果没有@Transactional，stu的失败不会影响stuRela
//			stu.setGender("male");
			stu.setSno("S0022");
			studentRepository.save(stu);
			log.info(stu.getFirstName()+"--"+stu.getLastName()+" saved successfully");
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}

		try {
			stuRela.setSno("S0022");
			stuRela.setCno("C001");
			stuRela.setScore(3);
			stuRelaRepository.save(stuRela);
			log.info(stuRela.getSno()+"--"+stuRela.getCno()+" saved successfully.");
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
	}

	public void anotherTrans(){
		StudentModel stu = new StudentModel();
		try {
			stu.setFirstName("killy");
			stu.setLastName("teq");
			stu.setAge(17);
			// 不给male字段赋值，导致更新失败，因有@Transactional保证事务一致性，stuRela的更新操作也会失败
			// 如果没有@Transactional，stu的失败不会影响stuRela
			stu.setGender("male");
			stu.setSno("S0022");
			studentRepository.save(stu);
			log.info(stu.getFirstName()+"--"+stu.getLastName()+" saved successfully");
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
	}
	
	public void justQuery(){
		StudentModel stu  = studentRepository.findOne(99);
		
	}
	/**
	 * 如果程序调用了其他数据库方法中有更新操作，事务扔可保持一致。
	 */
	@Transactional
	public void relaTransaction(){
		StudentRelaCourseModel stuRela = new StudentRelaCourseModel();
		anotherTrans();
		try {
			stuRela.setSno("S0022");
			stuRela.setCno("C001");
			stuRela.setScore(3);
			stuRelaRepository.save(stuRela);
			log.info(stuRela.getSno()+"--"+stuRela.getCno()+" saved successfully.");
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.getMessage());
		}
	}
	
	public void multiDataSource(){
		List<CityModel> city = cityRepository.findAll();
		
		List<StudentModel> stu = studentRepository.findAll();
		
		log.info("City共查询了 ："+city.size());
		log.info("student共查询了 ："+stu.size());
	}
//	@Transactional
	public boolean multiDataSourceTransaction(){
		log.info("now Excuting multiDataSourceTransaction....");
		boolean isCity = true;
		boolean isStu = true;
		try {
			log.info("now Excuting multiDataSourceTransaction....CityModel");
			CityModel c = new CityModel();
			c.setCountryCode("CHINA");
			c.setPopulation(20000);
			c.setName("beijing");
			c.setDistrict("chaoyang");
			
			CityModel city = cityRepository.save(c);
//			log.info(city==null?"failed city":"successed city");
			log.info(""+city);
			log.info("Citymode Saved successfully.");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Citymode 执行出错了："+e.getMessage());
			isCity = false;
		}
		
		try {
			log.info("now Excuting multiDataSourceTransaction....StudentModel");
			StudentModel stu = new StudentModel();
			stu.setFirstName("killy");
			stu.setLastName("teq");
			stu.setAge(17);
			// 不给male字段赋值，导致更新失败，因有@Transactional保证事务一致性，stuRela的更新操作也会失败
			// 如果没有@Transactional，stu的失败不会影响stuRela
			stu.setGender("male");
			stu.setSno("S0022");
			studentRepository.save(stu);
			log.info("StudentModel Saved successfully.");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("StudentModel 执行出错了："+e.getMessage());
			isStu = false;
		}
		log.info("Already Excuted multiDataSourceTransaction....");
		
		return isCity && isStu;
		
	}
	
}
