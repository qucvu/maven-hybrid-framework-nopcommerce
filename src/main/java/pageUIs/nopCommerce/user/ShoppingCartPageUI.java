package pageUIs.nopCommerce.user;

public class ShoppingCartPageUI {
    public static final String SHOPPING_CART_TITLE = "xpath=//div[@class='page-title']/h1[text()='Shopping cart']";
    public static final String DYNAMIC_PRODUCT_NAM_AT_CART_TABLE = "xpath=//form[@id='shopping-cart-form']//table//tbody//td/a[@class='product-name' and text()='%s']";
    public static final String DYNAMIC_ATTRIBUTE_AT_CART_TABLE = "XPATH=//table//td[@class='product']/div[@class='attributes' and contains(., '%s')]";
    public static final String DYNAMIC_ATTRIBUTE_AT_MINI_CART = "xpath=//div[@id='flyout-cart']//div[@class='attributes' and contains(., '%s')]";
    public static final String QUANTITY_ITEM_AT_MINI_CART = "css=div#flyout-cart div.count>a";
    public static final String SUB_TOTAL_AT_MINI_CART = "css=div#flyout-cart div.totals>strong";
    public static final String EDIT_LINK_BY_PRODUCT_NAME = "xpath=//a[text()='%s']//following-sibling::div[@class='edit-item']/a";
    public static final String SUB_TOTAL_CART_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::td//following-sibling::td[@class='subtotal']/span";
    public static final String QUANTITY_AT_CART_TABLE_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::td//following-sibling::td[@class='quantity']/input";
    public static final String REMOVE_BUTTON_AT_CART_TABLE_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::td//following-sibling::td[@class='remove-from-cart']/button";
    public static final String EMPTY_CART_MESSAGE = "xpath=//div[@class='order-summary-content']/div[@class='no-data' and contains(text(), 'Your Shopping Cart is empty')]";
    public static final String UPDATE_SHOPPING_CART_BUTTON = "css=button#updatecart";
    public static final String GIFT_WRAPPING_DROPDOWN = "css=div.checkout-attributes select[id*=checkout_attribute]";
    public static final String ESTIMATE_SHIPPING_LINK = "css=a#open-estimate-shipping-popup";
    public static final String APPLY_BUTTON = "xpath=//div[contains(@class, 'shipping-option active')]/ancestor::div[@class='shipping-options']/following-sibling::div/button";
    public static final String AGREE_TERM_SERVICE_CHECKBOX = "css=input#termsofservice";
    public static final String CHECKOUT_BUTTON = "css=button#checkout";

}
