package com.ASSM.thepv.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 
 */
@NoArgsConstructor
@Getter
@Setter
public class QLUpdateChiTietSanPham {
    private String img;
    private String tenSP;
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
                ", ten='" + tenSP + '\'' +
                ", moTa='" + moTa + '\'' +
                ", giaBan=" + giaBan +
                ", soLuongTon=" + soLuongTon +
                ", mauSac='" + mauSac + '\'' +
                ", nsx='" + nsx + '\'' +
                '}';
    }
}
