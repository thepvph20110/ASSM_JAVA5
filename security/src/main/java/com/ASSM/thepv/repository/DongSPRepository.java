package com.ASSM.thepv.repository;

import com.ASSM.thepv.entity.DongSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author thepvph20110
 */
@Repository
public interface DongSPRepository extends JpaRepository<DongSanPham, String> {
}
