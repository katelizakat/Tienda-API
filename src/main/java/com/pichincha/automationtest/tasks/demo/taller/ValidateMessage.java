package com.pichincha.automationtest.tasks.demo.taller;

import com.pichincha.automationtest.ui.taller.PageAffiliation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import java.time.Duration;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class ValidateMessage implements Task {

    private final String message;

    public ValidateMessage(String message) {
        this.message = message;
    }

    public static ValidateMessage whitDescription(String message) {
        return Tasks.instrumented(ValidateMessage.class, message);
    }

    @Step("{0} valida el mensaje de error obtenido")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.should(
                seeThat(the(PageAffiliation.LABEL_MENSAJEERROR.of(message).waitingForNoMoreThan(Duration.ofSeconds(10))), isPresent())
        );
    }
}
