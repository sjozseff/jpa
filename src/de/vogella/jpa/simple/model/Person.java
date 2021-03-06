package de.vogella.jpa.simple.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    private String firstName;
    private String lastName;



    @Transient
    private String nonsenseField = "";

    @OneToMany
    private List<Job> jobList = new ArrayList<Job>();

    public String getId() {
            return id;
    }

    public void setId(String Id) {
            this.id = Id;
    }

    public String getFirstName() {
            return firstName;
    }

    public void setFirstName(String firstName) {
            this.firstName = firstName;
    }

    // Leave the standard column name of the table
    public String getLastName() {
            return lastName;
    }

    public void setLastName(String lastName) {
            this.lastName = lastName;
    }

   
    public String getNonsenseField() {
            return nonsenseField;
    }

    public void setNonsenseField(String nonsenseField) {
            this.nonsenseField = nonsenseField;
    }


    public List<Job> getJobList() {
            return this.jobList;
    }

    public void setJobList(List<Job> nickName) {
            this.jobList = nickName;
    }
}
