package com.cg.cust.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cust.dao.ICustDao;
import com.cg.cust.model.Cust;
@Service
@Transactional
public class ICustServiceImpl implements ICustService {
	@Autowired
	private ICustDao dao;
	@Override
	public void addDetails(Cust bean) {
		// TODO Auto-generated method stub
		dao.addDetails(bean);
	}
	@Override
	public List<Cust> retrieveDetails() {
		// TODO Auto-generated method stub
		return dao.retrieveDetails();
	}
	@Override
	public Cust retrieveById(int custId) {
		// TODO Auto-generated method stub
		return dao.retrieveById(custId);
	}
	@Override
	public List<Integer> retrieveIds() {
		// TODO Auto-generated method stub
		return dao.retrieveIds();
	}
	
	@Override
	public void deleteCustomer(int custId)
	{
		dao.deleteCustomer(custId);
	}
	@Override
	public Cust update(Cust cust) {
		// TODO Auto-generated method stub
		return dao.update(cust);
	}

}
