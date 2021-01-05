package co.syeon.student;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@ImportResource("classpath:beanConfig.xml")	// 자바에 xml 포함.
public class BeanConfig {

	@Bean
	public StudentVO student1() {

		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("넷플보기");
		hobbys.add("등산");
		hobbys.add("산책");
//		String name="홍길동";
		StudentVO student = new StudentVO("홍길동", 18, hobbys);
		student.setHeight("180");

		return student;
	}

}
