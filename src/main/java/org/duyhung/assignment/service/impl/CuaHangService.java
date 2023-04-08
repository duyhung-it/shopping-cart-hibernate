package org.duyhung.assignment.service.impl;

import org.duyhung.assignment.entity.CuaHang;
import org.duyhung.assignment.repository.ICuaHangRepository;
import org.duyhung.assignment.repository.INhanVienRepository;
import org.duyhung.assignment.repository.impl.CuaHangRepository;
import org.duyhung.assignment.repository.impl.NhanVienRepository;
import org.duyhung.assignment.service.ICuaHangService;

import java.util.List;

public class CuaHangService implements ICuaHangService {
    private final ICuaHangRepository repository;
    private final INhanVienRepository nhanVienRepository;
    public CuaHangService(){
        repository = new CuaHangRepository();
        nhanVienRepository = new NhanVienRepository();
    }
    @Override
    public List<CuaHang> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(CuaHang cuaHang) {
        return repository.insert(cuaHang);
    }

    @Override
    public Boolean delete(CuaHang cuaHang) {
        if(nhanVienRepository.deleteByCuaHang(cuaHang.getId())){
            return repository.delete(cuaHang);
        }
        return false;
    }

    @Override
    public Boolean update(CuaHang cuaHang) {
        return repository.update(cuaHang);
    }

    @Override
    public CuaHang getOne(String id) {
        return repository.getOne(id);
    }
}
