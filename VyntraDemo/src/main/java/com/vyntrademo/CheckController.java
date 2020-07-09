package com.vyntrademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vyntrademo.dao.CustomerRepo;
import com.vyntrademo.model.Customer;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CheckController {
	
	@Autowired
	CustomerRepo customerrepo;
	@RequestMapping("/")
	public String hello()
	{
		
		
		System.out.print("hello world");
		return "hii how are you?";
	}
	 @PostMapping("/authenticate")
    public long listUsers(@RequestBody Login login)
    {
    	Customer customeremail=customerrepo.findByEmail(login.getUserdata());
    	Customer customerphone=customerrepo.findByPhone(login.getUserdata());
    	System.out.println("Customers...........");
    	System.out.println(customeremail);
    	System.out.println(customerphone);
    	
    	 if(customeremail!=null && customeremail.getUser_password().equals(login.getPassword()))
    	{
    		return customeremail.getUser_id();
    	}
    	else if(customerphone!=null && customerphone.getUser_password().equals(login.getPassword()))
    	{
    		return customerphone.getUser_id();
    	}
    	
    	return (long)0;
    }

}
