package org.duyhung.assignment.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Embeddable
public class IdChiTietGioHang implements Serializable {
    private static final long serialVersionUID = 3839541417905211229L;
    @OneToOne
    @JoinColumn(name = "IdGioHang")
    private GioHang gioHang;
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSanPham sanPham;
}
