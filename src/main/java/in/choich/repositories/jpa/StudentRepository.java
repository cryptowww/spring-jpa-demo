/**
 * [gs-accessing-data-jpa-initial] hello.repositoris.StudentRepository.java
 * 
 * created at 2016年10月25日 by kevin_zhu
 */
package in.choich.repositories.jpa;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import in.choich.entities.jpa.StudentModel;



/**
 * @author kevin_zhu
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Integer>{


	//	查询所有人
	public List<StudentModel> findAll();
	
	// 按年龄降序查找前5名
	public List<StudentModel> findTop5ByOrderByAgeDesc();


	//按firstname和lastname查询(and)
	public List<StudentModel> findByFirstNameAndLastName(String firstName,String lastName);

	
	//按firstname或lastname查询(Or)
	public List<StudentModel> findByFirstNameOrLastName(String firstName,String lastName);

	//按firstname(以下三个等同)
	public List<StudentModel> findByFirstName(String firstName);
	
	//按firstname
	public List<StudentModel> findByFirstNameIs(String firstName);
	
	//按firstname
	public List<StudentModel> findByFirstNameEquals(String firstName);

	//按Age(between)
	public List<StudentModel> findByAgeBetween(int start,int end);
	
	
	//按Age(<)
	public List<StudentModel> findByAgeLessThan(int age);
	
	//按Age(<=)
	public List<StudentModel> findByAgeLessThanEqual(int age);
	
	//按Age(>)
	public List<StudentModel> findByAgeGreaterThan(int age);
	
	//按Age(>=)
	public List<StudentModel> findByAgeGreaterThanEqual(int age);

	//按Age(IsNull)
	public List<StudentModel> findByAgeIsNull();
	
	//按Age(IsNotNull/NotNull)
	public List<StudentModel> findByAgeIsNotNull();
	
	//按firstname(Like)
	public List<StudentModel> findByFirstNameLike(String firstName);
	
	//按firstname(NotLike)
	public List<StudentModel> findByFirstNameNotLike(String firstName);
	
	//按firstname(StartingWith)
	public List<StudentModel> findByFirstNameStartingWith(String firstName);
	
	//按firstname(EndingWith)
	public List<StudentModel> findByFirstNameEndingWith(String firstName);
	
	//按firstname(Containing)
	public List<StudentModel> findByFirstNameContaining(String firstName);
	
	//按firstname(<>)
	public List<StudentModel> findByFirstNameNot(String firstName);
	
	
	//按Age(in(20,29))
	public List<StudentModel> findByAgeIn(Collection ages);
	
	//按Age(not in(20,29))
	public List<StudentModel> findByAgeNotIn(Collection ages);
	
	
	//按firstname(忽略大小写)
	public List<StudentModel> findByFirstNameIgnoreCase(String firstName);
	
	// 复杂
	public List<StudentModel> findByFirstNameAndLastNameAndAgeGreaterThanAndGenderIsNotNullOrderByAgeDesc(String firstName,String lastName,int age);
	
	// 查询firstname like 'param%'
	@Query(value = "select * from student where firstname like ?1%",nativeQuery = true)
	public List<StudentModel> findByQuery(String firstName);
	// 索引参数查询，传递参数的位置需与sql对应
	@Query(value = "select * from student where firstname = ?1 and lastname= ?1",nativeQuery = true)
	public List<StudentModel> findByFirstNameAndLastName_1(String firstName,String lastName);
	
	// 命名参数查询，传递参数的位置任意
	@Query(value = "select * from student where firstname = :firstname and lastname= :lastname",nativeQuery = true)
	public List<StudentModel> findByFirstNameAndLastName_2(@Param("lastname") String lastName,@Param("firstname") String firstName);
}
