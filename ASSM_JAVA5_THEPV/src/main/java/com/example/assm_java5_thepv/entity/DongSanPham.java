package com.example.assm_java5_thepv.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "DongSP")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DongSanPham {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(name = "Ma", unique = true, nullable = false, length = 20)
    private String ma;

    @Column(name = "Ten", nullable = false, length = 30, columnDefinition = "nvarchar(Max)")
    private String ten;

}
