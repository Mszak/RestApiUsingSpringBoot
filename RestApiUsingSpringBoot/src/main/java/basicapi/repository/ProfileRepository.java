package basicapi.repository;

import org.springframework.data.repository.CrudRepository;

import basicapi.model.Profile;

public interface ProfileRepository extends CrudRepository<Profile,String> {

}