package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;
import model.repository.ContactRepository;

/**
 * Servlet implementation class ContactNewController
 */
public class ContactNewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger log = Logger.getLogger(ContactUpdateController.class.getName());
	
    public ContactNewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO: Read request parameters
                String name = request.getParameter("name");
                String phone = request.getParameter("phone");
                
                System.out.println("Contacto nuevo: " + name + " - " + phone);
		
		// TODO: Create contact in the repository
                ContactRepository bd = ContactRepository.getInstance();
                bd.addContact(name, phone);

		// TODO: Forward to contact list view
		request.setAttribute("message", "Contact created successfully");
                request.getRequestDispatcher("/").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
