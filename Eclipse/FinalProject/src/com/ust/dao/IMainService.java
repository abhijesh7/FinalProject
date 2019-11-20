package com.ust.dao;

import java.util.List;

import com.ust.model.Model;

public interface IMainService {

	// Login
	public abstract Model verifyLogin(String username, String password);

	// Insert vendor
	public abstract int vendorInsert(Model mod);

	//View vendor details
	public abstract List<Model> vendorList();

	//view by vId

	public abstract List<Model> vendorListId(int vId);

	//Edit vendor details
	public abstract int updatevendor(Model mod);

	//Disable vendor
	public abstract int disableVendor(int vId);

	//Search
	public abstract List<Model> vendorSearch(String search);

	//Sort by vId
	public abstract List<Model> sortedList1();

	//Sort by vName
	public abstract List<Model> sortedList2();

}