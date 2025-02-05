package com.nttdata.glue;

import com.nttdata.steps.CrearPedidoStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CrearPedidoStepDef {
    @Steps
    CrearPedidoStep crearPedido;

    @When("creo el pedido con id {}, petId {}, quantity {}, shipDate {string}, status {string}, complete {string}")
    public void creoElPedidoConIdIdPetIdPetIdQuantityQuantityShipDateStatusCompleteComplete(int id, int petId, int quantity, String shipDate, String status, String complete) {
        crearPedido.crearPedido(id,petId,quantity,shipDate,status,complete);
    }

    @Then("el código de estado es {int}")
    public void verificarCodigoDeRespuesta(int statusCode){
        crearPedido.verificarCodigo(statusCode);
    }

    @And("muestro los examples")
    public void mostrarBody(){
        crearPedido.mostrarBodyCrearPedidoStep();
    }



}
