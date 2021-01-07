package co.syeon.ex3.member.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.syeon.ex3.member.service.MemberDAO;
import co.syeon.ex3.member.service.MemberService;
import co.syeon.ex3.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO dao;

	@Override
	public ArrayList<MemberVO> selectAll() {

		return dao.selectAll();
	}

	@Override
	public MemberVO select(MemberVO vo) {
		return null;
	}

	@Override
	public int insert(MemberVO vo) {
		return 0;
	}

	@Override
	public int update(MemberVO vo) {
		return 0;
	}

	@Override
	public int delete(MemberVO vo) {
		return 0;
	}

}
