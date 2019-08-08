package com.neuedu.service.impl;

import com.neuedu.dao.ProductMapper;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {


    @Autowired
    private ProductMapper productMapper;

    @Override
    public int addProduct(Product product) {

        int count=productMapper.insert(product);

        return count;
    }

    @Override
    public int deleteProduct(int id) {

        int count=productMapper.deleteByPrimaryKey(id);
        return count;
    }

    @Override
    public int updateProduct(Product product) {

        int count=productMapper.updateByPrimaryKey(product);
        return count;
    }

    @Override
    public List<Product> selectAllProduct() {

        List<Product> products=productMapper.selectAll();

        return products;
    }

    @Override
    public Product findById(Integer id) {

        Product product=productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public List<Product> findByCategoryId(Integer id) {

        List<Product> products=productMapper.findByCategoryId(id);
        return products;
    }
}
