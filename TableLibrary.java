package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableLibrary {

	public static void main(String[] args) {
		
    WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("https://html.com/tags/table/");
	
	WebElement table = driver.findElement(By.className("render"));
	
	List<WebElement> rows = table.findElements(By.tagName("tr"));
	
	System.out.println(rows.size());
	
	System.out.println(table.findElement(By.xpath("//thead/tr")).getText());
	
	System.out.println(table.findElement(By.xpath("//tbody/tr[1]")).getText());
	
	System.out.println(table.findElement(By.xpath("//tbody/tr[2]")).getText());
}
}