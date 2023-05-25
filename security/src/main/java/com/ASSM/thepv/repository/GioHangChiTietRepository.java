package com.ASSM.thepv.repository;

import com.ASSM.thepv.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author thepvph20110
 */
@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, String> {

    @Query(value = """
            FROM GioHangChiTiet  gh where gh.chiTietSP.id = :idChiTietSP and gh.gioHang.id =:idGioHang
            """)
    GioHangChiTiet findGioHangChiTietByChiTietSP(@Param("idChiTietSP") String idChiTietSP,@Param("idGioHang")String idGioHang );

    @Query(value = """
            DELETE FROM gio_hang_chi_tiet where gio_hang_chi_tiet.id = :idGioHang
            """, nativeQuery = true)
    void deleteChiTietGioHang(@Param("idGioHang")String idGioHangChiTiet);

    @Query(value = """
            DELETE FROM GioHangChiTiet gh where gh .chiTietSP.id = :idChiTietSP
            """)
    void deleteByChiTietSPId(@Param("idChiTietSP")String id);
}
