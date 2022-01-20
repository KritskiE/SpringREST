package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.entities.Social;
import com.springrest.springrest.entities.User;
import com.springrest.springrest.repository.SocialRepository;
@RestController
public class SocialController {
	@Autowired
	private SocialRepository repository;
	//Svi drustvene mreze
	@GetMapping("/platform")
	public List<Social> getAllPlatforms(){
		return (List<Social>)repository.findAll();
	}
	//mreza po id
	@GetMapping("/platform/{id}")
	public Social getOne(@PathVariable int id) {
		return repository.findById(id).orElse(null);
	}
	//cuva odredjenu mrezu
	@PostMapping("/platform")
	public Social postOne(@RequestBody Social social) {
		return repository.save(social);
	}
	//dobija mrezu po id-ju
	@PutMapping("/platform/{id}")
	public Social updateSocial(@PathVariable int id, @RequestBody Social social) {
		return repository.save(social);
		
	}
	//brise mrezu po id
	@DeleteMapping("/platform/{id}")
	public String deleteSocial(@PathVariable int id) {
		repository.deleteById(id);
		return " Social id:" + id + "\nDeleted: OK"; 
	}
	//Vraca listu mreza po regionu
	@GetMapping("/platform/region/{region}")
	public List<Social> getSocialRegion(@PathVariable String region) {
		return repository.findByRegion(region);
	}
	
	//Vraca prazan skup, nema greske u springu
	/*@GetMapping("/two/{region}/{platform}")
	@ResponseBody
	public List<Social> getPlatformByRP(@PathVariable("platform") String platform , @PathVariable("region") String region){
		return repository.findByRegionAndPlatformAllIgnoreCase(platform, region);
	}
	isto i ovde vraca prazan skup []
	//Platforma po svim regionima
	@GetMapping("/props/{platform}")
	public List<Social> getAllPlatformRegions(@PathVariable String platform){
		return (List<Social>)repository.findSocialsByPlatform(platform);
	}*/
	//Lista platformi koje koristi user
	@GetMapping("/platform/platformusers")
	public List<Social> getSocialsByUsers(@RequestBody User user){
		return repository.findAllSocialsByUsers(user);
	}

	
}











