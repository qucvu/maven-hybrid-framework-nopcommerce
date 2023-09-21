package pageUIs.nopCommerce.user;

public class OrderPageUI {
    public static final String ORDER_NUMBER_TITLE = "xpath=//div[contains(@class, 'order-item')]//strong[text()='Order Number: %s']";
    public static final String ORDER_DETAIL_BUTTON_BY_ORDER_NUMBER = "xpath=//strong[text()='Order Number: %s']/parent::div/following-sibling::div[@class='buttons']/button";
    public static final String ORDER_NUMBER_TITLE_AT_ORDER_OVERVIEW = "xpath=//div[@class='order-number']/strong[contains(text(), 'Order #%s')]";
    public static final String ORDER_STATS_AT_ORDER_OVERVIEW = "css=li.order-status";
    public static final String ORDER_TOTAL_PRICE_AT_ORDER_OVERVIEW = "CSS=li.order-total>strong";

    public static final String BILLING_ADDRESS_INFORMATION = "xpath=//div[@class='billing-info']/ul[@class='info-list' and contains(., '%s')]";
    public static final String PAYMENT_METHOD_IN_CONFIRM_ORDER = "XPATH=//li[@class='payment-method']/span[@class='value' and contains(text(), '%s')]";
    public static final String PENDING_PAYMENT_STATUS = "xpath=//li[@class='payment-method-status']/span[contains(text(), 'Pending')]";
    public static final String SHIPPING_ADDRESS_INFORMATION = "xpath=//div[@class='shipping-info']/ul[@class='info-list' and contains(., '%s')]";
    public static final String SHIPPING_METHOD_IN_CONFIRM_ORDER = "xpath=//li[@class='shipping-method']/span[@class='value' and contains(text(), '%s')]";
    public static final String NOT_YET_SHIPPING_STATUS = "XPATH=//li[@class='shipping-status']/span[contains(text(), 'Not yet shipped')]";
    public static final String PRODUCT_NAME_AT_ORDER_TABLE = "xpath=//td[@class='product']//a[text()='%s']";
    public static final String QUANITY_BY_PRODUCT_NAME_AT_ORDER_TABLE = "xpath=//a[text()='%s']/ancestor::td//following-sibling::td[@class='quantity']/span";
    public static final String GIFT_WRAPPING_OPTION = "XPATH=//div[@class='selected-checkout-attributes' and contains(text(), '%s')]";
    public static final String TOTAL_ORDER_PRICE_AT_ORDER_TABLE_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/ancestor::td/following-sibling::td[@class='total']/span";
    public static final String ORDER_SUBTOTAL_SUMMARY = "css=tr:nth-child(1)>td.cart-total-right>span";
    public static final String ORDER_TOTAL_SUMMARY = "css=tr:nth-child(4)>td.cart-total-right>span";
    public static final String RE_ORDER_BUTTON = "css=button.re-order-button";


}
