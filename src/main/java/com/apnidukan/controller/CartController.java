package com.apnidukan.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apnidukan.entity.Cart;
import com.apnidukan.entity.Product;
import com.apnidukan.entity.User;
import com.apnidukan.service.CartService;
import com.apnidukan.service.ProductService;
import com.apnidukan.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void addToCart(@RequestBody JsonNode data) {
		Cart c=new Cart();
		
		User u=null;
		try
		{
			 String[] split_string = data.get("token").toString().split("\\.");
		        String base64EncodedHeader = split_string[0];
		        String base64EncodedBody = split_string[1];
		        String base64EncodedSignature = split_string[2];

		        Base64 base64Url = new Base64(true);
		        String header = new String(base64Url.decode(base64EncodedHeader));
		        
		        String body = new String(base64Url.decode(base64EncodedBody));
		        JSONObject jsonObj = new JSONObject(body);
		         
		        JSONObject user = new JSONObject(jsonObj.get("user").toString());	       
		        u= userService.findByEmailid(user.get("emailid").toString());
		     
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		c.setUserid(u.getId());
		c.setProductid(Integer.parseInt(data.get("pid").toString()));
		c.setQuantity(1);
		c.setDate(new Date());
		cartService.save(c);		
	}
	
	
	@RequestMapping(value="/findCartByUserId/{userid}",method=RequestMethod.GET)
	public ResponseEntity<String> findCartByUserId(@PathVariable Long userid) {
		
		List<Cart> l =cartService.findCartByUserId(userid);
		
		JSONArray data=new JSONArray();
		
		for(int i=0;i<l.size();i++)
		{
			Cart c=l.get(i);
			Product p=productService.findById(c.getProductid());
			JSONObject obj=new JSONObject();
			obj.put("img", p.getImage());
			obj.put("pid", p.getProductid());
			obj.put("pname", p.getProductname());
			obj.put("pprice",p.getPrice());
			obj.put("qty",c.getQuantity());
			
			data.put(i,obj);
		}
		ResponseEntity response = new ResponseEntity(data.toString(),HttpStatus.OK);
		
		return response;
	}
	
	@RequestMapping(value="/findCartSizeByUserId/{userid}",method=RequestMethod.GET)
	public String findCartSizeByUserId(@PathVariable Long userid) {
		String size;
		size = String.valueOf(cartService.findCartSizeByUserId(userid).size());
		System.out.println("\n\n"  + size);
		return size; 
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public void delete()
	{
		cartService.deleteByUserid(1);
	}
}
