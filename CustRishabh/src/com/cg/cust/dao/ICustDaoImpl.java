package com.cg.cust.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.cust.model.Cust;
@Repository
public class ICustDaoImpl implements ICustDao {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void addDetails(Cust bean) {
		// TODO Auto-generated method stub
		entityManager.persist(bean);
	}
	@Override
	public List<Cust> retrieveDetails() {
		// TODO Auto-generated method stub
		Query query = (Query) entityManager.createNamedQuery("getAllCustomers");
		@SuppressWarnings("unchecked")
		List<Cust> custList = query.getResultList();
		
		return custList;
	}
	@Override
	public Cust retrieveById(int custId) {
		// TODO Auto-generated method stub
		 Cust customer = entityManager.find(Cust.class, custId);
	
		return customer;
	}
	@Override
	public List<Integer> retrieveIds() {
		// TODO Auto-generated method stub
		TypedQuery<Integer> query = entityManager.createNamedQuery("getCustomerIds", Integer.class);
		List<Integer> idList = query.getResultList();
		return idList;
		}
	@Override
	public void deleteCustomer(int custId) {
		// TODO Auto-generated method stub
		Query query = entityManager.createNamedQuery("deleteCustomerById");
		query.setParameter("cId", custId);
		query.executeUpdate();
	}
	@Override
	public Cust update(Cust cust) {
		// TODO Auto-generated method stub
	 return entityManager.merge(cust);
	}
	

}
