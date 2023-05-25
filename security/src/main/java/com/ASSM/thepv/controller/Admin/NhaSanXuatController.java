package com.ASSM.thepv.controller.Admin;

import com.ASSM.thepv.entity.MauSac;
import com.ASSM.thepv.entity.NhaSanXuat;
import com.ASSM.thepv.repository.MauSacRepository;
import com.ASSM.thepv.repository.NhaSanXuatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author thepvph20110
 */

@Controller
@RequestMapping("/admin/nha-san-xuat")
public class NhaSanXuatController {

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @GetMapping("/list")
    public String listNhaSanXuat(Model model){
        List<NhaSanXuat> list = nhaSanXuatRepository.findAll();
        model.addAttribute("list", list);
        return "nhasanxuat/nha-san-xuat";
    }

    @PostMapping("/add")
    public String addNhaSanXuat( NhaSanXuat nhaSanXuat){
        nhaSanXuatRepository.save(nhaSanXuat);
        return "redirect:/admin/nha-san-xuat/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteNhaSanXuat(@PathVariable("id") String id){
        NhaSanXuat nhaSanXuat = nhaSanXuatRepository.findById(id).get();
        nhaSanXuatRepository.delete(nhaSanXuat);
        return "redirect:/admin/nha-san-xuat/list";
    }
    @GetMapping("/view-update/{id}")
    public String viewUpdateNhaSanXuat(@PathVariable("id") String id,Model model){
        NhaSanXuat nhaSanXuat = nhaSanXuatRepository.findById(id).get();
        model.addAttribute("nhaSanXuat",nhaSanXuat);
        return "nhasanxuat/view-update";
    }
    @PostMapping("/update")
    public String updateNhaSanXuat(NhaSanXuat nhaSanXuat){
        nhaSanXuatRepository.save(nhaSanXuat);
        return "redirect:/admin/nha-san-xuat/list";
    }
}
