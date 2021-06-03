package eu.ensup.servlet;

import eu.ensup.dao.CoursDao;
import eu.ensup.dao.EtudiantDao;
import eu.ensup.domaine.Cours;
import eu.ensup.domaine.Etudiant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Course", urlPatterns = "/course")
public class Course extends HttpServlet {
    private CoursDao courseDao;
    private EtudiantDao etudiantDao;

    public Course() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        courseDao=new CoursDao();
        etudiantDao= new EtudiantDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Cours> cours= courseDao.findAll();
    request.setAttribute("cours",cours);
    request.getRequestDispatcher("course.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idcours =request.getParameter("idcours");
        String idetudiant =request.getParameter("idetudiant");
        String associer =request.getParameter("associer");
        if (associer!=null && associer.equals("associer")) {
            Etudiant etudiant= etudiantDao.getEtudiant(Integer.parseInt(idetudiant));
            Cours cours = courseDao.getCours(Integer.parseInt(idcours));
            courseDao.inscription(cours,etudiant);
            doGet(request,response);
        }else {
        String theme = request.getParameter("theme");
        String heures = request.getParameter("heures");
        Cours cours= new Cours(theme,Integer.parseInt(heures));
        courseDao.addCours(cours);
        doGet(request,response);}

    }
}
