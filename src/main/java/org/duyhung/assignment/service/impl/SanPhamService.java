package org.duyhung.assignment.service.impl;

import org.duyhung.assignment.entity.SanPham;
import org.duyhung.assignment.repository.IChiTietSanPhamRepository;
import org.duyhung.assignment.repository.ISanPhamRepository;
import org.duyhung.assignment.repository.impl.ChiTietSanPhamRepository;
import org.duyhung.assignment.repository.impl.SanPhamRepository;
import org.duyhung.assignment.service.ISanPhamService;

import java.util.List;

public class SanPhamService implements ISanPhamService {
    private final ISanPhamRepository repository;
    private final IChiTietSanPhamRepository chiTietSanPhamRepository;
    public SanPhamService(){
        repository = new SanPhamRepository();
        chiTietSanPhamRepository = new ChiTietSanPhamRepository();
    }
    @Override
    public List<SanPham> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(SanPham sanPham) {
        return repository.insert(sanPham);
    }

    @Override
    public Boolean delete(SanPham sanPham) {
        if(chiTietSanPhamRepository.deleteBySanPham(sanPham.getId())){
            return repository.delete(sanPham);
        }
        return false;
    }

    @Override
    public Boolean update(SanPham sanPham) {
        return repository.update(sanPham);
    }

    @Override
    public SanPham getOne(String id) {
        return repository.getOne(id);
    }
}
