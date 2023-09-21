package pageObjects.nopCommerce.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.ProductDetailPageUI;

public class UserProductDetailPageObject extends BasePage {
    private WebDriver driver;

    public UserProductDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public UserProductReviewPageObject openProductReviewPage() {
        waitForElementClickable(driver, ProductDetailPageUI.ADD_REVIEW_LINK);
        clickToElement(driver, ProductDetailPageUI.ADD_REVIEW_LINK);
        return PageGeneratorManager.getProductReviewPage(driver);
    }

    public String getCurrentProductName() {
        waitForElementVisibility(driver, ProductDetailPageUI.CURRENT_PRODUCT_NAME);
        return getElementText(driver, ProductDetailPageUI.CURRENT_PRODUCT_NAME);
    }

    public void clickToAddToWishlistButton() {
        waitForElementClickable(driver, ProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
        clickToElement(driver, ProductDetailPageUI.ADD_TO_WISHLIST_BUTTON);
    }


    public UserWishlistPageObject clickToWishlistLinkAtTheBarNotification() {
        waitForElementClickable(driver, ProductDetailPageUI.WISHLIST_LINK_AT_BAR_NOTIFICATION);
        clickToElement(driver, ProductDetailPageUI.WISHLIST_LINK_AT_BAR_NOTIFICATION);
        return PageGeneratorManager.getWishListPage(driver);
    }

    public void selectItemToProcessorDropdown(String processorOption) {
        waitForElementClickable(driver, ProductDetailPageUI.PROCESSOR_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductDetailPageUI.PROCESSOR_DROPDOWN, processorOption);
    }

    public void selectItemToRamDropdown(String ramOption) {
        waitForElementClickable(driver, ProductDetailPageUI.RAM_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductDetailPageUI.RAM_DROPDOWN, ramOption);

    }

    public void checkToHddOptionRadio(String hddOption) {
        waitForElementClickable(driver, ProductDetailPageUI.HDD_OPTION_RADIO, hddOption);
        checkToDefaultCheckboxRadio(driver, ProductDetailPageUI.HDD_OPTION_RADIO, hddOption);
    }

    public void checkToOsOptionRadio(String osOption) {
        waitForElementClickable(driver, ProductDetailPageUI.OS_OPTION_RADIO, osOption);
        checkToDefaultCheckboxRadio(driver, ProductDetailPageUI.OS_OPTION_RADIO, osOption);

    }

    public void checkToSoftwareOptionCheckbox(String softwareOption) {
        waitForElementClickable(driver, ProductDetailPageUI.SOFTWARE_OPTION_CHECKBOX, softwareOption);
        checkToDefaultCheckboxRadio(driver, ProductDetailPageUI.SOFTWARE_OPTION_CHECKBOX, softwareOption);
    }

    public void clickToAddToCartButton() {
        waitForElementClickable(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, ProductDetailPageUI.ADD_TO_CART_BUTTON);
    }

    public UserShoppingCartPageObject clickToShoppingCartLinkOnBarNotification() {
        waitForElementClickable(driver, ProductDetailPageUI.SHOPPING_CART_LINK_AT_BAR_NOTIFICATION);
        clickToElement(driver, ProductDetailPageUI.SHOPPING_CART_LINK_AT_BAR_NOTIFICATION);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }


    public void unCheckToSoftwareOptionCheckbox(String softwareOption) {
        waitForElementClickable(driver, ProductDetailPageUI.SOFTWARE_OPTION_CHECKBOX, softwareOption);
        unCheckToDefaultCheckbox(driver, ProductDetailPageUI.SOFTWARE_OPTION_CHECKBOX, softwareOption);
    }

    public void enterToQuantityTextbox(String value) {
        waitForElementVisibility(driver, ProductDetailPageUI.QUANTITY_PRODUCT_TEXTBOX);
        sendkeyToElement(driver, ProductDetailPageUI.QUANTITY_PRODUCT_TEXTBOX, value);
    }

    public String getCurrentProductPrice() {
        waitForElementVisibility(driver, ProductDetailPageUI.CURRENT_PRODUCT_PRICE);
        return getElementText(driver, ProductDetailPageUI.CURRENT_PRODUCT_PRICE).substring(1);

    }

    public void clickToUpdateButton() {
        waitForElementClickable(driver, ProductDetailPageUI.UPDATE_BUTTON);
        clickToElement(driver, ProductDetailPageUI.UPDATE_BUTTON);
    }
}
