package co.syeon.ex.serviceimpl;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import co.syeon.ex.service.TV;

public class MainApp {

	public static void main(String[] args) {
		// @Component -> context:component-scan 사용 
		// -> getBean으로 가져오지 않아도 컨테이너에 구축되어진 생성자가 불러와진다.
		
		// 컴포넌트 자체가 컨테이너에 구축됨.
		String context = "classpath:beanConfig.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(context);

		// 컨테이너 안 객체 가져오기.
		TV tv = (TV) ctx.getBean("samsungtv");
		tv.on();
		tv.speaker();

		tv = ctx.getBean("lgtv", TV.class);
		tv.on();
		tv.speaker();

		ctx.close();

	}

}
