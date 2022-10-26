package com.cleversonfernando.workshopspringboot2.services;


import com.cleversonfernando.workshopspringboot2.DTO.UserDTO;
import com.cleversonfernando.workshopspringboot2.domain.Post;
import com.cleversonfernando.workshopspringboot2.domain.User;
import com.cleversonfernando.workshopspringboot2.repository.PostRepository;
import com.cleversonfernando.workshopspringboot2.repository.UserRepository;
import com.cleversonfernando.workshopspringboot2.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
    public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll(){
        return repo.findAll();
    }

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
    }
}
