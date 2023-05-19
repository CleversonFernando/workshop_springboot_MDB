package com.cleversonfernando.workshopspringboot2.DTO;

import com.cleversonfernando.workshopspringboot2.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO(User obj) {
        BeanUtils.copyProperties(obj, this);
    }
}
