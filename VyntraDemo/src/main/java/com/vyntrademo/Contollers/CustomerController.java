package com.vyntrademo.Contollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vyntrademo.dao.CustomerRepo;
import com.vyntrademo.dao.ShoppingCartRepo;
import com.vyntrademo.dao.UserRepo;
import com.vyntrademo.model.CartItems;
import com.vyntrademo.model.Customer;
import com.vyntrademo.model.ShoppingCart;
import com.vyntrademo.model.User;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "users")
public class CustomerController {
	@Autowired
	CustomerRepo customerrepo;
	@Autowired
	UserRepo userrepo;
	
	
	//return list of Customers.........
	@GetMapping("/listusers")
	public List<Customer> listCustomer(){
		return customerrepo.findAll();
	}
	//add a customer..........
    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer) throws DataIntegrityViolationException{
    	try{
    		customer.setRole("ROLE_USER");
    		customerrepo.save(customer);
    	}
    	catch(DataIntegrityViolationException e){
    		return "Already Registered email or phone";
    	}
    	
    	return customer.getName()+" registered successfully.";
    }
    //delete a customer......by an admin
    @DeleteMapping(path = { "/{id}" })
    public  String deleteCustomer(@PathVariable("id") Long id) throws Exception{
    	Customer deletedCustomer=customerrepo.getOne(id);
    	try {
    	 customerrepo.deleteById(id);
    	 System.out.print(deletedCustomer);
    	
    	}
    	catch(Exception e){
    		System.out.print("psing data");
    		 return deletedCustomer.getName()+" deleted";
    	}
    	
    	 return deletedCustomer.getName()+" deleted";
    }
    
   /* @RequestMapping("/authenticate")
    public String listUsers(@RequestParam(value="userdata") String exp,@RequestParam(value="password") String pwd)
    {
    	Customer customeremail=customerrepo.findByEmail(exp);
    	Customer customerphone=customerrepo.findByPhone(exp);
    	System.out.println("Customers...........");
    	System.out.println(customeremail);
    	System.out.println(customerphone);
    	
    	 if(customeremail!=null && customeremail.getUser_password().equals(pwd))
    	{
    		return customeremail.getName();
    	}
    	else if(customerphone!=null && customerphone.getUser_password().equals(pwd))
    	{
    		return customerphone.getName();
    	}
    	
    	return "not a user";
    }*/
    //return all users.......
    @RequestMapping("/userdetails")
    public List<User> newUser()
    {
    	return userrepo.findAll();
    }
    
  
    
}
