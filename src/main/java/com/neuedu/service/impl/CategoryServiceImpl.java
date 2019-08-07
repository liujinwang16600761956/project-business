package com.neuedu.service.impl;

import com.neuedu.dao.CategoryMapper;
import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public int addCategory(Category category) {

        int count=categoryMapper.insert(category);
        return count;
    }

    @Override
    public int deleteCategory(int id) {
        int count=categoryMapper.deleteByPrimaryKey(id);
        return count;
    }

    @Override
    public int updateCategory(Category category) {

        int count=categoryMapper.updateByPrimaryKey(category);
        return count;
    }

    @Override
    public List<Category> selectAllCategory() {

        List<Category> categories= categoryMapper.selectAll();

        return categories;
    }

    @Override
    public Category findById(Integer id) {

        Category category=categoryMapper.findByCategoryId(id);

        return category;
    }
}
