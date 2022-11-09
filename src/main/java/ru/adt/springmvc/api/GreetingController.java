package ru.adt.springmvc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.adt.springmvc.models.Product;
import ru.adt.springmvc.repository.RepoProducts;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
//@RestController - все методы автоматом @ResponseBody
public class GreetingController {
    @Autowired
    RepoProducts products;

    @PostConstruct
    public void printProd(){
        products.printAllProductList();
    }


//*********тест***********
    //проброс параметра в html(т.е. в строке в браузере писать name а не ?...=...):
    // @GetMapping("/hello/{name}")
    @GetMapping("/hello")
    @ResponseBody//ответ в методе "?...=..."
    public String helloSimple(){
        //проброс параметра в html: public String helloSimple(@PathVariable String name){....}
        return "Hello!";
        //return "Hello, "+name+"!";
    }
    @GetMapping("/test/{value}")
    public String tests(@PathVariable String value, Model model){
        model.addAttribute("value", value);
        return "test";
    }
//--------------------------------------------------------------------------------------
    @GetMapping("/index")
    public String index(Model model){
        List<Product> someProducts = products.getSomeProductsArrayList();
        model.addAttribute("someProductArrayList", someProducts);
        return "index";
    }
    @GetMapping("/product/{id}")
    public String product(@PathVariable int id, Model model) {
        Product productExample = products.getProductById(id);
        System.out.println(productExample.getId());
        model.addAttribute("product", productExample);
        return "product";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("product", new Product());
        return "add";
    }
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(@ModelAttribute("product")Product product){
        products.addProduct(product);

        return "redirect:/index";
    }





}
