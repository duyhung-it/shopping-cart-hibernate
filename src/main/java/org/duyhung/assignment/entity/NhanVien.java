package org.duyhung.assignment.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Data
@ToString(onlyExplicitlyIncluded = true,includeFieldNames = false)
@NoArgsConstructor
@Entity
@Table(name = "NhanVien")
public class NhanVien implements Serializable {
    @Id
    @GenericGenerator(name = "generator", strategy = "guid")
    @GeneratedValue(generator = "generator")
    private String id;

    @ToString.Include
    @Column(name = "Ma", unique = true)
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "GioiTinh")
    private String gioiTinh;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String soDienThoai;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "IdCH")
    private CuaHang cuaHang;

    @ManyToOne
    @JoinColumn(name = "IdCV")
    private ChucVu chucVu;

//    @ManyToOne
//    @JoinColumn(name = "IdGuiBC")
//    private NhanVien truongPhong;

    @Builder
    public NhanVien(String ma, String ten, String ho, String tenDem, String gioiTinh, Date ngaySinh, String diaChi, String soDienThoai, String matKhau, Integer trangThai, CuaHang cuaHang, ChucVu chucVu) {
        this.ma = ma;
        this.ten = ten;
        this.ho = ho;
        this.tenDem = tenDem;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
        this.cuaHang = cuaHang;
        this.chucVu = chucVu;
//        this.truongPhong = truongPhong;
    }
}
