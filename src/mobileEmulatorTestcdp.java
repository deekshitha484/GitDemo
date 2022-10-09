
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.emulation.Emulation;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mobileEmulatorTestcdp {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
       DevTools devtools=driver.getDevTools();
       devtools.createSession();
      Map<String, Object> devicemetrics=new HashMap();
      devicemetrics.put("width", 600);
      devicemetrics.put("height", 1000);
      devicemetrics.put("deviceScaleFactor", 50);
      devicemetrics.put("mobile", true);
      driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",devicemetrics);
      driver.get("https://rahulshettyacademy.com/angularAppdemo/");
      driver.findElement(By.cssSelector("span.navbar-toggler-icon")).click();
      Thread.sleep(2000);
      driver.findElement(By.cssSelector("a[routerlink='/library']")).click();


 
   
	}

}
 