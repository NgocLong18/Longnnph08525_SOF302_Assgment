package com.sample.controller;

import com.sample.model.Records;
import com.sample.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("records/")
public class RecordsController {
    @Autowired
    private RecordsService recordsService;

    @GetMapping("records-save")
    public ModelAndView saveStaffs(){
        ModelAndView modelAndView = new ModelAndView("records/records-save");
        modelAndView.addObject("records", new Records());
        return modelAndView;
    }
    @PostMapping("records-save")
    public ModelAndView saveStaffs(@ModelAttribute("records") Records records){
        recordsService.save(records);
        ModelAndView modelAndView = new ModelAndView("records/records-save");
        modelAndView.addObject("message", "Records Successfully!!");
        return modelAndView;
    }


}
