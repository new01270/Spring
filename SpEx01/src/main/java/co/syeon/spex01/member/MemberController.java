package co.syeon.spex01.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@RequestMapping("/member/list")
	public String list(Model model) {

		return "member/list";
	}
}
