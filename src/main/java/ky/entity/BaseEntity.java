package ky.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlElement;
@MappedSuperclass
public class BaseEntity {
	
	@SuppressWarnings("restriction")
	@Id
	@GeneratedValue
	@XmlElement(name = "id")	
	private long id;
	
	public BaseEntity(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
