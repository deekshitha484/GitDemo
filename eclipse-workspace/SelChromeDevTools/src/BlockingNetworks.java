import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.network.Network;

import com.google.common.collect.ImmutableList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlockingNetworks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//css,images
		WebDriverManager.chromedriver().setup();
	       ChromeDriver driver= new ChromeDriver();
	       DevTools devtools =driver.getDevTools();
	       devtools.createSession();
	       devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
	       //List<String> urls  = Arrays.asList("*data:image");
	       //devtools.send(Network.setBlockedURLs(ImmutableList.of(".jpeg")));
		//Network.setBlockedURLs
	       long Starttime=System.currentTimeMillis();
	       driver.get("https://rahulshettyacademy.com/angularAppdemo/");
	       driver.findElement(By.linkText("Browse Products")).click();
	       driver.findElement(By.linkText("Selenium")).click();
	       driver.findElement(By.cssSelector(".add-to-cart.btn.btn-default")).click();
	       
	       System.out.println(driver.findElement(By.tagName("p")).getText());
	       long endTime=System.currentTimeMillis();
	       driver.findElement(By.cssSelector("a[routerlink='/cart']")).click();
	       System.out.println(endTime-Starttime);


	       

	}

}
