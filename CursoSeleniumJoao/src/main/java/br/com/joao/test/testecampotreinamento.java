package br.com.joao.test;
import static br.com.joao.core.DriverFactory.getDriver;
import static br.com.joao.core.DriverFactory.killDriver;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.joao.core.DSL;

public class testecampotreinamento {
	
	private DSL dsl;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL ();
	}
	
	@After
	public void finaliza() {
		killDriver();
	}
	
	
	@Test
	public void teste() {
		dsl.escrever("elementosForm:nome", "teste de escrita");
		Assert.assertEquals("teste de escrita", dsl.obterValorCampo("elementosForm:nome"));	
	}
	
	@Test
	public void testeTextField() {
		dsl.escrever("elementosForm:nome", "João");
		Assert.assertEquals("João", dsl.obterValorCampo("elementosForm:nome"));
		dsl.escrever("elementosForm:nome", "Victor");
		Assert.assertEquals("Victor", dsl.obterValorCampo("elementosForm:nome"));
		}
	
	@Test
    public void deveInteragirComTextArea(){
		dsl.escrever("elementosForm:sugestoes", "teste");
		Assert.assertEquals("teste", dsl.obterValorCampo("elementosForm:sugestoes"));
    }


    @Test
    public void deveInteragirComRadioButton(){
		dsl.clicarRadio("elementosForm:sexo:0");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
    }
                                              
  
    @Test
    public void deveInteragirComCheckbox(){
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
		Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));
    } 
        
    @Test
    public void deveInteragirComCombo(){
    	dsl.selecionarCombo("elementosForm:escolaridade", "Mestrado");
 		Assert.assertEquals("Mestrado", dsl.obterValorCampo("elementosForm:escolaridade")); 
    }
    
    
    @Test
    public void deveVerificarValoresCombo(){
  		Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
  		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));			
	}


    @Test
    public void deveVerificarValoresComboMultiplo(){	   
    	dsl.selecionarCombo("elementosForm:esportes", "Natacao");
    	dsl.selecionarCombo("elementosForm:esportes", "Corrida");
    	dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
    	
    	List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
    	Assert.assertEquals(3, opcoesMarcadas.size());
 		
    	dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
    	opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
    	Assert.assertEquals(3, opcoesMarcadas.size());
    	opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?"));
	}
    

    @Test
    public void deveinteragirComBotoes(){
    	dsl.clicarBotao("buttonSimple");
		Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));
    }
    
    @Test
    public void deveinteragirComclicks(){
   		dsl.clicarLink("Voltar");
		Assert.assertEquals("Voltou!", dsl.obterTexto("resultado"));
    }
    
    
    @Test
    public void devebuscarTextosnaPagina(){
//    	Assert.assertTrue(driver.findElement(By.tagName("baby"))
//   			.getText().contains("campo de treinamento"));
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...",
				dsl.obterTexto(By.className("facilAchar")));
	}
    
    @Test
    public void testJavaScript() {
    	JavascriptExecutor js = (JavascriptExecutor) getDriver();
    	js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrita via js'");
    	js.executeScript("document.getElementById('elementosForm:sobrenome').type = 'radio'");
    	
    	WebElement element = getDriver().findElement(By.id("elementosForm:nome"));
    	js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
    }
    
    @Test
    public void deveClicarBotaoTabela() {
    	dsl.clicarBotaoTabela("Nome", "Maria", "Botao", "elementosForm:tableUsuarios");
    }
    
}
    






