package com.ASSM.thepv.controller;

import com.ASSM.thepv.entity.ChiTietSanPham;
import com.ASSM.thepv.entity.GioHang;
import com.ASSM.thepv.entity.NhaSanXuat;
import com.ASSM.thepv.repository.NhaSanXuatRepository;
import com.ASSM.thepv.service.ChiTietSPService;
import com.ASSM.thepv.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
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

    @Autowired
    private GioHangService gioHangService;

    @GetMapping("/list-san-pham")
    public String listSanPham(Model model, @PageableDefault(page = 0, size = 2) Pageable pageable, Principal principal){
        Page<ChiTietSanPham> list =  chiTietSPService.chiTietSanPhamList(pageable);
        List<NhaSanXuat> sanXuatList  = nhaSanXuatRepository.findAll();
        GioHang gioHangList = gioHangService.findGioHangByUserName(principal.getName());
        model.addAttribute("sizeCart",gioHangList.getChiTietGioHang().size());
        model.addAttribute("sp",list.getContent().get(list.getContent().size()-1));
        model.addAttribute("productPage",list);
        model.addAttribute("nsx",sanXuatList );
        return "sanpham";
    }

    @GetMapping("/detail/{id}")
    public String findById(@PathVariable("id") String id , Model model,Principal principal){
        ChiTietSanPham ctsp = chiTietSPService.findOneById(id);
        GioHang gioHangList = gioHangService.findGioHangByUserName(principal.getName());
        model.addAttribute("sizeCart",gioHangList.getChiTietGioHang().size());
        model.addAttribute("ctsp",ctsp);
        return "detail_product";
    }

    @GetMapping("/nha-san-xuat/{id}")
    public String findALLByNSX(@PathVariable("id") String id , Model model,@PageableDefault(page = 0, size = 2) Pageable pageable,Principal principal){
        Page<ChiTietSanPham> list =  chiTietSPService.findAllByNhaSanXuat(id,pageable);
        List<NhaSanXuat> sanXuatList  = nhaSanXuatRepository.findAll();
        GioHang gioHangList = gioHangService.findGioHangByUserName(principal.getName());
        model.addAttribute("sizeCart",gioHangList.getChiTietGioHang().size());
        model.addAttribute("sp",list.getContent().get(list.getContent().size()-1));
        model.addAttribute("productPage",list);
        model.addAttribute("nsx",sanXuatList );
        return "sanpham";
    }

}
