package co.syeon.ex3.member.service;

import java.util.ArrayList;

import co.syeon.ex3.member.vo.MemberVO;

public interface MemberService {

	ArrayList<MemberVO> selectAll();
	MemberVO select(MemberVO vo);
	int insert(MemberVO vo);
	int update(MemberVO vo);
	int delete(MemberVO vo);
	
}
