package org.duyhung.assignment.service.impl;

import org.duyhung.assignment.entity.KhachHang;
import org.duyhung.assignment.repository.IKhachHangRepository;
import org.duyhung.assignment.repository.impl.KhachHangRepository;
import org.duyhung.assignment.service.IKhachHangService;

import java.util.List;

public class KhachHangService implements IKhachHangService {
    private final IKhachHangRepository repository;
    public KhachHangService(){
        repository = new KhachHangRepository();
    }
    @Override
    public List<KhachHang> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(KhachHang khachHang) {
        return repository.insert(khachHang);
    }

    @Override
    public Boolean delete(KhachHang khachHang) {
        return repository.delete(khachHang);
    }

    @Override
    public Boolean update(KhachHang khachHang) {
        return repository.update(khachHang);
    }

    @Override
    public KhachHang getOne(String id) {
        return repository.getOne(id);
    }
}
