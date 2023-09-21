package pageUIs.nopCommerce.user;

public class ProductDetailPageUI {
    public static final String ADD_REVIEW_LINK = "XPATH=//div[@class='product-review-links']//a[text()='Add your review']";
    public static final String CURRENT_PRODUCT_NAME = "css=form#product-details-form div.product-essential div.product-name > h1";
    public static final String ADD_TO_WISHLIST_BUTTON = "css=div.add-to-wishlist>button";
    public static final String WISHLIST_LINK_AT_BAR_NOTIFICATION = "XPATH=//div[@id='bar-notification']//a[text()='wishlist']";

    public static final String PROCESSOR_DROPDOWN = "XPATH=//label[contains(text(), 'Processor')]/parent::dt/following-sibling::dd[1]/select";

    public static final String RAM_DROPDOWN = "XPATH=//label[contains(text(), 'RAM')]/parent::dt/following-sibling::dd[1]/select";

    public static final String HDD_OPTION_RADIO = "XPATH=//label[contains(text(), 'HDD')]/parent::dt/following-sibling::dd[1]//label[text()='%s']/preceding-sibling::input";

    public static final String OS_OPTION_RADIO = "xpath=//label[contains(text(), 'OS')]/parent::dt/following-sibling::dd[1]//label[text()='%s']/preceding-sibling::input";

    public static final String SOFTWARE_OPTION_CHECKBOX = "xpath=//label[contains(text(), 'Software')]/parent::dt/following-sibling::dd[1]//label[text()='%s']/preceding-sibling::input";

    public static final String ADD_TO_CART_BUTTON = "css=button.add-to-cart-button";
    public static final String SHOPPING_CART_LINK_AT_BAR_NOTIFICATION = "CSS=div.bar-notification a[href='/cart']";
    public static final String CURRENT_PRODUCT_PRICE = "css=div.product-price";
    public static final String QUANTITY_PRODUCT_TEXTBOX = "css=div.add-to-cart-panel>input";
    public static final String UPDATE_BUTTON = "css=div.add-to-cart-panel>button";

}
