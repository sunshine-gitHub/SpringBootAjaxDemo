package ecnu.cy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import ecnu.cy.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findById(int id);
	
	User findByName(String name);
	
	@Transactional
	int deleteById(int id);
	
	@Transactional
	@Modifying
	@Query("update User u set u.age =:age where u.id =:id")
	int updateUserAge(@Param("age") String age, @Param("id") int id);
}
