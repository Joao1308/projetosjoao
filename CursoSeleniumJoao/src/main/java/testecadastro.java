import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class testecadastro {

	 @Test
	 public void deveREalizarCadastroComSucesso(){	    	
	    	WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Joao");
			driver.findElement(By.id("elementosForm:Sobrenome")).sendKeys("Victor");
			driver.findElement(By.id("elementosForm:sexo:0")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
			new Select(driver.findElement(By.id("elementosForm:escolaridade")))
				.selectByVisibleText("Mestrado");
			new Select(driver.findElement(By.id("elementosForm:esportes")))
				.selectByVisibleText("Natacao");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			
			Assert.assertTrue(driver.findElement(By.id("resultado")).getText().startsWith("Cadastrado"));
			Assert.assertTrue(driver.findElement(By.id("descNome")).getText().endsWith("Joao"));
			Assert.assertEquals("Sobrenome: Victor", driver.findElement(By.id("descSobrenome")).getText());
			Assert.assertEquals("Sexo: Masculino", driver.findElement(By.id("descSexo")).getText());
			Assert.assertEquals("Comida: Pizza", driver.findElement(By.id("descComida")).getText());
			Assert.assertEquals("Escolaridade: mestrado", driver.findElement(By.id("descEscolaridade")).getText());
			Assert.assertEquals("Esportes: Natacao", driver.findElement(By.id("descEsportes")).getText());
			
			driver.quit();
			
	 }
	 
	 
	 
	 @Test
	 public void deveValidarNomeObrigatorio(){	    	
	    	WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	 
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("Nome eh obrigatorio", alert.getText());
			driver.quit();			
	 }
	 
	 @Test
	 public void deveValidarSobreNomeObrigatorio(){	    	
	    	WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	 
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
			driver.quit();			
	  }
	
	 @Test
	 public void deveValidarSexoObrigatorio(){	    	
	    	WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	 
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
			driver.quit();			
	 
	 }
	
	 

	 @Test
	 public void deveValidarComidaVegetariana(){	    	
	    	WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	 
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
			driver.findElement(By.id("elementosForm:sexo:1")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
			driver.quit();			
	  }
	 

	 @Test
	 public void deveValidarEsportistaindeciso(){	    	
	    	WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	 
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Nome qualquer");
			driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Sobrenome qualquer");
			driver.findElement(By.id("elementosForm:sexo:1")).click();
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
			combo.selectByVisibleText("Karate");
			combo.selectByVisibleText("O que eh esporte?");
			driver.findElement(By.id("elementosForm:cadastrar")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
			driver.quit();			

	 } 
	 
}
