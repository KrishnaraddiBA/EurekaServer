package com.userservice.controller;

import com.userservice.dto.PostResponse;
import com.userservice.dto.UserDto;
import com.userservice.entity.User;
import com.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/v2")
    public ResponseEntity<UserDto> saveData(@RequestBody UserDto userdto){
        UserDto userDto = userService.saveData(userdto);
return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }
//here we are implementing a pagination feature
    @GetMapping("/v3")
    public ResponseEntity<PostResponse> getAllUser(@RequestParam(value = "pageNo",defaultValue = "0",required = false) int pageNo,
                                                   @RequestParam(value = "pageSize",defaultValue = "10",required = false)int pageSize,
                                                   @RequestParam(value = "sortBy",defaultValue = "userId",required = false)String sortBy,
                                                   @RequestParam(value="sortDir",defaultValue = "asc",required = false)String sortDir){
        PostResponse allData = userService.findAllData(pageNo, pageSize, sortBy, sortDir);
        return ResponseEntity.ok(allData);
    }
    @GetMapping("/v4/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId){
        UserDto byIds = userService.findByIds(userId);
        return new ResponseEntity<>(byIds,HttpStatus.OK);
    }
    @DeleteMapping("/v5/{userId}")
    public ResponseEntity<String> deleteUserById(@PathVariable String userId){
        userService.deleteByIds(userId);
        return ResponseEntity.ok("deleted successfully!!!");
    }

    @PutMapping("v6/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") String id,@RequestBody UserDto userDto){
        UserDto userDto1 = userService.updatePosts(id, userDto);

    return new ResponseEntity<>(userDto1,HttpStatus.CREATED);
    }



}
