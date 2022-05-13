package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

//// Handling drop down using Select class
////1. Find the drop down element
//WebElement sourceDropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
//
////2. Access the Select class
//Select select1 = new Select(sourceDropdown);
//
////3. Select the value from the drop down
//select1.selectByIndex(1);
////select1.deselectByIndex(1);
//
//WebElement marketingCampaignDropdown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
//
//Select select2 = new Select(marketingCampaignDropdown);
//
////select2.selectByVisibleText("Car and Driver");
//
//select2.selectByValue("9000");
//List<WebElement> options = select2.getOptions();
//select2.selectByIndex(options.size()-1);
//
//for (WebElement eachOption : options) {
//    System.out.println(eachOption.getText());
//}

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownsClassRoomActivity {
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa",Keys.ENTER);	
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		WebElement OwnerShipDropdown=driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select select2=new Select(OwnerShipDropdown); 
		select2.selectByValue("OWN_PUBLIC_CORP");
		WebElement IndustryDropdown = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select select = new Select (IndustryDropdown);
		List <WebElement> options = select.getOptions();
		for (WebElement eachOption: options) {
			System.out.println(eachOption.getText());
		}
	}

	}
	


