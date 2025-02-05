Feature: Crear y Consultar un pedido de la tienda de Mascotas

  @crearPedido
  Scenario Outline: Creación de un pedido de la tienda de Mascotas
    When creo el pedido con id <id>, petId <petId>, quantity <quantity>, shipDate "<shipDate>", status "<status>", complete "<complete>"
    Then el código de estado es 200
    And muestro los examples de CrearPedido
    Examples:
      | id | petId | quantity | shipDate                     | status | complete |
      | 1  | 1     | 1        | 2025-02-04T23:49:34.737Z     | placed | true     |
      | 2  | 2     | 2        | 2025-02-04T23:49:34.737Z     | placed | true     |
      | 3  | 3     | 3        | 2025-02-04T23:49:34.737Z     | placed | true     |

  @consultarPedido
  Scenario Outline: Consulta de un pedido de la tienda de Mascotas
    When consulto el pedido con idPedido <idPedido>
    Then valido que el codigo de respuesta sea 200
    And muestro los examples de la Base de Datos
    Examples:
      | idPedido |
      | 1        |
      | 2        |
      | 3        |
