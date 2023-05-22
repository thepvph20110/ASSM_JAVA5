package com.ASSM.thepv.repository;

import com.ASSM.thepv.entity.NhaSanXuat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author thepvph20110
 */
@Repository
public interface NhaSanXuatRepository extends JpaRepository<NhaSanXuat, String> {
}
