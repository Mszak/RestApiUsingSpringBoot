package basicapi.repository;

import org.springframework.data.repository.CrudRepository;

import basicapi.model.Comment;

public interface CommentRepository extends CrudRepository<Comment,Long> {

}