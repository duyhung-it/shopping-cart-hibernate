package org.duyhung.assignment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.duyhung.assignment.constant.AppConstant;
import org.duyhung.assignment.entity.NhaSanXuat;
import org.duyhung.assignment.service.INhaSanXuatService;
import org.duyhung.assignment.service.impl.NhaSanXuatService;
import org.duyhung.assignment.util.ObjectMapper;

import java.io.IOException;

@WebServlet(name = "NhaSanXuatServlet",value = {
        "/nha-san-xuat/hien-thi",
        "/nha-san-xuat/add",
        "/nha-san-xuat/delete",
        "/nha-san-xuat/update",
        "/nha-san-xuat/detail"
})
public class NhaSanXuatServlet extends HttpServlet {
    private INhaSanXuatService service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new NhaSanXuatService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String view = "";
        if(uri.contains("detail")){
            String id = req.getParameter("id");
            NhaSanXuat nhaSanXuat = service.getOne(id);
            req.setAttribute("nhaSanXuat",nhaSanXuat);
            req.setAttribute("button", AppConstant.BUTTON_UPDATE);
            req.setAttribute("action",AppConstant.ACTION_UPDATE);
            view = "/views/nha-san-xuat/hien-thi-chi-tiet.jsp";
        }
        else if(uri.contains("add")){
            req.setAttribute("button",AppConstant.BUTTON_ADD);
            req.setAttribute("action",AppConstant.ACTION_ADD);
            view = "/views/nha-san-xuat/hien-thi-chi-tiet.jsp";
        }
        else{
            if(uri.contains("delete")){
                String id = req.getParameter("id");
                NhaSanXuat nhaSanXuat =new NhaSanXuat();
                nhaSanXuat.setId(id);
                service.delete(nhaSanXuat);
            }
            view = "/views/nha-san-xuat/hien-thi.jsp";
            req.setAttribute("list",service.getAll());
        }
        req.setAttribute("view",view);
        req.getRequestDispatcher("/views/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        NhaSanXuat nhaSanXuat = ObjectMapper.getInstance().mapper(NhaSanXuat.class,req);
        String uri = req.getRequestURI();
        if(uri.contains("update")){
            if(id != null){
                nhaSanXuat.setId(id);
                service.update(nhaSanXuat);
            }
        } else{
            String inserted = service.insert(nhaSanXuat);
        }
        resp.sendRedirect(req.getContextPath() + "/nha-san-xuat/hien-thi");
    }
}
