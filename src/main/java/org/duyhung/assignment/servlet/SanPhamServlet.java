package org.duyhung.assignment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.duyhung.assignment.constant.AppConstant;
import org.duyhung.assignment.entity.SanPham;
import org.duyhung.assignment.service.INhaSanXuatService;
import org.duyhung.assignment.service.ISanPhamService;
import org.duyhung.assignment.service.impl.SanPhamService;
import org.duyhung.assignment.util.ObjectMapper;

import java.io.IOException;

@WebServlet(name = "SanPhamServlet",value = {
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/delete",
        "/san-pham/update",
        "/san-pham/detail"
})
public class SanPhamServlet extends HttpServlet {
    private ISanPhamService service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new SanPhamService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String view = "";
        if(uri.contains("detail")){
            String id = req.getParameter("id");
            SanPham sanPham = service.getOne(id);
            req.setAttribute("sanPham",sanPham);
            req.setAttribute("button", AppConstant.BUTTON_UPDATE);
            req.setAttribute("action",AppConstant.ACTION_UPDATE);
            view = "/views/san-pham/hien-thi-chi-tiet.jsp";
        }
        else if(uri.contains("add")){
            req.setAttribute("button",AppConstant.BUTTON_ADD);
            req.setAttribute("action",AppConstant.ACTION_ADD);
            view = "/views/san-pham/hien-thi-chi-tiet.jsp";
        }
        else{
            if(uri.contains("delete")){
                String id = req.getParameter("id");
                SanPham sanPham =new SanPham();
                sanPham.setId(id);
                service.delete(sanPham);
            }
            view = "/views/san-pham/hien-thi.jsp";
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
        SanPham sanPham = objectMapper.mapper(SanPham.class,req);
        String uri = req.getRequestURI();
        if(uri.contains("update")){
            if(id != null){
                sanPham.setId(id);
                service.update(sanPham);
            }
        } else{
            String inserted = service.insert(sanPham);
        }
        resp.sendRedirect(req.getContextPath() + "/san-pham/hien-thi");
    }
}
