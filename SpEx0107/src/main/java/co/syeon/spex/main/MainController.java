package co.syeon.spex.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/main.do")
	public String main() {

		return "no/main/main";
	}
}
