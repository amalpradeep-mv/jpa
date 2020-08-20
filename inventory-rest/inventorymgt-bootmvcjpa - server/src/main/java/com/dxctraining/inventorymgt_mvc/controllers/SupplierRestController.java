package com.dxctraining.inventorymgt_mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dxctraining.inventorymgt_mvc.supplier.dto.CreateSupplierRequest;
import com.dxctraining.inventorymgt_mvc.supplier.dto.UpdateSupplierRequest;
import com.dxctraining.inventorymgt_mvc.supplier.entities.Supplier;
import com.dxctraining.inventorymgt_mvc.supplier.service.ISupplierService;

@Controller
@RequestMapping("/suppliers")
public class SupplierRestController {
	
	@Autowired
	private ISupplierService supplierService;
	
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Supplier create(@RequestBody CreateSupplierRequest requestData) {
		String name=requestData.getName();
		String password=requestData.getPassword();
		Supplier supplier=new Supplier(name,password);
		supplier=supplierService.save(supplier);
		return supplier;
	}
	
	@GetMapping("/get/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Supplier findSupplierBy(@PathVariable("id") int id) {
		Supplier supplier=supplierService.findSupplierById(id);
		return supplier;
	}
	
	@PutMapping("/update")
	public Supplier updateSupplier(@RequestBody UpdateSupplierRequest requestData) {
		String name = requestData.getName();
		String password = requestData.getPassword();
		int id = requestData.getId();
		Supplier supplier = new Supplier(name, password);
		supplier.setId(id);
		supplier = supplierService.update(supplier);
		return supplier;
	}
	
	 @GetMapping("/authenticate/{id}/{password}")
	    public boolean authenticate(@PathVariable("id") int id, @PathVariable("password") String password){
	       boolean result= supplierService.authenticate(id, password);
	       return result;
	    }

}
