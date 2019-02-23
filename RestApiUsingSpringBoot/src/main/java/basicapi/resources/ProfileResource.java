package basicapi.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import basicapi.model.Profile;
import basicapi.service.ProfileService;


/**
 *
 * @author Maniek
 */

@RestController
public class ProfileResource {
    
	@Autowired
	private ProfileService profileService;
    
    
    @RequestMapping("/profiles")
    public List<Profile> getAllProfiles(){
    	return profileService.getAllProfiles();
    }
    
    @RequestMapping("/profiles/{name}")
    public Profile getProfile(@PathVariable String name) {
    	Profile help = profileService.getProfile(name);
    	help.add(linkTo(methodOn(ProfileResource.class).getProfile(name)).withSelfRel());
    	return help;
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/profiles")
    public void addProfile(@RequestBody Profile profile) {
    	profileService.addProfile(profile);
    }
    
    @RequestMapping(method=RequestMethod.PUT, value="/profiles/{name}")
    public void updateProfile(@RequestBody Profile profile, @PathVariable String name) {
    	profileService.updateProfile(profile, name);
    }
    
    @RequestMapping(method=RequestMethod.DELETE, value="/profiles/{id}")
    public void deleteProfile(@PathVariable String id) {
    	profileService.removeProfile(id);
    }
}
