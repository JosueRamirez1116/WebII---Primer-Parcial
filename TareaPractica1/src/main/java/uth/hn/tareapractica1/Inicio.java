package uth.hn.tareapractica1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Inicio", value = "/")
public class Inicio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
        out.println("<html>");
        out.println("<head><title>Menu de Inicio</title>");
        out.println("<style>body{font-family: Arial, sans-serif;margin:0;padding:0;background-color: #f4f4f4} .menu{background-color: #333;overflow: hidden;text-align:center} .menu a {display: inline-block;padding:15px 20px; color:white;text-decorator:none;transition:background 0.3s} .menu a:hoover{background-color: #575757}</style>");


        out.println("</head>");
        out.println("<body>");
        out.println("<div class= 'menu'>");
        out.println("<a href='Binarios'>Conversion de Numeros Binarios</a>");
        out.println("<a href='Numeros_Mayores_Menores'>Numeros Mayores y Menores</a>");
        out.println("<a href='Hipotenusa'>Calculo de la Hipotenusa</a>");
        out.println("</div>");


        out.println("</body></html>");
    }


}