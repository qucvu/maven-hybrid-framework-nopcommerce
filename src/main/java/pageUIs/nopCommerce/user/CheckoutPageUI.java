package pageUIs.nopCommerce.user;

public class CheckoutPageUI {
    public static final String CONTINUE_BUTTON_BY_CONTAINER_ID = "xpath=//div[@id='%s']/button[text()='Continue']";
    public static final String SHIPPING_METHOD_CHECKOX_BY_LABEL = "xpath=//div[@id='shipping-methods-form']//label[text()='%s']/preceding-sibling::input";
    public static final String PAYMENT_METHOD_CHECKBOX_BY_LABEL = "XPATH=//div[@class='payment-details']//label[text()='%s']/preceding-sibling::input";
    public static final String PAYMENT_ANNOUNCEMENT_MESSAGE = "XPATH=//p[contains(text(), 'Mail Personal or Business Check')]/ancestor::div[contains(@class, 'payment-info')]";
    public static final String BILLING_ADDRESS_INFORMATION = "xpath=//div[@class='billing-info']/ul[@class='info-list' and contains(., '%s')]";
    public static final String PAYMENT_METHOD_IN_CONFIRM_ORDER = "XPATH=//li[@class='payment-method']/span[@class='value' and contains(text(), '%s')]";
    public static final String SHIPPING_ADDRESS_INFORMATION = "xpath=//div[@class='shipping-info']/ul[@class='info-list' and contains(., '%s')]";
    public static final String SHIPPING_METHOD_IN_CONFIRM_ORDER = "xpath=//li[@class='shipping-method']/span[@class='value' and contains(text(), '%s')]";
    public static final String PRODUCT_NAME_AT_ORDER_TABLE = "xpath=//td[@class='product']//a[text()='%s']";
    public static final String QUANITY_BY_PRODUCT_NAME_AT_ORDER_TABLE = "xpath=//a[text()='%s']/parent::td//following-sibling::td[@class='quantity']/span";
    public static final String TOTAL_ORDER_PRICE_AT_ORDER_TABLE_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::td//following-sibling::td[@class='subtotal']/span";
    public static final String GIFT_WRAPPING_OPTION = "XPATH=//div[@class='selected-checkout-attributes' and contains(text(), '%s')]";
    public static final String ORDER_SUBTOTAL_SUMMARY = "css=tr.order-subtotal span";
    public static final String ORDER_TOTAL_SUMMARY = "css=tr.order-total span";
    public static final String CONFIRM_BUTTON = "css=button.confirm-order-next-step-button";
    public static final String ORDER_SUCCESS_MESSAGE = "xpath=//div[contains(@class,'order-completed')]//strong[text()='Your order has been successfully processed!']";
    public static final String ORDER_NUMBER = "css=div.order-number>strong";
    public static final String EDIT_BUTTON_AT_BILLING_ADDRESS = "css=button#edit-billing-address-button";
    public static final String SAVE_BUTTON_AT_BILLING_ADDRESS = "css=button#save-billing-address-button";

    public static final String BACK_LINK_BY_CONTAINER_ID = "css=div#%s>p>a";
}
