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
public class Comment extends ResourceSupport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
    private long comment_id;
    private String comment_content;
    private java.sql.Timestamp created;
    private String author;
    private long message_id;
    //private List<Link> links;
    

    /**
     * @return the id
     */
    public long getCommentId() {
        return comment_id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.comment_id = id;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return comment_content;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.comment_content = message;
    }

    /**
     * @return the created
     */
    public java.sql.Timestamp getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(java.sql.Timestamp created) {
        this.created = created;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    
    private static java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
	return new java.sql.Timestamp(today.getTime());
    }

		public long getMessage_id() {
			return message_id;
		}

		public void setMessage_id(long message_id) {
			this.message_id = message_id;
		}
}
