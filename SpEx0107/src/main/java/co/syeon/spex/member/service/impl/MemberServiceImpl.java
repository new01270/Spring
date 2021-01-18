package co.syeon.spex.member.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.syeon.spex.member.service.MemberService;
import co.syeon.spex.member.vo.MemberVO;

/** MemberService.java ����ü **/

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper dao;

	@Override
	public List<MemberVO> memberList(MemberVO vo) throws SQLException {
		return dao.memberList(vo);
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) throws SQLException {
		return dao.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) throws SQLException {
		return dao.memberInsert(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) throws SQLException {
		return dao.memberUpdate(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) throws SQLException {
		return dao.memberDelete(vo);
	}

	@Override
	public boolean memberLoginCheck(MemberVO vo) throws SQLException {
		MemberVO resultVO = dao.memberSelect(vo);
		if (vo != null && vo.getPassword().equals(resultVO.getPassword())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public ArrayList<MemberVO> memberList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
