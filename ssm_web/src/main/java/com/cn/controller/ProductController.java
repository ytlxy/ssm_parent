package com.cn.controller;

import com.cn.domain.Product;
import com.cn.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;
    @RequestMapping("/save.do")
    public String save(Product product)throws Exception{
    productService.save(product);
    return "redirect:findAll.do";
    }
    /**
     * 查询全部
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
    ModelAndView mv=new ModelAndView();
    List<Product> pr=productService.findAll();
    mv.addObject("productList",pr);
    mv.setViewName("product_list");
    return mv;
    }
    @RequestMapping("/delete.do")
    public String delete(Long id) throws Exception{
        productService.delete(id);
        return "redirect:findAll.do";
    }
    @RequestMapping("/edit.do")
    public ModelAndView edit(Integer id) throws Exception{
        ModelAndView mv=new ModelAndView();
        Product product=productService.findById(id);
        mv.addObject("product",product);
        mv.addObject("id",product.getId());
        mv.setViewName("product_edit");
        return mv;
    }
    @RequestMapping("/update.do")
    public String edit(Product product) throws Exception{
//        System.out.println(product);
        productService.update(product);
        return "redirect:findAll.do";
    }
}
