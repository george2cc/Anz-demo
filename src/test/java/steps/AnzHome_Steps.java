package steps;

import static org.junit.Assert.fail;

import actions.AnzHome_Actions;
import actions.Common_Actions;
import elements.AnzHome_Elements;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.lu.an;
import utils.Constant;

public class AnzHome_Steps {
	Common_Actions common_actions;
	AnzHome_Actions anzhome_actions;

	public AnzHome_Steps(Common_Actions common_actions, AnzHome_Actions anzhome_actions) {
		this.common_actions = common_actions;
		this.anzhome_actions = anzhome_actions;
	}

	@Given("I am on the ANZ Home Page")
	public void i_am_on_the_ANZ_Home_Page() {
		common_actions.goToUrl("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	}

	@When("I click on application type single button")
	public void i_click_on_application_type_single_button() throws InterruptedException {
		anzhome_actions.clickOnSingleApplicationType();
	}

	@When("I select no of dependants")
	public void i_select_no_of_dependants() throws InterruptedException {

		anzhome_actions.selectDependants();
	}

	@When("I click on property type Home to live in")
	public void i_click_on_property_type_Home_to_live_in() throws InterruptedException {
		anzhome_actions.clickOnBorrowTypeHome();
	}

	@When("I enter {string} income before tax")
	public void i_enter_income_before_tax(String taxbefore) throws InterruptedException {
		anzhome_actions.enterIncomeBeforeTax(taxbefore);
	}
	
	@When("I enter {string} income after tax")
	public void i_enter_income_after_tax(String aftertax) throws InterruptedException {
	    anzhome_actions.enterIncomeAfterTax(aftertax);
	  
	}
	
	@Then("I enter my expanses as")
	public void i_enter_my_expanses_as(DataTable dataTable) throws InterruptedException {
		anzhome_actions.enterExpensesValue(dataTable.cell(1, 0));
		anzhome_actions.enterCurrentLoan(dataTable.cell(1, 1));
		anzhome_actions.enterOtherLoanPayment(dataTable.cell(1, 2));
		anzhome_actions.enterOtherCommitments(dataTable.cell(1, 3));
		anzhome_actions.enterTotalCreditCardLimit(dataTable.cell(1, 4));
	}
	
	@When("I click on the borrow button")
	public void i_click_on_the_borrow_button() throws InterruptedException {
	    anzhome_actions.clickOnBorrowButton();
	}

	@Then("I validate that page values of {int} is displayed")
	public void i_validate_that_page_values_of_is_displayed(int tax) {
		int actValue = anzhome_actions.getAmountofLoan();
		int custValue = 479000;
		 if (actValue < custValue) {
		    	fail("Customer is below the borrow amount: " + actValue);
		    }
	}
	
	@When("I click on start over button")
	public void i_click_on_start_over_button() throws InterruptedException {
		anzhome_actions.clickOnStartOverBtn();
	}

	@Then("I validate that page message is displayed")
	public void i_validate_that_page_message_is_displayed() {
		String actValue = anzhome_actions.getMessageDisplayed();
		String expValue = Constant.HELP_MESSAGE;
		 if (!actValue.equals(expValue)) {
		    	fail("Page message is not correct " + actValue);
		    }
	}

	@Then("I check that the form is reset")
	public void i_check_that_the_form_is_reset() {
		String actValue = "";
		String expValue = anzhome_actions.getResetValue();
		 if (!actValue.equals(expValue)) {
		    	fail("Page message is not correct " + actValue);
		    }
	}

}