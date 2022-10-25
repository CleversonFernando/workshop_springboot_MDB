package com.cleversonfernando.workshopspringboot2.repository;

import com.cleversonfernando.workshopspringboot2.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
