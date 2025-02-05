Feature: Crear y Consultar un pedido de la tienda de Mascotas

  @crearPedido
  Scenario Outline: Creación de un pedido de la tienda de Mascota
    When creo el pedido con id <id>, petId <petId>, quantity <quantity>, shipDate "<shipDate>", status "<status>", complete "<complete>"
    Then el código de estado es <statusCode>
    And muestro los examples
    Examples:
      | id | petId | quantity | shipDate                     | status | complete | statusCode |
      | 11 | 11    | 11       | 2025-02-04T23:49:34.737Z     | placed | true     | 200        |