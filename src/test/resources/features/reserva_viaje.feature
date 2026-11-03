
# language: es

Característica: Reservar un viaje
  Como trabajador de la empresa
  Quiero reservar un asiento en un viaje disponible
  Para asegurar mi transporte de regreso a casa

  Escenario: Reservar exitosamente un asiento
    Dado que existe un viaje con 3 asientos disponibles
    Cuando el trabajador reserva 1 asiento
    Entonces la reserva debe ser confirmada
    Y deben quedar 2 asientos disponibles

  Esquema del escenario: Validar disponibilidad de asientos
    Dado que existe un viaje con <disponibles> asientos disponibles
    Cuando el trabajador intenta reservar <solicitados> asientos
    Entonces el resultado de la reserva debe ser "<resultado>"

    Ejemplos:
      | disponibles | solicitados | resultado  |
      | 3           | 1           | confirmada |
      | 1           | 2           | rechazada  |
      | 0           | 1           | rechazada  |
