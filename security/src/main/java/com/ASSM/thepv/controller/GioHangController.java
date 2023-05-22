package com.ASSM.thepv.controller;

import com.ASSM.thepv.entity.ChiTietSanPham;
import com.ASSM.thepv.entity.GioHangChiTiet;
import com.ASSM.thepv.service.ChiTietSPService;
import com.ASSM.thepv.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author thepvph20110
 */
@Controller
@RequestMapping("/user")
public class GioHangController {

    @Autowired
    private GioHangService gioHangService;

    @Autowired
    private ChiTietSPService chiTietSPService;

    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam("idSP")String idSanPham ,@RequestParam("urlnow")String urlNow){
//        ChiTietSanPham chiTietSanPham = chiTietSPService.findOneById(idSanPham);
//        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
//        gioHangChiTiet.set
            return "redirect:"+urlNow;
    }
}
