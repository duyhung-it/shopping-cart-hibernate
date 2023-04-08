package org.duyhung.assignment.repository.impl;


import org.duyhung.assignment.entity.NhanVien;
import org.duyhung.assignment.repository.INhanVienRepository;
import org.duyhung.assignment.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class NhanVienRepository implements INhanVienRepository {
    @Override
    public List<NhanVien> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Transaction transaction = null;
        List<NhanVien> results = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.createQuery("from NhanVien",NhanVien.class).getResultList();
            transaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if(transaction != null) transaction.rollback();
        }
        return results;
    }
    @Override
    public String insert(NhanVien nhanVien) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        String results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = (String) session.save(nhanVien);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean delete(NhanVien nhanVien) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.delete("NhanVien",nhanVien);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean update(NhanVien nhanVien) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            session.merge("NhanVien",nhanVien);
            transaction.commit();
            results = true;
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public NhanVien getOne(String id) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        NhanVien results = null;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            results = session.get(NhanVien.class,id);
            transaction.commit();
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return results;
    }

    @Override
    public Boolean updateChucVu(String idChucVu) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            int affected = session.createQuery("UPDATE NhanVien n set n.chucVu = null where n.chucVu.id = :idChucVu")
                            .setParameter("idChucVu",idChucVu)
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
    public Boolean deleteByCuaHang(String idCuaHang) {
        SessionFactory sessionFactory = HibernateUtil.getFACTORY();
        Boolean results = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            int affected = session.createQuery("delete NhanVien n where n.cuaHang.id = :idCuaHang")
                    .setParameter("idCuaHang",idCuaHang)
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
