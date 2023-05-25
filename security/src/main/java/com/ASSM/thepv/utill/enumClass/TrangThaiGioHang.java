package com.ASSM.thepv.utill.enumClass;

/**
 * @author thepvph20110
 */
public enum TrangThaiGioHang {

     CHUA_DAT_HANG("0"),
     DAT_HANG ("1"),
     CHO_NHAN_HANG ("2");

    public final String label;

    private TrangThaiGioHang(String label) {
        this.label = label;
    }
}
