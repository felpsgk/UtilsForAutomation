package frameworkAut.pages.tests;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions (features = "src/test/resources/features/abrir_pagina_google.feature",
                    glue = {"frameworkAut.pages.stepsdefinitions",
                            "frameworkAut.pages.pages",
                            "frameworkAut.pages.tests"})
public class googleTest {
}
