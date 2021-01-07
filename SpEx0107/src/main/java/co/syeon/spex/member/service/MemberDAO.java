package co.syeon.spex.member.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import co.syeon.spex.member.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAO implements MemberService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// Template _ query, queryForObject, update 사용
	
	@Override
	public ArrayList<MemberVO> memberList() throws SQLException {

		String sql = "SELECT * FROM member";
		ArrayList<MemberVO> list = (ArrayList<MemberVO>) jdbcTemplate.query(sql, new MemberRowMapper());
		return list;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) throws SQLException {

		String sql = "SELECT * FROM member WHERE memberid=?";
		Object[] args = { vo.getMemberid()};
		return jdbcTemplate.queryForObject(sql, args, new MemberRowMapper());
	}

	@Override
	public int memberInsert(MemberVO vo) throws SQLException {

		String sql = "INSERT INTO member(memberid, password, membername, memberauth) VALUES(?,?,?,?)";
		Object[] args = { vo.getMemberid(), vo.getPassword(), vo.getMembername(), vo.getMemberauth() };
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public int memberUpdate(MemberVO vo) throws SQLException {

		String sql = "UPDATE member SET password=?, memberauth=? WHERE memberid=?";
		Object[] args = { vo.getPassword(), vo.getMemberauth(), vo.getMemberid() };
		return jdbcTemplate.update(sql, args);
	}

	@Override
	public int memberDelete(MemberVO vo) throws SQLException {

		String sql = "DELETE FROM member WHERE memberid=?";
		return jdbcTemplate.update(sql, vo.getMemberid());	// arg가 몇개없으면 return구문에 바로 작성가능.
	}

	@Override
	public boolean memberLoginCheck(MemberVO vo) throws SQLException {
		boolean check = false;

		String sql = "SELECT COUNT(*) FROM member WHERE memberid=? AND password=?";
		Object[] args = { vo.getMemberid(), vo.getPassword()};
		int n = jdbcTemplate.queryForObject(sql, args, Integer.class);

		if (n != 0)	// 값이 있으면 로그인 할수 있다.
			check = true;

		return check;
	}
}
