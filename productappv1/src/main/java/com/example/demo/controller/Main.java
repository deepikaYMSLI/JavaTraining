package com.example.demo.controller;

import java.util.List;

import com.example.demo.dao.ProductDao;
import com.example.demo.dao.ProductDaoMapImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;

public class Main {
	public static void main(String [] args) {
		ProductDao productDao = new ProductDaoMapImpl();
		ProductService productService = new ProductServiceImpl(productDao);
		List<String> proList = productService.getAllProducts();
		proList.forEach(p-> System.out.println());
		
		
	}

}
