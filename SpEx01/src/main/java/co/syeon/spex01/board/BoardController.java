package co.syeon.spex01.board;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {

	@RequestMapping("/board/list")
	public String list(Model model) {
		// 필요한 모델 기술.

		return "board/list";
	}

	@RequestMapping("/board/write")
	public String write(Model model) {
		// 필요한 모델 기술.

		return "board/write";
	}
}
