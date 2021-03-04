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

public class testePrine {

	private DSL dsl;

	@Before
	public void inicializa() {
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=c6593");
		dsl = new DSL();
	}

	@After
	public void finaliza() {
		killDriver();
	}

	@Test
	public void deveInteragirComRadioPrime() {
		try {

			dsl.clicarRadio(By.xpath("//label[.='Option1']/..//span"));
			Thread.sleep(3000);
			Assert.assertTrue(dsl.isRadioMarcado("j_idt300:console:0"));
			dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
			Thread.sleep(3000);
			Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:1"));

		} catch (Exception e) {

		}

	}

}
