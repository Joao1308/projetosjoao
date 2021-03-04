package br.com.joao.test;
import static br.com.joao.core.DriverFactory.getDriver;
import static br.com.joao.core.DriverFactory.killDriver;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.joao.core.DSL;
import br.com.joao.core.baseTest;
import br.com.joao.page.CampoTreinamentoPage;

@RunWith(Parameterized.class)
public class TestesRegrasCadastro extends baseTest {
	
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobrenome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> comidas;
	@Parameter(value=4)
	public String[] esportes;
	@Parameter(value=5)
	public String msg;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
		page = new CampoTreinamentoPage();
	}
	
	
	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), new String[]{}, "Nome eh obrigatorio"},
			{"Nome qualquer", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			{"Nome qualquer", "Sobrenome qualquer", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			{"Nome qualquer", "Sobrenome qualquer", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Nome qualquer", "Sobrenome qualquer", "Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"},
		});
	}
	
	 @Test
	 public void deveValidarRegras(){
		 	page.setNome(nome);
			page.setSobrenome(sobrenome);
			if(sexo.equals("Masculino")) {
				page.setSexoMasculino();
			}
			if(sexo.equals("Feminino")) {
				page.setSexoFeminino();
			}
			if(comidas.contains("Carne")) page.setComidaCarne();
			if(comidas.contains("Pizza")) page.setComidaPizza();
			if(comidas.contains("Vegetariano")) page.setComidaVegetariano();
			page.setEsporte(esportes);
			page.cadastrar();
			System.out.println(msg);
			Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());			
	 } 
}
