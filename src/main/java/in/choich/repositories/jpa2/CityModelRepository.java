/**
 * [gs-accessing-data-jpa-initial] hello.anotherrepositoris.CityModelRepository.java
 * 
 * created at 2016年10月28日 by kevin_zhu
 */
package in.choich.repositories.jpa2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.choich.entities.jpa2.CityModel;


/**
 * @author kevin_zhu
 *
 */
@Repository
public interface CityModelRepository extends JpaRepository<CityModel, Integer> {

	public List<CityModel> findAll();
}
