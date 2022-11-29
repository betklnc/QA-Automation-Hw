package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.Base_PO;
import pageObject.Step_Def_PO;

public class My_Step_def extends Base_PO {

    private Step_Def_PO step_def_po;

    private String price_in_search;
    private String price_in_cart;

    public My_Step_def(Step_Def_PO step_def_po) {
        this.step_def_po = step_def_po;
    }

    @Given("I go to Trendyol homepage")
    public void i_go_to_trendyol_homepage() {
        step_def_po.navigateTo_Trendyol_Homepage();
    }

    @When("I search the product keyword")
    public void i_search_the_product_keyword() {
        step_def_po.search_product();
        step_def_po.clickOn_search_button();
    }

    @Then("I validate products are shown in the search page")
    public void i_validate_products_are_shown_in_the_search_page() {
        step_def_po.validate_search_results();
    }

    @When("I take the price of first product in the search page")
    public void i_take_the_price_of_first_product_in_the_search_page() {
        price_in_search = step_def_po.take_price_of_search_product();
    }

    @And("I go to pdp of first product")
    public void i_go_to_pdp_of_first_product() {
        step_def_po.clickOn_first_product();
    }


    @And("I go to cart")
    public void i_go_to_cart() {
        step_def_po.clickOn_add_cart_button();
        step_def_po.clickOn_go_cart_button();
    }

    @Then("I should see the product price are the same with in search page")
    public void i_should_see_the_product_price_are_the_same_with_in_search_page() {
        price_in_cart = step_def_po.take_price_of_product_in_cart();
        Assert.assertEquals(price_in_search, price_in_cart);

    }

}
