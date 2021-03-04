package br.com.joao.test;
import static br.com.joao.core.DriverFactory.getDriver;
import static br.com.joao.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.joao.core.DSL;

public class testeframe {
	
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
	 public void deveinteragirComFrames(){	    	
			dsl.entrarFrame("frame1");
			dsl.clicarBotao("frameButton");
			String msg = dsl.alertaObterTextoEAceita();
			Assert.assertEquals("Frame OK!", msg);
			
			dsl.sairFrame();
			dsl.escrever("elementosForm:nome", msg);		
		}

	 @Test
	 public void deveInteragirComFramesEscondido() {
		 	WebElement frame = getDriver().findElement(By.id("frame2"));
		 	dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		 	dsl.entrarFrame("frame2");
			dsl.clicarBotao("frameButton");
			String msg = dsl.alertaObterTextoEAceita();
			Assert.assertEquals("Frame OK!", msg);
	 }
	 
	 
	 
	 @Test
	 public void deveinteragirComJanelas(){	    	
			dsl.clicarBotao("buttonPopUpEasy");
			dsl.trocarJanela("Popup");
			dsl.escrever(By.tagName("textarea"), "Deu certo?");
			getDriver().close();
			dsl.trocarJanela("");
			dsl.escrever(By.tagName("textarea"), "e agora?");
	 }
	 
	 		
			@Test
			public void deveInteragirComjanelasSemTitulo() {
			dsl.clicarBotao("buttonPopUpHard");
			System.out.println(getDriver().getWindowHandle());
			System.out.println(getDriver().getWindowHandles());
			dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[1]);
			dsl.escrever(By.tagName("textarea"), "Deu certo?");
			dsl.trocarJanela((String) getDriver().getWindowHandles().toArray()[0]);
			dsl.escrever(By.tagName("textarea"), "E agora?");
			}
	 }