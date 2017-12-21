package mum.waa.coffee.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity(name = "Credentials")
public class UserCredentials {

	@Id
	@Column(nullable = false, unique = true)
	@NotEmpty
	String username;
	
	String password;

	@Transient
	@NotEmpty(groups = UserCredentials.class)
	String inputPassword;
	
	@Transient
	@NotEmpty(groups = UserCredentials.class)
	String verifyPassword;
	
	Boolean enabled;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "username")
	List<Authority> authrorityList = new ArrayList<Authority>();

	@OneToOne(mappedBy = "userCredentials")
	Member member;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInputPassword() {
		return inputPassword;
	}

	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}
	
	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Authority> getAuthorityList() {
		return authrorityList;
	}

	public void setAuthorityList(List<Authority> authorityList) {
		this.authrorityList = authorityList;
	}
	
	public String getAuthorities() {
		return authrorityList.stream().map(a -> a.getAuthority()).collect(Collectors.joining(" "));
	}
	
	public void addAuthority(Authority authority) {
		this.authrorityList.add(authority);
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
