package com.neuedu.controller;


import com.neuedu.pojo.Category;
import com.neuedu.service.ICategoryService;
import com.neuedu.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/category/")
public class CategoryController {


    @Autowired
    private ICategoryService categoryService;


    @RequestMapping("all")
    public String AllCategory(HttpSession session){

        List<Category> categories=categoryService.selectAllCategory();
        session.setAttribute("categories",categories);

        return "categoryList";
    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String UpdateCategory(@PathVariable("id") Integer id,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
        Category category=categoryService.findById(id);
        HttpSession session=request.getSession();
        session.setAttribute("category",category);
        return "categoryUpdate";

    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String UpdateCategory(Category category){
        int count=categoryService.updateCategory(category);

        if(count>0){
            return "redirect:/category/all";
        }
        return "categoryUpdate";

    }



    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String DeleteCategory(@PathVariable("id") Integer id,
                                 HttpServletRequest request,
                                 HttpServletResponse response){

        Integer count=categoryService.deleteCategory(id);

        return "redirect:/category/all";

    }


    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String AddCategory(){

        return "categoryAdd";

    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String AddCategory(Category category){
        Integer count=categoryService.addCategory(category);

        if(count>0){
            return "redirect:/category/all";
        }
        return "categoryAdd";

    }



}
