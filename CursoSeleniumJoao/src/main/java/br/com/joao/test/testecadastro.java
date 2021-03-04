package br.com.joao.test;
import static br.com.joao.core.DriverFactory.getDriver;
import static br.com.joao.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.joao.core.baseTest;
import br.com.joao.page.CampoTreinamentoPage;

public class testecadastro extends baseTest{
		
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CampoTreinamentoPage();
	}
	

	 @Test
	 public void deveREalizarCadastroComSucesso(){	    	
			page.setNome("João");
			page.setSobrenome("Victor");
			page.setSexoMasculino();
			page.setComidaPizza();
			page.setEscolaridade("Mestrado");
			page.setEsporte("Natacao");
			page.cadastrar();
			
			Assert.assertEquals("Cadastrado!", page.obterResuladoCadastro());
			Assert.assertEquals("João", page.obterNomeCadastro());
			Assert.assertEquals("Victor", page.obterSobrenomeCadastro());
			Assert.assertEquals("Masculino", page.obterSexoCadastro());
			Assert.assertEquals("Pizza", page.obterComidaCadastro());
			Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
			Assert.assertEquals("Natacao", page.obterEsportesCadastro());			
	 }
	 
}	 
	