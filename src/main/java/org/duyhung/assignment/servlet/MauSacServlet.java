package org.duyhung.assignment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.duyhung.assignment.constant.AppConstant;
import org.duyhung.assignment.entity.MauSac;
import org.duyhung.assignment.service.IMauSacService;
import org.duyhung.assignment.service.impl.MauSacService;
import org.duyhung.assignment.util.ObjectMapper;

import java.io.IOException;

@WebServlet(name = "MauSacServlet",value = {
        "/mau-sac/hien-thi",
        "/mau-sac/add",
        "/mau-sac/delete",
        "/mau-sac/update",
        "/mau-sac/detail"
})
public class MauSacServlet extends HttpServlet {
    private IMauSacService service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new MauSacService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String view = "";
        if(uri.contains("detail")){
            String id = req.getParameter("id");
            MauSac mauSac = service.getOne(id);
            req.setAttribute("mauSac",mauSac);
            req.setAttribute("button", AppConstant.BUTTON_UPDATE);
            req.setAttribute("action",AppConstant.ACTION_UPDATE);
            view = "/views/mau-sac/hien-thi-chi-tiet.jsp";
        }
        else if(uri.contains("add")){
            req.setAttribute("button",AppConstant.BUTTON_ADD);
            req.setAttribute("action",AppConstant.ACTION_ADD);
            view = "/views/mau-sac/hien-thi-chi-tiet.jsp";
        }
        else{
            if(uri.contains("delete")){
                String id = req.getParameter("id");
                MauSac mauSac =new MauSac();
                mauSac.setId(id);
                service.delete(mauSac);
            }
            view = "/views/mau-sac/hien-thi.jsp";
            req.setAttribute("list",service.getAll());
        }
        req.setAttribute("view",view);
        req.getRequestDispatcher("/views/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String ma = req.getParameter("ma");
//        String ten = req.getParameter("ten");
        String id = req.getParameter("id");
        ObjectMapper objectMapper = ObjectMapper.getInstance();
        MauSac mauSac = objectMapper.mapper(MauSac.class,req);
        String uri = req.getRequestURI();
        if(uri.contains("update")){
            if(id != null){
                mauSac.setId(id);
                service.update(mauSac);
            }
        } else{
            String inserted = service.insert(mauSac);
        }
        resp.sendRedirect(req.getContextPath() + "/mau-sac/hien-thi");
    }
}
