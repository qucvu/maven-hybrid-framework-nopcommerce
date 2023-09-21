package pageObjects.nopCommerce.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.ShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage {
    private WebDriver driver;

    public UserShoppingCartPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isShoppingCartTitleDisplayed() {
        waitForElementVisibility(driver, ShoppingCartPageUI.SHOPPING_CART_TITLE);
        return isElementDisplayed(driver, ShoppingCartPageUI.SHOPPING_CART_TITLE);
    }

    public boolean isProductNameDisplayedAtCartTable(String productName) {
        waitForElementVisibility(driver, ShoppingCartPageUI.DYNAMIC_PRODUCT_NAM_AT_CART_TABLE, productName);
        return isElementDisplayed(driver, ShoppingCartPageUI.DYNAMIC_PRODUCT_NAM_AT_CART_TABLE, productName);
    }


    public boolean isDataOptionProductDisplayed(String dataProduct) {
        waitForElementVisibility(driver, ShoppingCartPageUI.DYNAMIC_ATTRIBUTE_AT_CART_TABLE, dataProduct);
        return isElementDisplayed(driver, ShoppingCartPageUI.DYNAMIC_ATTRIBUTE_AT_CART_TABLE, dataProduct);
    }

    public boolean isDataOptionProductDisplayedAtMiniCart(String dataProduct) {
        waitForElementVisibility(driver, ShoppingCartPageUI.DYNAMIC_ATTRIBUTE_AT_MINI_CART, dataProduct);
        return isElementDisplayed(driver, ShoppingCartPageUI.DYNAMIC_ATTRIBUTE_AT_MINI_CART, dataProduct);
    }

    public String getCurrentItemQuantityAtMiniCart() {
        waitForElementVisibility(driver, ShoppingCartPageUI.QUANTITY_ITEM_AT_MINI_CART);
        return getElementText(driver, ShoppingCartPageUI.QUANTITY_ITEM_AT_MINI_CART).substring(0, 1);
    }

    public String getCurrentSubTotalAtMiniCart() {
        waitForElementVisibility(driver, ShoppingCartPageUI.SUB_TOTAL_AT_MINI_CART);
        return getElementText(driver, ShoppingCartPageUI.SUB_TOTAL_AT_MINI_CART).substring(1);
    }


    public UserProductDetailPageObject clickToEditLinkByProductName(String productName) {
        waitForElementClickable(driver, ShoppingCartPageUI.EDIT_LINK_BY_PRODUCT_NAME, productName);
        clickToElement(driver, ShoppingCartPageUI.EDIT_LINK_BY_PRODUCT_NAME, productName);
        return PageGeneratorManager.getProductDetailPage(driver);
    }

    public String getTotalPriceAtCartTableByProductName(String productName) {
        waitForElementVisibility(driver, ShoppingCartPageUI.SUB_TOTAL_CART_BY_PRODUCT_NAME, productName);
        return getElementText(driver, ShoppingCartPageUI.SUB_TOTAL_CART_BY_PRODUCT_NAME, productName).substring(1);
    }

    public String getQuantityByProductNameAtCartTable(String productName) {
        waitForElementVisibility(driver, ShoppingCartPageUI.QUANTITY_AT_CART_TABLE_BY_PRODUCT_NAME, productName);
        return getElementAttribute(driver, "value", ShoppingCartPageUI.QUANTITY_AT_CART_TABLE_BY_PRODUCT_NAME, productName);
    }

    public void clickToRemoveButtonByProductName(String productName) {
        waitForElementClickable(driver, ShoppingCartPageUI.REMOVE_BUTTON_AT_CART_TABLE_BY_PRODUCT_NAME, productName);
        clickToElement(driver, ShoppingCartPageUI.REMOVE_BUTTON_AT_CART_TABLE_BY_PRODUCT_NAME, productName);
    }

    public boolean isEmptyCartMessageDisplayed() {
        waitForElementVisibility(driver, ShoppingCartPageUI.EMPTY_CART_MESSAGE);
        return isElementDisplayed(driver, ShoppingCartPageUI.EMPTY_CART_MESSAGE);
    }

    public boolean isDataProductUndisplayedAtCart(String data) {
        return isElementUndisplayed(driver, ShoppingCartPageUI.DYNAMIC_ATTRIBUTE_AT_CART_TABLE, data);
    }

    public boolean isProductNameUndisplayedAtCart(String productName) {
        return isElementUndisplayed(driver, ShoppingCartPageUI.DYNAMIC_PRODUCT_NAM_AT_CART_TABLE, productName);
    }

    public void enterToQuanityTextboxByProductName(String quantity, String productName) {
        waitForElementVisibility(driver, ShoppingCartPageUI.QUANTITY_AT_CART_TABLE_BY_PRODUCT_NAME, productName);
        sendkeyToElement(driver, ShoppingCartPageUI.QUANTITY_AT_CART_TABLE_BY_PRODUCT_NAME, quantity, productName);
    }

    public void clickToUpdateShoppingCart() {
        waitForElementClickable(driver, ShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.UPDATE_SHOPPING_CART_BUTTON);
    }

    public void selectOptionAtGiftWrappingDropdown(String wrappingOption) {
        waitForElementClickable(driver, ShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN);
        selectItemInDefaultDropdown(driver, ShoppingCartPageUI.GIFT_WRAPPING_DROPDOWN, wrappingOption);
    }

    public void clickToEstimateShippingLink() {
        waitForElementClickable(driver, ShoppingCartPageUI.ESTIMATE_SHIPPING_LINK);
        clickToElement(driver, ShoppingCartPageUI.ESTIMATE_SHIPPING_LINK);
    }

    public void clickToApplyButtonInShipPopup() {
        waitForElementClickable(driver, ShoppingCartPageUI.APPLY_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.APPLY_BUTTON);

    }

    public void checkToAgreeTermCheckbox() {
        waitForElementClickable(driver, ShoppingCartPageUI.AGREE_TERM_SERVICE_CHECKBOX);
        clickToElement(driver, ShoppingCartPageUI.AGREE_TERM_SERVICE_CHECKBOX);

    }

    public UserCheckoutPageObject clickToCheckoutButton() {
        waitForElementClickable(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
        clickToElement(driver, ShoppingCartPageUI.CHECKOUT_BUTTON);
        return PageGeneratorManager.getCheckoutPage(driver);
    }
}
