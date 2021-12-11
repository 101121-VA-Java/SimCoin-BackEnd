package com.revature.DAO;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findUsersByRole(String role);
	 User save(User user);
	 
	

	
}
