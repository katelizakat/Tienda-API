package com.pichincha.automationtest.tasks.demo.taller;

import com.pichincha.automationtest.model.ModelWebLogin;
import com.pichincha.automationtest.ui.taller.PageAffiliation;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class StartAffiliation implements Task {

    private final ModelWebLogin data;
    private final Target optionRadioButton;

    public StartAffiliation(ModelWebLogin data, Target optionRadioButton) {
        this.data = data;
        this.optionRadioButton = optionRadioButton;
    }

    public static StartAffiliation whitPhoneNumber(ModelWebLogin data) {
        return Tasks.instrumented(StartAffiliation.class, data, PageAffiliation.RADIOBUTTON_PHONE);
    }

    public static StartAffiliation whitMail(ModelWebLogin data) {
        return Tasks.instrumented(StartAffiliation.class, data, PageAffiliation.RADIOBUTTON_CORREO);
    }


    @Step("{0} Ingresa los datos para iniciar el flujo")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(optionRadioButton),
                Enter.keyValues(data.id()).into(PageAffiliation.TEXT_FIELD_CEDULA),
                Enter.keyValues(data.phoneOrMail()).into(PageAffiliation.TEXT_FIELD_DATO),
                WaitUntil.the(PageAffiliation.BUTTON_LOGIN, isEnabled()).forNoMoreThan(Duration.ofSeconds(30)),
                Click.on(PageAffiliation.BUTTON_LOGIN)
        );
    }
}