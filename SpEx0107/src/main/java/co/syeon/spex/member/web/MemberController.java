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
import org.springframework.web.bind.annotation.ResponseBody;

import co.syeon.spex.main.common.Paging;
import co.syeon.spex.member.service.MemberService;
import co.syeon.spex.member.service.impl.MemberMapper;
import co.syeon.spex.member.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService; // MemberServiceImpl 객체 자동주입 -> @Service("memberService")와 같은이름

	@Autowired
	MemberMapper dao;

	@RequestMapping("/ajax/memberList.do")
	@ResponseBody
	/*
	 * 클라이언트에서 서버로 필요한 데이터를 전송하기 위해서 JSON이라는 데이터를 요청 본문에 담아서 서버로 보내면,
	 * 서버에서는 @RequestBody 어노테이션을 사용하여 HTTP 요청 본문에 담긴 값들을 자바 객체로 변환 시켜, 객체에 저장시킵니다.
	 * 
	 * 서버에서 클라이언트로 응답 데이터를 전송하기 위해서 @ResponseBody 를 사용하여 자바 객체를 HTTP 응답 본문의 객체로 변환하여
	 * 클라이언트로 전송시키는 역할을 합니다.
	 */
	public List<MemberVO> ajaxMemberList(MemberVO vo) throws SQLException {

		return memberService.memberList(vo);
	}

	@RequestMapping("/memberList.do")
	public String memberList(Model model, @ModelAttribute("vo") MemberVO vo, Paging paging) throws SQLException {
		
		// 페이징처리
		paging.setPageUnit(2);	// 목록2개
		paging.setPageSize(3);	// 페이징박스3개
		// 페이지번호 파라미터
		if (paging.getPage() == null) {
			paging.setPage(1);
		}
		// 시작/마지막 레코드 번호
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		// 전체 건수
		paging.setTotalRecord(13);	// 전체 레코드 건수 임의->paging.java에서 마지막으로 계산해준다

		model.addAttribute("paging", paging);	//memberList에 my:paging
		
		// 데이터 조회
		// MemberVO vo => jsp에서 command 객체 받아옴
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
			viewPath = "member/memberUpdateFail"; // viewResolve -> .jsp 호출
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
