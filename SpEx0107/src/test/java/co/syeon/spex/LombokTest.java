package co.syeon.spex;

import co.syeon.spex.member.vo.MemberVO;

public class LombokTest {
	public static void main(String[] args) {
		MemberVO.builder().memberid("ddd").password("123").build();
		//�����ڸ� ��ü�ؼ� ������ִ� ��. @Builder
	}
}
