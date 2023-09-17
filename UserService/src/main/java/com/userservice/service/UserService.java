package com.userservice.service;

import com.userservice.dto.PostResponse;
import com.userservice.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public UserDto saveData(UserDto userdto);

    PostResponse findAllData(int pageNo, int pageSize, String sortBy, String sortDir);

    UserDto findByIds(String userId);

    void deleteByIds(String userId);

    UserDto updatePosts(String id, UserDto userDto);
}
