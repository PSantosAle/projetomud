package br.com.sandro.mudi.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import br.com.sandro.mudi.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
	

}
