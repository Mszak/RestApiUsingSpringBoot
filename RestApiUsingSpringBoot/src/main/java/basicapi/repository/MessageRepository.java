package basicapi.repository;

import org.springframework.data.repository.CrudRepository;

import basicapi.model.Message;

public interface MessageRepository extends CrudRepository<Message,Long> {

}
