package com.pichincha.automationtest.glue.demo;

import com.pichincha.automationtest.model.ModelWebLogin;
import com.pichincha.automationtest.tasks.demo.taller.StartAffiliation;
import com.pichincha.automationtest.tasks.demo.taller.ValidateMessage;
import com.pichincha.automationtest.ui.taller.PageAffiliation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TallerSBDDGlue {

    @Given("que el {actor} esta en la pantalla de login")
    public void queElClienteEstaEnLaPantallaDeLogin(Actor actor) {
        givenThat(actor).attemptsTo(
                Open.browserOn().the(PageAffiliation.class)
        );
    }
    @When("ingresa sus credenciales incorrectas cedula {string} y mail {string}")
    public void ingresaSusCredencialesIncorrectasCedulaYMail(String dni, String mail) {
        when(theActorInTheSpotlight()).wasAbleTo(
                StartAffiliation.whitMail(new ModelWebLogin(dni, mail))
        );
    }
    @Then("deberia visualizar el mensaje de error {string}")
    public void deberiaVisualizarElMensajeDeError(String message) {
        then(theActorInTheSpotlight()).attemptsTo(
                ValidateMessage.whitDescription(message)
        );
    }
}
