package br.com.joao.suites;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.joao.core.DriverFactory;
import br.com.joao.test.TestesRegrasCadastro;
import br.com.joao.test.testecadastro;
import br.com.joao.test.testecampotreinamento;

@RunWith(Suite.class)
@SuiteClasses({
	testecadastro.class,
	TestesRegrasCadastro.class
})		
public class SuiteTeste {
	
	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}
}
