package com.ASSM.thepv.repository;

import com.ASSM.thepv.entity.ChiTietSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author thepvph20110
 */
@Repository
public interface ChiTietSPRepository extends JpaRepository<ChiTietSanPham, String> {

    @Query(value = """
                    FROM ChiTietSanPham sp where sp.nhaSanXuat.id = :id_nsx
            """)
    Page<ChiTietSanPham> findAllByNhaSanXuat(@Param("id_nsx") String idNSX,Pageable pageable);
}
