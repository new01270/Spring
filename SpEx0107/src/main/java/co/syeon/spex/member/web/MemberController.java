package co.syeon.spex.member.web;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.syeon.spex.member.service.MemberService;
import co.syeon.spex.member.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService; // MemberServiceImpl 객체 자동주입 -> @Service("memberService")와 같은이름

	@RequestMapping("/memberList.do")
	public String memberList(Model model, @ModelAttribute("vo") MemberVO vo) throws SQLException {
		// MemberVO vo  => jap에서 command 객체 받아옴
		// @ModelAttribute("vo") : model객체에 담을때 변수명지정
		List<MemberVO> members = memberService.memberList(vo);
		model.addAttribute("members", members);

		return "member/memberList";
	}

	@RequestMapping("/memberInsertForm.do")
	public String memberInsertForm() throws SQLException {

		return "member/memberInsertForm";
	}

	// 호출명과 return명 일치시켜주기
	
	@PostMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo, Model model) throws SQLException {

		String viewPath = null;
		int n = memberService.memberInsert(vo);

		if (n != 0) {
			viewPath = "redirect:memberList.do"; // Mapping method 호출
		} else {
			viewPath = "member/memberInsertFail"; // viewResolve -> .jsp 호출
		}

		return viewPath;
	}

	@RequestMapping("/memberDelete.do")
	public String memberDelete(MemberVO vo) throws SQLException {

		String viewPath = null;
		int n = memberService.memberDelete(vo);

		if (n != 0) {
			viewPath = "redirect:memberList.do";
		} else {
			viewPath = "member/memberDeleteFail"; // viewResolve -> .jsp 호출
		}

		return viewPath;
	}

	@RequestMapping("/memberSelect.do")
	public String memberSelect(MemberVO vo, Model model) throws SQLException {

		MemberVO member = memberService.memberSelect(vo);
		model.addAttribute("member", member);

		return "member/memberSelect";
	}

	@RequestMapping("/memberEditForm.do")
	public String memberEditForm(MemberVO vo, Model model) throws SQLException {

		MemberVO member = memberService.memberSelect(vo);
		model.addAttribute("member", member);

		return "member/memberEditForm";
	}

	@RequestMapping("/memberEdit.do")
	public String memberEdit(MemberVO vo) throws SQLException {

		String viewPath = null;
		int n = memberService.memberUpdate(vo);

		if (n != 0) {
			viewPath = "redirect:memberList.do";
		} else {
			viewPath = "member/memberUpdateFail"; // viewResolve -> .jsp �샇異�
		}

		return viewPath;
	}

	@RequestMapping("/memberLoginForm.do")
	public String memberLoginForm() throws SQLException {

		return "member/memberLoginForm";
	}

	@RequestMapping("/memberLoginResult.do")
	public String memberLoginResult(MemberVO vo, Model model, HttpSession session) throws SQLException {

		String viewPath = null;
		boolean check = memberService.memberLoginCheck(vo);
		
		session.setAttribute("memberid", vo.getMemberid());
		String memberid = (String) session.getAttribute("memberid");
		model.addAttribute("memberid", memberid);
		
		if (check == true) {
//			viewPath = "member/memberLoginSeccess";	// .jsp 정상적으로 넘어감
			viewPath = "redirect:main.do";

		} else {
			viewPath = "member/memberLoginFail";
		}

		return viewPath;
	}
	
	@RequestMapping("/memberLogout.do")
	public String memberLogout(MemberVO vo, Model model, HttpSession session) throws SQLException {
		
		model.addAttribute("memberid", session.getAttribute("memberid"));
		session.invalidate();
		
		return "member/memberLogout";
	}

	@RequestMapping("/memberLoginCheck.do")
	public String memberLoginCheck(MemberVO vo) throws SQLException {

		String viewPath = null;
		System.out.println(vo.getMemberid());
		boolean check = memberService.memberLoginCheck(vo);

		if (check == true) {
			viewPath = "member/checkFail";
		} else {
			viewPath = "redirect:memberInsertForm.do";
		}

		return viewPath;
	}

}
