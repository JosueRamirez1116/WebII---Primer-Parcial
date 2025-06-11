package uth.hn.tareapractica1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Hipotenusa", value = "/Hipotenusa")
public class Hipotenusa extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CalculoHipotenusa(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CalculoHipotenusa(request, response);
    }


    private void CalculoHipotenusa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String CatetoA = request.getParameter("catetoA");
        String CatetoB = request.getParameter("catetoB");



        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
        out.println("<html>");

        //Encabezado
        out.println("<head>");

            out.println("<title>Calculo de la Hipotenusa</title>");
            out.println("<style>" +
                    "body{font-family: Arial, " +
                        "sans-serif;" +
                        "margin:0;" +
                        "padding:0;" +
                        "background-color: #f4f4f4}" +

                        ".menu{background-color: #333;" +
                        "overflow: hidden;text-align:center}" +

                        ".menu a {display: inline-block;" +
                        "padding:15px 20px; " +
                        "color:white;" +
                        "text-decorator:none;" +
                        "transition:background 0.3s}" +

                        ".menu a:hover{background-color: #575757}" +
                    "</style>");

            //Menu Principal
            out.println("<div class= 'menu'>");
            out.println("<a href='Binarios'>Conversion de Numeros Binarios</a>");
            out.println("<a href='Numeros_Mayores_Menores'>Numeros Mayores y Menores</a>");
            out.println("<a href='Hipotenusa'>Calculo de la Hipotenusa</a>");
            out.println("</div>");

        out.println("</head>");



        out.println("<body>");

            out.println("<h1>Ingrese el valor de los catetos</h1>");

            out.println("<form action='Hipotenusa' method='get'>");

                out.println("<label for='catetoA'>Ingrese el valor del cateto A:</label>");
                out.println("<input type='text' id='catetoA' name='catetoA' required><br><br>");
                out.println("<label for='catetoB'>Ingrese el valor del cateto B:</label>");
                out.println("<input type='text' id='catetoB' name='catetoB' required><br><br>");
                out.println("<button type='submit'>Calcular Hipotenusa</button>");

            out.println("</form><br>");

            if(CatetoA != null  && CatetoB != null){
                doHipotenusa(CatetoA, CatetoB, out);
            }


        out.println("</body></html>");

    }



    public void doHipotenusa(String catetoA, String catetoB, PrintWriter out){
        try {
            double ladoA = Double.parseDouble(catetoA);
            double ladoB = Double.parseDouble(catetoB);
            double hipotenusa;
            hipotenusa = Math.sqrt(Math.pow(ladoA, 2) + Math.pow(ladoB, 2));


            out.println("<h2>Servlet Tarea 1: Josue Manuel Ramirez & Wilmer Raul Colindres</h2>");
            out.println("<h2>Cuentas: 202010010375 & 201910020063</h2>");
            out.println("<h4>Operacion Realizada: Calculo de la hipotenusa</h4>");
            out.println("<table border=1>" +
                    "<tr>" +
                    "<th>Entrada</th>" +
                    "<th>Respuesta</th>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +"Lado A: "+catetoA+", Lado B: "+catetoB+"</td>" +
                    "<td>" +hipotenusa+"</td>" +
                    "</tr>" +
                    "</table>");

        }catch (NumberFormatException e){
            out.println("<p style='color:red;'>Error: Ingrese números válidos para los catetos.</p>");
        }
    }




}