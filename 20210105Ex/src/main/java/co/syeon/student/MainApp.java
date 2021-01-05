package co.syeon.student;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		// 자바를 이용한 DI
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		// xml에 자바를 넣는 방법
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:beanXmlConfig.xml");
		
		
		StudentVO st = ctx.getBean("student1", StudentVO.class); // @BEAN의 메서드명과 동일.
		st.toString();

		System.out.println("============");
		st = ctx.getBean("student2", StudentVO.class);
		st.toString();

		ctx.close();
	}

}
