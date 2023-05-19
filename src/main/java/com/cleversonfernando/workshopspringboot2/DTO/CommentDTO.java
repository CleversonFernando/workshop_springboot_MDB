package com.cleversonfernando.workshopspringboot2.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO implements Serializable {

    private String text;
    private Date date;
    private AuthorDTO author;
}

