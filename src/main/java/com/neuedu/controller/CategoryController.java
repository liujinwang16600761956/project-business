package com.neuedu.controller;


import com.neuedu.pojo.Category;
import com.neuedu.pojo.Product;
import com.neuedu.service.ICategoryService;
import com.neuedu.service.IProductService;
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
@RequestMapping("/admin/category/")
public class CategoryController {


    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductService productService;


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
        List<Category> categories=categoryService.selectAllCategory();
        HttpSession session=request.getSession();
        session.setAttribute("category",category);
        session.setAttribute("categories",categories);
        return "categoryUpdate";

    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String UpdateCategory(Category category){
        int count=categoryService.updateCategory(category);

        if(count>0){
            return "redirect:/admin/category/all";
        }
        return "categoryUpdate";

    }



    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String DeleteCategory(@PathVariable("id") Integer id,
                                 HttpServletRequest request,
                                 HttpServletResponse response){

        Integer count=categoryService.deleteCategory(id);

        return "redirect:/admin/category/all";

    }


    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String AddCategory(HttpSession session){
        List<Category> categories=categoryService.selectAllCategory();
        session.setAttribute("categories",categories);
        return "categoryAdd";

    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String AddCategory(Category category){
        Integer count=categoryService.addCategory(category);

        if(count>0){
            return "redirect:/admin/category/all";
        }
        return "categoryAdd";

    }













    @RequestMapping(value = "product2/{CategoryId}",method = RequestMethod.GET)
    public String MoreProduct(@PathVariable("CategoryId") Integer categoryId,
                              HttpServletRequest request,
                              HttpServletResponse response){

        List<Product> products=productService.findByCategoryId(categoryId);
        HttpSession session=request.getSession();
        session.setAttribute("products",products);
        session.setAttribute("categoryId",categoryId);
        return "productList";

    }

    @RequestMapping(value = "product2/update/{id}",method = RequestMethod.GET)
    public String UpdateProduct(@PathVariable("id") Integer id,
                                HttpServletRequest request,
                                HttpServletResponse response){
        Product product=productService.findById(id);
        List<Category> categories=categoryService.selectAllCategory();
        HttpSession session=request.getSession();
        Integer categoryId=(Integer) session.getAttribute("categoryId");
        session.setAttribute("product",product);
        session.setAttribute("categoryId",categoryId);

        System.out.println("========"+categoryId);
        return "productUpdate";

    }

    @RequestMapping(value = "product2/update/{id}",method = RequestMethod.POST)
    public String UpdateProduct(Product product,HttpSession session){
        int count=productService.updateProduct(product);
        Integer categoryId=(Integer) session.getAttribute("categoryId");
        if(count>0){
            String url="redirect:/admin/category/product2/"+categoryId;
            return url;
        }
        return "productUpdate";

    }



    @RequestMapping(value = "product2/delete/{id}",method = RequestMethod.GET)
    public String DeleteProduct(@PathVariable("id") Integer id,
                                HttpServletRequest request,
                                HttpServletResponse response){
        HttpSession session=request.getSession();
        Integer count=productService.deleteProduct(id);
        Integer categoryId=(Integer) session.getAttribute("categoryId");
        String url="redirect:/admin/category/product2/"+categoryId;
        return url;

    }


    @RequestMapping(value = "product2/add",method = RequestMethod.GET)
    public String AddProduct(HttpSession session){
        Integer categoryId=(Integer) session.getAttribute("categoryId");
        session.setAttribute("categoryId",categoryId);
        return "productAdd";

    }

    @RequestMapping(value = "product2/add",method = RequestMethod.POST)
    public String AddProduct(Product product,HttpSession session){
        Integer count=productService.addProduct(product);
        Integer categoryId=(Integer) session.getAttribute("categoryId");
        session.setAttribute("categoryId",categoryId);

        if(count>0){
            String url="redirect:/admin/category/product2/"+categoryId;
            return url;
        }
        return "productAdd";

    }






}
