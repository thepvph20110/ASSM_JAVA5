package com.ASSM.thepv.controller.restController;

import com.ASSM.thepv.entity.ChiTietSanPham;
import com.ASSM.thepv.entity.MauSac;
import com.ASSM.thepv.entity.NhaSanXuat;
import com.ASSM.thepv.repository.MauSacRepository;
import com.ASSM.thepv.repository.NhaSanXuatRepository;
import com.ASSM.thepv.request.QLChiTietSanPham;
import com.ASSM.thepv.request.QLUpdateChiTietSanPham;
import com.ASSM.thepv.response.ChiTietSPResponse;
import com.ASSM.thepv.service.ChiTietSPService;
import com.ASSM.thepv.utill.convert.StringToMultipartFileConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author thepvph20110
 */
@RestController
@RequestMapping("/admin")
@MultipartConfig
public class QLSanPhamRestController {

    @Autowired
    private ChiTietSPService chiTietSPService;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private NhaSanXuatRepository nhaSanXuatRepository;

    @Autowired
    private ServletContext servletContext;

    @GetMapping("/detail/{id}")
    private void detailProdct(@PathVariable("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ChiTietSanPham chiTietSP = chiTietSPService.findOneById(id);
        ChiTietSPResponse chiTietSPResponse = new ChiTietSPResponse();
        chiTietSPResponse.setId(chiTietSP.getId());
        chiTietSPResponse.setTenSP(chiTietSP.getTenSP());
        chiTietSPResponse.setNhaSanXuat(chiTietSP.getNhaSanXuat().getId());
        chiTietSPResponse.setMauSac(chiTietSP.getMauSac().getId());
        chiTietSPResponse.setGiaBan(chiTietSP.getGiaBan());
        chiTietSPResponse.setImg(chiTietSP.getImg());
        chiTietSPResponse.setMoTa(chiTietSP.getMoTa());
        chiTietSPResponse.setSoLuongTon(chiTietSP.getSoLuongTon());
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(chiTietSPResponse);
        // Thiết lập header và gửi dữ liệu về cho client
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    @PostMapping("/update-san-pham")
    public void updateChiTietSP( @RequestParam(value = "image",required =
            false) MultipartFile filePart,QLUpdateChiTietSanPham chiTietSanPham) throws Exception {

        String imgName = filePart.getOriginalFilename();
        MauSac mauSac = mauSacRepository.findById(chiTietSanPham.getMauSac()).get();
        NhaSanXuat nhaSanXuat = nhaSanXuatRepository.findById(chiTietSanPham.getNsx()).get();
        int viTriDauCham = imgName.indexOf(".");
        String duoiImage = imgName.substring(viTriDauCham + 1).trim();
        if (duoiImage.equalsIgnoreCase("jpeg") || duoiImage.equalsIgnoreCase("png") || duoiImage.equalsIgnoreCase("svg") || duoiImage.equalsIgnoreCase("jpg") || duoiImage.equalsIgnoreCase("tiff") || duoiImage.equalsIgnoreCase("heic")) {
            if (!filePart.isEmpty()) {
                String url = servletContext.getRealPath("/img/");
                File fileSave = new File(url + imgName);
                filePart.transferTo(fileSave);
            }
            ChiTietSanPham sanPham = new ChiTietSanPham();
            sanPham.setId(chiTietSanPham.getId());
            sanPham.setTenSP(chiTietSanPham.getTenSP());
            sanPham.setImg(imgName);
            sanPham.setMoTa(chiTietSanPham.getMoTa());
            Long giaBan = Long.valueOf(chiTietSanPham.getGiaBan());
            sanPham.setGiaBan(BigDecimal.valueOf(giaBan));
            sanPham.setSoLuongTon(Integer.valueOf(chiTietSanPham.getSoLuongTon()));
            sanPham.setMauSac(mauSac);
            sanPham.setNhaSanXuat(nhaSanXuat);
            chiTietSPService.saveChiTietSanPham(sanPham);
        }
    }
}
