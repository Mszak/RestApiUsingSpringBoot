/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import basicapi.model.Comment;
import basicapi.repository.CommentRepository;


/**
 *
 * @author Maniek
 */

@Service
public class CommentService {
    
	@Autowired
	private CommentRepository commentRepository;
         
    public List <Comment> getAllComments(Long id){
    	List<Comment> list = new ArrayList<Comment>();
    	commentRepository.findAll().forEach(comment->{
    		if (comment.getMessage_id()==id) {
    			list.add(comment);
    		}
    	});
    	
    	return list;
    }
    
    public Optional<Comment> getComment(long commentId){
        return commentRepository.findById(commentId);
    }
    
    public void addComment(long messageId, Comment comment){
        comment.setMessage_id(messageId);
        commentRepository.save(comment);
    }
    
    public void updateComment(long messageId, long commentId, Comment comment){
    	comment.setMessage_id(messageId);
    	comment.setId(commentId);
    	commentRepository.save(comment);
    }
    
    public void  removeComment(long commentId){
    	commentRepository.deleteById(commentId);
  
    }
}
