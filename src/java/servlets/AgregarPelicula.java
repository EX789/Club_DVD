/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dto.PeliculaDto;
import dao.*;

/**
 *
 * @author raide
 */
public class AgregarPelicula extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            PeliculaDto dto = new PeliculaDto();
            dto.setNombre(request.getParameter("txtNombre"));
            dto.setFechaRegistro(null);
            dto.setAño(Integer.parseInt(request.getParameter("cbAno".toString())));
            switch (request.getParameter("cbSeleccionarGenero")) {
                case "Acción":
                    dto.setId_genero(1);
                    break;
                case "Animación":
                    dto.setId_genero(2);
                    break;
                case "Aventuras":
                    dto.setId_genero(3);
                    break;
                case "Ciencia Ficción":
                    dto.setId_genero(4);
                case "Comedia":
                    dto.setId_genero(5);
                    break;
                case "Thriller":
                    dto.setId_genero(6);
                    break;
                case "Romance":
                    dto.setId_genero(7);
                    break;
                case "Documental":
                    dto.setId_genero(8);
                    break;
                case "Drama":
                    dto.setId_genero(9);
                    break;
                case "Infantil":
                    dto.setId_genero(10);
                    break;
                case "Musical":
                    dto.setId_genero(11);
                    break;
                case "Terror":
                    dto.setId_genero(12);
                    break;
                case "Western":
                    dto.setId_genero(13);
                    break;
            }

            String mensaje = null;
            if (new PeliculaDaoImplementado().agregar(dto)) {
                mensaje = "Se agrego correctamente";
            } else {
                mensaje = "No se pudo agregar la pelicula, revise";
            }

            request.setAttribute("msn", mensaje);
            request.getRequestDispatcher("paginas/agregarPelicula.jsp").forward(request, response);
        }
//        } catch (Exception ex) {
//            mensaje = ex.getMessage();
//            request.setAttribute("msn", mensaje);
//            request.getRequestDispatcher("paginas/agregarPelicula.jsp").forward(request, response);
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
