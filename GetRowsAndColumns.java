package week4.day1;

//1. Launch the URL https://html.com/tags/table/
//2. Get the count of number of rows
//3. Get the count of number of columns

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetRowsAndColumns {

	public static void main(String[] args) {
   
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://html.com/tags/table/");
		
		WebElement table = driver.findElement(By.className("render"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		int size1=rows.size();
		
		System.out.println("rows- "+ size1);
		
		for(int i=1; i<rows.size(); i++) {
		
		List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
		
		int size = cols.size();
	   
        System.out.println( "cols- " +size);
		
		for (int j=0; j<cols.size(); j++) {
			
	    System.out.println(cols.get(j).getText());


		}	
		
		
	}
	}
}

		
	
	

