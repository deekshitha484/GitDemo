import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v104.fetch.Fetch;
import org.openqa.selenium.devtools.v104.network.Network;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NetworkMock {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		DevTools devtools=driver.getDevTools();
		devtools.createSession();
		devtools.send(Fetch.enable(Optional.empty(), Optional.empty()));
		devtools.addListener(Fetch.requestPaused(),request->
		{
			if(request.getRequest().getUrl().contains("shetty"))
			{
				
				String mockedURL=request.getRequest().getUrl().replace("=shetty", "=BadGuy");
				System.out.println(mockedURL);
				//now resume req paused
				//devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedURL), Optional.of(request.getRequest().getMethod()), Optional.of(request.getRequest().getPostData()), Optional.of(request.getRequest().getHeaders(), request.getResponseHeaders()));
				devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedURL), Optional.of(request.getRequest().getMethod()),Optional.empty(),Optional.empty(),Optional.empty()));
			}
			else{
				
				devtools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.of(request.getRequest().getMethod()),Optional.empty(),Optional.empty(),Optional.empty()));
			}
		});
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		System.out.println("rahulshetty.com");
		System.out.println("rahulshetty.com");
		System.out.println("rahulshetty.com");
	}

}
