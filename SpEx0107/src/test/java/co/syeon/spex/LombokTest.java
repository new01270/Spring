package co.syeon.spex;

import co.syeon.spex.member.vo.MemberVO;

public class LombokTest {
	public static void main(String[] args) {
		MemberVO.builder().memberid("ddd").password("123").build();
		//생성자를 대체해서 만들어주는 것. @Builder
	}
}
