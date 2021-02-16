import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testealert {
	
	
	 @Test
	 public void deveinteragirComAlertSimples(){	    	
	    	WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("alert")).click();
			Alert alert = driver.switchTo().alert();
			String texto = alert.getText();
			Assert.assertEquals("Alert Simples", texto);
			alert.accept();
			
			driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
			
			
	}
	 
	 
	 @Test
	 public void deveinteragirComAlertConfirm(){	    	
	    	WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.id("confirm")).click();
			Alert alert = driver.switchTo().alert();
			Assert.assertEquals("Confirm Simples", alert.getText());
			alert.accept();
			Assert.assertEquals("Confirmado", alert.getText());
			alert.accept();
			
			driver.findElement(By.id("confirm")).click();
			alert = driver.switchTo().alert();
			Assert.assertEquals("Confirm Simples", alert.getText());
			alert.dismiss();
			Assert.assertEquals("Negado", alert.getText());
			alert.dismiss();
			
			
			driver.quit();									
	 }
	 
	 @Test
	 public void deveinteragirComAlertPrompt(){	    	
	    	WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	 
			driver.findElement(By.id("prompt")).click();
			Alert alerta = driver.switchTo().alert();
			Assert.assertEquals("Digite um numero", alerta.getText());
			alerta.sendKeys("12");
			alerta.accept();
			Assert.assertEquals("Era 12?", alerta.getText());
			alerta.accept();
			Assert.assertEquals(":D", alerta.getText());
			alerta.accept();
			
			driver.quit();
	 
	 }
	 
	 	
			
			

}
