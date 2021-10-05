package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import elements.AnzHome_Elements;
import steps.Common_Steps;

public class AnzHome_Actions {
	
	private WebDriver driver;
	AnzHome_Elements anzhome_elements;
	
	public AnzHome_Actions(Common_Steps common_steps) {
		this.driver = common_steps.getDriver();
		anzhome_elements = new AnzHome_Elements(driver);
	}
	

	public void clickOnSingleApplicationType() throws InterruptedException {
		anzhome_elements.text_app_type_single.click();
		Thread.sleep(1000);
	}

	public void selectDependants() throws InterruptedException {
		Select noofdependens = new Select(anzhome_elements.noOfDependentsDropDown);
		noofdependens.selectByIndex(0);
		Thread.sleep(1000);
	}
	
	public void clickOnBorrowTypeHome() throws InterruptedException {
		anzhome_elements.text_borrow_type_home.click();
		Thread.sleep(3000);
	}
	
	public void enterIncomeBeforeTax(String beforeTaxString) throws InterruptedException {
		anzhome_elements.text_income_before_tax.sendKeys(beforeTaxString);
		Thread.sleep(1000);
	}
	
	public void enterIncomeAfterTax(String afterTaxString) throws InterruptedException {
		anzhome_elements.text_income_after_tax.sendKeys(afterTaxString);
		Thread.sleep(1000);
	}
	
	public void enterExpensesValue(String string) throws InterruptedException {
		anzhome_elements.text_expenses_value.sendKeys(string);
		Thread.sleep(1000);
	}
	
	public void enterCurrentLoan(String string) throws InterruptedException {
		anzhome_elements.text_homeloans_value.sendKeys(string);
		Thread.sleep(2000);
	}
	
	public void enterOtherLoanPayment(String string) throws InterruptedException {
		anzhome_elements.text_otherloans_value.sendKeys(string);
		Thread.sleep(1000);
	}
	
	public void enterOtherCommitments(String string) throws InterruptedException {
		anzhome_elements.text_other_commitments.sendKeys(string);
		Thread.sleep(1000);
	}
	
	public void enterTotalCreditCardLimit(String string) throws InterruptedException {
		anzhome_elements.text_total_creditcard_limits.sendKeys(string);
		Thread.sleep(1000);
	}
	
	public void clickOnBorrowButton() throws InterruptedException {
		anzhome_elements.btn_BorrowCalculator.click();
		Thread.sleep(1000);
	}
	
	public int getAmountofLoan() {
		String value = anzhome_elements.amount_borrowText.getText();
		 int getvalue= Integer.parseInt(value.replaceAll("$,", ""));
		return getvalue;
	}
	
	public void clickOnStartOverBtn() throws InterruptedException {
		anzhome_elements.startOverBtn.click();
		Thread.sleep(1000);
	}
	
	public String getMessageDisplayed() {
		return anzhome_elements.helpMessage.getText();
	}
	
	public String getResetValue() {
		return anzhome_elements.text_expenses_value.getText();
	}
}
