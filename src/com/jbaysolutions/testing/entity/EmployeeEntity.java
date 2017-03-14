package com.jbaysolutions.testing.entity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee", catalog = "mydb", schema = "")
public class EmployeeEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "idemployee")
	    private Integer idemployee;

	    @Basic(optional = false)
	    @Column(name = "name")
	    private String name;

	    @Basic(optional = false)
	    @Column(name = "phone")
	    private String phone;
	    
	    @ManyToOne(optional = false, cascade=CascadeType.ALL )
	    @JoinColumn(name = "company", referencedColumnName = "idcompany")
	    private CompanyEntity company;

	    public EmployeeEntity() {
	    }

	    public EmployeeEntity(Integer idemployee) {
	        this.idemployee = idemployee;
	    }

	    public EmployeeEntity(Integer idemployee, String name, String phone) {
	        this.idemployee = idemployee;
	        this.name = name;
	        this.phone = phone;
	    }

	    public Integer getIdemployee() {
	        return idemployee;
	    }

	    public void setIdemployee(Integer idemployee) {
	        this.idemployee = idemployee;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getPhone() {
	        return phone;
	    }

	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	    public CompanyEntity getCompany() {
	        return company;
	    }

	    public void setCompany(CompanyEntity company) {
	        this.company = company;
	    }
	    
}
