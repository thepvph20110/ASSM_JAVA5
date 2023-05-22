package com.ASSM.thepv.repository;

import com.ASSM.thepv.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author thepvph20110
 */
@Repository
public interface MauSacRepository extends JpaRepository<MauSac, String> {
}
