package nz.co.jahre.dto;

import java.util.Date;

import nz.co.jahre2.utils.JsonDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Json serialisable DTO Job
 * @author shauryab
 *
 */
public class JobDto {

	private Long id;
	
	private String type;
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private Date creationDate;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	
}
