package org.duyhung.assignment.repository.impl;


import org.duyhung.assignment.entity.GioHang;
import org.duyhung.assignment.repository.IGioHangRepository;
import org.duyhung.assignment.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class GioHangRepository implements IGioHangRepository {
    @Override
    public List<GioHang> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        List<GioHang> results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.createQuery("from GioHang",GioHang.class)
                    .getResultList();
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public String insert(GioHang gioHang) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        String results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = (String) session.save(gioHang);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean delete(GioHang gioHang) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.delete("GioHang",gioHang);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean update(GioHang gioHang) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge("GioHang",gioHang);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public GioHang getOne(String id) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        GioHang results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.get(GioHang.class,id);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }
}
