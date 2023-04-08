package org.duyhung.assignment.service.impl;

import org.duyhung.assignment.entity.NhaSanXuat;
import org.duyhung.assignment.repository.IChiTietSanPhamRepository;
import org.duyhung.assignment.repository.INhaSanXuatRepository;
import org.duyhung.assignment.repository.impl.ChiTietSanPhamRepository;
import org.duyhung.assignment.repository.impl.NhaSanXuatRepository;
import org.duyhung.assignment.service.INhaSanXuatService;

import java.util.List;

public class NhaSanXuatService implements INhaSanXuatService {
    private final INhaSanXuatRepository repository;
    private final IChiTietSanPhamRepository chiTietSanPhamRepository;
    public NhaSanXuatService(){
        repository = new NhaSanXuatRepository();
        chiTietSanPhamRepository = new ChiTietSanPhamRepository();
    }
    @Override
    public List<NhaSanXuat> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(NhaSanXuat nhaSanXuat) {
        return repository.insert(nhaSanXuat);
    }

    @Override
    public Boolean delete(NhaSanXuat nhaSanXuat) {
        if(chiTietSanPhamRepository.deleteByNSX(nhaSanXuat.getId())){
            return repository.delete(nhaSanXuat);
        }
        return false;
    }

    @Override
    public Boolean update(NhaSanXuat nhaSanXuat) {
        return repository.update(nhaSanXuat);
    }

    @Override
    public NhaSanXuat getOne(String id) {
        return repository.getOne(id);
    }
}
