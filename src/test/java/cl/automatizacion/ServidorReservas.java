
package cl.automatizacion;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ServidorReservas {

    private static final AtomicInteger asientosDisponibles =
            new AtomicInteger(10000);

    public static void main(String[] args) throws IOException {

        HttpServer servidor = HttpServer.create(
                new InetSocketAddress(8080), 0);

        servidor.createContext("/reservas", ServidorReservas::reservar);

        servidor.setExecutor(Executors.newFixedThreadPool(10));

        servidor.start();

        System.out.println("Servidor de reservas iniciado");
        System.out.println("Disponible en http://localhost:8080/reservas");
    }

    private static void reservar(HttpExchange intercambio)
            throws IOException {

        if (!intercambio.getRequestMethod().equals("POST")) {
            responder(intercambio, 405,
                    "{\"mensaje\":\"Metodo no permitido\"}");
            return;
        }

        int restantes = asientosDisponibles.decrementAndGet();

        if (restantes < 0) {
            asientosDisponibles.incrementAndGet();

            responder(intercambio, 409,
                    "{\"mensaje\":\"No hay asientos disponibles\"}");
            return;
        }

        String respuesta = "{\"resultado\":\"confirmada\","
                + "\"asientosDisponibles\":" + restantes + "}";

        responder(intercambio, 200, respuesta);
    }

    private static void responder(
            HttpExchange intercambio,
            int codigo,
            String respuesta) throws IOException {

        byte[] datos = respuesta.getBytes(StandardCharsets.UTF_8);

        intercambio.getResponseHeaders().set(
                "Content-Type", "application/json; charset=UTF-8");

        intercambio.sendResponseHeaders(codigo, datos.length);

        try (var salida = intercambio.getResponseBody()) {
            salida.write(datos);
        }
    }
}
