package com.stiamiwebapps.stiami.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.stiamiwebapps.stiami.model.Users;


public interface UsersRepository extends MongoRepository<Users, String> {
	Users findBy_id(ObjectId _id);

	@Query(value = "{'username' : ?0}")
	Users findByUserName(String username);

	@Query(value = "{'username' : ?0 ,'password' : ?1}")
	Users signIn(String username, String password);
	
	@Query(value = "{'roles' : {'$ref' : 'roles' , '$id' : ?0} }")
	List<Users> findByRoleId(ObjectId roleId);
	
	@Query(value = "{'roles' : {'$ref' : 'roles' , '$id' : ?0} }")
	List<Users> findByRoleId(ObjectId roleId, Pageable pageable);
	
	@Query(value = "{'facebookId' : ?0}")
	Users findByFaceBookId(String string);
	
	@Query(value = "{'googleId' : ?0}")
	Users findByGoogleId(String string);
}