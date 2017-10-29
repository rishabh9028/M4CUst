package com.cg.cust.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.cust.model.Cust;
import com.cg.cust.service.ICustService;

@Controller
public class CustController {
	@Autowired
	ICustService service;
	
	@RequestMapping("/index")
	public String firtsPage(){
		return "index";
	}
	
	
	
	@RequestMapping("/start")
	public String goToStart(Model model){
		model.addAttribute("bean",new Cust());
		return "customerRegForm";
	}
	@RequestMapping("/reg")
	public ModelAndView registration(@ModelAttribute("bean") @Valid Cust cust,BindingResult result){
		if(result.hasErrors())
		{
			 
			 return new ModelAndView("customerRegForm");
		}
		service.addDetails(cust);
		return new ModelAndView("customerSuccess","k", cust);
	}
	
	@RequestMapping("/goFindAll")
	public ModelAndView findAll(){
		
		List<Cust> custList = service.retrieveDetails();
		return new ModelAndView("customerListSuccess", "list", custList);
	}
	@RequestMapping("/Back")
	public String back(){
		return "index";
	}
	@RequestMapping("/find")
	public ModelAndView getIds(){
		
		List<Integer> idList= service.retrieveIds();
		return new ModelAndView("custIdFind", "idList", idList);
	}
	@RequestMapping("/toFind")
	public ModelAndView findById(@RequestParam("custId") int custId){
		
		Cust cust = service.retrieveById(custId);
		return new ModelAndView("customerSuccess", "k", cust);
	}
	

	@RequestMapping("/remove")
	public ModelAndView goToDelete()
	{
		List<Integer> idList= service.retrieveIds();
		return new ModelAndView("Removecust", "idList", idList);
	}  
	
	
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("custId") int cId)
	{
			service.deleteCustomer(cId);
		
		return "RemoveResult";
	}
	
	@RequestMapping("/Update")
	public ModelAndView goToUpdate(){
		List<Integer> idList=service.retrieveIds();
		return new ModelAndView("CustUpdateId","custId",idList);
	}
	
	@RequestMapping("/update")
	public String updateById(@RequestParam("custId") int custId,Model m){
		Cust cust = service.retrieveById(custId);
		System.out.println(cust);
		m.addAttribute("customer", cust);
		return "UpdateForm";
	}
	@RequestMapping("/doUpdation")
	public String updateDetails(@ModelAttribute("customer") @Valid Cust cust,BindingResult result, Model model){
		
		if(result.hasErrors())
		{
			return "UpdateForm";
		}
		else{
			Cust customer = service.update(cust);
			model.addAttribute("k", customer);
			return "UpdateSuccess";
		}	
	}
	
	
	}
	
	
	
	
	
