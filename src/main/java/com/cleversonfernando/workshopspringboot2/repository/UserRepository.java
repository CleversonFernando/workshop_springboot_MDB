package com.cleversonfernando.workshopspringboot2.repository;

import com.cleversonfernando.workshopspringboot2.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
