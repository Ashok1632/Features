package com.yash.service.Impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.yash.binding.ActivateAccount;
import com.yash.binding.Login;
import com.yash.binding.User;
import com.yash.entity.UserMaster;
import com.yash.repo.UserMasterRepo;
import com.yash.service.UserMgmtService;
import com.yash.utils.EmailUtils;

@Service
public class UserMgmtServiceImpl implements UserMgmtService {
	@Autowired
	private UserMasterRepo userMasterRepo;
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		UserMaster entity = new UserMaster();
		BeanUtils.copyProperties(user, entity);
		entity.setPassword(generateRandomPwd());
		entity.setAccStatus("In-Active");
		UserMaster save=userMasterRepo.save(entity);
		//send email to email id
		String subject="Your registration Sucsess";
		String filename="REG-EMAIL-BODY.txt";
		String body=readEmailBody(entity.getFullname(),entity.getPassword(),filename);
		emailUtils.sendEmail(user.getEmail(), subject, body);
		return save.getUserId()!=null;
	}

	@Override
	public boolean activateUserAcc(ActivateAccount activateacc) {
		// TODO Auto-generated method stub
	UserMaster entity=new UserMaster();
	entity.setEmail(activateacc.getEmail());
	entity.setPassword(activateacc.getTempPwd());
	//select * from UserMaster where email=? and pwd=?
	Example<UserMaster> of = Example.of(entity);
	List<UserMaster> findAll = userMasterRepo.findAll(of);
	if(findAll.isEmpty())
	{
		return false;
	}else
	{
		UserMaster userMaster=findAll.get(0);
		userMaster.setPassword(activateacc.getNewPwd());
		userMaster.setAccStatus("Active");
		userMasterRepo.save(userMaster);
		return true;
	}
		
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserMaster> findAll = userMasterRepo.findAll();
		List<User> users=new ArrayList<>();
		for(UserMaster entity:findAll)
		{
			User user=new User();
			BeanUtils.copyProperties(entity, users);
			users.add(user);
		}
		return users;
	}

	@Override
	public User getUserById(Integer userId) {
		// TODO Auto-generated method stub
		Optional<UserMaster> findById = userMasterRepo.findById(userId);
	if(findById.isPresent())
	{
		User user=new User();
		UserMaster userMaster = findById.get();
		BeanUtils.copyProperties(userMaster,user);
		return user;
	}
		
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		// TODO Auto-generated method stub
		try {
			userMasterRepo.deleteById(userId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean changeAccountStatus(Integer userId, String accStatus) {
		// TODO Auto-generated method stub
		Optional<UserMaster> findById = userMasterRepo.findById(userId);
		if(findById.isPresent())
		{
			UserMaster userMaster = findById.get();
			userMaster.setAccStatus(accStatus);
			return true;
			
		}
		return false;
	}

	@Override
	public String login(Login login) {
		// TODO Auto-generated method stub
		/*
		 * UserMaster entity=new UserMaster(); entity.setEmail(login.getEmail());
		 * entity.setPassword(login.getPassword()); Example<UserMaster> of =
		 * Example.of(entity); List<UserMaster> findAll = userMasterRepo.findAll(of);
		 */
		UserMaster entity = userMasterRepo.findByEmailAndPassword(login.getEmail(), login.getPassword());
		if(entity==null)
		{
			return "Invalid Credentials";
		}
		else {
			//UserMaster userMaster = findAll.get(0);
			if(entity.getAccStatus().equals("Active"))
			{
				return "Success";
			}else
			{
				return "Account Not Activated";
			}
				
		}
	}

	@Override
	public String forgotPwd(String email) {
		// TODO Auto-generated method stub
		UserMaster entity = userMasterRepo.findByEmail(email);
		if(entity==null)
		{
			return "Invalid Email";
		}
		else
		{
			String subject="Forgot Password";
			String fileName="RECOVER-MAIL-BODY.txt";
			String body=readEmailBody(entity.getFullname(), entity.getPassword(), fileName);
			boolean sendEmail = emailUtils.sendEmail(email, subject, body);
			if(sendEmail)
			{
				return "Password sent to your registred email";
			}
		}
		return null;
	}

	private String generateRandomPwd() {

		String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		int length = 6;

		for (int i = 0; i < length; i++) {

			int index = random.nextInt(alphaNumeric.length());

			char randomChar = alphaNumeric.charAt(index);

			sb.append(randomChar);
		}

		return sb.toString();

	}
	private String readEmailBody(String fullname,String pwd,String filename)
	{
		String url="";
		String mailBody=null;
		try {
			FileReader fr=new FileReader(filename);
			BufferedReader br=new BufferedReader(fr);
			StringBuffer buffer=new StringBuffer();
			String line = br.readLine();
			while(line!=null)
			{
				buffer.append(line);
				line=br.readLine();
			}
			br.close();
			mailBody=buffer.toString();
			mailBody=mailBody.replace("{FULLNAME}", fullname);
			mailBody=mailBody.replace("{TEMP-PWD}", pwd);
			mailBody=mailBody.replace("{URL}", url);
			mailBody=mailBody.replace("{PWD}", pwd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mailBody;
		
	}

}
