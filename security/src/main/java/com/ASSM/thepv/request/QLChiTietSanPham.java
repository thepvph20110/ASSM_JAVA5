package com.ASSM.thepv.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 
 */
@NoArgsConstructor
@Getter
@Setter
public class QLChiTietSanPham {
    private String img;
    private String ten;
    private String moTa;
    private String giaBan;
    private String soLuongTon;
    private String mauSac;
    private String nsx;

    private String id;

    @Override
    public String toString() {
        return "QLChiTietSanPham{" +
                "img='" + img + '\'' +
                ", ten='" + ten + '\'' +
                ", moTa='" + moTa + '\'' +
                ", giaBan=" + giaBan +
                ", soLuongTon=" + soLuongTon +
                ", mauSac='" + mauSac + '\'' +
                ", nsx='" + nsx + '\'' +
                '}';
    }
}
