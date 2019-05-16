package com.certiorem.librarymicroservicesproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.certiorem.librarymicroservicesproject.constants.PurchasePathConstants;
import com.certiorem.librarymicroservicesproject.service.PurchaseService;

@RestController
public class PurchaseRestController {

	@Autowired
	private PurchaseService purchaseService;
	
	@PostMapping(PurchasePathConstants.PURCHASE_SERVICE_SAVE)
	@ResponseBody
	public Object savePurchase(@RequestParam Object purchase) {
		return purchaseService.createUpdatePurchase(purchase);
	}
	
	@GetMapping(PurchasePathConstants.PURCHASE_SERVICE_READ)
	@ResponseBody
	public Object getPurchaseById(@RequestParam String id) {
		return purchaseService.getPurchase(Integer.parseInt(id));
	}
	
	@GetMapping(PurchasePathConstants.PURCHASE_SERVICE_DELETE)
	@ResponseBody
	public void deletePurchase(@RequestParam String id) {
		purchaseService.deletePurchase(Integer.parseInt(id));
	}
	
	@GetMapping(PurchasePathConstants.PURCHASE_SERVICE_GET_ALL)
	@ResponseBody
	public List<Object> getAllPurchaes() {
		return purchaseService.getAllPurchases();
	}
	
	@GetMapping(PurchasePathConstants.PURCHASE_SERVICE_GET_BY_PROVIDER)
	@ResponseBody
	public List<Object> getPurchasesByProvider(@RequestParam String providerId) {
		return purchaseService.getPurchasesByProviderId(Integer.parseInt(providerId));
	}
}
