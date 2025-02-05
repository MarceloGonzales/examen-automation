package com.nttdata.glue;

import com.nttdata.steps.ConsultarPedidoStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ConsultarPedidoStepDef {
    @Steps
    ConsultarPedidoStep consultarPedido;

    @When("consulto el pedido con idPedido {}")
    public void consultoPedidoConIdPedido(int idPedido){
        consultarPedido.consultarPedido(idPedido);
    }
    @Then("valido que el codigo de respuesta sea {int}")
    public void validoCodigoRespuesta(int statusCode){
        consultarPedido.validarStatusCode(statusCode);
    }

}
