package com.studentApi.StudentApi.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
  
	
	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="CreatedDate")
	private LocalDateTime createdDate;
	
	@Column(name="UpdatedDate")
	private LocalDateTime updatedDate;
	
	@Column(name="LastCreatedDate")
	private LocalDateTime lastCreatedDate;
	
	@Column(name="LastUpdatedTime")
	private LocalDateTime lastUpdatedDate;
}
