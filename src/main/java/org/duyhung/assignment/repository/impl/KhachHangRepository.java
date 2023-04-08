package org.duyhung.assignment.repository.impl;


import org.duyhung.assignment.entity.KhachHang;
import org.duyhung.assignment.repository.IKhachHangRepository;
import org.duyhung.assignment.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class KhachHangRepository implements IKhachHangRepository {
    public List<KhachHang> getAll(){
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Transaction transaction = null;
        List<KhachHang> results = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.createQuery("from KhachHang",KhachHang.class).getResultList();
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction != null) transaction.rollback();
        }
        return results;
    }
    @Override
    public String insert(KhachHang khachHang) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        String results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = (String) session.save(khachHang);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean delete(KhachHang khachHang) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.delete("KhachHang",khachHang);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean update(KhachHang khachHang) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge("KhachHang",khachHang);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public KhachHang getOne(String id) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        KhachHang results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.get(KhachHang.class,id);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }
}
