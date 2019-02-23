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
import basicapi.model.Message;
import basicapi.repository.MessageRepository;

/**
 *
 * @author Maniek
 */
@Service
public class MessageService {
    
 
    public MessageService(){
    }
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAllMessages(){
    	List<Message> list = new ArrayList<Message>();
    	messageRepository.findAll().forEach(list::add);
    	return list;
        
    }
    
    public Optional<Message> getMessage(long id){
      return messageRepository.findById(id);
    }
    
    public void addMessage(Message message){
    	message.setCreated(Message.getCurrentTimeStamp());
    	messageRepository.save(message);
    }
    public void updateMessage(Message message, long id){
    	message.setId(id);
    	messageRepository.save(message);
    }
    public void removeMessage(long id){
        messageRepository.deleteById(id);
    }
}
