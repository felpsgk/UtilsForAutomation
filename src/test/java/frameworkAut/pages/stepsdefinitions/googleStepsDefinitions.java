package frameworkAut.pages.stepsdefinitions;

import frameworkAut.pages.pages.googlePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class googleStepsDefinitions {
    googlePage gp;

    @Given("Estou no google")
    public void abrirGoogle() {
        gp.abrirGoogle();
    }
    @When("digito {string}")
    public void digitoAlgo(String texto) {
        gp.digitaBusca(texto);
    }
    @And("busco")
    public void buscar() {
        gp.buscar();
    }
    @And("espero {int} segundos")
    public void esperarTempo(Integer segundos) {
        gp.esperarTempo(segundos*1000);
    }
}
