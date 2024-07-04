package com.pichincha.automationtest.ui.taller;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("page:webdriver.base.url.tarjetas")
public class PageAffiliation extends PageObject {

    //Sección Login
    public static final Target TEXT_FIELD_CEDULA = Target.the("Textfield dni").located(By.id("inputId"));
    public static final Target TEXT_FIELD_DATO = Target.the("Textfield telefono/mail").located(By.id("contactInfoId"));
    public static final Target BUTTON_LOGIN = Target.the("Botón Login").located(By.id("buttonLoginId"));
    public static final Target RADIOBUTTON_CORREO = Target.the("RadioButton correo").located(By.id("EmailLoginId"));
    public static final Target RADIOBUTTON_PHONE = Target.the("RadioButton telefono").locatedBy("#PhoneLoginId");

    //Sección Validaciones
    public static final Target LABEL_MENSAJEERROR = Target.the("Mensaje de error").locatedBy("//div[@data-testid='MessageBarId'][contains(.,'warning{0}close')]");

}