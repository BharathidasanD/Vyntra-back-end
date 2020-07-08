package com.vyntrademo.Contollers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vyntrademo.dao.ProductRepo;
import com.vyntrademo.model.Product;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	ProductRepo productrepo;
	
	private byte[] bytes;
	
	@GetMapping("/listproducts")
	public List<Product> getProducts()
	{
		return productrepo.findAll();
	}
	
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.setBytes(file.getBytes());
	}
	@PostMapping("/addproduct")
	public void createBook(@RequestBody Product new_product) throws IOException {
		new_product.setPicByte(this.bytes);
		productrepo.save(new_product);
		this.bytes = null;
	}
	@PutMapping("/update")
	public void updateBook(@RequestBody Product product) {
		productrepo.save(product);
	}

	@DeleteMapping(path = { "/{id}" })
	public String removeProduct(@PathVariable("id") long id) {
		Product product = productrepo.getOne(id);
		productrepo.deleteById(id);
		return product.getProductName()+" deleted successfully";
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

}
