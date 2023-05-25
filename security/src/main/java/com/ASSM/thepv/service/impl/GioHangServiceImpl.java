package com.ASSM.thepv.service.impl;

import com.ASSM.thepv.entity.GioHang;
import com.ASSM.thepv.repository.GioHangRepository;
import com.ASSM.thepv.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author thepvph20110
 */
@Service
public class GioHangServiceImpl implements GioHangService {

    @Autowired
    private GioHangRepository gioHangRepository;
    @Override
    public GioHang findGioHangByUserName(String username) {
        return gioHangRepository.findGioHangByAccount_Username(username);
    }

    @Override
    public GioHang save(GioHang gioHang) {
        return gioHangRepository.save(gioHang);
    }
}
