package co.syeon.ex3.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.syeon.ex3.member.vo.MemberVO;

@Repository("dao")
public class MemberDAO implements MemberService {

	@Autowired
	private DataSource dataSource;

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private final String memberList = "SELECT * FROM member";

	@Override
	public ArrayList<MemberVO> selectAll() {

		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo;

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(memberList);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAuth(rs.getString("memberauth"));
				vo.setMemberPoint(rs.getInt("memberpoint"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
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

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
