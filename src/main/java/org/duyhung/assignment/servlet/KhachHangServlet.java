package org.duyhung.assignment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.duyhung.assignment.constant.AppConstant;
import org.duyhung.assignment.entity.ChucVu;
import org.duyhung.assignment.entity.CuaHang;
import org.duyhung.assignment.entity.KhachHang;
import org.duyhung.assignment.service.IChucVuService;
import org.duyhung.assignment.service.ICuaHangService;
import org.duyhung.assignment.service.IKhachHangService;
import org.duyhung.assignment.service.IKhachHangService;
import org.duyhung.assignment.service.impl.ChucVuService;
import org.duyhung.assignment.service.impl.CuaHangService;
import org.duyhung.assignment.service.impl.KhachHangService;
import org.duyhung.assignment.service.impl.KhachHangService;
import org.duyhung.assignment.util.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "KhachHangServlet",value = {
        "/khach-hang/hien-thi",
        "/khach-hang/add",
        "/khach-hang/delete",
        "/khach-hang/update",
        "/khach-hang/detail"
})
public class KhachHangServlet extends HttpServlet {
    private IKhachHangService khachHangService;
    @Override
    public void init() throws ServletException {
        super.init();
        khachHangService = new KhachHangService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String uri = req.getRequestURI();
        String view = "";
        if(uri.contains("detail")){
            String id = req.getParameter("id");
            KhachHang khachHang = khachHangService.getOne(id);
            req.setAttribute("khachHang",khachHang);
            req.setAttribute("ngaySinh",simpleDateFormat.format(khachHang.getNgaySinh()));
            req.setAttribute("button", AppConstant.BUTTON_UPDATE);
            req.setAttribute("action",AppConstant.ACTION_UPDATE);
            view = "/views/khach-hang/hien-thi-chi-tiet.jsp";
        }
        else if(uri.contains("add")){
            req.setAttribute("button",AppConstant.BUTTON_ADD);
            req.setAttribute("action",AppConstant.ACTION_ADD);
            view = "/views/khach-hang/hien-thi-chi-tiet.jsp";
        }
        else{
            if(uri.contains("delete")){
                String id = req.getParameter("id");
                KhachHang khachHang =new KhachHang();
                khachHang.setId(id);
                khachHangService.delete(khachHang);
            }
            view = "/views/khach-hang/hien-thi.jsp";
            req.setAttribute("list",khachHangService.getAll());
        }
        req.setAttribute("view",view);
        req.getRequestDispatcher("/views/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
//        String ma = req.getParameter("ma");
//        String ten = req.getParameter("ten");
//        String tenDem = req.getParameter("tenDem");
//        String ho = req.getParameter("ho");
//        String ngaySinh = req.getParameter("ngaySinh");
//        String diaChi = req.getParameter("diaChi");
//        String soDienThoai = req.getParameter("soDienThoai");
//        String thanhPho = req.getParameter("thanhPho");
//        String quocGia = req.getParameter("quocGia");
//        String matKhau = req.getParameter("matKhau");
//        String id = req.getParameter("id");
//        KhachHang khachHang = null;
//        try {
//            khachHang = KhachHang.builder()
//                    .ma(ma)
//                    .ten(ten)
//                    .diaChi(diaChi)
//                    .ho(ho)
//                    .tenDem(tenDem)
//                    .ngaySinh(simpleDateFormat.parse(ngaySinh))
//                    .soDienThoai(soDienThoai)
//                    .matKhau(matKhau)
//                    .quocGia(quocGia)
//                    .thanhPho(thanhPho)
//                    .build();
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        String uri = req.getRequestURI();
//        if(uri.contains("update")){
//            if(id != null){
//                khachHang.setId(id);
//                khachHangService.update(khachHang);
//            }
//        } else{
//            String inserted = khachHangService.insert(khachHang);
//        }
//        resp.sendRedirect(req.getContextPath() + "/khach-hang/hien-thi");
        ObjectMapper objectMapper = ObjectMapper.getInstance();
        KhachHang khachHang = objectMapper.mapper(KhachHang.class,req);
        System.out.println(khachHang);
        String id = req.getParameter("id");
        String uri = req.getRequestURI();
        if(uri.contains("update")){
            if(id != null){
                khachHang.setId(id);
                khachHangService.update(khachHang);
            }
        } else{
            String inserted = khachHangService.insert(khachHang);
        }
        resp.sendRedirect(req.getContextPath() + "/khach-hang/hien-thi");
    }
}
