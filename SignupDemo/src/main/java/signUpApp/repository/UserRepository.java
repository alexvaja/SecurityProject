package signUpApp.repository;

import org.springframework.data.repository.CrudRepository;

import signUpApp.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>
{

}
