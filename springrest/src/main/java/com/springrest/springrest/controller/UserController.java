package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.springrest.springrest.entities.Social;
import com.springrest.springrest.entities.User;
import com.springrest.springrest.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository repo;
	//svi korisnici
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return (List<User>) repo.findAll();
	}
	//trazi korisnika po id
	@GetMapping("/users/{id}")
	public User getOne(@PathVariable int id) {
		return repo.findById(id).orElse(null);
	}
	//Brise korisnika sa odredjenim id-jem
	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable int id) {
		repo.deleteById(id);
		return " User id: "+id +"\nDeleted: OK.";
	}
	//Kreira novog korisnika
	@PostMapping("/users")
	public User postUser(@RequestBody User user) {
		return repo.save(user);
	}
	//Update-uje korisnika po id
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User user) {
		return repo.save(user);
	}
	/*
	//brise korisnika po email-u
	@DeleteMapping("/users/{email}")
	public String deleteByEmail(@PathVariable String email) {
		repo.deleteUserByEmail(email);
		return "User sa e-mailom:  "+email+"\nDeleted : OK";
	}*/
	//Vraca sve korisnike iz zajednicke tabele.
	//Svi korisniki neke drustvene mreze
	@GetMapping("/userbysocial")
	public List<User> getUserBySocial(@RequestBody Social social){
		return repo.findAllUsersBySocials(social);
	}
	/*@PostMapping("/social_us/{user_id}/{social_id}")
	public String postUserInPlatform(@PathVariable int user_id,@PathVariable int social_id) {
		repo.saveUserIdAndSocialId(user_id, social_id);
		return "User added to platform";
	}*/
	//trazi korisnike po email-u
	@GetMapping("/{email}")
	public User getUserByEmail(@PathVariable String email) {
		return repo.findByEmail(email);
		
	}
	//trazi sve po operativnom sistemu
	@GetMapping("/ops/{os}")
	public List<User> getUsersByOS(@PathVariable String os){
		return (List<User>)repo.findUserByOs(os);
	}
	//trzi sve po zemlji
	@GetMapping("/cnt/{country}")
	public List<User> getUsersByCountry(@PathVariable String country){
		return (List<User>)repo.findUsersByCountry(country);
	}
	//trazi sve po imenu
	@GetMapping("/name/{firstname}")
	public User getUserByFirstname(@PathVariable String firstname) {
		return repo.findUserByFirstname(firstname);
	}
	//trazi sve po imenu(Ako ima vise sa istim imenom vraca)
	@GetMapping("/name-l/{firstname}")
	public List<User> getUsersByFirstname(@PathVariable String firstname){
		return (List<User>)repo.findUsersByFirstname(firstname);
	}
	//Trazi sve po prezimenu
	@GetMapping("/lastname/{lastname}")
	public List<User> getUsersByLastname(@PathVariable String lastname) {
		return (List<User>)repo.findUsersByLastname(lastname);
	}
	//Trazi po zemlji , grupise po prezimenu
	@GetMapping("/order/{country}")
	public List<User> getUsersOrderedByLastname(@PathVariable String country){
		return (List<User>)repo.findByCountryOrderByLastname(country);
	}
	
}







