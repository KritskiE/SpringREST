package com.springrest.springrest.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.springrest.springrest.entities.Social;
import com.springrest.springrest.entities.User;
@Repository
public interface SocialRepository extends CrudRepository<Social,Integer> {
			
		 
		 List<Social> findByRegion(String region);
		 
		 List<Social> findByRegionAndPlatformAllIgnoreCase(String platform,String region);
		 
		 List<Social> findSocialsByPlatform(String platform);
		 
		 List<Social> findAllSocialsByUsers(User user);
		 
		 
		 
		 
}
