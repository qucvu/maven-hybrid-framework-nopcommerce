package pageObjects.nopCommerce.user;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.OrderPageUI;

public class UserOrderPageObject extends BasePage {
    private WebDriver driver;

    public UserOrderPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderNumberDisplayed(String orderNumber) {
        waitForElementVisibility(driver, OrderPageUI.ORDER_NUMBER_TITLE, orderNumber);
        return isElementDisplayed(driver, OrderPageUI.ORDER_NUMBER_TITLE, orderNumber);
    }

    public void clickToDetailButtonByOrderNumber(String orderNumber) {
        waitForElementClickable(driver, OrderPageUI.ORDER_DETAIL_BUTTON_BY_ORDER_NUMBER, orderNumber);
        clickToElement(driver, OrderPageUI.ORDER_DETAIL_BUTTON_BY_ORDER_NUMBER, orderNumber);

    }

    public boolean isOrderNumberTitleDisplayed(String orderNumber) {
        waitForElementVisibility(driver, OrderPageUI.ORDER_NUMBER_TITLE_AT_ORDER_OVERVIEW, orderNumber);
        return isElementDisplayed(driver, OrderPageUI.ORDER_NUMBER_TITLE_AT_ORDER_OVERVIEW, orderNumber);
    }

    public String getCurrentOrderStatusAtOrderInforamtion() {
        waitForElementVisibility(driver, OrderPageUI.ORDER_STATS_AT_ORDER_OVERVIEW);
        String orderStatusText = getElementText(driver, OrderPageUI.ORDER_STATS_AT_ORDER_OVERVIEW);
        return orderStatusText.substring(orderStatusText.lastIndexOf(":") + 2);
    }

    public String getTotalOrder() {
        waitForElementVisibility(driver, OrderPageUI.ORDER_TOTAL_PRICE_AT_ORDER_OVERVIEW);
        return getElementText(driver, OrderPageUI.ORDER_TOTAL_PRICE_AT_ORDER_OVERVIEW).substring(1);
    }

    public boolean isBillingAddressInformationDisplayed(String addressInformation) {
        waitForElementVisibility(driver, OrderPageUI.BILLING_ADDRESS_INFORMATION, addressInformation);
        return isElementDisplayed(driver, OrderPageUI.BILLING_ADDRESS_INFORMATION, addressInformation);
    }

    public boolean isPaymentMethodDisplayed(String paymentMethod) {
        waitForElementVisibility(driver, OrderPageUI.PAYMENT_METHOD_IN_CONFIRM_ORDER, paymentMethod);
        return isElementDisplayed(driver, OrderPageUI.PAYMENT_METHOD_IN_CONFIRM_ORDER, paymentMethod);
    }

    public boolean isShippingAddressInformationDisplayed(String addressInformation) {
        waitForElementVisibility(driver, OrderPageUI.SHIPPING_ADDRESS_INFORMATION, addressInformation);
        return isElementDisplayed(driver, OrderPageUI.SHIPPING_ADDRESS_INFORMATION, addressInformation);
    }

    public boolean isShippingMethodDisplayed(String shippingMethod) {
        waitForElementVisibility(driver, OrderPageUI.SHIPPING_METHOD_IN_CONFIRM_ORDER, shippingMethod.substring(0, shippingMethod.indexOf("(") - 1));
        return isElementDisplayed(driver, OrderPageUI.SHIPPING_METHOD_IN_CONFIRM_ORDER, shippingMethod.substring(0, shippingMethod.indexOf("(") - 1));
    }

    public boolean isProductNameDisplayedAtOrderTable(String productName) {
        waitForElementVisibility(driver, OrderPageUI.PRODUCT_NAME_AT_ORDER_TABLE, productName);
        return isElementDisplayed(driver, OrderPageUI.PRODUCT_NAME_AT_ORDER_TABLE, productName);
    }

    public String getTotalPriceOrderAtOrderTable(String productName) {
        waitForElementVisibility(driver, OrderPageUI.TOTAL_ORDER_PRICE_AT_ORDER_TABLE_BY_PRODUCT_NAME, productName);
        return getElementText(driver, OrderPageUI.TOTAL_ORDER_PRICE_AT_ORDER_TABLE_BY_PRODUCT_NAME, productName).substring(1);
    }

    public String getCurrentQuantityAtOrderTable(String productName) {
        waitForElementVisibility(driver, OrderPageUI.QUANITY_BY_PRODUCT_NAME_AT_ORDER_TABLE, productName);
        return getElementText(driver, OrderPageUI.QUANITY_BY_PRODUCT_NAME_AT_ORDER_TABLE, productName);
    }

    public boolean isWrappingOptionDislayed(String wrappingOption) {
        waitForElementVisibility(driver, OrderPageUI.GIFT_WRAPPING_OPTION, wrappingOption);
        return isElementDisplayed(driver, OrderPageUI.GIFT_WRAPPING_OPTION, wrappingOption);
    }

    public String getOrderSubTotalSummary() {
        waitForElementVisibility(driver, OrderPageUI.ORDER_SUBTOTAL_SUMMARY);
        return getElementText(driver, OrderPageUI.ORDER_SUBTOTAL_SUMMARY).substring(1);
    }

    public String getOrderTotalSummary() {
        waitForElementVisibility(driver, OrderPageUI.ORDER_TOTAL_SUMMARY);
        return getElementText(driver, OrderPageUI.ORDER_TOTAL_SUMMARY).substring(1);
    }

    public boolean isPaymentStatusPendingDisplayed() {
        waitForElementVisibility(driver, OrderPageUI.PENDING_PAYMENT_STATUS);
        return isElementDisplayed(driver, OrderPageUI.PENDING_PAYMENT_STATUS);
    }

    public boolean isShippingStatusNotYetDisplayed() {
        waitForElementVisibility(driver, OrderPageUI.NOT_YET_SHIPPING_STATUS);
        return isElementDisplayed(driver, OrderPageUI.NOT_YET_SHIPPING_STATUS);
    }

    public UserShoppingCartPageObject clickToReOderButton() {
        waitForElementClickable(driver, OrderPageUI.RE_ORDER_BUTTON);
        clickToElement(driver, OrderPageUI.RE_ORDER_BUTTON);
        return PageGeneratorManager.getShoppingCartPage(driver);
    }
}
