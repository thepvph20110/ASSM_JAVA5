package com.ASSM.thepv.controller;

import com.ASSM.thepv.entity.Account;
import com.ASSM.thepv.entity.ChiTietSanPham;
import com.ASSM.thepv.entity.GioHang;
import com.ASSM.thepv.entity.GioHangChiTiet;
import com.ASSM.thepv.repository.AccountRepository;
import com.ASSM.thepv.repository.GioHangChiTietRepository;
import com.ASSM.thepv.service.ChiTietSPService;
import com.ASSM.thepv.service.GioHangService;
import com.ASSM.thepv.utill.enumClass.TrangThaiGioHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

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

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;

    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam("idSP") String idSanPham, @RequestParam("urlnow") String urlNow, Principal principal, Model model) {
        String username = principal.getName();
        GioHang gioHang = gioHangService.findGioHangByUserName(username);

        if (gioHang != null) {
            ChiTietSanPham chiTietSanPham = chiTietSPService.findOneById(idSanPham);
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setSoLuong(1);
            gioHangChiTiet.setDonGia(chiTietSanPham.getGiaBan());
            gioHangChiTiet.setGioHang(gioHang);
            gioHangChiTiet.setChiTietSP(chiTietSanPham);

            savaGioHangChiTiet(gioHang, chiTietSanPham, gioHangChiTiet);

        } else {
            Account account = accountRepository.findAccountByUsername(username);
            GioHang gioHangNew = new GioHang();
            gioHangNew.setNgayTao(new Date());
            gioHangNew.setTinhTrang(0);
            gioHangNew.setAccount(account);

            GioHang gioHangSave = gioHangService.save(gioHangNew);

            ChiTietSanPham chiTietSanPham = chiTietSPService.findOneById(idSanPham);
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setSoLuong(1);
            gioHangChiTiet.setDonGia(chiTietSanPham.getGiaBan());
            gioHangChiTiet.setGioHang(gioHangSave);
            gioHangChiTiet.setChiTietSP(chiTietSanPham);

            savaGioHangChiTiet(gioHangSave, chiTietSanPham, gioHangChiTiet);
        }
        GioHang gioHangList = gioHangService.findGioHangByUserName(username);
        model.addAttribute("sizeCart", gioHangList.getChiTietGioHang().size());
        return "redirect:" + urlNow;
    }

    public void savaGioHangChiTiet(GioHang gioHang, ChiTietSanPham chiTietSanPham, GioHangChiTiet gioHangChiTietNew) {
        GioHangChiTiet gioHangChiTietOrl = gioHangChiTietRepository.findGioHangChiTietByChiTietSP(chiTietSanPham.getId(), gioHang.getId());
        if (gioHangChiTietOrl != null) {
            gioHangChiTietOrl.setSoLuong(gioHangChiTietOrl.getSoLuong() + 1);
            BigDecimal donGia = gioHangChiTietOrl.getChiTietSP().getGiaBan().multiply(BigDecimal.valueOf(gioHangChiTietOrl.getSoLuong()));
            gioHangChiTietOrl.setDonGia(donGia);
            gioHangChiTietNew = gioHangChiTietOrl;
        }
        gioHangChiTietRepository.save(gioHangChiTietNew);
    }

    @GetMapping("/show")
    public String showGioHang(Model model, Principal principal) {
        GioHang gioHangList = gioHangService.findGioHangByUserName(principal.getName());
        model.addAttribute("gh", gioHangList);
        model.addAttribute("sizeCart", gioHangList.getChiTietGioHang().size());
        return "cart";
    }

    @PostMapping("/update-cart")
    public String updateGioHang(Model model, @RequestParam("idCart") String idCart, int soLuongUpdate, String idGioHang) {
        GioHangChiTiet gioHangChiTiet = gioHangChiTietRepository.findGioHangChiTietByChiTietSP(idCart, idGioHang);
        gioHangChiTiet.setSoLuong(soLuongUpdate);
        BigDecimal donGia = gioHangChiTiet.getChiTietSP().getGiaBan().multiply(BigDecimal.valueOf(soLuongUpdate));
        gioHangChiTiet.setDonGia(donGia);
        gioHangChiTietRepository.save(gioHangChiTiet);
        return "redirect:/user/show";
    }

    @GetMapping("/delete-cart/{idCart}")
    public String deleteGioHang(@PathVariable("idCart") String idCart) {
        try {
            gioHangChiTietRepository.deleteChiTietGioHang(idCart);
        }catch (Exception e){

        }

        return "redirect:/user/show";
    }
}
