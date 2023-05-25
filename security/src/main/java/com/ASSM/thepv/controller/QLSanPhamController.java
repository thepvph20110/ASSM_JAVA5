package com.ASSM.thepv.controller;

import com.ASSM.thepv.entity.ChiTietSanPham;
import com.ASSM.thepv.entity.GioHang;
import com.ASSM.thepv.entity.MauSac;
import com.ASSM.thepv.entity.NhaSanXuat;
import com.ASSM.thepv.repository.GioHangChiTietRepository;
import com.ASSM.thepv.repository.MauSacRepository;
import com.ASSM.thepv.repository.NhaSanXuatRepository;
import com.ASSM.thepv.request.QLChiTietSanPham;
import com.ASSM.thepv.service.ChiTietSPService;
import com.ASSM.thepv.service.GioHangService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.Principal;

/**
 * @author thepvph20110
 */
@Controller
@RequestMapping("/admin")
@MultipartConfig
public class QLSanPhamController {

    @Autowired
    private ChiTietSPService chiTietSPService;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @Autowired
    private GioHangService gioHangService;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;


    @GetMapping("/quan-ly-san-pham")
    public String listSanPham(Model model, @PageableDefault(page = 0, size = 2) Pageable pageable, Principal principal){
//        pageable.
        Page<ChiTietSanPham> chiTietSanPhamList = chiTietSPService.chiTietSanPhamList(pageable);
        GioHang gioHangList = gioHangService.findGioHangByUserName(principal.getName());
        model.addAttribute("sizeCart",gioHangList.getChiTietGioHang().size());
        model.addAttribute("productPage",chiTietSanPhamList);
        model.addAttribute("mauSacs", mauSacRepository.findAll());
        model.addAttribute("nsx", nhaSanXuatRepository.findAll());
        return "quanlysanpham";
    }

    @GetMapping("/delete/{id}")
    public String deleteSanPham(@PathVariable("id") String id,Model model){
        try {
//            gioHangChiTietRepository.deleteByChiTietSPId(id);
            chiTietSPService.daleteChiTietSanPham(id);
        }catch (Exception e){

        }


        return "redirect:/admin/quan-ly-san-pham";
    }

    @PostMapping("/add-san-pham")
    public String addChiTietSP(QLChiTietSanPham chiTietSanPham , @RequestParam("image") MultipartFile file) throws IOException {
        String imgName = file.getOriginalFilename();
        MauSac mauSac = mauSacRepository.findById(chiTietSanPham.getMauSac()).get();
        NhaSanXuat nhaSanXuat = nhaSanXuatRepository.findById(chiTietSanPham.getNsx()).get();
        int viTriDauCham = imgName.indexOf(".");
        String duoiImage = imgName.substring(viTriDauCham + 1).trim();
        if (duoiImage.equalsIgnoreCase("jpeg") || duoiImage.equalsIgnoreCase("png") || duoiImage.equalsIgnoreCase("svg") || duoiImage.equalsIgnoreCase("jpg") || duoiImage.equalsIgnoreCase("tiff") || duoiImage.equalsIgnoreCase("heic")) {
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String url = servletContext.getRealPath("/img/");
                File fileSave = new File(url + fileName);
                file.transferTo(fileSave);
            }
            ChiTietSanPham sanPham = new ChiTietSanPham();
            sanPham.setTenSP(chiTietSanPham.getTen());
            sanPham.setImg(imgName);
            sanPham.setMoTa(chiTietSanPham.getMoTa());
            Long giaBan = Long.valueOf(chiTietSanPham.getGiaBan());
            sanPham.setGiaBan(BigDecimal.valueOf(giaBan));
            sanPham.setSoLuongTon(Integer.valueOf(chiTietSanPham.getSoLuongTon()));
            sanPham.setMauSac(mauSac);
            sanPham.setNhaSanXuat(nhaSanXuat);
            chiTietSPService.saveChiTietSanPham(sanPham);
        }


        return "redirect:/admin/quan-ly-san-pham";
    }


}
