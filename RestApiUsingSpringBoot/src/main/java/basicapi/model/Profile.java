/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicapi.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.ResourceSupport;



/**
 *
 * @author Maniek
 */
@Entity
public class Profile extends ResourceSupport {
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long profile_id;
    private String profile_name;
    private String profile_first;
    private String profile_last;
    private java.sql.Timestamp created;
    


  
    public Long getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(Long profile_id) {
		this.profile_id = profile_id;
	}


	public String getProfile_name() {
		return profile_name;
	}

	public void setProfile_name(String profile_name) {
		this.profile_name = profile_name;
	}

	public String getProfile_first() {
		return profile_first;
	}

	public void setProfile_first(String profile_first) {
		this.profile_first = profile_first;
	}

	public String getProfile_last() {
		return profile_last;
	}

	public void setProfile_last(String profile_last) {
		this.profile_last = profile_last;
	}

	public java.sql.Timestamp getCreated() {
		return created;
	}

	public void setCreated(java.sql.Timestamp created) {
		this.created = created;
	}


}
