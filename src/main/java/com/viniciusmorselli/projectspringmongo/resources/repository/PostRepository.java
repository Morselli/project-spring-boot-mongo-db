package com.viniciusmorselli.projectspringmongo.resources.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.viniciusmorselli.projectspringmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
  
}
