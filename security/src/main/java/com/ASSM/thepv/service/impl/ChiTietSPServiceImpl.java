package com.ASSM.thepv.service.impl;

import com.ASSM.thepv.entity.ChiTietSanPham;
import com.ASSM.thepv.repository.ChiTietSPRepository;
import com.ASSM.thepv.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author thepvph20110
 */

@Service
public class ChiTietSPServiceImpl implements ChiTietSPService {

    @Autowired
    private ChiTietSPRepository chiTietSPRepository;

    @Override
    public Page<ChiTietSanPham> chiTietSanPhamList(Pageable pageable) {

        return chiTietSPRepository.findAll(pageable);
    }

    @Override
    public List<ChiTietSanPham> getAll() {
        return chiTietSPRepository.findAll();
    }

    @Override
    public void daleteChiTietSanPham(String id) {
        ChiTietSanPham chiTietSanPham = chiTietSPRepository.findById(id).get();
        chiTietSPRepository.delete(chiTietSanPham);
    }

    @Override
    public ChiTietSanPham findOneById(String id) {
        return chiTietSPRepository.findById(id).get();
    }

    @Override
    public List<ChiTietSanPham> findAllByNhaSanXuat(String idNSX) {
        return chiTietSPRepository.findAllByNhaSanXuat(idNSX);
    }
}
