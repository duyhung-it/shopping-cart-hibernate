package org.duyhung.assignment.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ChiTietGioHang")
public class ChiTietGioHang implements Serializable {
    @EmbeddedId
    private IdChiTietGioHang id;
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Column(name = "DonGia",columnDefinition = "decimal(20,0)")
    private Double donGia;
    @Column(name = "DonGiaKhiGiam",columnDefinition = "decimal(20,0)")
    private Double donGiaKhiGiam;
    @Transient
    private Double thanhTien;
}
