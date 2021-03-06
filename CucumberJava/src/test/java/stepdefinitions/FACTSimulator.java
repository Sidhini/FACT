package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FACTSimulator {

	WebDriver driver = null;
	JavascriptExecutor js;

	@Given("Browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/sxb315/AutomationWorkSpace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		driver = new ChromeDriver(options);
		System.out.println("Browser is open");
	}

	@And("at QA FACT simulator homepage")
	public void at_qa_fact_simulator_homepage() {
		driver.get("https://qa-simulator.gcsdevelopment.com/simulator/");
		js = (JavascriptExecutor) driver;		
		try {	
			Screenshots.takeFullSnapshot(driver,"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//QAFACTHomepage.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("User is in QA FACT simulator page");

	}

	@When("user enters the PII data in simluator page")
	public void user_enters_the_pii_data_in_simluator_page() {
		js = (JavascriptExecutor) driver;
		js.executeScript(
				"document.getElementById('firstName').setAttribute('value','YAMILA');document.getElementById('lastName').setAttribute('value','MKWXGP');document.getElementById('ssn').setAttribute('value','666514155');document.getElementById('month').value=3;document.getElementById('day').value=28;document.getElementById('year').value=1995;document.getElementById('addressLine1').setAttribute('value','2122');document.getElementById('addressLine2').setAttribute('value','HOWARD ST');document.getElementById('city').setAttribute('value','LITTLE ROCK');document.getElementById('state').setAttribute('value','AR');document.getElementById('zip').setAttribute('value','72202');");		
		try {		
			Screenshots.takeFullSnapshot(driver,"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//PIIDATA.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("user enters the PII data in simluator page");

	}

	@And("clicks on the submit button in simulator page")
	public void clicks_on_the_submit_button_in_simulator_page() {		
		driver.findElement(By.name("submit")).click();
		System.out.println("clicks on the submit button in simulator page");

	}

	@And("clicks on the POST TO FACT button in knapsack page")
	public void clicks_on_the_post_to_fact_button_in_knapsack_page() {
		try {
			Screenshots.takeSnapShot(driver,"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//POSTTOFACT.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.findElement(By.name("Decrypt")).click();
		System.out.println("clicks on the POST TO FACT button in knapsack page");

	}

	@And("enters last four digits of SSN")
	public void enters_last_four_digits_of_ssn() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uid")));
		driver.findElement(By.id("uid")).sendKeys("4155");
		try {
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//SSN.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("enters last four digits of SSN");

	}

	@And("clicks CONTINUE button")
	public void clicks_continue_button() {
		driver.findElement(By.id("continueButton")).click();
		System.out.println("clicks CONTINUE button");
	}	

	@And("select KBA answers")
	public void select_KBA_answers() throws ReportAlreadyPulledException, ODUException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("question-Q1")));
		} catch (Exception e) {
			if (driver.findElements(By.xpath("//*[text()[contains(.,'Report Already Received')]]")).size() > 0) {				
				throw new ReportAlreadyPulledException("Report Already Pulled screen shown. Please scrub the user and try again.");
			} else if (driver.findElements(By.xpath("//*[text()[contains(.,'Online Delivery Unavailable')]]")).size() > 0) {				
				throw new ODUException("ODU page is shown");
			} else {
				e.printStackTrace();
			}
		}
		driver.findElement(By.xpath("//*[text()[contains(.,'THE HOME DEPOT, INC.')]]")).click();		
		driver.findElement(By.xpath("//*[text()[contains(.,'BANK OF AMERICA CORPORATION')]]")).click();		
		driver.findElement(By.xpath("//*[text()[contains(.,'1ST POWER SERVICES, INC')]]")).click();
		if (driver.findElements(By.xpath("//*[text()[contains(.,'$900 - $949')]]")).size() > 0) {
			System.out.println("inside $900 - $949 check");
			driver.findElement(By.xpath("//*[text()[contains(.,'$900 - $949')]]")).click();
		} else if (driver.findElements(By.xpath("//*[text()[contains(.,'$875 - $924')]]")).size() > 0) {
			System.out.println("inside $875 - $924 check");
			driver.findElement(By.xpath("//*[text()[contains(.,'$875 - $924')]]")).click();
		} 
		/*driver.findElement(By.id("kbaQuestion11")).click();	
		driver.findElement(By.id("kbaQuestion02")).click();	
		driver.findElement(By.id("kbaQuestion18")).click();	
		driver.findElement(By.id("kbaQuestion21")).click();	*/
		try {
			Screenshots.takeFullSnapshot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//KBAAnswers.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("select KBA answers");
	}

	@And("clicks KBA CONTINUE button")
	public void clicks_KBA_continue_button() {
		driver.findElement(By.id("continueButton")).click();
		System.out.println("clicks CONTINUE button");
	}
	
	@And("Result popup")
	public void Result_popup() {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()[contains(.,'Thank You for Your Order!')]]")));
		try {			
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//Result.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("clicks DOWNLOAD REPORT button")
	public void clicks_DOWNLOAD_REPORT_button() throws ODUException {
		try {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("downloadPdfButton")));		
		Screenshots.takeSnapShot(driver, "C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//DownloadReport.png");
		} catch (Exception e) {
			if (driver.findElements(By.xpath("//*[text()[contains(.,'Online Delivery Unavailable')]]")).size() > 0) {				
				throw new ODUException("ODU page is shown");
			} else {
				e.printStackTrace();
			}
		}
		driver.findElement(By.id("downloadPdfButton")).click();
		System.out.println("clicks DOWNLOAD REPORT button");
	}

	@And("clicks on all sections")
	public void clicks_on_all_sections() throws Exception {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'Report Summary')]]"))).click().perform();
		Thread.sleep(2000);
		try {
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//ReportSummary.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'Revolving Accounts')]]"))).click()
				.perform();
		Thread.sleep(2000);
		try {
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//RevolvingAccounts.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'Mortgage Accounts')]]"))).click()
				.perform();
		Thread.sleep(2000);
		try {
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//MortgageAccounts.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'Installment Accounts')]]"))).click()
				.perform();
		Thread.sleep(2000);
		try {
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//InstallmentAccounts.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'Other Accounts')]]"))).click().perform();
		Thread.sleep(2000);
		try {
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//OtherAccounts.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'Consumer Statements')]]"))).click()
				.perform();
		Thread.sleep(2000);
		try {
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//ConsumerStatements.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'Personal Information')]]"))).click()
				.perform();
		Thread.sleep(2000);
		try {
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//PersonalInformation.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'Inquiries')]]"))).click().perform();
		Thread.sleep(2000);
		try {
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//Inquiries.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'Public Records')]]"))).click().perform();
		Thread.sleep(2000);
		try {
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//PublicRecords.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'Collections')]]"))).click().perform();
		Thread.sleep(2000);
		try {
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//Collections.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'Dispute File Information')]]"))).click()
				.perform();
		Thread.sleep(2000);
		try {
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//DisputFileInformation.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//*[text()[contains(.,'Summary of Your Rights Under FCRA')]]")))
				.click().perform();
		Thread.sleep(2000);
		try {
			Screenshots.takeSnapShot(driver,
					"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//FCRA.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(2000);
		Screenshots.takeFullSnapshot(driver,"C://Users//sxb315//Desktop//GCS_Scrum_Team//Automation//Screenshots//AllSections.png");		
		System.out.println("All sections loaded");
	}

	@Then("user gets a page")
	public void user_gets_a_page() {
		System.out.println("user should gets page");
	}

}
