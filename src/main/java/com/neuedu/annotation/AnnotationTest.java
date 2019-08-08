package com.neuedu.annotation;

import com.neuedu.pojo.Cart;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnotationTest {



    private static    String   tableValue;



    public static String captureName(String name) {
        //     name = name.substring(0, 1).toUpperCase() + name.substring(1);
//        return  name;
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);

    }









    public static void main(String[] args) {
//
//        try {
//            Class c = Class.forName("com.neuedu.pojo.Cart");
//            Boolean isTableAnnotation = c.isAnnotationPresent(Table.class);
//            if (isTableAnnotation) {
//                Table table=(Table)c.getAnnotation(Table.class);
//                String tableValue=table.value();
//            }
//
//            Field[] fields=c.getFields();
//            List<String> columnValues=new ArrayList<>();
//            List<String> cartParams=new ArrayList<>();
//            for(Field field:fields){
//                String cartParam=field.getName();
//                cartParams.add(cartParam);
//
//
//                Boolean isColumnAnnotation = c.isAnnotationPresent(Column.class);
//                if (isColumnAnnotation) {
//                    Column column=(Column)c.getAnnotation(Column.class);
//                    String columnValue=column.value();
//                    columnValues.add(columnValue);
//                }
//            }
//
//            List<String> cartParams2=new ArrayList<>();
//            for(String cartParam:cartParams){
//
//                String cartParam2=captureName(cartParam);
//                cartParam2="get"+cartParam2;
//                cartParams2.add(cartParam2);
//
//            }
//
//            List<Method> cartParams3=new ArrayList<>();
//            for(String cartParam2:cartParams2){
//                Method cartParam3=null;
//                try {
//                    cartParam3=c.getMethod(cartParam2);
//                } catch (NoSuchMethodException e) {
//                    e.printStackTrace();
//                }
//                cartParams3.add(cartParam3);
//
//            }
//
//
//            for(int count=0;count<columnValues.size();count++){
//
//                String cart=null;
//                try {
//                    cart=cartParams3.get(count).invoke(Cart.class)
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//                if (==null) {
//                }
//
//
//
//            }
//
//
//
//        } catch (ClassNotFoundException e1) {
//            e1.printStackTrace();
//        }
//
//


    }




}
