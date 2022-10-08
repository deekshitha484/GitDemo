import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import java.net.URI;
import java.util.function.Predicate;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicAuth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		Predicate<URI> predicate=uri->uri.getHost().contains("httpbin.org");
		((HasAuthentication)driver).register(predicate, UsernameAndPassword.of("foo", "bar"));
		driver.get("http://httpbin.org/basic-auth/foo/bar");
		
		
				

	}

}
