package com.ASSM.thepv.controller;

import com.ASSM.thepv.repository.DongSPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author thepvph20110
 */
@Controller
@RequestMapping("/admin/dong-sp")
public class DongSanPhamController {

    @Autowired
    private DongSPRepository dongSPRepository;

    @GetMapping("/list")
    public String addDongSP(Model model){
        return "dongsp/dong-sp";

    }
}
