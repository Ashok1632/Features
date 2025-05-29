package com.ashok.emailnotification.service;

import com.ashok.emailnotification.entity.User;
import com.ashok.emailnotification.payload.RequestDto;
import com.ashok.emailnotification.payload.UserDetailsDto;

import java.util.List;

public interface UserService {

    public void registerUser(RequestDto requestDto);

    public UserDetailsDto getUserByEmail(String email);

    public List<UserDetailsDto> getAllUsers();

    public boolean updateUser(RequestDto requestDto);

    public boolean deleteUser(String email);
}
