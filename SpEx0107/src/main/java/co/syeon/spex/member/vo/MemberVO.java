package co.syeon.spex.member.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
/*
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
*/
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {
	
	private String memberid;
	private String membername;
	private String password;
	private String memberauth;
	private int memberpoint;
	
}
