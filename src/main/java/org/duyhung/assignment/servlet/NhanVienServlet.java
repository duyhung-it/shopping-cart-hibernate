package org.duyhung.assignment.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.duyhung.assignment.constant.AppConstant;
import org.duyhung.assignment.entity.ChucVu;
import org.duyhung.assignment.entity.CuaHang;
import org.duyhung.assignment.entity.NhanVien;
import org.duyhung.assignment.service.IChucVuService;
import org.duyhung.assignment.service.ICuaHangService;
import org.duyhung.assignment.service.INhanVienService;
import org.duyhung.assignment.service.impl.ChucVuService;
import org.duyhung.assignment.service.impl.CuaHangService;
import org.duyhung.assignment.service.impl.NhanVienService;
import org.duyhung.assignment.util.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(name = "NhanVienServlet",value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/add",
        "/nhan-vien/delete",
        "/nhan-vien/update",
        "/nhan-vien/detail"
})
public class NhanVienServlet extends HttpServlet {
    private INhanVienService nhanVienService;
    private IChucVuService chucVuService;
    private ICuaHangService cuaHangService;
    @Override
    public void init() throws ServletException {
        super.init();
        nhanVienService = new NhanVienService();
        chucVuService = new ChucVuService();
        cuaHangService = new CuaHangService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String uri = req.getRequestURI();
        String view = "";
        if(uri.contains("detail")){
            String id = req.getParameter("id");
            NhanVien nhanvien = nhanVienService.getOne(id);
            req.setAttribute("nhanVien",nhanvien);
            String ngaySinh = simpleDateFormat.format(nhanvien.getNgaySinh());
            req.setAttribute("ngaySinh",ngaySinh);
            req.setAttribute("listTruongPhong",nhanVienService.getAll());
            req.setAttribute("listCuaHang",cuaHangService.getAll());
            req.setAttribute("listChucVu",chucVuService.getAll());
            req.setAttribute("button", AppConstant.BUTTON_UPDATE);
            req.setAttribute("action",AppConstant.ACTION_UPDATE);
            view = "/views/nhan-vien/hien-thi-chi-tiet.jsp";
        }
        else if(uri.contains("add")){
            req.setAttribute("listTruongPhong",nhanVienService.getAll());
            req.setAttribute("listCuaHang",cuaHangService.getAll());
            req.setAttribute("listChucVu",chucVuService.getAll());
            req.setAttribute("button",AppConstant.BUTTON_ADD);
            req.setAttribute("action",AppConstant.ACTION_ADD);
            view = "/views/nhan-vien/hien-thi-chi-tiet.jsp";
        }
        else{
            if(uri.contains("delete")){
                String id = req.getParameter("id");
                NhanVien nhanvien =new NhanVien();
                nhanvien.setId(id);
                nhanVienService.delete(nhanvien);
            }
            view = "/views/nhan-vien/hien-thi.jsp";
            req.setAttribute("list",nhanVienService.getAll());
        }
        req.setAttribute("view",view);
        req.getRequestDispatcher("/views/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
//        String ma = req.getParameter("ma");
//        String ten = req.getParameter("ten");
//        String tenDem = req.getParameter("tenDem");
//        String ho = req.getParameter("ho");
//        String gioiTinh = req.getParameter("gioiTinh");
//        String ngaySinh = req.getParameter("ngaySinh");
//        String diaChi = req.getParameter("diaChi");
//        String soDienThoai = req.getParameter("soDienThoai");
//        String matKhau = req.getParameter("matKhau");
//        String idTruongPhong = req.getParameter("truongPhong");
        String idCuaHang = req.getParameter("cuaHang");
        String idChucVu = req.getParameter("chucVu");
//        NhanVien truongPhong = nhanVienService.getOne(idTruongPhong);
        ChucVu chucVu = chucVuService.getOne(idChucVu);
        CuaHang cuaHang = cuaHangService.getOne(idCuaHang);
//        Integer trangThai = Integer.parseInt(req.getParameter("trangThai"));
        String id = req.getParameter("id");
        NhanVien nhanvien = ObjectMapper.getInstance().mapper(NhanVien.class,req);
//        nhanvien.setTruongPhong(truongPhong);
        nhanvien.setChucVu(chucVu);
        nhanvien.setCuaHang(cuaHang);
//        try {
//            nhanvien = NhanVien.builder()
//                    .ma(ma)
//                    .ten(ten)
//                    .diaChi(diaChi)
//                    .ho(ho)
//                    .tenDem(tenDem)
//                    .gioiTinh(gioiTinh)
//                    .ngaySinh(simpleDateFormat.parse(ngaySinh))
//                    .soDienThoai(soDienThoai)
//                    .trangThai(trangThai)
//                    .matKhau(matKhau)
//                    .truongPhong(truongPhong).chucVu(chucVu).cuaHang(cuaHang)
//                    .build();
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
        String uri = req.getRequestURI();
        if(uri.contains("update")){
            if(id != null){
                nhanvien.setId(id);
                nhanVienService.update(nhanvien);
            }
        } else{
            String inserted = nhanVienService.insert(nhanvien);
        }
        resp.sendRedirect(req.getContextPath() + "/nhan-vien/hien-thi");
    }
}
