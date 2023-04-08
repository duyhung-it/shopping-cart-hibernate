package org.duyhung.assignment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.duyhung.assignment.constant.AppConstant;
import org.duyhung.assignment.entity.CuaHang;
import org.duyhung.assignment.service.ICuaHangService;
import org.duyhung.assignment.service.impl.CuaHangService;

import java.io.IOException;

@WebServlet(name = "CuaHangServlet",value = {
        "/cua-hang/hien-thi",
        "/cua-hang/add",
        "/cua-hang/delete",
        "/cua-hang/update",
        "/cua-hang/detail"
})
public class CuaHangServlet extends HttpServlet {
    private ICuaHangService service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new CuaHangService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String view = "";
        if(uri.contains("detail")){
            String id = req.getParameter("id");
            CuaHang cuaHang = service.getOne(id);
            req.setAttribute("cuaHang",cuaHang);
            req.setAttribute("button", AppConstant.BUTTON_UPDATE);
            req.setAttribute("action",AppConstant.ACTION_UPDATE);
            view = "/views/cua-hang/hien-thi-chi-tiet.jsp";
        }
        else if(uri.contains("add")){
            req.setAttribute("button",AppConstant.BUTTON_ADD);
            req.setAttribute("action",AppConstant.ACTION_ADD);
            view = "/views/cua-hang/hien-thi-chi-tiet.jsp";
        }
        else{
            if(uri.contains("delete")){
                String id = req.getParameter("id");
                CuaHang cuaHang =new CuaHang();
                cuaHang.setId(id);
                service.delete(cuaHang);
            }
            view = "/views/cua-hang/hien-thi.jsp";
            req.setAttribute("list",service.getAll());
        }
        req.setAttribute("view",view);
        req.getRequestDispatcher("/views/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        String ten = req.getParameter("ten");
        String diaChi = req.getParameter("diaChi");
        String thanhPho = req.getParameter("thanhPho");
        String quocGia = req.getParameter("quocGia");
        String id = req.getParameter("id");
        CuaHang cuaHang = CuaHang.builder()
                .ma(ma)
                .ten(ten)
                .diaChi(diaChi)
                .thanhPho(thanhPho)
                .quocGia(quocGia).build();
        String uri = req.getRequestURI();
        if(uri.contains("update")){
            if(id != null){
                cuaHang.setId(id);
                service.update(cuaHang);
            }
        } else{
            String inserted = service.insert(cuaHang);
        }
        resp.sendRedirect(req.getContextPath() + "/cua-hang/hien-thi");
    }
}
