package week4.day1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StockMarket {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Launch URL
		driver.get("https://www.chittorgarh.com/");
		//Click on the stock market
		driver.findElement(By.linkText("STOCK MARKET")).click();
		//click on bulk NSE bulk deals
		driver.findElement(By.partialLinkText("NSE Bulk Deals")).click();
		WebElement elementTable = driver.findElement(
				By.xpath("//h2[contains(text(),'NSE Bulk Deals From Last Trading Session')]/..//table//tbody"));

		List<WebElement> rows = elementTable.findElements(By.tagName("tr"));
		String text = "";
		
		// Iterate the rows to get the data
		List<String> text1 = new ArrayList<String>();
		for (int i = 0; i < rows.size(); i++) {
			// Cols inside the rows
			List<WebElement> cols = rows.get(i).findElements(By.xpath("//td[3]"));
			
			//Get All the Security names
			for (WebElement print : cols) {
			
				text = print.getText();
				text1.add(text);
			}
		}
		Set<String> hash_Set = new LinkedHashSet<String>(text1);
		
		//Ensure whether there are duplicate Security names
		System.out.println(hash_Set);
	}
}
