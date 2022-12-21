package com.ute.ecwebapp3.controller;


import com.ute.ecwebapp3.utils.ServletUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;


@WebServlet(name = "MiscServlet", value = "/Misc/*")
@MultipartConfig(
        fileSizeThreshold = 2*1024*1024,
        maxFileSize = 50*2014*1024,
        maxRequestSize =  50*2014*1024
)
public class MiscServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/Editor":
                ServletUtils.forward("/views/vwMisc/Editor.jsp", request,response);
                break;

            case "/Upload":
                ServletUtils.forward("/views/vwMisc/Upload.jsp", request,response);
                break;

            default:
                ServletUtils.forward("/views/404.jsp", request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/Editor":
                postEditor(request, response);
                break;

            case "/Upload":
                postUpload(request,response);
                break;

            default:
                ServletUtils.forward("/views/404.jsp", request,response);
                break;
        }
    }

    private void postUpload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("ProName"));


        for (Part part: request.getParts()) {

            if (part.getName().equals("fuMain")) {
                //   System.out.println(part);
                String contentDisposition = part.getHeader("content-disposition");
                String[] items = contentDisposition.split(";");
                for (String s : items) {
                    String tmp = s.trim();
                    if (tmp.startsWith("filename")) {
                        int idx = tmp.indexOf("=") + 2;
                        String filename = tmp.substring(idx, tmp.length() - 1);


                        String targetDir = this.getServletContext().getRealPath("public/user-upload");
                        File dir = new File(targetDir);
                        if (!dir.exists()){
                            dir.mkdir();
                        }
                        String destination = targetDir + "/" + filename;
                        part.write(destination);
                    }
                }

            }
        }
        ServletUtils.forward("/views/vwMisc/Upload.jsp", request,response);
    }

    private void postEditor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String tinyDesc = request.getParameter("TinyDes");
        System.out.println(tinyDesc);

        String desc = request.getParameter("FullDes");
        System.out.println(desc);
        ServletUtils.forward("/views/vwMisc/Editor.jsp", request,response);
    }
}
