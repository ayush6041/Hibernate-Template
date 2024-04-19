package org.jsp.hibernateTemplatePractice.Controller;

import java.util.Scanner;

import org.jsp.hibernateTemplatePractice.DAO.UserDao;
import org.jsp.hibernateTemplatePractice.DTO.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class UserController {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring-orm.xml");
		UserDao userDao=context.getBean("userDao",UserDao.class);
		System.out.println("1.Save User");
		System.out.println("2.Update User");
		System.out.println("3.Find User By Id");
		System.out.println("4.Delete User By Id");
		System.out.println("5.Verify User By Phone and Password");
		System.out.println("6.Verify User By email and password");
		System.out.println("7.Verify User By Id and password");
		System.out.println("8.Find User By Phone");
		System.out.println("9.Find User By email");
		System.out.println("10.Find Users By name");
		Scanner sc=new Scanner(System.in);
		switch(sc.nextInt()) {
		case 1:{
			System.out.println("Enter the  Name,Phone,Email and Password to save");
			User user=new User();
			user.setName(sc.next());
			user.setPhone(sc.nextLong());
			user.setEmail(sc.next());
			user.setPassword(sc.next());
			user=userDao.saveUser(user);
			System.out.println("User saved with Id :"+user.getId());
			break;
		}
		case 2:{
			System.out.println("Enter  the ID,Name,Phone,Email and Password to update");
			User user=new User();
			user.setId(sc.nextInt());
			user.setName(sc.next());
			user.setPhone(sc.nextLong());
			user.setEmail(sc.next());
			user.setPassword(sc.next());
			user=userDao.updateUser(user);
			
			if(user!=null) {
				System.out.println("User with id "+user.getId()+" updated");
			}
			else{
				System.err.println("Invalid user ID");
			}
			break;
		}
		case 3:{
			System.out.println("Enter the user ID to print details");
			User user=userDao.findById(sc.nextInt());
			if(user!=null) {
				System.out.println(user);
			}
			else {
				System.err.println("Invalid details");
			}
			break;
		}
		case 4 :{
			System.out.println("Enter the user ID to delete the User details");
			boolean delete=userDao.delete(sc.nextInt());
			if(delete) {
				System.out.println("deleted");
			}
			else {
				System.err.println("invalid id");
			}
			break;
		}
		case 5:{
			System.out.println("Enter the Phone and Password to verify");
			User user=userDao.verifyUser(sc.nextLong(),sc.next());
			if(user!=null) {
				System.out.println("Verified Succesfull");
				System.out.println(user);
			}
			else {
				System.out.println("Invalid Details");
			}
			break;
		}
		case 6:{
			System.out.println("Enter the Email and Password to verify");
			User user=userDao.verifyUser(sc.next(),sc.next());
			if(user!=null) {
				System.out.println("Verified Succesfull");
				System.out.println(user);
			}
			else {
				System.out.println("Invalid Details");
			}
			break;
		}
		case 7:{
			System.out.println("Enter the ID and Password to verify");
			User user=userDao.verifyUser(sc.nextInt(),sc.next());
			if(user!=null) {
				System.out.println("Verified Succesfull");
				System.out.println(user);
			}
			else {
				System.out.println("Invalid Details");
			}
			break;
		}
		
		case 8:{
			System.out.println("Enter the Phone number to find user");
			User user= userDao.findByPhone(sc.nextLong());
			if(user!=null)
				System.out.println(user);
			else {
				System.out.println("Invalid details");
			}
			break;
		}
		case 9:{
			System.out.println("Enter the email number to find user");
			User user= userDao.findByEmail(sc.next());
			if(user!=null)
				System.out.println(user);
			else {
				System.out.println("Invalid details");
			}
			break;
		}
		case 10:{
			System.out.println("Enter the name number to find user");
			User user= userDao.findByName(sc.next());
			if(user!=null)
				System.out.println(user);
			else {
				System.out.println("Invalid details");
			}
			break;
		}

		}
	}
}
