package com.cleversonfernando.workshopspringboot2.config;

import com.cleversonfernando.workshopspringboot2.DTO.AuthorDTO;
import com.cleversonfernando.workshopspringboot2.DTO.CommentDTO;
import com.cleversonfernando.workshopspringboot2.domain.Post;
import com.cleversonfernando.workshopspringboot2.domain.User;
import com.cleversonfernando.workshopspringboot2.repository.PostRepository;
import com.cleversonfernando.workshopspringboot2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import static java.util.TimeZone.getTimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));


        Post post1 = new Post(null, sdf.parse("21/03/2018"), new AuthorDTO(maria), "partiu viagem", "Vou viajar para são paulo");
        Post post2 = new Post(null, sdf.parse("23/03/2018"), new AuthorDTO(maria), "Bom dia", "Acordei feliz hoje");

        CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);
    }
}
