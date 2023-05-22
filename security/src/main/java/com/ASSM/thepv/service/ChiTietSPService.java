package com.ASSM.thepv.service;

import com.ASSM.thepv.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author thepvph20110
 */
public interface ChiTietSPService {

    Page<ChiTietSanPham> chiTietSanPhamList(Pageable pageable);

    List<ChiTietSanPham> getAll();

    void daleteChiTietSanPham(String id);

   ChiTietSanPham findOneById(String id);

    List<ChiTietSanPham> findAllByNhaSanXuat( String idNSX);
}
