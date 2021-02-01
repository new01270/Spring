package co.syeon.spex.member.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.syeon.spex.member.service.MemberService;
import co.syeon.spex.member.vo.MemberVO;

/** MemberService.java 구현체 **/

@Service("memberService")
public class MemberServiceImpl implements MemberService, UserDetailsService {

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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		// 단건조회 -> username, password, authority
		MemberVO memberVo = new MemberVO();
		memberVo.setMemberid(username);
		MemberVO resultvo = dao.memberSelect(memberVo);

		// 사용자가 존재하지 않는 경우
		if (resultvo == null) {
			throw new UsernameNotFoundException("no user");
		}

		// 권한 지정
		List<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority("ROLE_" + resultvo.getMemberauth().toUpperCase()));

		resultvo.setAuthorities(auth);

		return resultvo;
	}

	@Override
	public ArrayList<MemberVO> memberList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
