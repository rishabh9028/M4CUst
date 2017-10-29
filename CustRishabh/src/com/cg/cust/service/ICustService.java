package com.cg.cust.service;

import java.util.List;

import com.cg.cust.model.Cust;

public interface ICustService {

	void addDetails(Cust bean);

	List<Cust> retrieveDetails();

	Cust retrieveById(int custId);

	List<Integer> retrieveIds();



	void deleteCustomer(int custId);

	Cust update(Cust cust);
	



}
