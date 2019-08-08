package com.neuedu.controller;

import com.neuedu.pojo.Category;
import com.neuedu.pojo.Product;
import com.neuedu.service.ICategoryService;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/category/product/")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;


    @RequestMapping("all")
    public String AllProduct(HttpSession session){

        List<Product> products=productService.selectAllProduct();
        session.setAttribute("products",products);
        return "productList";
    }




    @RequestMapping(value = "update/{id}",method = RequestMethod.GET)
    public String UpdateProduct(@PathVariable("id") Integer id,
                                 HttpServletRequest request,
                                 HttpServletResponse response){
        Product product=productService.findById(id);
        List<Category> categories=categoryService.selectAllCategory();
        HttpSession session=request.getSession();
        session.setAttribute("product",product);
        session.setAttribute("categories",categories);
        return "productUpdate";

    }

    @RequestMapping(value = "update/{id}",method = RequestMethod.POST)
    public String UpdateProduct(Product product){
        int count=productService.updateProduct(product);

        if(count>0){
            return "redirect:/admin/category/product/all";
        }
        return "productUpdate";

    }



    @RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
    public String DeleteProduct(@PathVariable("id") Integer id,
                                 HttpServletRequest request,
                                 HttpServletResponse response){

        Integer count=productService.deleteProduct(id);

        return "productList";

    }


    @RequestMapping(value = "add",method = RequestMethod.GET)
    public String AddProduct(HttpSession session){
        List<Category> categories=categoryService.selectAllCategory();
        session.setAttribute("categories",categories);
        return "productAdd";

    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String AddProduct(Product product){
        Integer count=productService.addProduct(product);

        if(count>0){
            return "redirect:/admin/category/product/all";
        }
        return "productAdd";

    }


    @RequestMapping(value = "uploadPic",method = RequestMethod.GET)
    public String UploadProduct(){
        return "upload";

    }

    @RequestMapping(value = "uploadPic",method = RequestMethod.POST)
    public String UploadProduct(@RequestParam("picfile") MultipartFile uploadfile,
                                HttpSession session){
        if(uploadfile!=null)
        {
            String uuid= UUID.randomUUID().toString();
            //uuid+扩展名
            String fileName=uploadfile.getOriginalFilename();
            System.out.println("====filename"+fileName);

            String fileextendname=fileName.substring(fileName.lastIndexOf("."));

            String newFileName=uuid+fileextendname;
            System.out.println("=====新扩展名"+newFileName);

            //将图片保存到目录
            File file=new File("D:\\SX\\upload");
//            如果目录不存在，则创建目录
            if(!file.exists())
            {
                file.mkdir();
            }
            File newFile=new File(file,newFileName);
            try {
                //将文件写入到磁盘中
                uploadfile.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            String url="D:\\SX\\upload\\"+newFileName;
            session.setAttribute("url",url);
        }
        return "redirect:/admin/category/product/add";

    }



    @RequestMapping(value = "uploadPic2",method = RequestMethod.GET)
    public String Upload(){
        return "upload2";

    }

    @RequestMapping(value = "uploadPic2",method = RequestMethod.POST)
    public String Upload(@RequestParam("picfile1") MultipartFile uploadfile1,
                         @RequestParam("picfile2") MultipartFile uploadfile2,
                         @RequestParam("picfile3") MultipartFile uploadfile3,
                         HttpSession session){
        String newFileName1=null;
        String newFileName2=null;
        String newFileName3=null;
        if(uploadfile1!=null)
        {
            String uuid= UUID.randomUUID().toString();
            //uuid+扩展名
            String fileName=uploadfile1.getOriginalFilename();

            String fileextendname=fileName.substring(fileName.lastIndexOf("."));

            newFileName1=uuid+fileextendname;
            System.out.println("=====新扩展名"+newFileName1);

            //将图片保存到目录
            File file=new File("D:\\SX\\upload2");
//            如果目录不存在，则创建目录
            if(!file.exists())
            {
                file.mkdir();
            }
            File newFile=new File(file,newFileName1);
            try {
                //将文件写入到磁盘中
                uploadfile1.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        if(uploadfile2!=null)
        {
            String uuid= UUID.randomUUID().toString();
            //uuid+扩展名
            String fileName=uploadfile2.getOriginalFilename();

            String fileextendname=fileName.substring(fileName.lastIndexOf("."));

            newFileName2=uuid+fileextendname;
            System.out.println("=====新扩展名"+newFileName2);

            //将图片保存到目录
            File file=new File("D:\\SX\\upload2");
//            如果目录不存在，则创建目录
            if(!file.exists())
            {
                file.mkdir();
            }
            File newFile=new File(file,newFileName2);
            try {
                //将文件写入到磁盘中
                uploadfile2.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        if(uploadfile3!=null)
        {
            String uuid= UUID.randomUUID().toString();
            //uuid+扩展名
            String fileName=uploadfile3.getOriginalFilename();

            String fileextendname=fileName.substring(fileName.lastIndexOf("."));

            newFileName3=uuid+fileextendname;
            System.out.println("=====新扩展名"+newFileName3);

            //将图片保存到目录
            File file=new File("D:\\SX\\upload2");
//            如果目录不存在，则创建目录
            if(!file.exists())
            {
                file.mkdir();
            }
            File newFile=new File(file,newFileName3);
            try {
                //将文件写入到磁盘中
                uploadfile3.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        String url2="D:\\SX\\upload2\\"+newFileName1+"      "+
                "D:\\SX\\upload2\\"+newFileName2+"      "+
                "D:\\SX\\upload2\\"+newFileName3+"      ";
        session.setAttribute("url2",url2);
        return "redirect:/admin/category/product/add";

    }




}
