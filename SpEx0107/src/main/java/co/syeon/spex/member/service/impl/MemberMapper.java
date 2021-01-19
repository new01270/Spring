package co.syeon.spex.member.service.impl;

import java.sql.SQLException;
import java.util.List;

import co.syeon.spex.member.vo.DeptVO;
import co.syeon.spex.member.vo.MemberVO;

public interface MemberMapper {
	
	void deptIns(DeptVO vo);
	
	List<MemberVO> memberList(MemberVO vo);

	MemberVO memberSelect(MemberVO vo);

	int memberInsert(MemberVO vo);

	int memberUpdate(MemberVO vo);

	int memberDelete(MemberVO vo);
	
	boolean memberLoginCheck(MemberVO vo) throws SQLException;
}
