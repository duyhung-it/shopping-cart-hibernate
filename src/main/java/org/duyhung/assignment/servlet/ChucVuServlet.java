package org.duyhung.assignment.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.duyhung.assignment.constant.AppConstant;
import org.duyhung.assignment.entity.ChucVu;
import org.duyhung.assignment.service.IChucVuService;
import org.duyhung.assignment.service.impl.ChucVuService;
import org.duyhung.assignment.util.ObjectMapper;

import java.io.IOException;

@WebServlet(name = "ChucVuServlet",value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/add",
        "/chuc-vu/delete",
        "/chuc-vu/update",
        "/chuc-vu/detail"
})
public class ChucVuServlet extends HttpServlet {
    private IChucVuService service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new ChucVuService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String view = "";
        if(uri.contains("detail")){
            String id = req.getParameter("id");
            ChucVu chucVu = service.getOne(id);
            req.setAttribute("chucVu",chucVu);
            req.setAttribute("button", AppConstant.BUTTON_UPDATE);
            req.setAttribute("action",AppConstant.ACTION_UPDATE);
            view = "/views/chuc-vu/hien-thi-chi-tiet.jsp";
        }
        else if(uri.contains("add")){
            req.setAttribute("button",AppConstant.BUTTON_ADD);
            req.setAttribute("action",AppConstant.ACTION_ADD);
            view = "/views/chuc-vu/hien-thi-chi-tiet.jsp";
        }
        else{
            if(uri.contains("delete")){
                String id = req.getParameter("id");
                ChucVu chucVu =new ChucVu();
                chucVu.setId(id);
                service.delete(chucVu);
            }
            view = "/views/chuc-vu/hien-thi.jsp";
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
        ChucVu chucVu = objectMapper.mapper(ChucVu.class,req);
        String uri = req.getRequestURI();
        if(uri.contains("update")){
            if(id != null){
                chucVu.setId(id);
                service.update(chucVu);
            }
        } else{
            String inserted = service.insert(chucVu);
        }
        resp.sendRedirect(req.getContextPath() + "/chuc-vu/hien-thi");
    }
}
