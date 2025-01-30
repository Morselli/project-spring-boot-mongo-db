package com.viniciusmorselli.projectspringmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viniciusmorselli.projectspringmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
