/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicapi.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import basicapi.model.Message;
import basicapi.model.Profile;
import basicapi.repository.ProfileRepository;

/**
 *
 * @author Maniek
 */
@Service
public class ProfileService {
    
 
    public ProfileService(){
    }
    
    @Autowired
    private ProfileRepository profileRepository;
    
    public List<Profile> getAllProfiles(){
    	List<Profile> list = new ArrayList<Profile>();
    	profileRepository.findAll().forEach(list::add);
    	return list;
        
    }
    
    public Profile getProfile(String name){
    	List<Profile> list = this.getAllProfiles();
    	for (Profile profile : list) {
    		if (profile.getProfile_name().equals(name)) {
    			return profile;
    		}
    	}
    	return null;
    }
    
    public void addProfile(Profile profile){
    	profile.setCreated(Message.getCurrentTimeStamp());
    	profileRepository.save(profile);
    }
    public void updateProfile(Profile profile, String name){
    	Profile help = this.getProfile(name);
    	profile.setProfile_id(help.getProfile_id());
    	profileRepository.save(profile);
    }
    public void removeProfile(String name){
    	Profile help = this.getProfile(name);
    	profileRepository.delete(help);
    }
    
    private java.sql.Timestamp getCurrentTimeStamp() {
        java.util.Date today = new java.util.Date();
	return new java.sql.Timestamp(today.getTime());
    }
}
