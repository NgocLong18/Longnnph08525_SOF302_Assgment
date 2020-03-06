package com.sample.controller;

import com.sample.model.Records;
import com.sample.model.Staffs;
import com.sample.model.Users;
import com.sample.service.DepartsService;
import com.sample.service.StaffServiceNew;
import com.sample.service.StaffsService;
import com.sample.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("staffs/")
public class StaffsControler {
    @Autowired
    private StaffsService staffsService;

    @Autowired
    private UsersService usersService;

    //phongban
    @Autowired
    private DepartsService departsService;

    //lưu nhân viên
    @GetMapping("staffs-save")
    public ModelAndView saveStaffs(Model model){
        ModelAndView modelAndView = new ModelAndView("staffs/staffs-save");
        modelAndView.addObject("staffs", new Staffs());
        model.addAttribute("listDeparts", departsService.findAll());
        return modelAndView;
    }

    @PostMapping("staffs-save")
    public ModelAndView saveStaffs(@ModelAttribute("staffs")Staffs staffs, @RequestParam("username") String username, @RequestParam("staffName") String staffName ,Model model){
        try {
            Users us = new Users(username,"123",staffName);
            usersService.save(us);
            staffsService.save(staffs);
            model.addAttribute("listStaffs", staffsService.findAll());
            ModelAndView modelAndView = new ModelAndView("/staffs/staffs");
            modelAndView.addObject("staffsSearch", new Staffs());
            return modelAndView;
        }
        catch (Exception e){
            ModelAndView modelAndView = new ModelAndView("staffs/staffs-save");
            modelAndView.addObject("staffs", new Staffs());
            modelAndView.addObject("message", "Save not succesfull!!!");
            return modelAndView;
        }
    }

    //Tìm kiếm thông tin
    @PostMapping("searchStaff")
    public ModelAndView login(Model model, @RequestParam("staffId") long staffId) {
        try {
            Staffs staffs = staffsService.findById(staffId);
            if ((staffId + "").equalsIgnoreCase(staffs.getStaffId() + "")) {
//                ModelAndView modelAndView = new ModelAndView("/staffs/staffs");
//                modelAndView.addObject("listStaffs", staffsService.findById(staffId));
                model.addAttribute("listStaffs", staffsService.findById(staffId));
                ModelAndView modelAndView = new ModelAndView("/staffs/staffs");
                modelAndView.addObject("staffsSearch", new Staffs());
                return modelAndView;
        }
        } catch (Exception ex){
            model.addAttribute("listStaffs", staffsService.findAll());
            ModelAndView modelAndView = new ModelAndView("/staffs/staffs");
            modelAndView.addObject("staffsSearch", new Staffs());
            modelAndView.addObject("message", "No information for this person");
            return modelAndView;
        }
        model.addAttribute("listStaffs", staffsService.findAll());
        ModelAndView modelAndView = new ModelAndView("/staffs/staffs");
        modelAndView.addObject("staffsSearch", new Staffs());
        modelAndView.addObject("message", "No information for this person");
        return modelAndView;
    }

    //dung jpa repository
    @Autowired
    private StaffServiceNew staffServiceNew;
    //hien và sua thong tin nhan vien
    @GetMapping("staffs-edit/{staffId}")
    public ModelAndView editStaffs(@PathVariable Long staffId){
        Optional<Staffs> staffs= staffServiceNew.findById(staffId);
            ModelAndView modelAndView = new ModelAndView("/staffs/staffs-edit");
            modelAndView.addObject("staffs", staffs );
            return modelAndView;
    }
    @PostMapping("staffs-edit")
    public ModelAndView doUpdateStaffs(@ModelAttribute("staffs") Staffs staffs){
        staffsService.save(staffs);
        ModelAndView modelAndView = new ModelAndView("/staffs/staffs-edit");
        modelAndView.addObject("staffs", staffs);
        modelAndView.addObject("message", "Staffs updated successfully!!");
        return modelAndView;
    }

    //hien thi va xoa thong tin nhan vien, noi tom gon la duoi viec
    @GetMapping("staffs-delete/{staffId}")
    public ModelAndView deleteStaffs(@PathVariable Long staffId){
        Optional<Staffs> staffs= staffServiceNew.findById(staffId);
        ModelAndView modelAndView = new ModelAndView("/staffs/staffs-delete");
        modelAndView.addObject("staffs", staffs );
        return modelAndView;
    }
    @PostMapping("staffs-delete")
    public ModelAndView doDeleteStaff(@ModelAttribute("staffs") Staffs staffs){
        staffsService.save(staffs);
        ModelAndView modelAndView = new ModelAndView("/staffs/staffs-delete");
        modelAndView.addObject("staffs", staffs);
        modelAndView.addObject("message", "Staffs deleted successfully!!");
        return modelAndView;
    }

    @GetMapping("staffs")
    public ModelAndView staffs(Model model){
        model.addAttribute("listStaffs", staffsService.findAll());
        ModelAndView modelAndView = new ModelAndView("/staffs/staffs");
        modelAndView.addObject("staffsSearch", new Staffs());
        return modelAndView;
    }

}
