package com.sample.controller;

import com.sample.model.Departs;
import com.sample.model.Staffs;
import com.sample.model.Users;
import com.sample.responsitory.RecordsResponsitory;
import com.sample.responsitory.StaffsResponsitory;
import com.sample.service.DepartsService;
import com.sample.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("/")
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("users", new Users());
        List<Users> list = usersService.findAll();
        return modelAndView;
    }


    @PostMapping("login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("pass") String pass, Model model) {
        List<Users> list = usersService.findAll();
        for (Users users : list){
            if(username.equalsIgnoreCase(users.getUsername()) && pass.equalsIgnoreCase(users.getPass())){
                Users user = new Users(username,pass);
                List<Users> listOnly = new ArrayList<>();
                listOnly.add(user);
                model.addAttribute("listOnly", listOnly);
                ModelAndView modelAndView = new ModelAndView("main");
                return modelAndView ;
            }
        }
        return new ModelAndView("fail");
    }
    @RequestMapping("trangchu")
    public String main() {
        return "main";
    }

    //phongban
    @Autowired
    private DepartsService departsService;
    @RequestMapping("phongban")
    public String listDeparts(Model model) {
        model.addAttribute("listDeparts", departsService.findAll());
        return "departs/departs";
    }


    //staffs
    @Autowired
    private StaffsResponsitory staffsResponsitory;
    @RequestMapping("nhanvien")
    public ModelAndView staffs(Model model){
        model.addAttribute("listStaffs", staffsResponsitory.findAll());
        ModelAndView modelAndView = new ModelAndView("/staffs/staffs");
        modelAndView.addObject("staffsSearch", new Staffs());
        return modelAndView;
    }

//    public String listStaffs(Model model) {
//        model.addAttribute("listStaffs", staffsResponsitory.findAll());
//        new ModelAndView("staffsSearch");
//        return "staffs/staffs";
//    }

    //records
    @Autowired
    private RecordsResponsitory recordsResponsitory;
    @RequestMapping("kyluat")
    public String listRecords(Model model) {
        model.addAttribute("listRecords", recordsResponsitory.findAll());
        return "records/records";
    }


}
