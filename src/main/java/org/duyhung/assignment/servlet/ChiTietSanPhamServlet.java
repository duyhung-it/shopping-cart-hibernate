package org.duyhung.assignment.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.duyhung.assignment.constant.AppConstant;
import org.duyhung.assignment.entity.ChiTietSanPham;
import org.duyhung.assignment.service.*;
import org.duyhung.assignment.service.impl.*;
import org.duyhung.assignment.util.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet(name = "ChiTietSanPhamServlet",value = {
        "/chi-tiet-san-pham/hien-thi",
        "/chi-tiet-san-pham/add",
        "/chi-tiet-san-pham/delete",
        "/chi-tiet-san-pham/update",
        "/chi-tiet-san-pham/detail"
})
@MultipartConfig
public class ChiTietSanPhamServlet extends HttpServlet {
    private IChiTietSanPhamService chiTietSanPhamService;
    private ISanPhamService sanPhamService;
    private INhaSanXuatService nhaSanXuatService;
    private IMauSacService mauSacService;
    private IDongSanPhamService dongSanPhamService;
    @Override
    public void init() throws ServletException {
        super.init();
        chiTietSanPhamService = new ChiTietSanPhamService();
        sanPhamService = new SanPhamService();
        nhaSanXuatService = new NhaSanXuatService();
        mauSacService = new MauSacService();
        dongSanPhamService = new DongSanPhamService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String view = "";
        if(uri.contains("detail")){
            String id = req.getParameter("id");
            ChiTietSanPham chiTietSanPham = chiTietSanPhamService.getOne(id);
            req.setAttribute("chiTietSanPham",chiTietSanPham);
            req.setAttribute("listMauSac",mauSacService.getAll());
            req.setAttribute("listDongSanPham",dongSanPhamService.getAll());
            req.setAttribute("listSanPham",sanPhamService.getAll());
            req.setAttribute("listNhaSanXuat",nhaSanXuatService.getAll());
            req.setAttribute("button", AppConstant.BUTTON_UPDATE);
            req.setAttribute("action",AppConstant.ACTION_UPDATE);
            view = "/views/chi-tiet-san-pham/hien-thi-chi-tiet.jsp";
        }
        else if(uri.contains("add")){
            req.setAttribute("listMauSac",mauSacService.getAll());
            req.setAttribute("listDongSanPham",dongSanPhamService.getAll());
            req.setAttribute("listSanPham",sanPhamService.getAll());
            req.setAttribute("listNhaSanXuat",nhaSanXuatService.getAll());
            req.setAttribute("button",AppConstant.BUTTON_ADD);
            req.setAttribute("action",AppConstant.ACTION_ADD);
            view = "/views/chi-tiet-san-pham/hien-thi-chi-tiet.jsp";
        }
        else{
            if(uri.contains("delete")){
                String id = req.getParameter("id");
                ChiTietSanPham chiTietSanPham =new ChiTietSanPham();
                chiTietSanPham.setId(id);
                chiTietSanPhamService.delete(chiTietSanPham);
            }
            view = "/views/chi-tiet-san-pham/hien-thi.jsp";
            req.setAttribute("list",chiTietSanPhamService.getAll());
        }
        req.setAttribute("view",view);
        req.getRequestDispatcher("/views/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String ma = req.getParameter("ma");
//        String ten = req.getParameter("ten");
        String id = req.getParameter("id");
        String idSanPham = req.getParameter("sanPham");
        String idMauSac = req.getParameter("mauSac");
        String idDongSanPham = req.getParameter("dongSanPham");
        String idNhaSanXuat = req.getParameter("nhaSanXuat");
        String images = getFileName(req.getPart("image"),req.getServletContext());
        ObjectMapper objectMapper = ObjectMapper.getInstance();
        ChiTietSanPham chiTietSanPham = objectMapper.mapper(ChiTietSanPham.class,req);
        chiTietSanPham.setSanPham(sanPhamService.getOne(idSanPham));
        chiTietSanPham.setMauSac(mauSacService.getOne(idMauSac));
        chiTietSanPham.setDongSanPham(dongSanPhamService.getOne(idDongSanPham));
        chiTietSanPham.setNhaSanXuat(nhaSanXuatService.getOne(idNhaSanXuat));
        chiTietSanPham.setImages(images);
        String uri = req.getRequestURI();
        if(uri.contains("update")){
            if(id != null){
                chiTietSanPham.setId(id);
                chiTietSanPhamService.update(chiTietSanPham);
            }
        } else{
            String inserted = chiTietSanPhamService.insert(chiTietSanPham);
        }
        resp.sendRedirect(req.getContextPath() + "/chi-tiet-san-pham/hien-thi");
    }
    private String getFileName(Part part, ServletContext context) throws IOException {
        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        File uploads = new File(context.getInitParameter("uploads.dir"));
        File file = new File(uploads,fileName);
        if(!file.exists()){
            file.mkdir();
            part.write(file.getAbsolutePath());
        }
        return fileName;
    }
}
