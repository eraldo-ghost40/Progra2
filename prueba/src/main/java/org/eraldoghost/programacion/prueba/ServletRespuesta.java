/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eraldoghost.programacion.prueba;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
@WebServlet(name = "ServletRespuesta", urlPatterns = {"/ServletRespuesta"})
public class ServletRespuesta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String user;
    String numero1;
    String numero2;
    String suma;
    String resta;
    String multiplicacion;
    String division;
    int num1, num2;
    int resultado;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Respuesta</title>");
            out.println("</head>");
            out.println("<body>");

            user = request.getParameter("usuario");
            numero1 = request.getParameter("num1");
            num1 = Integer.parseInt(numero1);
            numero2 = request.getParameter("num2");
            num2 = Integer.parseInt(numero2);
            suma = request.getParameter("sumar");
            resta = request.getParameter("restar");
            division = request.getParameter("dividir");
            multiplicacion = request.getParameter("multiplicar");

            if (suma != null) {
                resultado = num1 + num2;
                out.println(user + " El resultado de la suma es :" + resultado);
            }
            if (resta != null) {
                resultado = num1 - num2;
                out.println(user + " El resultado de la resta es :" + resultado);
            }
            if (multiplicacion != null) {
                resultado = num1 * num2;
                out.println(user + " El resultado de la multiplicacion es :" + resultado);
            }
            if (division != null) {
                double n1, n2, div;
                n1 = Double.parseDouble(numero1);
                n2 = Double.parseDouble(numero2);
                div = n1 / n2;
                out.println(user + " El resultado de la division es :" + div);
            }
            if (num1 >= 0 && num2 >= 0 && num1 != num2) {
                out.println("Los numeros primos encontrados son:");
                if (num2 > num1) {
                    for (int i = num2; i >= num1; i--) {
                        int divisor = 0;
                        for (int j = 1; j <= num2; j++) {
                            if (i % j == 0) {
                                divisor++;
                            }
                        }
                        if (divisor == 2) {
                            out.println(i);
                        }
                    }
                } else {
                    for (int i = num1; i >= num2; i--) {
                        int divisor = 0;
                        for (int j = 1; j <= num1; j++) {
                            if (i % j == 0) {
                                divisor++;
                            }
                        }
                        if (divisor == 2) {
                            out.println(i);
                        }
                    }
                }

            } else {
                if (num1 < 0 && num2 < 0) {
                    out.println("No se encuentran numeros primos");
                } 
            }

            out.println("</body>");
            out.println("</html>");
        }
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
