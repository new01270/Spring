package co.syeon.spex.member.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.syeon.spex.member.vo.MemberVO;

public interface MemberService {
	
	List<MemberVO> memberList() throws SQLException;	// 멤버 전체 목록조회
	MemberVO memberSelect(MemberVO vo) throws SQLException;	// 멤버 1인 조회
	int memberInsert(MemberVO vo) throws SQLException;
	int memberUpdate(MemberVO vo) throws SQLException;
	int memberDelete(MemberVO vo) throws SQLException;
	boolean memberLoginCheck(MemberVO vo) throws SQLException;	// 멤버 로그인 체크
	
	
}
