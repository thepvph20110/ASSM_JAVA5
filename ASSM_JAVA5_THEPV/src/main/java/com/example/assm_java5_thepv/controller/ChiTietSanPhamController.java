package com.example.assm_java5_thepv.controller;

import com.example.assm_java5_thepv.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author thepvph20110
 */

@Controller
@RequestMapping("/san-pham")
public class ChiTietSanPhamController {

    @Autowired
    private ChiTietSPService chiTietSPService;

    @GetMapping("/list")
    public String getALlChiTietSP(Model model){
        return "/san_pham/chi-tiet-sp";
    }
}
