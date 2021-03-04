package br.com.joao.test;
import static br.com.joao.core.DriverFactory.getDriver;
import static br.com.joao.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.joao.core.DSL;


public class testeAjax {
	private DSL dsl;
	
	@Before
	public void inicializa() {
		
		getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=35db0");
		dsl = new DSL ();
	}
	
	@After
	public void finaliza() {
		killDriver();
	}

	@Test
	public void testAjax() {
		dsl.escrever("j_idt299:name", "teste");
		dsl.clicarBotao("j_idt299:j_idt303");
		Assert.assertEquals("teste", dsl.obterTexto("j_idt299:display"));
	}










}
