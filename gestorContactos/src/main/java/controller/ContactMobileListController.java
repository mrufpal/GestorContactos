/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contact;
import model.repository.ContactRepository;

/**
 *
 * @author TIC
 */
public class ContactMobileListController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ContactRepository bd = ContactRepository.getInstance();
        /*Map<String, Contact> contacts = bd.getContacts();
        Map<String, Contact> contactsMobile = new HashMap<>();
        
        Contact c = null;
        for(String id : contacts.keySet()) {
            c = contacts.get(id);
            if(c.getTelephone().startsWith("6")) {
                contactsMobile.put(id, c);
            }
        }*/
        
        request.setAttribute("contacts", bd.getMobileContacts());
        request.getRequestDispatcher("/contactListView.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    

}
