package com.ASSM.thepv.controller;

import com.ASSM.thepv.entity.ChiTietSanPham;
import com.ASSM.thepv.entity.NhaSanXuat;
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
@RequestMapping("/user")
public class SanPhamUserController {

    @Autowired
    private ChiTietSPService chiTietSPService;

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @GetMapping("/list-san-pham")
    public String listSanPham(Model model){
        List<ChiTietSanPham> list =  chiTietSPService.getAll();
        List<NhaSanXuat> sanXuatList  = nhaSanXuatRepository.findAll();
        model.addAttribute("sp",list.get(list.size()-1));
        model.addAttribute("list",list);
        model.addAttribute("nsx",sanXuatList );
        return "sanpham";
    }

    @GetMapping("/detail/{id}")
    public String findById(@PathVariable("id") String id , Model model){
        ChiTietSanPham ctsp = chiTietSPService.findOneById(id);
        model.addAttribute("ctsp",ctsp);
        return "detail_product";
    }

    @GetMapping("/nha-san-xuat/{id}")
    public String findALLByNSX(@PathVariable("id") String id , Model model){
        List<ChiTietSanPham> list =  chiTietSPService.findAllByNhaSanXuat(id);
        List<NhaSanXuat> sanXuatList  = nhaSanXuatRepository.findAll();
        model.addAttribute("sp",list.get(list.size()-1));
        model.addAttribute("list",list);
        model.addAttribute("nsx",sanXuatList );
        return "sanpham";
    }
}
