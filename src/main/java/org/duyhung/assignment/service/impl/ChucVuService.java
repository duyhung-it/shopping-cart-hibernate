package org.duyhung.assignment.service.impl;

import org.duyhung.assignment.entity.ChucVu;
import org.duyhung.assignment.repository.IChucVuRepository;
import org.duyhung.assignment.repository.INhanVienRepository;
import org.duyhung.assignment.repository.impl.ChucVuRepository;
import org.duyhung.assignment.repository.impl.NhanVienRepository;
import org.duyhung.assignment.service.IChucVuService;

import java.util.List;

public class ChucVuService implements IChucVuService {
    private final IChucVuRepository repository;
    private final INhanVienRepository nhanVienRepository;
    public ChucVuService(){
        repository = new ChucVuRepository();
        nhanVienRepository = new NhanVienRepository();
    }
    @Override
    public List<ChucVu> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(ChucVu chucVu) {
        return repository.insert(chucVu);
    }

    @Override
    public Boolean delete(ChucVu chucVu) {
        if(nhanVienRepository.updateChucVu(chucVu.getId())){
            return repository.delete(chucVu);
        }
        return false;
    }

    @Override
    public Boolean update(ChucVu chucVu) {
        return repository.update(chucVu);
    }

    @Override
    public ChucVu getOne(String id) {
        return repository.getOne(id);
    }
}
