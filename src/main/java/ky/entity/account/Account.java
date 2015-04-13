package ky.entity.account;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ky.entity.BaseEntity;


@SuppressWarnings("restriction")
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Account extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = -8039686696076337053L;
	
	@XmlElement(name = "UID")	
	private String UID;
	
	@XmlElement(name = "firstName")	
	private String firstName;
	
	@XmlElement(name = "lastName")	
	private String lastName;
	
	@XmlElement(name = "email")	
	private String email;
	
	@XmlElement(name = "nickName")	
	private String nickName;
	
	@OneToOne(mappedBy="account", cascade = CascadeType.ALL)
	@XmlElement(name = "profile")
	private Profile profile;
	
	public Account(){
		
	}
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUID() {
		return UID;
	}

	public void setUID(String uID) {
		UID = uID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}
