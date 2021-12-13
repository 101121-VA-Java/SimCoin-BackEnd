package com.revature.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	List<User> findUsersByRole(String role);
	
	User findUserByUsername(String username);

}
