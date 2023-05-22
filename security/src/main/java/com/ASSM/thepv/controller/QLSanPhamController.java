package com.ASSM.thepv.controller;

import com.ASSM.thepv.entity.ChiTietSanPham;
import com.ASSM.thepv.repository.DongSPRepository;
import com.ASSM.thepv.repository.MauSacRepository;
import com.ASSM.thepv.repository.NhaSanXuatRepository;
import com.ASSM.thepv.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author thepvph20110
 */
@Controller
@RequestMapping("/admin")
public class QLSanPhamController {

    @Autowired
    private ChiTietSPService chiTietSPService;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @Autowired
    private DongSPRepository dongSPRepository;

    @GetMapping("/quan-ly-san-pham")
    public String listSanPham(Model model){
        List<ChiTietSanPham> chiTietSanPhamList = chiTietSPService.getAll();
        model.addAttribute("chiTietSanPhams",chiTietSanPhamList);
        model.addAttribute("mauSacs", mauSacRepository.findAll());
        model.addAttribute("nsx", nhaSanXuatRepository.findAll());
        return "quanlysanpham";
    }

    @GetMapping("/delete/{id}")
    public String deleteSanPham(@PathVariable("id") String id,Model model){
        chiTietSPService.daleteChiTietSanPham(id);
        return "redirect:/admin/quan-ly-san-pham";
    }
}
