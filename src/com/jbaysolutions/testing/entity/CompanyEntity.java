/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jbaysolutions.testing.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rui
 */
@Entity
@Table(name = "company", catalog = "mydb", schema = "")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcompany")
    private Integer idcompany;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "address")
    private String address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private Collection<EmployeeEntity> employeeCollection;
    
    @ManyToMany
    private Collection<ClientEntity> clientCollection;

    public CompanyEntity() {
    }

    public CompanyEntity(Integer idcompany) {
        this.idcompany = idcompany;
    }

    public CompanyEntity(Integer idcompany, String name, String address) {
        this.idcompany = idcompany;
        this.name = name;
        this.address = address;
    }

    public Integer getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(Integer idcompany) {
        this.idcompany = idcompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<EmployeeEntity> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<EmployeeEntity> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

	public Collection<ClientEntity> getClientCollection() {
		return clientCollection;
	}

	public void setClientCollection(Collection<ClientEntity> clientCollection) {
		this.clientCollection = clientCollection;
	}

}
