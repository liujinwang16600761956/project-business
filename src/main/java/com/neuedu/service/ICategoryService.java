package com.neuedu.service;

import com.neuedu.pojo.Category;

import java.util.List;

public interface ICategoryService {


    public int addCategory(Category category);

    public int deleteCategory(int id);

    public int updateCategory(Category category);

    public List<Category> selectAllCategory();

    public Category findById(Integer id);

    public List<Category> selectByParentId();

}
