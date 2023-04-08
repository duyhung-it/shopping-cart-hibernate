package org.duyhung.assignment.repository.impl;


import org.duyhung.assignment.entity.ChiTietSanPham;
import org.duyhung.assignment.repository.IChiTietSanPhamRepository;
import org.duyhung.assignment.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ChiTietSanPhamRepository implements IChiTietSanPhamRepository {
    @Override
    public List<ChiTietSanPham> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        List<ChiTietSanPham> results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.createQuery("from ChiTietSanPham",ChiTietSanPham.class)
                    .getResultList();
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public String insert(ChiTietSanPham chiTietSanPham) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        String results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = (String) session.save(chiTietSanPham);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean delete(ChiTietSanPham chiTietSanPham) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.delete("ChiTietSanPham",chiTietSanPham);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean update(ChiTietSanPham chiTietSanPham) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge("ChiTietSanPham",chiTietSanPham);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public ChiTietSanPham getOne(String id) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        ChiTietSanPham results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.get(ChiTietSanPham.class,id);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }
    @Override
    public Boolean deleteByMauSac(String idMauSac) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            int affected = session.createQuery("delete ChiTietSanPham c where c.mauSac.id = :idMauSac")
                    .setParameter("idMauSac",idMauSac)
                    .executeUpdate();
            if(affected >= 0){
                results = true;
            }
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean deleteByNSX(String idNSX) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            int affected = session.createQuery("delete ChiTietSanPham c where c.nhaSanXuat.id = :idNSX")
                    .setParameter("idNSX",idNSX)
                    .executeUpdate();
            if(affected >= 0){
                results = true;
            }
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean deleteBySanPham(String idSanPham) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            int affected = session.createQuery("delete ChiTietSanPham c where c.sanPham.id = :idSanPham")
                    .setParameter("idSanPham",idSanPham)
                    .executeUpdate();
            if(affected >= 0){
                results = true;
            }
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean updateDongSanPham(String idDongSanPham) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            int affected = session.createQuery("update ChiTietSanPham c set c.dongSanPham = null where c.dongSanPham.id = :idDongSanPham")
                    .setParameter("idDongSanPham",idDongSanPham)
                    .executeUpdate();
            if(affected >= 0){
                results = true;
            }
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }
}
