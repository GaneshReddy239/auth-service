package com.ganesh.auth_service.Configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {
    public ModelMapper getMapper(){
            return new ModelMapper();
    }
}
