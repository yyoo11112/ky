package ky.entity.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
public class Profile extends BaseEntity{
	
	@XmlElement(name = "rank")	
	private int rank;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="accountID",referencedColumnName="id",nullable=false,unique=true)
	@XmlElement(name = "account")	
	private Account account;
	
	public Profile(){}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
