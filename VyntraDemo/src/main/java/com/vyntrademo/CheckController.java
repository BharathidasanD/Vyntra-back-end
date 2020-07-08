package com.vyntrademo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckController {
	
	@RequestMapping("/")
	public String hello()
	{
		
		
		System.out.print("hello world");
		return "hii";
	}

}
