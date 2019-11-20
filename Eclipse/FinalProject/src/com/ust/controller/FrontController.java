package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.IMainService;
import com.ust.dao.MainService;
import com.ust.model.Model;



@RestController
public class FrontController {
	@Autowired
	IMainService ms=new MainService();
	
	//Login
	@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
	public Model getRole(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		return ms.verifyLogin(username, password);
		
	}
	
	//View details
	@RequestMapping(value="/api/vendordetails",method=RequestMethod.GET)
	public List vendorView()
	{
		List list=ms.vendorList();
		return list;
	}
	
	//Search
	@RequestMapping(value="/api/vendor/{search}",method=RequestMethod.GET)
	public List viewsearch(@PathVariable("search") String search)
	{
		List list=ms.vendorSearch(search);
		return list;
	}
	
	//Add or update
	@RequestMapping(value="/api/vendor/add",method={RequestMethod.POST,RequestMethod.PUT})
	public void insertVendor(@RequestBody Model mod)
	{
	
			ms.vendorInsert(mod);
	}
	
	@RequestMapping(value="/api/vendor/update",method=RequestMethod.PUT)
	public void updateVendor(@RequestBody Model mod)
	{
	
			ms.updatevendor(mod);
	}

	
	//Disable vendor
	@RequestMapping(value = "/api/disablevendor/{vId}", method = RequestMethod.PUT)
	public void staffDisable(@PathVariable("vId") int vId) {
	ms.disableVendor(vId);
	}
	
	
	//Sort by vId
	@RequestMapping(value="/api/vendor/sortbyid",method=RequestMethod.GET)
	public List sortById()
	{
		List list=ms.sortedList1();
		return list;
	}
	
	
	//Sort by vName
	@RequestMapping(value="/api/vendor/sortbyname",method=RequestMethod.GET)
	public List sortByName()
	{
		List list=ms.sortedList2();
		return list;
	}
	
	//GET ALL VENDER DETAILS BY ID

	@RequestMapping(value = "/api/getVenderByid/{vId}", method = RequestMethod.GET , produces = "application/json")
	public Model getVenderById(@ModelAttribute("mod") Model mod,@PathVariable("vId") int vId)
	{
	List eachVenderList=ms.vendorListId(vId);
	mod=(Model)eachVenderList.get(0);
	return  mod;
	}

	
}
