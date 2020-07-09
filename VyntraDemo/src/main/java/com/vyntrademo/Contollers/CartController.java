package com.vyntrademo.Contollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vyntrademo.dao.ProductRepo;
import com.vyntrademo.dao.ShoppingCartRepo;
import com.vyntrademo.model.CartItems;
import com.vyntrademo.model.Product;
import com.vyntrademo.model.ShoppingCart;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "cart")
public class CartController {
	@Autowired
	ProductRepo productrepo;
	@Autowired
	ShoppingCartRepo shoppingcartrepo;
	//add products to cart
    @PostMapping("/addcartdetails")
    public String addCartDetails(@RequestBody ShoppingCart shoppingcart) throws DataIntegrityViolationException{
    	try{
    		
    		shoppingcartrepo.save(shoppingcart);
    	}
    	catch(DataIntegrityViolationException e){
    		 return "Something went wrong!....";
    	}
    	
    	return " registered successfully.";
    }
	 // get products from cart
    @GetMapping("/listcartdetails/{userid}")
	public List<CartItems> listCartDetails(@PathVariable("userid") Long userId){
    	System.out.print(userId);
    	ArrayList<CartItems> al=new ArrayList<>();
		List<ShoppingCart> list_of_cart= shoppingcartrepo.findByuserId(userId);
		System.out.print(list_of_cart.size());
		for(ShoppingCart shoppingCart:list_of_cart) {
			CartItems cartitems=new CartItems();
			Product productForCart=productrepo.findByproductId(shoppingCart.getProductId());
			cartitems.setPicByte(productForCart.getPicByte());
			cartitems.setProductName(productForCart.getProductName());
			cartitems.setProductDetail(productForCart.getProductDetail());
			cartitems.setNoOfProduct(shoppingCart.getNoOfProducts());
			cartitems.setTotalPrice(productForCart.getProductPrice());
			al.add(cartitems);
		}
		//cartitems.setPicByte(picturebyte);
		 return al;	
	}
}
