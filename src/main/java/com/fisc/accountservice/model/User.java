package com.fisc.accountservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author lpm
 *
 */
@Entity(name="TBL_USER_PROFILE")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name= "USER_PROFILE_ID") 
    private Long id;    
    
    @Column(name= "USER_ID") 
    private String userId;
    
    @Transient
    private String password;
    
    @Column(name= "FIRST_NAME") 
    private String firstName;
    
    @Column(name= "LAST_NAME") 
    private String lastName;    

    
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
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



	@Override
    public String toString() {
        return String.format(
                "User[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
