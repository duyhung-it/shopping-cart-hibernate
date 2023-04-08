package org.duyhung.assignment.repository;



import org.duyhung.assignment.entity.ChiTietSanPham;
import org.duyhung.assignment.entity.ChucVu;
import org.duyhung.assignment.service.CRUDService;

import java.util.List;

public interface IChiTietSanPhamRepository extends CRUDRepository<ChiTietSanPham,String> {

    Boolean deleteByMauSac(String idMauSac);
    Boolean deleteByNSX(String idNSX);
    Boolean deleteBySanPham(String idSanPham);
    Boolean updateDongSanPham(String idDongSanPham);
}
