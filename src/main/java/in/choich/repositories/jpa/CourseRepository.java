/**
 * [gs-accessing-data-jpa-initial] hello.repositoris.CourseRepository.java
 * 
 * created at 2016年10月25日 by kevin_zhu
 */
package in.choich.repositories.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.choich.entities.jpa.CourseModel;



/**
 * @author kevin_zhu
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<CourseModel, Integer>{

}
