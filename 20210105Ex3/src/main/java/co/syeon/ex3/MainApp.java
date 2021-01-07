package co.syeon.ex3;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import co.syeon.ex3.member.service.MemberService;
import co.syeon.ex3.member.vo.MemberVO;

public class MainApp {

	public static void main(String[] args) {

		String context = "classpath:beanConfig.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(context);

		MemberService member = (MemberService) ctx.getBean("memberService");
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		list = member.selectAll();
		
		for(MemberVO vo : list) {
			vo.toString();
		}
		
		ctx.close();

	}

}
