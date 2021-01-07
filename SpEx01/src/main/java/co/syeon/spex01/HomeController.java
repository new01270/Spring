package co.syeon.spex01;

import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/** 컨트롤러 클래스 제작 순서 **/

// 1. @Controller를 이용한 클래스 생성
@Controller
public class HomeController {

	// 2. @RequestMapping(path) 을 이용한 요청 경로 지정
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {

		// 3. 요청 처리 메소드 구현 _ home();
		String str = "스프링 프레임워크에 온 것을 환영합니다~~~!!";
		model.addAttribute("serverTime", str);

		// 4. 뷰 이름 리턴 -> WEB-INF/views/home.jsp 으로 받음
		return "home";
	}
	
	// ... @RequestMapping이 여러개 지정된다.

}
