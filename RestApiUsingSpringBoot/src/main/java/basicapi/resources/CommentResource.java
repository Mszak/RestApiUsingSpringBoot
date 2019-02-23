package basicapi.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import basicapi.model.Comment;
import basicapi.service.CommentService;


/**
 *
 * @author Maniek
 */

@RestController
public class CommentResource {
    
	@Autowired
	private CommentService commentService;
    
    
    @RequestMapping("/messages/{id}/comments")
    public List<Comment> getAllComments(@PathVariable Long id){
    	return commentService.getAllComments(id);
    }
    
    @RequestMapping("/messages/{id}/comments/{commentId}")
    public Comment getComment(@PathVariable Long id, @PathVariable Long commentId) {
    	Optional<Comment> optionalHelp = commentService.getComment(commentId);
    	Comment help = optionalHelp.get();
    	help.add(linkTo(methodOn(CommentResource.class).getComment(id, commentId)).withSelfRel());
    	help.add(linkTo(methodOn(ProfileResource.class).getProfile(help.getAuthor())).withRel("Author profile"));
    	return help;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/messages/{id}/comments")
    public void addComment(@RequestBody Comment comment, @PathVariable Long id) {
    	commentService.addComment(id, comment);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/messages/{id}/comments/{commentId}")
    public void updateComment(@RequestBody Comment comment, @PathVariable Long id, @PathVariable Long commentId) {
    	commentService.updateComment(id,commentId, comment);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/messages/{id}/comments/{commentId}")
    public void deleteMessage(@PathVariable Long id, @PathVariable Long commentId) {
    	commentService.removeComment(commentId);
    }
}
