package org.duyhung.assignment.service.impl;

import org.duyhung.assignment.entity.MauSac;
import org.duyhung.assignment.repository.IChiTietSanPhamRepository;
import org.duyhung.assignment.repository.IMauSacRepository;
import org.duyhung.assignment.repository.impl.ChiTietSanPhamRepository;
import org.duyhung.assignment.repository.impl.MauSacRepository;
import org.duyhung.assignment.service.IMauSacService;

import java.util.List;

public class MauSacService implements IMauSacService {
    private final IMauSacRepository repository;
    private final IChiTietSanPhamRepository chiTietSanPhamRepository;
    public MauSacService(){
        repository = new MauSacRepository();
        chiTietSanPhamRepository = new ChiTietSanPhamRepository();
    }
    @Override
    public List<MauSac> getAll() {
        return repository.getAll();
    }

    @Override
    public String insert(MauSac mauSac) {
        return repository.insert(mauSac);
    }

    @Override
    public Boolean delete(MauSac mauSac) {
        if(chiTietSanPhamRepository.deleteByMauSac(mauSac.getId())){
            return repository.delete(mauSac);
        }
        return false;
    }

    @Override
    public Boolean update(MauSac mauSac) {
        return repository.update(mauSac);
    }

    @Override
    public MauSac getOne(String id) {
        return repository.getOne(id);
    }
}
