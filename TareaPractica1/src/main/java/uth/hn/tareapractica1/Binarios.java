package uth.hn.tareapractica1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Binarios", value = "/Binarios")
public class Binarios extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Opciones(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Opciones(request, response);
    }



    private void Opciones(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String conversion = request.getParameter("conversion");
        String numero = request.getParameter("numero");


        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
        out.println("<html>");

        //Encabezado
        out.println("<head>");

            out.println("<title>Conversion de Numeros Binarios y Decimales</title>");
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

            out.println("<h1>Seleccione un tipo de conversion</h1>");

            //Tipo de Conversion
            out.println("<form action='Binarios' method='get'>");
            out.println("<label>Seleccione una opción:</label><br><br>");

            out.println("<input type='radio' id='decimalBinario' name='conversion' value='decimalBinario' required>");
            out.println("<label for='decimalBinario'>Decimal a Binario</label><br>");
            out.println("<input type='radio' id='binarioDecimal' name='conversion' value='binarioDecimal' required>");
            out.println("<label for='binarioDecimal'>Binario a Decimal</label><br><br>");

            out.println("<label for='numero'>Ingrese el número:</label>");
            out.println("<input type='text' id='numero' name='numero' required><br><br>");

            out.println("<button type='submit'>Convertir</button>");
            out.println("</form><br>");


            if (conversion != null && numero != null) {
                if ("decimalBinario".equals(conversion)) {
                    doDecimal_Binario(numero, out);
                } else if ("binarioDecimal".equals(conversion)) {
                    doBinario_Decimal(numero, out);
                }
            }


        out.println("</body></html>");

    }



    private void doDecimal_Binario(String numero, PrintWriter out) {
        try {
            int decimal = Integer.parseInt(numero);
            String binario = Integer.toBinaryString(decimal);
            out.println("<h2>Servlet Tarea 1: Josue Manuel Ramirez & Wilmer Raul Colindres</h2>");
            out.println("<h2>Cuentas: 202010010375 & 201910020063</h2>");
            out.println("<h4>Operacion Realizada: Calculo de numero decimal a binario</h4>");
            out.println("<table border=1>" +
                            "<tr>" +
                                "<th>Entrada</th>" +
                                "<th>Respuesta</th>" +
                            "</tr>" +
                            "<tr>" +
                                "<td>" +decimal+"</td>" +
                                "<td>" +binario+"</td>" +
                            "</tr>" +
                        "</table>");
        } catch (NumberFormatException e) {
            out.println("<p style='color:red;'>Error: Ingrese un número decimal válido.</p>");
        }
    }

    private void doBinario_Decimal(String numero, PrintWriter out) {
        try {
            int decimal = Integer.parseInt(numero, 2);
            out.println("<h2>Servlet Tarea 1: Josue Manuel Ramirez & Wilmer Raul Colindres</h2>");
            out.println("<h2>Cuentas: 202010010375 & 201910020063</h2>");
            out.println("<h4>Operacion Realizada: Calculo de numero binario a decimal</h4>");
            out.println("<table border=1>" +
                    "<tr>" +
                    "<th>Entrada</th>" +
                    "<th>Respuesta</th>" +
                    "</tr>" +
                    "<tr>" +
                    "<td>" +numero+"</td>" +
                    "<td>" +decimal+"</td>" +
                    "</tr>" +
                    "</table>");
        } catch (NumberFormatException e) {
            out.println("<p style='color:red;'>Error: Ingrese un número binario válido.</p>");
        }
    }


}