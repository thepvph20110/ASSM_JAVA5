package com.example.assm_java5_thepv.service.impl;

import com.example.assm_java5_thepv.entity.ChiTietSanPham;
import com.example.assm_java5_thepv.repository.ChiTietSPRepository;
import com.example.assm_java5_thepv.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<ChiTietSanPham> chiTietSanPhamList() {
        return chiTietSPRepository.findAll();
    }
}
