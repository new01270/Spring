package co.syeon.spex.member.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.syeon.spex.member.vo.MemberVO;

public class MemberRowMapper implements RowMapper<MemberVO> {

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		MemberVO vo = new MemberVO();
		vo.setMemberid(rs.getString("memberid"));
		vo.setMembername(rs.getString("membername"));
		vo.setPassword(rs.getString("password"));
		vo.setMemberauth(rs.getString("memberauth"));
		vo.setMemberpoint(rs.getInt("memberpoint"));
		
		return vo;
	}

}
