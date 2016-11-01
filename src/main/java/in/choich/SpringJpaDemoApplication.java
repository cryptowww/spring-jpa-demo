package in.choich;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot的入口类，要放在package包的顶级包中，这样不需要额外的配置，就可以自动管理各类bean
 * 
 * 如果不这样，需要配置basepackage参数，指定包所在的路径，但没必要这样。
 * 
 * @author kevin_zhu
 *
 */
@SpringBootApplication
public class SpringJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDemoApplication.class, args);
	}
}
