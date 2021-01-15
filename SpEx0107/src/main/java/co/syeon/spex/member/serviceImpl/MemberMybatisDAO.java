package co.syeon.spex.member.serviceImpl;

import java.util.List;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.syeon.spex.member.service.MemberService;
import co.syeon.spex.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberMybatisDAO implements MemberService {

	@Autowired SqlSessionTemplate sqlSession;

	@Override
	public List<MemberVO> memberList() throws SQLException {
		// TODO Auto-generated method stub
		return sqlSession.selectList("MemberDAO.memberList");
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberInsert(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberUpdate(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean memberLoginCheck(MemberVO vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
		
	
	
	
}
