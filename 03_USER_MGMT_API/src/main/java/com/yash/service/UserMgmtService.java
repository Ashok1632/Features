package com.yash.service;

import java.util.List;

import com.yash.binding.ActivateAccount;
import com.yash.binding.Login;
import com.yash.binding.User;

public interface UserMgmtService {
public boolean saveUser(User user);
public boolean activateUserAcc(ActivateAccount activateacc);
public List<User> getAllUsers();
public User getUserById(Integer userId);
public User getUserByEmail(String email);
public boolean deleteUserById(Integer userId);
public boolean changeAccountStatus(Integer userId,String accStatus);
public String login(Login login);
public String forgotPwd(String email);

}
