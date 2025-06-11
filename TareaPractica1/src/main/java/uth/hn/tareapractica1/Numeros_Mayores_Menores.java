package uth.hn.tareapractica1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Numeros_Mayores_Menores", value = "/Numeros_Mayores_Menores")
public class Numeros_Mayores_Menores extends HttpServlet {
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

        String operacion = request.getParameter("operacion");
        String numero1 = request.getParameter("numero1");
        String numero2 = request.getParameter("numero2");
        String numero3 = request.getParameter("numero3");


        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">");
        out.println("<html>");

        //Encabezado
        out.println("<head>");

        out.println("<title>Numeros mayores y menores</title>");
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



        //Tipo de Operacion
        out.println("<h1>Seleccione un tipo de operacion:</h1>");
        out.println("<form action='Numeros_Mayores_Menores' method='get'>");
        out.println("<label>Seleccione una opción:</label>");
        out.println("<select name='opcion'>");
        out.println("<option value='mayor'>Calcular número mayor</option>");
        out.println("<option value='menor'>Calcular número menor</option>");
        out.println("<option value='repetido'>Número más repetido</option>");
        out.println("</select>");
        out.println("<button type='submit'>Continuar</button>");
        out.println("</form>");


        //Generacion de los input de acuerdo a la opcion escogida
        String opcion = request.getParameter("opcion");

        if (opcion != null) {
            out.println("<h2>Ingrese los números:</h2>");
            out.println("<form action='Numeros_Mayores_Menores' method='get'>");
            out.println("<input type='hidden' name='opcion' value='" + opcion + "'>");

            if ("mayor".equals(opcion) || "menor".equals(opcion)) {

                for (int i = 1; i <= 3; i++) {
                    out.println("<label>Número " + i + ":</label>");
                    out.println("<input type='number' name='num" + i + "' required><br><br>");
                }
            } else if ("repetido".equals(opcion)) {

                out.println("<label>Ingrese números separados por comas:</label>");
                out.println("<input type='text' name='numeros' required><br>");
            }

            out.println("<br><button type='submit'>Calcular</button>");
            out.println("</form>");
        }



        //Llamada a los metodos
        if (opcion != null) {
            if ("mayor".equals(opcion)) {
                String[] numeros = {request.getParameter("num1"), request.getParameter("num2"), request.getParameter("num3")};
                calcularMayor(numeros, out);
            } else if ("menor".equals(opcion)) {
                String[] numeros = {request.getParameter("num1"), request.getParameter("num2"), request.getParameter("num3")};
                calcularMenor(numeros, out);
            } else if ("repetido".equals(opcion)) {
                String numeros = request.getParameter("numeros");
                if (numeros != null) {
                    String[] numerosArray = numeros.split(",");
                    calcularMasRepetido(numerosArray, out);
                }
            }
        }

        out.println("</body></html>");

    }





    //Metodos para los calculos
    private void calcularMayor(String[] numeros, PrintWriter out) {
        int mayor = Integer.MIN_VALUE;
        for (String num : numeros) {
            mayor = Math.max(mayor, Integer.parseInt(num));
        }
        out.println("<h2>El número mayor es: " + mayor + "</h2>");
    }

    private void calcularMenor(String[] numeros, PrintWriter out) {
        int menor = Integer.MAX_VALUE;
        for (String num : numeros) {
            menor = Math.min(menor, Integer.parseInt(num));
        }
        out.println("<h2>El número menor es: " + menor + "</h2>");
    }


    private void calcularMasRepetido(String[] numeros, PrintWriter out) {
        int maxFrecuencia = 0;
        List<Integer> numerosMasRepetidos = new ArrayList<>();

        for (int i = 0; i < numeros.length; i++) {
            int numActual = Integer.parseInt(numeros[i]);
            int frecuencia = 0;


            for (int j = 0; j < numeros.length; j++) {
                if (numActual == Integer.parseInt(numeros[j])) {
                    frecuencia++;
                }
            }


            if (frecuencia > maxFrecuencia) {
                maxFrecuencia = frecuencia;
                numerosMasRepetidos.clear();
                numerosMasRepetidos.add(numActual);
            } else if (frecuencia == maxFrecuencia && !numerosMasRepetidos.contains(numActual)) {

                numerosMasRepetidos.add(numActual);
            }
        }


        out.println("<h2>Los números más repetidos son:</h2>");
        out.println("<ul>");
        for (int num : numerosMasRepetidos) {
            out.println("<li>Número " + num + " (aparece " + maxFrecuencia + " veces)</li>");
        }
        out.println("</ul>");
    }


    /// Para copiar la tabla
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








}