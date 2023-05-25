package com.ASSM.thepv.service;

import com.ASSM.thepv.entity.GioHang;

/**
 * @author thepvph20110
 */
public interface GioHangService {

    GioHang findGioHangByUserName(String username);

    GioHang save(GioHang gioHang);
}
