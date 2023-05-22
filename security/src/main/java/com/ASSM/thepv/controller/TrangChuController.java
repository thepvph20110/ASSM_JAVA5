package com.ASSM.thepv.controller;

import com.ASSM.thepv.entity.ChiTietSanPham;
import com.ASSM.thepv.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author thepvph20110
 */

@Controller
@RequestMapping("/home")
public class TrangChuController {

    @Autowired
    private ChiTietSPService chiTietSPService;

    @GetMapping("/list")
    public String getALlChiTietSP(Model model,@PageableDefault(page = 0, size = 10) Pageable pageable){
        List<ChiTietSanPham> list = chiTietSPService.chiTietSanPhamList(pageable).getContent();
        model.addAttribute("list", list);
        return "trang-chu";
    }


}
