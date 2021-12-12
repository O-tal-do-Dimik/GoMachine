package Controller;

import Model.User;
import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {

    UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @RequestMapping(value = {"/", "/pet"},method =  RequestMethod.GET)
    public String getPage(Model model){
        var list = service.findAll();
        model.addAttribute("listarMercadorias",list);
        return "index";
    }

    @RequestMapping("/cadastro")
    public String getFromCadastro(Model model){
        User pet = new User();
        model.addAttribute("pet", pet);
        return "cadastro";
    }




    @RequestMapping("/deletar/{id}")
    public String doDelete(@PathVariable(name = "id") Long id){
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping("/editar/{id}")
    public ModelAndView getFormEdicao(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView ("edicao");
        User user  = service.findById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
