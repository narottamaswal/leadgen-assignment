package com.leadgen.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditModel {
	
	@Column(name = "created_at", nullable = false, length = 29)
	private Date createdAt;
	
	@Column(name = "updated_at", nullable = false, length = 29)
	private Date updatedAt;

	protected AuditModel(Date createdAt, Date updatedAt) {
		super();
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	protected AuditModel() {
		super();
	}


	@CreatedDate
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	
	@LastModifiedDate
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}