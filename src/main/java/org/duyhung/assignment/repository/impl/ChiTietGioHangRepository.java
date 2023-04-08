package org.duyhung.assignment.repository.impl;


import org.duyhung.assignment.entity.ChiTietGioHang;
import org.duyhung.assignment.repository.IChiTietGioHangRepository;
import org.duyhung.assignment.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ChiTietGioHangRepository implements IChiTietGioHangRepository {
    @Override
    public List<ChiTietGioHang> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        List<ChiTietGioHang> results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.createQuery("from ChiTietGioHang",ChiTietGioHang.class)
                    .getResultList();
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public String insert(ChiTietGioHang chiTietGioHang) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        String results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = (String) session.save(chiTietGioHang);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean delete(ChiTietGioHang chiTietGioHang) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.delete("ChiTietGioHang",chiTietGioHang);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean update(ChiTietGioHang chiTietGioHang) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge("ChiTietGioHang",chiTietGioHang);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public ChiTietGioHang getOne(String id) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        ChiTietGioHang results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.get(ChiTietGioHang.class,id);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

}
