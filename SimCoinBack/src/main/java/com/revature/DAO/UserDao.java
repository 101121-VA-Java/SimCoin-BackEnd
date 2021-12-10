package com.revature.DAO;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
//	boolean addUser (User u);

	
}
