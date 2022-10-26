package com.cleversonfernando.workshopspringboot2.resources;

import com.cleversonfernando.workshopspringboot2.DTO.UserDTO;
import com.cleversonfernando.workshopspringboot2.domain.Post;
import com.cleversonfernando.workshopspringboot2.domain.User;
import com.cleversonfernando.workshopspringboot2.services.PostService;
import com.cleversonfernando.workshopspringboot2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}