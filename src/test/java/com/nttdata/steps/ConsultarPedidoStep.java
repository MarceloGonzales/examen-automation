package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;

public class ConsultarPedidoStep {
    private String URL_BASE = "https://petstore.swagger.io/v2/";

    public void consultarPedido(int idPedido) {
        System.out.println("Consultar Pedido");

        SerenityRest.given()
                .baseUri(URL_BASE)
                .relaxedHTTPSValidation()
                .log().all()
                .when()
                .get("store/order/" + String.valueOf(idPedido))
                .then()
                .log().all()
        ;
    }

    public void validarStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, SerenityRest.lastResponse().getStatusCode());
    }
    /*
    public void validoRespuesta(String msg) {
        String respuesta = SerenityRest.lastResponse().getBody().path("message");
        Assert.assertEquals(msg, respuesta);
    }
    */

    public void mostrarBodyConsultarPedido(){
        System.out.println("Impresión de los datos que se rescataron con el GET");
        String responseBody = SerenityRest.lastResponse().asString();
        System.out.println("Respuesta completa del servidor: ");
        System.out.println(responseBody);
    }

}
