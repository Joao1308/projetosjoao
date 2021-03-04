package br.com.joao.test;
import static br.com.joao.core.DriverFactory.getDriver;
import static br.com.joao.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.joao.core.DSL;


public class webmotors {
		
		private DSL dsl;
			
			@Before
			public void inicializa() {
				getDriver().get("https://www.webmotors.com.br/");
				dsl = new DSL();
			}
			
			
			@After
			public void finaliza() {
				killDriver();
			}

	
	@Test
	public void testandoBuscaPorMarca() {
			
			try {
				
				dsl.clicarBotao(By.xpath("//button[text()='OK']"));
				dsl.escrever("searchBar", "Honda"); 
				Thread.sleep(3000);
				dsl.clicarBotao(By.xpath("//*[@id=\'WhiteBox\']/div[1]/div[2]/div/div/div/div/div/div[1]/a/div[2]"));
			} catch (Exception e) {
			}
			
			}		

	
	@Test
	public void testandoBuscaPorModelo() {
		
		try {
			
			dsl.clicarBotao(By.xpath("//button[text()='OK']"));
			dsl.escrever("searchBar", "Honda"); 
			Thread.sleep(5000);
			dsl.clicarBotao(By.xpath("//*[@id=\"WhiteBox\"]/div[1]/div[2]/div/div/div/div/div/div[2]/a[3]/div[2]"));
			Assert.assertEquals("Honda City em Cajamar/SP - Novos e Usados", dsl.obterValorCampo("//*[@id=\"root\"]/main/div[1]/div[3]/h1")); 
		} catch (Exception e) {
		}
		
		}		






}