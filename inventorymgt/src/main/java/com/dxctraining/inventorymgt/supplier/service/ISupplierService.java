package com.dxctraining.inventorymgt.supplier.service;

import com.dxctraining.inventorymgt.supplier.entities.Supplier;

public interface ISupplierService {

	void validate(int id);

	void validate(Supplier supplier);

	Supplier save(Supplier supplier);

	Supplier update(Supplier supplier);

	Supplier findSupplierById(int id);

	Supplier findSupplierByName(String aname);

	Supplier remove(int id);

}
