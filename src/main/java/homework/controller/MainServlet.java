package homework.controller;

import homework.service.ZipReader;
import homework.model.FileRecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@WebServlet("/MainServlet")
@MultipartConfig
public class MainServlet extends HttpServlet {

    public static final String JSP = "index.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<FileRecord> data = this.getData(req);
        req.setAttribute("dt", data);

        req.getRequestDispatcher(JSP).forward(req, resp);
    }

    private List<FileRecord> getData(HttpServletRequest req) {
        try {
            Part part = req.getPart("zipfile");
            ZipReader zr = new ZipReader(part.getInputStream());
            return zr.getData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return null;
    }
}
