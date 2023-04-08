package org.duyhung.assignment.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.duyhung.assignment.entity.ChiTietSanPham;
import org.duyhung.assignment.service.impl.ChiTietSanPhamService;

import java.io.IOException;

@WebServlet(name = "TrangChuServlet",
        value = {
            "/trang-chu/hien-thi",
            "/trang-chu/chi-tiet/hien-thi",
        })
public class TrangChuServlet extends HttpServlet {
    private ChiTietSanPhamService service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new ChiTietSanPhamService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("chi-tiet")){
            String view = "/views/trang-chu/chi-tiet-san-pham.jsp";
            String id = request.getParameter("id");
            if(id != null){
                ChiTietSanPham chiTietSanPham = service.getOne(id);
                request.setAttribute("view",view);
                request.setAttribute("chiTietSanPham",chiTietSanPham);
            }
        }else{
            String view = "/views/trang-chu/hien-thi.jsp";
            request.setAttribute("view",view);
            request.setAttribute("list",service.getAll());
        }
        request.getRequestDispatcher("/views/trang-chu/index.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
