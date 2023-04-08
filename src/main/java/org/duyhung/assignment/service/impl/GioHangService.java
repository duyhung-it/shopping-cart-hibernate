package org.duyhung.assignment.service.impl;

import org.duyhung.assignment.entity.GioHang;
import org.duyhung.assignment.repository.IGioHangRepository;
import org.duyhung.assignment.repository.impl.GioHangRepository;
import org.duyhung.assignment.service.IGioHangService;

import java.util.List;

public class GioHangService implements IGioHangService {
    private IGioHangRepository repository;
    public GioHangService(){
        repository = new GioHangRepository();
    }
    @Override
    public List<GioHang> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(GioHang gioHang) {
        return repository.insert(gioHang);
    }

    @Override
    public Boolean delete(GioHang gioHang) {
        return repository.delete(gioHang);
    }

    @Override
    public Boolean update(GioHang gioHang) {
        return repository.update(gioHang);
    }

    @Override
    public GioHang getOne(String id) {
        return repository.getOne(id);
    }
}
