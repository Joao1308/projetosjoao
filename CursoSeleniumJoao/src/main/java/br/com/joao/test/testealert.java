package br.com.joao.test;
import static br.com.joao.core.DriverFactory.getDriver;
import static br.com.joao.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.joao.core.DSL;

public class testealert {
	
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	
	}
	
	@After
	public void finaliza() {
		killDriver();
	}
	
	
	 @Test
	 public void deveinteragirComAlertSimples(){
		 	dsl.clicarBotao("alert");
			String texto = dsl.alertaObterTextoEAceita();
			Assert.assertEquals("Alert Simples", texto);
			
			dsl.escrever("elementosForm:nome", texto);
		}
	 
	
	 @Test
	 public void deveinteragirComAlertConfirm(){	    	
			dsl.clicarBotao("confirm");
			Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
			Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
			
			dsl.clicarBotao("confirm");
			Assert.assertEquals("Confirm Simples", dsl.alertObterTextoENegar());
			Assert.assertEquals("Negado", dsl.alertObterTextoENegar());
	 }
	 
	 @Test
	 public void deveinteragirComAlertPrompt(){	    	
			dsl.clicarBotao("prompt");
			Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
			dsl.alertaEscrever("12");
			Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
			Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
	 }
}