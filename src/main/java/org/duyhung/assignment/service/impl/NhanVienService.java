package org.duyhung.assignment.service.impl;

import org.duyhung.assignment.entity.NhanVien;
import org.duyhung.assignment.repository.INhanVienRepository;
import org.duyhung.assignment.repository.impl.NhanVienRepository;
import org.duyhung.assignment.service.INhanVienService;

import java.util.List;

public class NhanVienService implements INhanVienService {
    private final INhanVienRepository repository;

    public NhanVienService() {
        this.repository = new NhanVienRepository();
    }

    @Override
    public List<NhanVien> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(NhanVien nhanVien) {
        return repository.insert(nhanVien);
    }

    @Override
    public Boolean delete(NhanVien nhanVien) {
        return repository.delete(nhanVien);
    }

    @Override
    public Boolean update(NhanVien nhanVien) {
        return repository.update(nhanVien);
    }

    @Override
    public NhanVien getOne(String id) {
        return repository.getOne(id);
    }
}
