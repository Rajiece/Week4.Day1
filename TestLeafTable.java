package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//http://www.leafground.com/pages/table.html
//	
//Get the count of number of columns
//
//Get the count of number of rows
//
//Get the progress value of 'Learn to interact with Elements'
//
//Check the vital task for the least completed progress

public class TestLeafTable {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://www.leafground.com/pages/table.html");
		
		WebElement elementTable = driver.findElement(By.className("innerblock"));
		
	    List<WebElement> rows = elementTable.findElements(By.tagName("tr"));
	    
		int size1 = rows.size();
		 
		System.out.println("rows size: "+ size1);
		
		for(int i=0; i<rows.size();i++) {
			
		List<WebElement> cols = rows.get(i).findElements(By.xpath("//tr[@class='even' ]"));
			
		int size = cols.size();
			
		if (size>0) {
			
		System.out.println("cols size: "+ size);
				
		break;
		}
		for (int j=0; j<cols.size(); j++) {
				
		String text = cols.get(j).getText();
				
		System.out.println(text);
			}
		}
		
		elementTable.findElement(By.xpath("//tr[6]/td[3]")).click();
		
        driver.close();
	}
	
	

}
