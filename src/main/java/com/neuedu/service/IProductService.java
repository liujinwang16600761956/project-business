package com.neuedu.service;

import com.neuedu.pojo.Product;

import java.util.List;

public interface IProductService {

    public int addProduct(Product product);

    public int deleteProduct(int id);

    public int updateProduct(Product product);

    public List<Product> selectAllProduct();

    public Product findById(Integer id);

    public List<Product> findByCategoryId(Integer id);



}
