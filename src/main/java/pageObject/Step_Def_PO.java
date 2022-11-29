package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Global_Vars;

public class Step_Def_PO extends Base_PO {


    private @FindBy(xpath = "//*[@id=\"sfx-discovery-search-suggestions\"]/div/div/input") WebElement searchBox_TextField;
    private @FindBy(xpath = "//*[@id=\"Combined-Shape\"]") WebElement popup_CloseIcon;
    private @FindBy(xpath = "//*[@id=\"sfx-discovery-search-suggestions\"]/div/div/i") WebElement click_searchIcon;
    private @FindBy(xpath = "//*[@id=\"search-app\"]/div/div[1]/div[2]/div[1]") WebElement div_searchResultTitle;
    private @FindBy(xpath = "(//div[@class='prc-box-dscntd'])[1]") WebElement price_FirstProduct;


    private @FindBy(xpath = "//button[@class='add-to-basket']") WebElement click_AddCart_Button;

    private @FindBy(xpath = "//a[@class='link account-basket']") WebElement click_GoCart_Button;

    private @FindBy(xpath = "//a[@class='goBasket']") WebElement clickCartSummaryPage;
    private @FindBy(xpath = "//div[@class='pb-basket-item-price']") WebElement price_CartProduct;

    public Step_Def_PO() {
        super();
    }

    public void navigateTo_Trendyol_Homepage() {
        navigateTo_URL(Global_Vars.TRENDYOL_HOMEPAGE_URL);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void search_product() {
        popup_CloseIcon.click();
        sendKeys(searchBox_TextField, "laptop");

    }

    public void clickOn_search_button() {
        waitForElementAndClick(click_searchIcon);
    }


    public void validate_search_results() {
        assertSearchingResult(div_searchResultTitle);

    }

    public String take_price_of_search_product() {
        return takePriceOfProduct(price_FirstProduct);
    }

    public void clickOn_first_product() {
        waitForElementAndClick(price_FirstProduct);
        switchToTab();
    }

    public void clickOn_add_cart_button() {
        waitForElementAndClick(click_AddCart_Button);
    }

    public void clickOn_go_cart_button() {
        waitForElementAndClick(click_GoCart_Button);
        //waitForElementAndClick(clickCartSummaryPage);
    }

    public String take_price_of_product_in_cart() {
        return takePriceOfProduct(price_CartProduct);
    }

}
