package org.duyhung.assignment.service.impl;

import org.duyhung.assignment.entity.ChiTietSanPham;
import org.duyhung.assignment.repository.IChiTietSanPhamRepository;
import org.duyhung.assignment.repository.impl.ChiTietSanPhamRepository;
import org.duyhung.assignment.service.IChiTietSanPhamService;

import java.util.List;

public class ChiTietSanPhamService implements IChiTietSanPhamService {
    private IChiTietSanPhamRepository repository;
    public ChiTietSanPhamService(){
        repository = new ChiTietSanPhamRepository();
    }
    @Override
    public List<ChiTietSanPham> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(ChiTietSanPham chiTietSanPham) {
        return repository.insert(chiTietSanPham);
    }

    @Override
    public Boolean delete(ChiTietSanPham chiTietSanPham) {
        return repository.delete(chiTietSanPham);
    }

    @Override
    public Boolean update(ChiTietSanPham chiTietSanPham) {
        return repository.update(chiTietSanPham);
    }

    @Override
    public ChiTietSanPham getOne(String id) {
        return repository.getOne(id);
    }
}
