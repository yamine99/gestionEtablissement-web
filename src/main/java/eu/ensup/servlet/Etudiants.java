package eu.ensup.servlet;


import eu.ensup.dao.EtudiantDao;
import eu.ensup.domaine.Etudiant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@WebServlet(name = "Etudiants",urlPatterns ="/etudiants")
public class Etudiants extends HttpServlet {

    private EtudiantDao etudiantDao ;
    private Set<Etudiant> etudiants;

    public Etudiants() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        etudiantDao= new EtudiantDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            etudiants=etudiantDao.getfindAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("etudiants",etudiants);
        System.out.println("liste des etudiants :"+etudiants.toString());
        request.getRequestDispatcher("etudiants.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String firstname = request.getParameter("firstname");
        String birthday = request.getParameter("birthday");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String tele = request.getParameter("tele");
        String password = request.getParameter("password");
        int id = (int) Math.random();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new Date();

        try {
             date = format.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        eu.ensup.domaine.Etudiant etudiant = new eu.ensup.domaine.Etudiant(id,name,  email, address, tele, firstname, password, "salt", new java.sql.Date(date.getTime()));

        etudiantDao.addEtudiant(etudiant);
        doGet(request,response);

    }
}