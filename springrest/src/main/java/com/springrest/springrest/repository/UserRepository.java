package com.springrest.springrest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestBody;

import com.springrest.springrest.entities.Social;
import com.springrest.springrest.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	String deleteUserByEmail(String email);
	
	List<User> findAllUsersBySocials(Social social);
	
	//String saveUserIdAndSocialId(int userId,int socialId);
	
	User findByEmail(String email);
	
	List<User> findUserByOs(String os);
	
	List<User> findUsersByCountry(String country);
	
	User findUserByFirstname(String firstname);
	
	List<User> findUsersByFirstname(String firstname);
	
	List<User> findUsersByLastname(String lastname);
	
	List<User> findByCountryOrderByLastname(String country);
	
	

}
