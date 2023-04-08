package org.duyhung.assignment.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ChiTietSP")
public class ChiTietSanPham implements Serializable {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid")
    @GeneratedValue(generator = "generator")
    private String id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSanPham dongSanPham;

    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NhaSanXuat nhaSanXuat;

    @Column(name = "NamBH")
    private Integer namBaoHanh;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaNhap",columnDefinition = "decimal(20,0)")
    private Double giaNhap;

    @Column(name = "GiaBan",columnDefinition = "decimal(20,0)")
    private Double giaBan;
    @Column(name = "images",columnDefinition = "text")
    private String images;
}
