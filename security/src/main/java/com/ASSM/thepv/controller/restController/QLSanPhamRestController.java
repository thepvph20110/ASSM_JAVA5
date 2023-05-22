package com.ASSM.thepv.controller.restController;

import com.ASSM.thepv.entity.ChiTietSanPham;
import com.ASSM.thepv.response.ChiTietSPResponse;
import com.ASSM.thepv.service.ChiTietSPService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author thepvph20110
 */
@RestController
@RequestMapping("/admin")
public class QLSanPhamRestController {

    @Autowired
    private ChiTietSPService chiTietSPService;

    @GetMapping("/detail/{id}")
    private void detailProdct(@PathVariable("id")String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ChiTietSanPham chiTietSP = chiTietSPService.findOneById(id);
        ChiTietSPResponse chiTietSPResponse = new ChiTietSPResponse();
        chiTietSPResponse.setId(chiTietSP.getId());
        chiTietSPResponse.setTenSP(chiTietSP.getTenSP());
        chiTietSPResponse.setNhaSanXuat(chiTietSP.getNhaSanXuat().getMa());
        chiTietSPResponse.setMauSac(chiTietSP.getMauSac().getMa());
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
}
