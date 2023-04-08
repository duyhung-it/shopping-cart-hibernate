package org.duyhung.assignment.service.impl;

import org.duyhung.assignment.entity.ChiTietGioHang;
import org.duyhung.assignment.repository.IChiTietGioHangRepository;
import org.duyhung.assignment.repository.impl.ChiTietGioHangRepository;
import org.duyhung.assignment.service.CRUDService;
import org.duyhung.assignment.service.IChiTietGioHangService;

import java.util.List;

public class ChiTietGioHangService implements IChiTietGioHangService {
    private final IChiTietGioHangRepository repository;
    public ChiTietGioHangService(){
        repository = new ChiTietGioHangRepository();
    }
    @Override
    public List<ChiTietGioHang> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(ChiTietGioHang chiTietGioHang) {
        return repository.insert(chiTietGioHang);
    }

    @Override
    public Boolean delete(ChiTietGioHang chiTietGioHang) {
        return repository.delete(chiTietGioHang);
    }

    @Override
    public Boolean update(ChiTietGioHang chiTietGioHang) {
        return repository.update(chiTietGioHang);
    }

    @Override
    public ChiTietGioHang getOne(String id) {
        return repository.getOne(id);
    }
}
