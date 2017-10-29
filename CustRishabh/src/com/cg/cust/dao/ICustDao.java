package com.cg.cust.dao;

import java.util.List;

import com.cg.cust.model.Cust;

public interface ICustDao {

	

	void addDetails(Cust bean);

	List<Cust> retrieveDetails();


	Cust retrieveById(int custId);

	List<Integer> retrieveIds();

	void deleteCustomer(int custId);

	Cust update(Cust cust);







}
