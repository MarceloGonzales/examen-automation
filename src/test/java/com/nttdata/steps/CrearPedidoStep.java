package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearPedidoStep {
    private static final Logger log = LoggerFactory.getLogger(CrearPedidoStep.class);
    private static String CREAR_PEDIDO= "https://petstore.swagger.io/v2/store/order";

    //@Step("Crear pedido {int} en PetStore")
    public void crearPedido(int id, int petId, int quantity, String shipDate, String status, String complete){
        SerenityRest.given()
                //.baseUri(CREAR_PEDIDO)
                .contentType("application/json")
                //.relaxedHTTPSValidation()
                .header("Content-Type","application/json")
                .body(
                        "{\n" +
                                "  \"id\": \""+id+"\",\n" +
                                "  \"petId\": \""+petId+"\",\n" +
                                "  \"quantity\": \""+quantity+"\",\n" +
                                "  \"shipDate\": \""+shipDate+"\",\n" +
                                "  \"status\": \""+status+"\",\n" +
                                "  \"complete\": \""+complete+"\"\n" +
                                "}"
                )
                .log().all()
                .when()
                .post(CREAR_PEDIDO)
                .then()
                .log().all();
    }

    public void verificarCodigo(int statusCode){
        restAssuredThat(response -> response.statusCode(statusCode));
        //Assert.assertEquals("Validación de Respuesta",statusCode,SerenityRest.lastResponse().getStatusCode());
    }

    public void validoRespuesta(String msg) {
        String respuesta = SerenityRest.lastResponse().getBody().path("message");
        Assert.assertEquals(msg, respuesta);
    }

    public void mostrarBodyCrearPedidoStep() {
        String respuesta = SerenityRest.lastResponse().asString();
        System.out.println("Respuesta de la API: ");
        System.out.println(respuesta);
    }
}
