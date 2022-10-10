import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.network.Network;
import org.openqa.selenium.devtools.v104.network.model.ConnectionType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkSpeed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		DevTools devtools=driver.getDevTools();
		devtools.createSession();
		devtools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		//devtools.send(Network.enable(maxTotalBufferSize, maxResourceBufferSize, maxPostDataSize))
		devtools.send(Network.emulateNetworkConditions(true, 3000, 20000, 100000, Optional.of(ConnectionType.ETHERNET)));
		devtools.addListener(Network.loadingFailed(), loadingFailed->
		{
			 System.out.println(loadingFailed.getErrorText());
			 System.out.println(loadingFailed.getTimestamp());
			 System.out.println("end");
			 System.out.println("rahulshetty.com");
			 System.out.println("rahulshetty.com");
			
		});
		long startTime=System.currentTimeMillis();
 
	       driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
	       long endTime=System.currentTimeMillis(); 
	       System.out.println(endTime-startTime);
	       System.out.println("end");
	       System.out.println("end");
//with low speed-15686  ,with speed-3176
	}

	
}
