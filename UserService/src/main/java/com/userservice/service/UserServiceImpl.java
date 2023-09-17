package com.userservice.service;

import com.userservice.Exception.ResourceNotFoundException;
import com.userservice.dto.PostResponse;
import com.userservice.dto.UserDto;
import com.userservice.entity.User;
import com.userservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto saveData(UserDto userdto) {

        User user=mapToUser(userdto);
        String s1 = UUID.randomUUID().toString();
        user.setId(s1);

        User save = userRepo.save(user);
UserDto use=mapToDto(save);

        return use;
    }

    @Override
    public PostResponse findAllData(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<User> all = userRepo.findAll(pageable);
        List<User> users = all.getContent();
        List<UserDto> collect = users.stream().map(s -> mapToDto(s)).collect(Collectors.toList());

        PostResponse pr=new PostResponse();
        pr.setContent(collect);
        pr.setPageNo(all.getNumber());
        pr.setPageSize(all.getSize());
        pr.setTotalElements(all.getTotalElements());

        pr.setTotalPages(all.getTotalPages());
        pr.setLastPage(all.isLast());

        return pr;
    }



    @Override
    public UserDto findByIds(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found !!!" + userId));

        UserDto userDto = mapToDto(user);
        return userDto;
    }

    @Override
    public void deleteByIds(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException());
        userRepo.delete(user);
    }

    @Override
    public UserDto updatePosts(String id, UserDto userDto) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException());
        user.setDescription(userDto.getDescription());
        user.setEmail(user.getEmail());
        User save = userRepo.save(user);
        UserDto userDto1 = mapToDto(save);
        return userDto1;
    }

    public UserDto mapToDto(User save) {
        UserDto map = modelMapper.map(save, UserDto.class);
return map;
    }

    public User mapToUser(UserDto userdto) {

        User u = modelMapper.map(userdto, User.class);
    return u;
    }
}
