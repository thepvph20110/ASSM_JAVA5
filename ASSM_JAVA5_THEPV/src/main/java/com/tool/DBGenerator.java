package com.tool;

import com.example.assm_java5_thepv.entity.GioHang;
import com.example.assm_java5_thepv.entity.HoaDon;
import com.example.assm_java5_thepv.repository.AccountRepository;
import com.example.assm_java5_thepv.repository.ChiTietSPRepository;
import com.example.assm_java5_thepv.repository.DongSPRepository;
import com.example.assm_java5_thepv.repository.GioHangChiTietRepository;
import com.example.assm_java5_thepv.repository.GioHangRepository;
import com.example.assm_java5_thepv.repository.HoaDonChiTietRepository;
import com.example.assm_java5_thepv.repository.HoaDonRepository;
import com.fpolydatn.entity.CanBo;
import com.fpolydatn.entity.ChuyenNganh;
import com.fpolydatn.entity.CoSo;
import com.fpolydatn.entity.DotDangKy;
import com.fpolydatn.entity.GiangVienHuongDan;
import com.fpolydatn.entity.HocKy;
import com.fpolydatn.entity.MonDatn;
import com.fpolydatn.entity.NhomDatn;
import com.fpolydatn.entity.PhanCongHuongDan;
import com.fpolydatn.entity.SinhVien;
import com.fpolydatn.infrastructure.constant.TrangThaiNhom;
import com.fpolydatn.infrastructure.constant.VaiTro;
import com.fpolydatn.repository.CanBoRepository;
import com.fpolydatn.repository.ChuyenNganhRepository;
import com.fpolydatn.repository.CoSoRepository;
import com.fpolydatn.repository.DotDangKyRepository;
import com.fpolydatn.repository.GiangVienHuongDanRepository;
import com.fpolydatn.repository.HocKyRepository;
import com.fpolydatn.repository.MonDatnRepository;
import com.fpolydatn.repository.NhomDatnRepository;
import com.fpolydatn.repository.PhanCongHuongDanRepository;
import com.fpolydatn.repository.SinhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

/**
 * @author phongtt35
 */

@SpringBootApplication
@EnableJpaRepositories(
        basePackages = "com.example.assm_java5_thepv.repository"
)
public class DBGenerator implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ChiTietSPRepository chiTietSPRepository;

    @Autowired
    private DongSPRepository dongSPRepository;

    @Autowired
    private GioHangRepository gioHangRepository;

    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;


    @Override
    public void run(String... args) throws Exception {

    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(DBGenerator.class);
        ctx.close();
    }

}