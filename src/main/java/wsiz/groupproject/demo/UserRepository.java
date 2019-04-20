package wsiz.groupproject.demo;

import org.springframework.data.repository.CrudRepository;
import wsiz.groupproject.demo.Service.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
