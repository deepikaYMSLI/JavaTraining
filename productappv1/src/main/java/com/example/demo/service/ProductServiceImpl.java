package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.ProductDao;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	@Override
	public List<String> getAllProducts(){
		return productDao.getAll();
	}
	public ProductServiceImpl(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	
	

}
