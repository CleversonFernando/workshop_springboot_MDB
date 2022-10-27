package com.cleversonfernando.workshopspringboot2.repository;

import com.cleversonfernando.workshopspringboot2.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
