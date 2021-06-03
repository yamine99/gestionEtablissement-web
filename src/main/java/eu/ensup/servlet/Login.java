package eu.ensup.servlet;

import eu.ensup.domaine.Responsable;
import eu.ensup.service.ResponsableService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Servlet implementation class Login
 */
@WebServlet(name="Login" , urlPatterns ="/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("home.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("Test");
		String login = req.getParameter("login");
        String pwd = req.getParameter("password");

        //Traitement des infos
        RequestDispatcher dispatcher;
        HttpSession session = req.getSession();
        ResponsableService responsableService = new ResponsableService();
        
        Responsable user;
        int isLogged = 0;
		try {
			user = responsableService.getCredentialByEmail(login);
			isLogged = responsableService.validAuthentification(user, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        if(isLogged == 1) {
        	dispatcher= req.getRequestDispatcher("home.jsp");
        }
        else {
        	session.setAttribute("error", "Identifiant ou mot de passe incorrect");
            dispatcher= req.getRequestDispatcher("index.jsp");
        }
        
        //Redirection
        dispatcher.forward(req, resp);
	}

}
