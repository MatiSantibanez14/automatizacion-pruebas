package cl.automatizacion;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaViajeSteps {

    private int asientosDisponibles;
    private int asientosSolicitados;
    private String resultado;

    @Dado("que existe un viaje con {int} asientos disponibles")
    public void existeUnViajeConAsientosDisponibles(int disponibles) {
        asientosDisponibles = disponibles;
    }

    @Cuando("el trabajador reserva {int} asiento")
    public void elTrabajadorReservaUnAsiento(int solicitados) {
        asientosSolicitados = solicitados;
        procesarReserva();
    }

    @Cuando("el trabajador intenta reservar {int} asientos")
    public void elTrabajadorIntentaReservarAsientos(int solicitados) {
        asientosSolicitados = solicitados;
        procesarReserva();
    }

    @Entonces("la reserva debe ser confirmada")
    public void laReservaDebeSerConfirmada() {
        assertEquals("confirmada", resultado);
    }

    @Entonces("deben quedar {int} asientos disponibles")
    public void debenQuedarAsientosDisponibles(int esperados) {
        assertEquals(esperados, asientosDisponibles);
    }

    @Entonces("el resultado de la reserva debe ser {string}")
    public void elResultadoDeLaReservaDebeSer(String esperado) {
        assertEquals(esperado, resultado);
    }

    private void procesarReserva() {
        if (asientosSolicitados > 0 && asientosDisponibles >= asientosSolicitados) {
            asientosDisponibles -= asientosSolicitados;
            resultado = "confirmada";
        } else {
            resultado = "rechazada";
        }
    }
}