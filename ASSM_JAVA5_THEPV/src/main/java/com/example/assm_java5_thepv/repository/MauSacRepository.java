package com.example.assm_java5_thepv.repository;

import com.example.assm_java5_thepv.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author thepvph20110
 */
@Repository
public interface MauSacRepository extends JpaRepository<MauSac, String> {
}
