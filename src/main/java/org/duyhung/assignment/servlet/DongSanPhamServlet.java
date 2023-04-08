package org.duyhung.assignment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.duyhung.assignment.constant.AppConstant;
import org.duyhung.assignment.entity.DongSanPham;
import org.duyhung.assignment.service.IDongSanPhamService;
import org.duyhung.assignment.service.impl.DongSanPhamService;
import org.duyhung.assignment.util.ObjectMapper;

import java.io.IOException;

@WebServlet(name = "DongSanPhamServlet",value = {
        "/dong-san-pham/hien-thi",
        "/dong-san-pham/add",
        "/dong-san-pham/delete",
        "/dong-san-pham/update",
        "/dong-san-pham/detail"
})
public class DongSanPhamServlet extends HttpServlet {
    private IDongSanPhamService service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new DongSanPhamService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String view = "";
        if(uri.contains("detail")){
            String id = req.getParameter("id");
            DongSanPham dongSanPham = service.getOne(id);
            req.setAttribute("dongSanPham",dongSanPham);
            req.setAttribute("button", AppConstant.BUTTON_UPDATE);
            req.setAttribute("action",AppConstant.ACTION_UPDATE);
            view = "/views/dong-san-pham/hien-thi-chi-tiet.jsp";
        }
        else if(uri.contains("add")){
            req.setAttribute("button",AppConstant.BUTTON_ADD);
            req.setAttribute("action",AppConstant.ACTION_ADD);
            view = "/views/dong-san-pham/hien-thi-chi-tiet.jsp";
        }
        else{
            if(uri.contains("delete")){
                String id = req.getParameter("id");
                DongSanPham dongSanPham =new DongSanPham();
                dongSanPham.setId(id);
                service.delete(dongSanPham);
            }
            view = "/views/dong-san-pham/hien-thi.jsp";
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
        DongSanPham dongSanPham = objectMapper.mapper(DongSanPham.class,req);
        String uri = req.getRequestURI();
        if(uri.contains("update")){
            if(id != null){
                dongSanPham.setId(id);
                service.update(dongSanPham);
            }
        } else{
            String inserted = service.insert(dongSanPham);
        }
        resp.sendRedirect(req.getContextPath() + "/dong-san-pham/hien-thi");
    }
}
