package com.revature.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.UserCurrency;

@Repository
public interface UserCurrencyDao extends JpaRepository<UserCurrency, Integer> {

}
