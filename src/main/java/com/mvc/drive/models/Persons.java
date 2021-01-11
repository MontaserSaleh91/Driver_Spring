package com.mvc.drive.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="persons")
public class Persons {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Size(min = 2, max = 20)
    private String first_name;
    @Size(min = 2, max = 20)
    private String last_name;
 
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(mappedBy="persons", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Licenses licenses;
	public Persons() {
		
	}
	public Licenses getLicenses() {
		return licenses;
	}
	public void setLicenses(Licenses licenses) {
		this.licenses = licenses;
	}
	public Persons(Long id, @Size(min = 2, max = 20) String first_name, @Size(min = 2, max = 20) String last_name) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	
	
}
