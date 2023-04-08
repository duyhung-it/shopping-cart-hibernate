package org.duyhung.assignment.repository;



import org.duyhung.assignment.entity.ChiTietSanPham;
import org.duyhung.assignment.entity.NhanVien;

import java.util.List;

public interface INhanVienRepository extends CRUDRepository<NhanVien,String> {

    Boolean updateChucVu(String idChucVu);
    Boolean deleteByCuaHang(String idCuaHang);
}
