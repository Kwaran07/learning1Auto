package week2.day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchApplication {

	public static void main(String[] args) {
		//Set up Chrome driver traditional
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		//set up driver - 1
	WebDriverManager.chromedriver().setup();
	// open chrome - 2
	ChromeDriver driver =new ChromeDriver();
	// load app url
	driver.get("http://leaftaps.com/opentaps/control/main");
	// maximize window browser - 4
	driver.manage().window().maximize();
	// find element for username field
	WebElement username= driver.findElementById("username");
	//to tyoe value in webelement
	username.sendKeys("Demosalesmanager");
	//for above 2 line we can write like below
	//driver.findElementById("username").sendKeys("Demosalesmanager");
	//find element for password field
	WebElement password = driver.findElementById("password");
	password.sendKeys("crmsfa");
	//login element
	driver.findElementByClassName("decorativeSubmit").click();
	//locate element using linktext locator - to click crmfsa
	driver.findElementByLinkText("CRM/SFA").click();
	//driver.close();
	driver.findElementByLinkText("Leads").click();
	driver.findElementByLinkText("Create Lead").click();
	
	//steps to get into dropdown -1 -> locate the parent(With select tag) 
	WebElement source = driver.findElementById("createLeadForm_dataSourceId");
	
	//Create object for the select class and pass the parent element as argument -2
	Select dropDown =new Select(source);
	
	//There are 3 methods to select 1. Visible text
	dropDown.selectByVisibleText("Conference");
	//select by value
	//dropDown.selectByValue("LEAD_CONFERENCE");
	//select by index
	//dropDown.selectByIndex(1);
	
	//list the dropdown
	List<WebElement> options = dropDown.getOptions();
	//count of dropdown elements
	int count=options.size(); 
	int lastelement = count-1;
	
	}
	

}
