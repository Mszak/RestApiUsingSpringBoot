package basicapi.resources;

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
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import basicapi.model.Message;
import basicapi.service.MessageService;


/**
 *
 * @author Maniek
 */

@RestController
public class MessageResource {
    
	@Autowired
	private MessageService messageService;
    
    
    @RequestMapping("/messages")
    public List<Message> getAllMessages(){
    	return messageService.getAllMessages();
    }
    
    @RequestMapping("/messages/{id}")
    public Message getMessage(@PathVariable Long id) {
    	Optional<Message> optionalHelp = messageService.getMessage(id);
    	Message help = optionalHelp.get();
    	help.add(linkTo(methodOn(MessageResource.class).getMessage(id)).withSelfRel());
    	help.add(linkTo(methodOn(CommentResource.class).getAllComments(id)).withRel("Comments"));
    	help.add(linkTo(methodOn(ProfileResource.class).getProfile(help.getAuthor())).withRel("Author profile"));
    	return help;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/messages")
    public void addMessage(@RequestBody Message message) {
    	messageService.addMessage(message);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/messages/{id}")
    public void updateMessage(@RequestBody Message message, @PathVariable Long id) {
    	messageService.updateMessage(message, id);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/messages/{id}")
    public void deleteMessage(@PathVariable Long id) {
    	messageService.removeMessage(id);
    }
    
}
