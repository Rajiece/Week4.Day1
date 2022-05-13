package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//http://www.leafground.com/pages/table.html
//
//https://erail.in/

public class RailClassRoomActivity {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		driver.get("https://erail.in/");
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MDU",Keys.TAB);
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("tpj", Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
	    WebElement table= driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
	    List <WebElement> rows=table.findElements(By.tagName("tr"));
		System.out.println("No of Trains: "+rows.size());
		for (int i=0; i<rows.size(); i++)
		{
			List <WebElement> Cols=rows.get(i).findElements(By.tagName("td"));
			for (int j=0;j<2;j++)
			{
	System.out.println(Cols.get(j).getText());
			}
		}
		
        
	}

	
	}

