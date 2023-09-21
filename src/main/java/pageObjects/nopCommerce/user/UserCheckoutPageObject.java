package pageObjects.nopCommerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopCommerce.user.CheckoutPageUI;

public class UserCheckoutPageObject extends BasePage {
    private WebDriver driver;

    public UserCheckoutPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToContinueButtonByContainerId(String containerId) {
        waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_CONTAINER_ID, containerId);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_BY_CONTAINER_ID, containerId);
    }

    public void checkToShippingMethodOption(String shippingMethod) {
        waitForElementClickable(driver, CheckoutPageUI.SHIPPING_METHOD_CHECKOX_BY_LABEL, shippingMethod);
        checkToDefaultCheckboxRadio(driver, CheckoutPageUI.SHIPPING_METHOD_CHECKOX_BY_LABEL, shippingMethod);
    }

    public void checkToPaymentMethodOption(String paymentMethod) {
        waitForElementClickable(driver, CheckoutPageUI.PAYMENT_METHOD_CHECKBOX_BY_LABEL, paymentMethod);
        checkToDefaultCheckboxRadio(driver, CheckoutPageUI.PAYMENT_METHOD_CHECKBOX_BY_LABEL, paymentMethod);

    }

    public boolean isPaymentAnnouncementMessageDisplayed() {
        waitForElementVisibility(driver, CheckoutPageUI.PAYMENT_ANNOUNCEMENT_MESSAGE);
        return isElementDisplayed(driver, CheckoutPageUI.PAYMENT_ANNOUNCEMENT_MESSAGE);
    }

    public boolean isBillingAddressInformationDislayed(String addressInformation) {
        waitForElementVisibility(driver, CheckoutPageUI.BILLING_ADDRESS_INFORMATION, addressInformation);
        return isElementDisplayed(driver, CheckoutPageUI.BILLING_ADDRESS_INFORMATION, addressInformation);
    }

    public boolean isPaymentMethodDisplayed(String paymentMethod) {
        waitForElementVisibility(driver, CheckoutPageUI.PAYMENT_METHOD_IN_CONFIRM_ORDER, paymentMethod);
        return isElementDisplayed(driver, CheckoutPageUI.PAYMENT_METHOD_IN_CONFIRM_ORDER, paymentMethod);
    }

    public boolean isShippingAddressInformationDisplayed(String addressInformation) {
        waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_ADDRESS_INFORMATION, addressInformation);
        return isElementDisplayed(driver, CheckoutPageUI.SHIPPING_ADDRESS_INFORMATION, addressInformation);
    }

    public boolean isShippingMethodDisplayed(String shippingMethod) {
        waitForElementVisibility(driver, CheckoutPageUI.SHIPPING_METHOD_IN_CONFIRM_ORDER, shippingMethod.substring(0, shippingMethod.indexOf("(") - 1));
        return isElementDisplayed(driver, CheckoutPageUI.SHIPPING_METHOD_IN_CONFIRM_ORDER, shippingMethod.substring(0, shippingMethod.indexOf("(") - 1));
    }

    public boolean isProductNameDisplayedAtOrderTable(String productName) {
        waitForElementVisibility(driver, CheckoutPageUI.PRODUCT_NAME_AT_ORDER_TABLE, productName);
        return isElementDisplayed(driver, CheckoutPageUI.PRODUCT_NAME_AT_ORDER_TABLE, productName);
    }

    public String getTotalPriceOrderAtOrderTable(String productName) {
        waitForElementVisibility(driver, CheckoutPageUI.TOTAL_ORDER_PRICE_AT_ORDER_TABLE_BY_PRODUCT_NAME, productName);
        return getElementText(driver, CheckoutPageUI.TOTAL_ORDER_PRICE_AT_ORDER_TABLE_BY_PRODUCT_NAME, productName).substring(1);
    }

    public String getCurrentQuantityAtOrderTable(String productName) {
        waitForElementVisibility(driver, CheckoutPageUI.QUANITY_BY_PRODUCT_NAME_AT_ORDER_TABLE, productName);
        return getElementText(driver, CheckoutPageUI.QUANITY_BY_PRODUCT_NAME_AT_ORDER_TABLE, productName);

    }

    public boolean isWrappingOptionDislayed(String wrappingOption) {
        waitForElementVisibility(driver, CheckoutPageUI.GIFT_WRAPPING_OPTION, wrappingOption);
        return isElementDisplayed(driver, CheckoutPageUI.GIFT_WRAPPING_OPTION, wrappingOption);

    }

    public String getOrderSubTotalSummary() {
        waitForElementVisibility(driver, CheckoutPageUI.ORDER_SUBTOTAL_SUMMARY);
        return getElementText(driver, CheckoutPageUI.ORDER_SUBTOTAL_SUMMARY).substring(1);
    }

    public String getOrderTotalSummary() {
        waitForElementVisibility(driver, CheckoutPageUI.ORDER_TOTAL_SUMMARY);
        return getElementText(driver, CheckoutPageUI.ORDER_TOTAL_SUMMARY).substring(1);

    }

    public void clickToConfirmButton() {
        waitForElementClickable(driver, CheckoutPageUI.CONFIRM_BUTTON);
        clickToElement(driver, CheckoutPageUI.CONFIRM_BUTTON);
    }

    public boolean isOrderSuccessMessagDisplayed() {
        waitForElementVisibility(driver, CheckoutPageUI.ORDER_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, CheckoutPageUI.ORDER_SUCCESS_MESSAGE);
    }

    public String getCurrentOrderNumber() {
        waitForElementVisibility(driver, CheckoutPageUI.ORDER_NUMBER);
        String orderNumberText = getElementText(driver, CheckoutPageUI.ORDER_NUMBER);
        return orderNumberText.substring(orderNumberText.indexOf(":") + 2);
    }

    public void clickToEditButtonAtBillingAddress() {
        waitForElementClickable(driver, CheckoutPageUI.EDIT_BUTTON_AT_BILLING_ADDRESS);
        clickToElement(driver, CheckoutPageUI.EDIT_BUTTON_AT_BILLING_ADDRESS);
    }

    public void clickToSaveButtonAtBillingAdress() {
        waitForElementClickable(driver, CheckoutPageUI.SAVE_BUTTON_AT_BILLING_ADDRESS);
        clickToElement(driver, CheckoutPageUI.SAVE_BUTTON_AT_BILLING_ADDRESS);

    }

    public void clickToBackLinkAtConfirmOrder(String sessionContainerId) {
        waitForElementClickable(driver, CheckoutPageUI.BACK_LINK_BY_CONTAINER_ID, sessionContainerId);
        clickToElement(driver, CheckoutPageUI.BACK_LINK_BY_CONTAINER_ID, sessionContainerId);

    }
}
