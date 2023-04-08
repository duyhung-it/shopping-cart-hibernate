package org.duyhung.assignment.service.impl;

import org.duyhung.assignment.entity.DongSanPham;
import org.duyhung.assignment.repository.IChiTietSanPhamRepository;
import org.duyhung.assignment.repository.IDongSanPhamRepository;
import org.duyhung.assignment.repository.impl.ChiTietSanPhamRepository;
import org.duyhung.assignment.repository.impl.DongSanPhamRepository;
import org.duyhung.assignment.service.IDongSanPhamService;

import java.util.List;

public class DongSanPhamService implements IDongSanPhamService {
    private final IDongSanPhamRepository repository;
    private final IChiTietSanPhamRepository chiTietSanPhamRepository;
    public DongSanPhamService(){
        repository = new DongSanPhamRepository();
        chiTietSanPhamRepository = new ChiTietSanPhamRepository();
    }
    @Override
    public List<DongSanPham> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(DongSanPham dongSanPham) {
        return repository.insert(dongSanPham);
    }

    @Override
    public Boolean delete(DongSanPham dongSanPham) {
        if(chiTietSanPhamRepository.updateDongSanPham(dongSanPham.getId())){
            return repository.delete(dongSanPham);
        }
        return false;
    }

    @Override
    public Boolean update(DongSanPham dongSanPham) {
        return repository.update(dongSanPham);
    }

    @Override
    public DongSanPham getOne(String id) {
        return repository.getOne(id);
    }
}
