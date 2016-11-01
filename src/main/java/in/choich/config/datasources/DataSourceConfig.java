/**
 * [gs-accessing-data-jpa-initial] hello.config.DataSourceConfig.java
 * 
 * created at 2016年10月28日 by kevin_zhu
 */
package in.choich.config.datasources;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 多数据源配置类
 * 
 * @ConfigurationProperties(prefix="spring.datasource.*")
 * 
 * 与application.yml配置文件对应，有多少个数据源就配置多少个对应方法
 * 
 * @author kevin_zhu
 *
 */
@Configuration
public class DataSourceConfig {

	@Bean(name="primaryDataSource")
	@Qualifier("primaryDataSource")
	@ConfigurationProperties(prefix="spring.datasource.primary")
	@Primary
	public DataSource primaryDataSource(){
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="secondaryDataSource")
	@Qualifier("secondaryDataSource")
	@ConfigurationProperties(prefix="spring.datasource.secondary")
	public DataSource secondaryDataSource(){
		return DataSourceBuilder.create().build();
	}
}
