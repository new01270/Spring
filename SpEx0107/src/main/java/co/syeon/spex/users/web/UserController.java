package co.syeon.spex.users.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.syeon.spex.main.common.Paging;
import co.syeon.spex.users.service.UserService;
import co.syeon.spex.users.vo.UserVO;

// http://localhost/spex/
// REST API 방식

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	
	// 등록 post
	@RequestMapping(value = "/users.do", method = RequestMethod.POST)
	@ResponseBody
	public UserVO insertUser(UserVO vo) {
		userService.insertUser(vo);
		return vo;
	}

	// 수정 put @RequestBody 필요
	@RequestMapping(value = "/users.do", method = RequestMethod.PUT)
	@ResponseBody
	public UserVO updateUser(@RequestBody UserVO vo) {
		userService.updateUser(vo);
		return vo;
	}

	// 삭제
	@RequestMapping(value = "/users.do/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public UserVO deleteUser(@PathVariable String id, UserVO vo) {
		vo.setId(id);
		userService.deleteUser(vo);
		return vo;
	}

	// 단건조회 {id}가 넘어오는 파라미터 여러개인경우 {id}/{pw}../{..}
	// @PathVariable 사용시 url-pattern '/'로 변경
	@RequestMapping(value = "/users.do/{id}", method = RequestMethod.GET)
	@ResponseBody
	public UserVO selectUser(@PathVariable String id, UserVO vo) {
		vo.setId(id);
		return userService.getUser(vo);
	}

	// 전체조회 get (default)
	@RequestMapping(value = "/users.do", method = RequestMethod.GET)
	@ResponseBody
	public List<UserVO> selectAllUser(UserVO vo) {

		return userService.getUserList(null);
	}
}
