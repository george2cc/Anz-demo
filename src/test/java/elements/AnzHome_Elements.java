package elements;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnzHome_Elements {
	
	WebDriver driver;

	@FindBy(xpath ="//input[@id='application_type_single']") public WebElement text_app_type_single;
	@FindBy(xpath ="//input[@id='application_type_joint']") public WebElement text_app_type_joint;
	@FindBy(xpath ="//select[@title='Number of dependants']") public WebElement noOfDependentsDropDown;
	@FindBy(xpath ="//input[@id='borrow_type_home']") public WebElement text_borrow_type_home;
	@FindBy(xpath ="//input[@id='borrow_type_investment']") public WebElement text_borrow_type_investment;
	@FindBy(xpath ="//span[@id='q2q1i1']/following-sibling::input") public WebElement text_income_before_tax;
	@FindBy(xpath ="//span[@id='q2q2i1']/following-sibling::input") public WebElement text_income_after_tax;
	@FindBy(id ="expenses") public WebElement text_expenses_value;
	@FindBy(id ="homeloans") public WebElement text_homeloans_value;
	@FindBy(id ="otherloans") public WebElement text_otherloans_value;
	@FindBy(xpath ="//span[@id='q3q4i1']/following-sibling::input") public WebElement text_other_commitments;
	@FindBy(xpath ="//span[@id='q3q5i1']/following-sibling::input") public WebElement text_total_creditcard_limits;
	@FindBy(xpath ="//button[@id='btnBorrowCalculater']") public WebElement btn_BorrowCalculator;
	@FindBy(xpath ="//span[@id='borrowResultTextAmount']") public WebElement amount_borrowText;
	@FindBy(xpath ="(//span[@class='icon icon_restart'])[1]") public WebElement startOverBtn;
	@FindBy(xpath ="//span[@class='borrow__error__text']") public WebElement helpMessage;
	
	public AnzHome_Elements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
