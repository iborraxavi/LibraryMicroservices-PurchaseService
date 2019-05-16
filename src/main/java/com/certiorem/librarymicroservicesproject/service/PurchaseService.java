package com.certiorem.librarymicroservicesproject.service;

import java.util.List;

public interface PurchaseService {

	public Object createUpdatePurchase(Object order);
	
	public Object getPurchase(Integer id);
	
	public void deletePurchase(Integer id);
	
	public List<Object> getAllPurchases();
	
	public List<Object> getPurchasesByProviderId(Integer providerId);
	
}
