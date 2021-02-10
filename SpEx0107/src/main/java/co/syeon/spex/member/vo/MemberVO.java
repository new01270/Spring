package co.syeon.spex.member.vo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
/*
 * @Getter
 * 
 * @Setter
 * 
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor
 * 
 * @ToString
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO implements UserDetails {

	private String memberid;
	private String membername;
	@JsonIgnore
	private String password;
	private String memberauth;
	private int memberpoint;
	int start;
	int end;
	private List<GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getUsername() {
		return memberid;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
