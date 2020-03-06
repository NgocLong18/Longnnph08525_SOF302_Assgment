package com.sample.controller;

import com.sample.model.Departs;
import com.sample.service.DepartsService;
import com.sample.service.DepartsServiceNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("departs/")//mặc định là khi trả về sẽ lấy bắt đầu từ departs/ + các mapping của file html
public class DepartsController {
    @Autowired
    private DepartsService departsService;

    @GetMapping("departs-save")
    public ModelAndView saveDeparts(){
        ModelAndView modelAndView = new ModelAndView("/departs/departs-save");
        modelAndView.addObject("departs", new Departs());
        return modelAndView;
    }

    @PostMapping("departs-save")
    public ModelAndView saveCustomer(@ModelAttribute("departs") Departs departs) {
        departsService.save(departs);
        ModelAndView modelAndView = new ModelAndView("/departs/departs");
        return modelAndView;
    }

    @GetMapping("departs")
    public ModelAndView staffs(Model model){
        model.addAttribute("listDeparts", departsService.findAll());
        ModelAndView modelAndView = new ModelAndView("/departs/departs");
        return modelAndView;
    }

    //sửa thông tin phòng ban
    @Autowired
    private DepartsServiceNew departsServiceNew;
    //hien và sua thong tin nhan vien
    @GetMapping("departs-edit/{departID}")
    public ModelAndView editStaffs(@PathVariable Long departID){
        Optional<Departs> departs= departsServiceNew.findById(departID);
        ModelAndView modelAndView = new ModelAndView("/departs/departs-edit");
        modelAndView.addObject("departs", departs );
        return modelAndView;
    }
    @PostMapping("departs-edit")
    public ModelAndView doUpdateStaffs(@ModelAttribute("departs") Departs departs){
        departsService.save(departs);
        ModelAndView modelAndView = new ModelAndView("/departs/departs-edit");
        modelAndView.addObject("departs", departs);
        modelAndView.addObject("message", "Departs updated successfully!!");
        return modelAndView;
    }
}
