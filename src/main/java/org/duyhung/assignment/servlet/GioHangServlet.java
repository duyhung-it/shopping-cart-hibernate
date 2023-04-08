package org.duyhung.assignment.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.duyhung.assignment.entity.ChiTietGioHang;
import org.duyhung.assignment.entity.ChiTietSanPham;
import org.duyhung.assignment.entity.IdChiTietGioHang;
import org.duyhung.assignment.service.impl.ChiTietSanPhamService;
import org.duyhung.assignment.util.SessionUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "GioHangServlet", value = {
        "/gio-hang/hien-thi",
        "/gio-hang/add",
        "/gio-hang/delete",
        "/gio-hang/update",
})
public class GioHangServlet extends HttpServlet {
    private ChiTietSanPhamService service;

    @Override
    public void init() throws ServletException {
        super.init();
        service = new ChiTietSanPhamService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ChiTietGioHang> chiTietGioHangs = (List<ChiTietGioHang>) SessionUtil.getInstance().getValue(request,"listSanPham");
        if(chiTietGioHangs == null) chiTietGioHangs = new ArrayList<>();
        String uri = request.getRequestURI();
        if(uri.contains("delete"))
        {
            String id = request.getParameter("id");
            if(id != null){
                ChiTietGioHang chiTietGioHang = kiemTra(chiTietGioHangs,service.getOne(id));
                chiTietGioHangs.remove(chiTietGioHang);
                SessionUtil.getInstance().putValue(request,"listSanPham",chiTietGioHangs);
            }
        }
        request.setAttribute("list",chiTietGioHangs);
        String view = "/views/trang-chu/gio-hang.jsp";
            request.setAttribute("view",view);
        request.getRequestDispatcher("/views/trang-chu/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String soLuong = request.getParameter("soLuong");
        if(!(id.isEmpty() || soLuong.isBlank())){
            ChiTietGioHang chiTietGioHang = new ChiTietGioHang();
            List<ChiTietGioHang> chiTietGioHangs = (List<ChiTietGioHang>) SessionUtil.getInstance().getValue(request,"listSanPham");
            if(chiTietGioHangs == null){
                chiTietGioHangs = new ArrayList<>();
            }
            if(id != null){
                ChiTietSanPham chiTietSanPham = service.getOne(id);
                if(chiTietSanPham != null ){
                    ChiTietGioHang check = kiemTra(chiTietGioHangs,chiTietSanPham);
                    if (check == null){
                        chiTietGioHang.setSoLuong(Integer.parseInt(soLuong));
                        IdChiTietGioHang idChiTietGioHang = new IdChiTietGioHang();
                        idChiTietGioHang.setSanPham(chiTietSanPham);
                        chiTietGioHang.setId(idChiTietGioHang);
                        chiTietGioHang.setDonGia(chiTietSanPham.getGiaBan());
                        chiTietGioHang.setThanhTien(chiTietGioHang.getSoLuong() * chiTietGioHang.getDonGia());
                        chiTietGioHangs.add(chiTietGioHang);
                    }else{
                        int index = chiTietGioHangs.indexOf(check);
                        check.setSoLuong(check.getSoLuong() + Integer.parseInt(soLuong));
                        check.setThanhTien(check.getSoLuong() * check.getDonGia());
                        chiTietGioHangs.set(index,check);
                    }
                    SessionUtil.getInstance().putValue(request,"listSanPham",chiTietGioHangs);
                }
            }
            response.sendRedirect(request.getContextPath() +  "/trang-chu/hien-thi");
        }
    }
    public ChiTietGioHang kiemTra(List<ChiTietGioHang> list,ChiTietSanPham chiTietSanPham){
        for(ChiTietGioHang g : list){
            if(g.getId().getSanPham().getId().equals(chiTietSanPham.getId()))
                return g;
        }
        return null;
    }
}
