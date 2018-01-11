package android.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import android.server.persistence.pageAble.Dialect;
import android.server.persistence.pageAble.MySQLDialect;
import android.server.persistence.pageAble.MybatisPageableInterceptor;


@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class} )
@SpringBootApplication
public class AndroidServerApplication implements CommandLineRunner{
	final Log logg=LogFactory.getLog(AndroidServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AndroidServerApplication.class, args);
	}
	
	public void run(String... arg0) throws Exception {
		logg.info("AndroidServerApplication服务器已经启�? success�?");	
	}
	
	
	 /**
     * 
    * @methodName:dialect
    * @Description: MySQL分页语法
    * @return
     */
    @Bean
	public Dialect dialect(){
		return new MySQLDialect();
	}
	
    /**
     * 
    * @methodName:mybatisPageableInterceptor
    * @Description: mybatis分页插件
    * @return
     */
	@Bean
	public MybatisPageableInterceptor mybatisPageableInterceptor(){
		MybatisPageableInterceptor mybatisPageableInterceptor = new MybatisPageableInterceptor();
		mybatisPageableInterceptor.setDialect(dialect());
		return mybatisPageableInterceptor;
	}


}
