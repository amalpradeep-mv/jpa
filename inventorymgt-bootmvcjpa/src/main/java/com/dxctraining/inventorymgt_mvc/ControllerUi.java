package com.dxctraining.inventorymgt_mvc;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxctraining.inventorymgt_mvc.sprint6_supplier.entities.Supplier;
import com.dxctraining.inventorymgt_mvc.sprint6_supplier.service.ISupplierService;
import com.dxctraining.inventorymgt_mvc.sprint7_item.entities.Item;
import com.dxctraining.inventorymgt_mvc.sprint7_item.service.IItemService;

@Controller
public class ControllerUi {

	@Autowired
	private ISupplierService supplierService;

	@Autowired

	private IItemService itemService;

	@PostConstruct
	public void init() {

		Supplier supplier1 = new Supplier("John");
		int id1 = supplier1.getId();
		supplier1 = supplierService.save(supplier1);

		Supplier supplier2 = new Supplier("Sam");
		int id2 = supplier1.getId();
		supplier2 = supplierService.save(supplier2);

		System.out.println("---Sprint 1 completed---");

		Item item1 = new Item("Head Set", supplier1);
		item1 = itemService.save(item1);
		Item item2 = new Item("Charger", supplier2);
		item2 = itemService.save(item2);

		System.out.println("---Sprint 2 completed---");
	}

	@GetMapping("/supplier")
	public ModelAndView supplierDetails(@RequestParam("id") int id) {
		Supplier supplier = supplierService.findSupplierById(id);
		ModelAndView modelAndView = new ModelAndView("sdetails", "supplier", supplier);
		return modelAndView;
	}

	@GetMapping("/item")
	public ModelAndView itemDetails(@RequestParam("id") int id) {
		Item item = itemService.findItemById(id);
		ModelAndView modelAndView = new ModelAndView("idetails", "item", item);
		return modelAndView;
	}
}
