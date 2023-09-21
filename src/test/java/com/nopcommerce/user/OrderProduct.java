package com.nopcommerce.user;

import com.aventstack.extentreports.Status;
import com.nopcommerce.common.Common_01_Register_Cookie;
import com.nopcommerce.data.UserData;
import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Arrays;

public class OrderProduct extends BaseTest {
    private WebDriver driver;
    private String productName;
    private UserHomePageObject homePage;
    private UserCategoryPageObject categoryPage;
    private UserProductDetailPageObject productDetailPage;
    private UserShoppingCartPageObject shoppingCartPage;
    private UserCheckoutPageObject checkoutPage;
    private UserCustomerInfoPageObject customerInfoPage;
    private UserOrderPageObject orderDetailPage;
    private String processorOption, ramOption, hddOption, osOption, totalPriceCart;
    private String processorOptionEdited, ramOptionEdited, hddOptionEdited, osOptionEdited, productPriceEdited, totalPriceCartEdited;
    private String productNameCheckout, wrappingOption, countryShip, provinceShip, zipCodeShip, cityShip, phoneNumberShip, address1Ship, shippingMethod, paymentMethod, totalPriceOrder, fullName, email, orderNumber;
    private String newCountryShip, newProvinceShip, newZipCodeShip, newCityShip, newPhoneNumberShip, newAddress1Ship, newShippingMethod, newTotalPriceOrder;

    private String paymentMethodCreditCard, cardholderName, cardNumber, expirationYear, expirationMonth, cardCode;
    private String productNameUpdateCart, totalPriceCartUpdateCart;
    private String[] softwareOptions;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        productName = "Build your own computer";
        processorOption = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
        ramOption = "8GB [+$60.00]";
        hddOption = "400 GB [+$100.00]";
        osOption = "Vista Premium [+$60.00]";
        softwareOptions = new String[]{"Microsoft Office [+$50.00]", "Acrobat Reader [+$10.00]", "Total Commander [+$5.00]"};
        totalPriceCart = "1,500.00";
        processorOptionEdited = "2.2 GHz Intel Pentium Dual-Core E2200";
        ramOptionEdited = "4GB [+$20.00]";
        hddOptionEdited = "320 GB";
        osOptionEdited = "Vista Home [+$50.00]";
        productPriceEdited = "1,320.00";
        totalPriceCartEdited = "2,640.00";

        productNameUpdateCart = "Lenovo IdeaCentre 600 All-in-One PC";
        totalPriceCartUpdateCart = "2,500.00";

        productNameCheckout = UserData.ShippingProductCheckout.PRODUCT;
        countryShip = UserData.ShippingProductCheckout.COUNTRY;
        provinceShip = UserData.ShippingProductCheckout.PROVINCE;
        wrappingOption = UserData.ShippingProductCheckout.GIFT_WRAPPING_OPTION;
        zipCodeShip = UserData.ShippingProductCheckout.ZIPCODE;
        cityShip = UserData.ShippingProductCheckout.CITY;
        address1Ship = UserData.ShippingProductCheckout.ADDRESS_1;
        phoneNumberShip = UserData.ShippingProductCheckout.PHONE_NUMBER;
        shippingMethod = UserData.ShippingProductCheckout.SHIPPING_METHOD;
        paymentMethod = UserData.ShippingProductCheckout.PAYMENT_METHOD;
        totalPriceOrder = UserData.ShippingProductCheckout.TOTAL_PRICE_ORDER;
        fullName = String.format("%s %s", Common_01_Register_Cookie.firstName, Common_01_Register_Cookie.lastName);
        email = Common_01_Register_Cookie.emailAddress;
        paymentMethodCreditCard = UserData.ShippingProductCheckout.PAYMENT_METHOD_CREDIT_CARD;
        cardholderName = UserData.ShippingProductCheckout.CARDHOLDER_NAME;
        cardNumber = UserData.ShippingProductCheckout.CARD_NUMBER;
        expirationMonth = UserData.ShippingProductCheckout.EXPIRATION_MONTH;
        expirationYear = UserData.ShippingProductCheckout.EXPIRATION_YEAR;
        cardCode = UserData.ShippingProductCheckout.CARD_CODE;

        newCountryShip = UserData.ShippingProductCheckout.BillingAdress.COUNTRY;
        newProvinceShip = UserData.ShippingProductCheckout.BillingAdress.PROVINCE;
        newZipCodeShip = UserData.ShippingProductCheckout.BillingAdress.ZIPCODE;
        newCityShip = UserData.ShippingProductCheckout.BillingAdress.CITY;
        newAddress1Ship = UserData.ShippingProductCheckout.BillingAdress.ADDRESS_1;
        newPhoneNumberShip = UserData.ShippingProductCheckout.BillingAdress.PHONE_NUMBER;
        newTotalPriceOrder = UserData.ShippingProductCheckout.BillingAdress.TOTAL_PRICE_ORDER;
        newShippingMethod = UserData.ShippingProductCheckout.BillingAdress.SHIPPING_METHOD;

        log.info("Pre-condition - Step 01: Open End User Page URL");
        driver = getBrowserDriverUrl(browserName, GlobalConstants.PORTAL_PAGE_URL);
        homePage = PageGeneratorManager.getUserHomePage(driver);

        log.info("Pre-condition - Step 02: Set cookie and reload page");
        homePage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
        homePage.refreshCurrentPage(driver);

        log.info("Pre-condition - Step 03: Verify 'My Account' Link is displayed");
        verifyTrue(homePage.isMyAccountDisplayed());

        log.info("Pre-condition - Step 04: Click to 'Desktops' category");
        homePage.hoverDynamicProductCategoryOnTopMenuByName(driver, "Computers");
        categoryPage = homePage.openCategoryPageOnTopMenuByCategoryName("Desktops");

        log.info("Pre-condition - Step 05: Open details product: " + productName);
        productDetailPage = categoryPage.openDynamicProductDetailPageByName(productName);

        log.info("Pre-condition - Step 06: Verify " + productName + " is displayed at Product details page");
        verifyEquals(productDetailPage.getCurrentProductName(), productName);
    }

    @Test
    public void Order_01_Add_Product_Card(Method method) {
        ExtentTestManager.startTest(method.getName(), "Order_01_Add_Product_Card");
        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 01: Select to processor dropdown with value: " + processorOption);
        productDetailPage.selectItemToProcessorDropdown(processorOption);

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 02: Select to RAM dropdown with value: " + ramOption);
        productDetailPage.selectItemToRamDropdown(ramOption);

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 03: Check to HDD radio with value: " + hddOption);
        productDetailPage.checkToHddOptionRadio(hddOption);
        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 04: Check to OS radio with value: " + osOption);
        productDetailPage.checkToOsOptionRadio(osOption);
        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 05: Check to Software checkbox with value: " + Arrays.toString(softwareOptions));
        productDetailPage.checkToSoftwareOptionCheckbox(softwareOptions[0]);
        productDetailPage.checkToSoftwareOptionCheckbox(softwareOptions[1]);
        productDetailPage.checkToSoftwareOptionCheckbox(softwareOptions[2]);
        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 06: Click to 'Add to Cart' button");
        productDetailPage.clickToAddToCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 07: Verify the 'Add to cart success' message is displayed");
        verifyTrue(productDetailPage.isMessageDispalyedOnBarNotificationByMessage(driver, "The product has been added to your shopping cart"));
        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 08: Click to 'shopping cart' link on Bar notification");
        shoppingCartPage = productDetailPage.clickToShoppingCartLinkOnBarNotification();

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Card - Step 09: Verify the 'Shopping cart' title is displayed");
        verifyTrue(shoppingCartPage.isShoppingCartTitleDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 10: Verify the product has been add to card with correct data");
        verifyTrue(shoppingCartPage.isProductNameDisplayedAtCartTable(productName));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayed(processorOption));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayed(ramOption));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayed(hddOption));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayed(osOption));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayed(softwareOptions[0]));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayed(softwareOptions[1]));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayed(softwareOptions[2]));

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 11: Hover to 'Shopping cart' link at User Page header");
        shoppingCartPage.hoverToShoppingCartLinkAtUserPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 12: Verify the product is shown poperly at mini cart ");
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayedAtMiniCart(processorOption));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayedAtMiniCart(hddOption));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayedAtMiniCart(ramOption));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayedAtMiniCart(osOption));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayedAtMiniCart(softwareOptions[0]));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayedAtMiniCart(softwareOptions[1]));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayedAtMiniCart(softwareOptions[2]));

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 13: Verify '1 item(s) add your cart' is displayed ");
        verifyEquals(shoppingCartPage.getCurrentItemQuantityAtMiniCart(), "1");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 13: Verify the sub-total display at mini cart with value: " + totalPriceCart);
        verifyEquals(shoppingCartPage.getCurrentSubTotalAtMiniCart(), totalPriceCart);


    }

    @Test
    public void Order_02_Edit_Product_Card(Method method) {
        ExtentTestManager.startTest(method.getName(), "Order_02_Edit_Product_Card");
        ExtentTestManager.getTest().log(Status.INFO, "Edit Product - Step 01: Click to Edit link of product: " + productName);
        productDetailPage = shoppingCartPage.clickToEditLinkByProductName(productName);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Product - Step 02: Select to processor dropdown with value: " + processorOptionEdited);
        productDetailPage.selectItemToProcessorDropdown(processorOptionEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Product - Step 03: Select to RAM dropdown with value: " + ramOptionEdited);
        productDetailPage.selectItemToRamDropdown(ramOptionEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Product - Step 04: Check to HDD radio with value: " + hddOptionEdited);
        productDetailPage.checkToHddOptionRadio(hddOptionEdited);
        ExtentTestManager.getTest().log(Status.INFO, "Edit Product - Step 05: Check to OS radio with value: " + osOptionEdited);
        productDetailPage.checkToOsOptionRadio(osOptionEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Product - Step 06: Uncheck to Software checkbox with thesevalues: " + String.format("%s, %s", softwareOptions[1], softwareOptions[2]));
        productDetailPage.unCheckToSoftwareOptionCheckbox(softwareOptions[1]);
        productDetailPage.unCheckToSoftwareOptionCheckbox(softwareOptions[2]);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Product - Step 07: Enter to quantity product textbox with value '2'");
        productDetailPage.enterToQuantityTextbox("2");

        ExtentTestManager.getTest().log(Status.INFO, "Edit Product - Step 08: Verify the sub-total is " + productPriceEdited);
        verifyEquals(productDetailPage.getCurrentProductPrice(), productPriceEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Edit Product - Step 09: Click to 'Update' button");
        productDetailPage.clickToUpdateButton();

        ExtentTestManager.getTest().log(Status.INFO, "Edit Product - Step 10: Verify the messsage 'Add product to card success' is displayed ");
        verifyTrue(productDetailPage.isMessageDispalyedOnBarNotificationByMessage(driver, "The product has been added to your shopping cart"));

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 11: Click to 'shopping cart' link on Bar notification");
        shoppingCartPage = productDetailPage.clickToShoppingCartLinkOnBarNotification();

        ExtentTestManager.getTest().log(Status.INFO, "Add Product To Card - Step 12: Verify the 'Shopping cart' title is displayed");
        verifyTrue(shoppingCartPage.isShoppingCartTitleDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 13: Verify the product has been add to card with correct edited data");
        verifyTrue(shoppingCartPage.isProductNameDisplayedAtCartTable(productName));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayed(processorOptionEdited));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayed(ramOptionEdited));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayed(hddOptionEdited));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayed(osOptionEdited));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayed(softwareOptions[0]));

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 14: Verify the Total display at Shopping cart table with value: " + totalPriceCartEdited);
        verifyEquals(shoppingCartPage.getTotalPriceAtCartTableByProductName(productName), totalPriceCartEdited);

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 15: Verify the quantity at Shopping cart table with value '2' ");
        verifyEquals(shoppingCartPage.getQuantityByProductNameAtCartTable(productName), "2");


        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 15: Hover to 'Shopping cart' link at User Page header");
        shoppingCartPage.hoverToShoppingCartLinkAtUserPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 16: Verify the product is shown poperly at mini cart ");
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayedAtMiniCart(processorOptionEdited));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayedAtMiniCart(hddOptionEdited));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayedAtMiniCart(ramOptionEdited));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayedAtMiniCart(osOptionEdited));
        verifyTrue(shoppingCartPage.isDataOptionProductDisplayedAtMiniCart(softwareOptions[0]));

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 17: Verify '1 item(s) add your cart' is displayed ");
        verifyEquals(shoppingCartPage.getCurrentItemQuantityAtMiniCart(), "2");

        ExtentTestManager.getTest().log(Status.INFO, "Add Product to Card - Step 18: Verify the sub-total display at mini cart with value: " + totalPriceCartEdited);
        verifyEquals(shoppingCartPage.getCurrentSubTotalAtMiniCart(), totalPriceCartEdited);

    }

    @Test
    public void Order_03_Remove_Product_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Order_03_Remove_Product_Cart");
        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 01: Click to remove button of product: " + productName + " at Cart Table");
        shoppingCartPage.clickToRemoveButtonByProductName(productName);

        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 02: Verify the 'Your Shopping Cart is empty!' is displayed");
        verifyTrue(shoppingCartPage.isEmptyCartMessageDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Remove Product - Step 03: Verify the product has been removed from cart successfully");
        verifyTrue(shoppingCartPage.isProductNameUndisplayedAtCart(productName));
        verifyTrue(shoppingCartPage.isDataProductUndisplayedAtCart(processorOption));
//        verifyTrue(shoppingCartPage.isDataProductUndisplayedAtCart(ramOption));
//        verifyTrue(shoppingCartPage.isDataProductUndisplayedAtCart(hddOption));
//        verifyTrue(shoppingCartPage.isDataProductUndisplayedAtCart(osOption));
//        verifyTrue(shoppingCartPage.isDataProductUndisplayedAtCart(softwareOptions[0]));
    }

    @Test
    public void Order_04_Update_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Order_04_Update_Shopping_Cart");
        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 01: Enter to global search store with value: " + productNameUpdateCart);
        shoppingCartPage.enterToSearchStoreTextBox(driver, productNameUpdateCart);

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 02: Click to 'SEARCH' button at search store box");
        shoppingCartPage.clickToSearchStoreButton(driver);
        categoryPage = PageGeneratorManager.getCategoryPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 03: Click to product title and open details product: " + productNameUpdateCart);
        productDetailPage = categoryPage.openDynamicProductDetailPageByName(productNameUpdateCart);

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 04: Click to 'Add to Cart' button");
        productDetailPage.clickToAddToCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 05: Verify the 'Add to cart success' message is displayed");
        verifyTrue(productDetailPage.isMessageDispalyedOnBarNotificationByMessage(driver, "The product has been added to your shopping cart"));

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 06: Click to 'shopping cart' link on Bar notification");
        shoppingCartPage = productDetailPage.clickToShoppingCartLinkOnBarNotification();

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 07: Increase quantity product textbox to '5' at Cart table");
        shoppingCartPage.enterToQuanityTextboxByProductName("5", productNameUpdateCart);

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 08: Click to 'Update Shopping Cart' button");
        shoppingCartPage.clickToUpdateShoppingCart();

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 09: Verify the current total price cart is " + totalPriceCartUpdateCart);
        verifyEquals(shoppingCartPage.getTotalPriceAtCartTableByProductName(productNameUpdateCart), totalPriceCartUpdateCart);

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 10: Hover to 'Shopping cart' link on header");
        shoppingCartPage.hoverToShoppingCartLinkAtUserPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 11: Verify the current sub-total at mini cart is " + totalPriceCartUpdateCart);
        verifyEquals(shoppingCartPage.getCurrentSubTotalAtMiniCart(), totalPriceCartUpdateCart);

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 12: Click to remove button of product: " + productNameUpdateCart + " at Cart Table");
        shoppingCartPage.clickToRemoveButtonByProductName(productNameUpdateCart);

        ExtentTestManager.getTest().log(Status.INFO, "Update Shopping Cart - Step 13: Verify the 'Your Shopping Cart is empty!' is displayed");
        verifyTrue(shoppingCartPage.isEmptyCartMessageDisplayed());


    }

    @Test
    public void Order_05_Checkout_Product(Method method) {
        ExtentTestManager.startTest(method.getName(), "Order_05_Checkout_Product");
        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 01: Enter to serach store textbox with value: " + productNameCheckout);
        shoppingCartPage.enterToSearchStoreTextBox(driver, productNameCheckout);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 02: Click to 'Search' button at search store box");
        shoppingCartPage.clickToSearchStoreButton(driver);
        categoryPage = PageGeneratorManager.getCategoryPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 03: Open product details page: " + productNameCheckout);
        productDetailPage = categoryPage.openDynamicProductDetailPageByName(productNameCheckout);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 04: Click to 'Add to cart' button");
        productDetailPage.clickToAddToCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 05: Verify the 'add to cart success' message is displayed");
        verifyTrue(productDetailPage.isMessageDispalyedOnBarNotificationByMessage(driver, "The product has been added to your shopping cart"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 06: Click to 'shopping cart' link on Bar notification");
        shoppingCartPage = productDetailPage.clickToShoppingCartLinkOnBarNotification();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 07: Select 'Gift wrapping' dropdown with option: " + wrappingOption);
        shoppingCartPage.selectOptionAtGiftWrappingDropdown(wrappingOption);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 08: Click to 'Estimate shipping' link");
        shoppingCartPage.clickToEstimateShippingLink();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 09: Select to 'Ship to' dropdown with option: " + countryShip);
        shoppingCartPage.selectDefaultDropDownByName(driver, "CountryId", countryShip);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 10: Select to 'Province' dropdown with option: " + provinceShip);
        shoppingCartPage.selectDefaultDropDownByName(driver, "StateProvinceId", provinceShip);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 11: Enter to Zipcode textbox with value: " + zipCodeShip);
        shoppingCartPage.inputToTextboxById(driver, "ZipPostalCode", zipCodeShip);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 12: Click to 'Apply' button");
        shoppingCartPage.clickToApplyButtonInShipPopup();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 13: Check to 'Agree' checkbox for the terms of service");
        shoppingCartPage.checkToAgreeTermCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 14: Click to 'Checkout' button");
        checkoutPage = shoppingCartPage.clickToCheckoutButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 15: Select to 'Country' dropdown with value: " + countryShip);
        checkoutPage.selectDefaultDropDownByName(driver, "BillingNewAddress.CountryId", countryShip);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 16: Select to 'Province' dropdown with value: " + provinceShip);
        checkoutPage.selectDefaultDropDownByName(driver, "BillingNewAddress.StateProvinceId", provinceShip);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 17: Enter to 'City' textbox with value: " + cityShip);
        checkoutPage.inputToTextboxById(driver, "BillingNewAddress_City", cityShip);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 18: Enter to 'Addres 1' textbox with value: " + address1Ship);
        checkoutPage.inputToTextboxById(driver, "BillingNewAddress_Address1", address1Ship);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 19: Enter to 'Zip code' textbox with value: " + zipCodeShip);
        checkoutPage.inputToTextboxById(driver, "BillingNewAddress_ZipPostalCode", zipCodeShip);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 20: Enter to 'Phone Number' textbox with value: " + phoneNumberShip);
        checkoutPage.inputToTextboxById(driver, "BillingNewAddress_PhoneNumber", phoneNumberShip);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 21: Click to 'Continue' button");
        checkoutPage.clickToContinueButtonByContainerId("billing-buttons-container");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 22: Check to 'Next Day Air' shipping method checkbox");
        checkoutPage.checkToShippingMethodOption(shippingMethod);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 23: Click to 'Continue' button");
        checkoutPage.clickToContinueButtonByContainerId("shipping-method-buttons-container");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 24: Click to 'Check/Money Order' Payment method checkbox");
        checkoutPage.checkToPaymentMethodOption(paymentMethod);
        checkoutPage.clickToContinueButtonByContainerId("payment-method-buttons-container");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 25: Verify the payment information has been shown");
        verifyTrue(checkoutPage.isPaymentAnnouncementMessageDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 26: Click to 'Continue' button");
        checkoutPage.clickToContinueButtonByContainerId("payment-info-buttons-container");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 27: Verify the product information has been shown properly at Confirm section");
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(fullName));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(email));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(phoneNumberShip));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(address1Ship));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(cityShip));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(countryShip));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(zipCodeShip));
        verifyTrue(checkoutPage.isPaymentMethodDisplayed(paymentMethod));

        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(email));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(phoneNumberShip));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(address1Ship));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(cityShip));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(countryShip));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(zipCodeShip));
        verifyTrue(checkoutPage.isShippingMethodDisplayed(shippingMethod));

        verifyTrue(checkoutPage.isProductNameDisplayedAtOrderTable(productNameCheckout));
        verifyEquals(checkoutPage.getTotalPriceOrderAtOrderTable(productNameCheckout), totalPriceOrder);
        verifyEquals(checkoutPage.getCurrentQuantityAtOrderTable(productNameCheckout), "2");
        verifyTrue(checkoutPage.isWrappingOptionDislayed(wrappingOption));
        verifyEquals(checkoutPage.getOrderSubTotalSummary(), totalPriceOrder);
        verifyEquals(checkoutPage.getOrderTotalSummary(), totalPriceOrder);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 28: Click to 'Confirm' button");
        checkoutPage.clickToConfirmButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 29: Verify the 'Thank you' message and 'Order Number' have been shown properly");
        verifyTrue(checkoutPage.isOrderSuccessMessagDisplayed());
        orderNumber = checkoutPage.getCurrentOrderNumber();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 30: Click to 'My account' link at User page");
        customerInfoPage = checkoutPage.openMyAccountPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 31: Navigate to Order page by clicking to 'Order' tab");
        customerInfoPage.openDynamicPageAtMyAccountByName(driver, "Orders");
        orderDetailPage = PageGeneratorManager.getOrderPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 32: Verify the order information has been shown properly");
        verifyTrue(orderDetailPage.isOrderNumberDisplayed(orderNumber));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 33: Click to 'Details' button");
        orderDetailPage.clickToDetailButtonByOrderNumber(orderNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 34: Verify the product information has been shown properly at Order details page");
        verifyTrue(orderDetailPage.isOrderNumberTitleDisplayed(orderNumber));
        verifyEquals(orderDetailPage.getCurrentOrderStatusAtOrderInforamtion(), "Pending");
        verifyEquals(orderDetailPage.getTotalOrder(), totalPriceOrder);

        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(fullName));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(email));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(phoneNumberShip));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(address1Ship));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(cityShip));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(countryShip));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(zipCodeShip));
        verifyTrue(orderDetailPage.isPaymentMethodDisplayed(paymentMethod));
        verifyTrue(orderDetailPage.isPaymentStatusPendingDisplayed());

        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(email));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(phoneNumberShip));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(address1Ship));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(cityShip));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(countryShip));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(zipCodeShip));
        verifyTrue(orderDetailPage.isShippingMethodDisplayed(shippingMethod));
        verifyTrue(orderDetailPage.isShippingStatusNotYetDisplayed());


        verifyTrue(orderDetailPage.isProductNameDisplayedAtOrderTable(productNameCheckout));
        verifyEquals(orderDetailPage.getTotalPriceOrderAtOrderTable(productNameCheckout), totalPriceOrder);
        verifyEquals(orderDetailPage.getCurrentQuantityAtOrderTable(productNameCheckout), "2");
        verifyTrue(orderDetailPage.isWrappingOptionDislayed(wrappingOption));
        verifyEquals(orderDetailPage.getOrderSubTotalSummary(), totalPriceOrder);
        verifyEquals(orderDetailPage.getOrderTotalSummary(), totalPriceOrder);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product - Step 35: Waiting for the site availability to place the next order ");
        orderDetailPage.sleepInSecond(30);

    }

    @Test
    public void Order_06_Checkout_Product_Credit_Card(Method method) {
        ExtentTestManager.startTest(method.getName(), "Order_07_Checkout_Product_Credit_Card");
        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 01: Enter to serach store textbox with value: " + productNameCheckout);
        shoppingCartPage.enterToSearchStoreTextBox(driver, productNameCheckout);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 02: Click to 'Search' button at search store box");
        shoppingCartPage.clickToSearchStoreButton(driver);
        categoryPage = PageGeneratorManager.getCategoryPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 03: Open product details page: " + productNameCheckout);
        productDetailPage = categoryPage.openDynamicProductDetailPageByName(productNameCheckout);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 04: Click to 'Add to cart' button");
        productDetailPage.clickToAddToCartButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 05: Verify the 'add to cart success' message is displayed");
        verifyTrue(productDetailPage.isMessageDispalyedOnBarNotificationByMessage(driver, "The product has been added to your shopping cart"));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 06: Click to 'shopping cart' link on Bar notification");
        shoppingCartPage = productDetailPage.clickToShoppingCartLinkOnBarNotification();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 07: Select 'Gift wrapping' dropdown with option: " + wrappingOption);
        shoppingCartPage.selectOptionAtGiftWrappingDropdown(wrappingOption);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 08: Click to 'Estimate shipping' link");
        shoppingCartPage.clickToEstimateShippingLink();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 09: Select to 'Ship to' dropdown with option: " + countryShip);
        shoppingCartPage.selectDefaultDropDownByName(driver, "CountryId", countryShip);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 10: Select to 'Province' dropdown with option: " + provinceShip);
        shoppingCartPage.selectDefaultDropDownByName(driver, "StateProvinceId", provinceShip);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 11: Enter to Zipcode textbox with value: " + zipCodeShip);
        shoppingCartPage.inputToTextboxById(driver, "ZipPostalCode", zipCodeShip);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 12: Click to 'Apply' button");
        shoppingCartPage.clickToApplyButtonInShipPopup();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 13: Check to 'Agree' checkbox for the terms of service");
        shoppingCartPage.checkToAgreeTermCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 14: Click to 'Checkout' button");
        checkoutPage = shoppingCartPage.clickToCheckoutButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 15: Click to 'Continue' button");
        checkoutPage.clickToContinueButtonByContainerId("billing-buttons-container");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 16: Check to 'Next Day Air' shipping method checkbox");
        checkoutPage.checkToShippingMethodOption(shippingMethod);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 17: Click to 'Continue' button");
        checkoutPage.clickToContinueButtonByContainerId("shipping-method-buttons-container");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 18: Click to 'Check/Money Order' Payment method checkbox");
        checkoutPage.checkToPaymentMethodOption(paymentMethodCreditCard);
        checkoutPage.clickToContinueButtonByContainerId("payment-method-buttons-container");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 19: Enter to Cardholder name textbox with value: " + cardholderName);
        checkoutPage.inputToTextboxById(driver, "CardholderName", cardholderName);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 20: Enter to Card number textbox with value: " + cardNumber);
        checkoutPage.inputToTextboxById(driver, "CardNumber", cardNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 21: Select to Expiration date with value: " + expirationMonth + "/" + expirationYear);
        checkoutPage.selectDefaultDropDownByName(driver, "ExpireMonth", expirationMonth);
        checkoutPage.selectDefaultDropDownByName(driver, "ExpireYear", expirationYear);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 22: Enter to Card code textbox with value: " + cardCode);
        checkoutPage.inputToTextboxById(driver, "CardCode", cardCode);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 23: Click to 'Continue' button");
        checkoutPage.clickToContinueButtonByContainerId("payment-info-buttons-container");

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 24: Verify the product information has been shown properly at Confirm section");
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(fullName));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(email));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(phoneNumberShip));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(address1Ship));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(cityShip));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(countryShip));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(zipCodeShip));
        verifyTrue(checkoutPage.isPaymentMethodDisplayed(paymentMethodCreditCard));

        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(email));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(phoneNumberShip));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(address1Ship));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(cityShip));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(countryShip));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(zipCodeShip));
        verifyTrue(checkoutPage.isShippingMethodDisplayed(shippingMethod));

        verifyTrue(checkoutPage.isProductNameDisplayedAtOrderTable(productNameCheckout));
        verifyEquals(checkoutPage.getTotalPriceOrderAtOrderTable(productNameCheckout), totalPriceOrder);
        verifyEquals(checkoutPage.getCurrentQuantityAtOrderTable(productNameCheckout), "2");
        verifyTrue(checkoutPage.isWrappingOptionDislayed(wrappingOption));
        verifyEquals(checkoutPage.getOrderSubTotalSummary(), totalPriceOrder);
        verifyEquals(checkoutPage.getOrderTotalSummary(), totalPriceOrder);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 25: Click to 'Confirm' button");
        checkoutPage.clickToConfirmButton();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 26: Verify the 'Thank you' message and 'Order Number' have been shown properly");
        verifyTrue(checkoutPage.isOrderSuccessMessagDisplayed());
        orderNumber = checkoutPage.getCurrentOrderNumber();

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 27: Click to 'My account' link at User page");
        customerInfoPage = checkoutPage.openMyAccountPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 28: Navigate to Order page by clicking to 'Order' tab");
        customerInfoPage.openDynamicPageAtMyAccountByName(driver, "Orders");
        orderDetailPage = PageGeneratorManager.getOrderPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 29: Verify the order information has been shown properly");
        verifyTrue(orderDetailPage.isOrderNumberDisplayed(orderNumber));

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 30: Click to 'Details' button");
        orderDetailPage.clickToDetailButtonByOrderNumber(orderNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 31: Verify the product information has been shown properly at Order details page");
        verifyTrue(orderDetailPage.isOrderNumberTitleDisplayed(orderNumber));
        verifyEquals(orderDetailPage.getCurrentOrderStatusAtOrderInforamtion(), "Pending");
        verifyEquals(orderDetailPage.getTotalOrder(), totalPriceOrder);


        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(fullName));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(email));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(phoneNumberShip));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(address1Ship));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(cityShip));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(countryShip));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(zipCodeShip));
        verifyTrue(orderDetailPage.isPaymentMethodDisplayed(paymentMethodCreditCard));
        verifyTrue(orderDetailPage.isPaymentStatusPendingDisplayed());

        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(email));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(phoneNumberShip));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(address1Ship));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(cityShip));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(countryShip));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(zipCodeShip));
        verifyTrue(orderDetailPage.isShippingMethodDisplayed(shippingMethod));
        verifyTrue(orderDetailPage.isShippingStatusNotYetDisplayed());

        verifyTrue(orderDetailPage.isProductNameDisplayedAtOrderTable(productNameCheckout));
        verifyEquals(orderDetailPage.getTotalPriceOrderAtOrderTable(productNameCheckout), totalPriceOrder);
        verifyEquals(orderDetailPage.getCurrentQuantityAtOrderTable(productNameCheckout), "2");
        verifyTrue(orderDetailPage.isWrappingOptionDislayed(wrappingOption));
        verifyEquals(orderDetailPage.getOrderSubTotalSummary(), totalPriceOrder);
        verifyEquals(orderDetailPage.getOrderTotalSummary(), totalPriceOrder);

        ExtentTestManager.getTest().log(Status.INFO, "Checkout product Credit Card - Step 32: Waiting for the site availability to place the next order");
        orderDetailPage.sleepInSecond(30);

    }

    @Test
    public void Order_07_ReOrder_Product(Method method) {
        ExtentTestManager.startTest(method.getName(), "Order_07_ReOrder_Product");
        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 01: Click to 'Re-order' button");
        shoppingCartPage = orderDetailPage.clickToReOderButton();

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 02: Enter to quantity with value '10' of product: " + productNameCheckout);
        shoppingCartPage.enterToQuanityTextboxByProductName("10", productNameCheckout);

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 03: Click to 'Update shopping cart' button");
        shoppingCartPage.clickToUpdateShoppingCart();

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 04: Check to 'Agree' checkbox for the terms of service");
        shoppingCartPage.checkToAgreeTermCheckbox();

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 04: Click to 'Checkout' button");
        checkoutPage = shoppingCartPage.clickToCheckoutButton();

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 05: Click to 'Edit' button at Billing Adree");
        checkoutPage.clickToEditButtonAtBillingAddress();

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 06: Enter the new data Billing Address");
        checkoutPage.selectDefaultDropDownByName(driver, "BillingNewAddress.CountryId", newCountryShip);
        checkoutPage.selectDefaultDropDownByName(driver, "BillingNewAddress.StateProvinceId", newProvinceShip);
        checkoutPage.inputToTextboxById(driver, "BillingNewAddress_City", newCityShip);
        checkoutPage.inputToTextboxById(driver, "BillingNewAddress_Address1", newAddress1Ship);
        checkoutPage.inputToTextboxById(driver, "BillingNewAddress_ZipPostalCode", newZipCodeShip);
        checkoutPage.inputToTextboxById(driver, "BillingNewAddress_PhoneNumber", newPhoneNumberShip);


        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 07: Click to 'Save' button at Billing Adress");
        checkoutPage.clickToSaveButtonAtBillingAdress();

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 08: Click to 'Continue' button at Billing Adress");
        checkoutPage.clickToContinueButtonByContainerId("billing-buttons-container");

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 09: Check to shipping method checkbox with value: " + newShippingMethod);
        checkoutPage.checkToShippingMethodOption(newShippingMethod);

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 10: Click to 'Continue' button at Shipping Method");
        checkoutPage.clickToContinueButtonByContainerId("shipping-method-buttons-container");

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 11: Click to 'Continue' button at Payment Method");
        checkoutPage.clickToContinueButtonByContainerId("payment-method-buttons-container");

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 12: Verify the payment information has been shown");
        verifyTrue(checkoutPage.isPaymentAnnouncementMessageDisplayed());

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 13: Click to 'Continue' button at Payment information");
        checkoutPage.clickToContinueButtonByContainerId("payment-info-buttons-container");

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 14: Verify the product information has been shown properly at Confirm section");
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(newPhoneNumberShip));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(newAddress1Ship));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(newCityShip));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(newCountryShip));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(newProvinceShip));
        verifyTrue(checkoutPage.isBillingAddressInformationDislayed(newZipCodeShip));
        verifyTrue(checkoutPage.isPaymentMethodDisplayed(paymentMethod));

        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(email));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(newPhoneNumberShip));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(newAddress1Ship));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(newCityShip));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(newProvinceShip));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(newCountryShip));
        verifyTrue(checkoutPage.isShippingAddressInformationDisplayed(newZipCodeShip));
        verifyTrue(checkoutPage.isShippingMethodDisplayed(newShippingMethod));

        verifyTrue(checkoutPage.isProductNameDisplayedAtOrderTable(productNameCheckout));
        verifyEquals(checkoutPage.getTotalPriceOrderAtOrderTable(productNameCheckout), newTotalPriceOrder);
        verifyEquals(checkoutPage.getCurrentQuantityAtOrderTable(productNameCheckout), "10");

        verifyTrue(checkoutPage.isWrappingOptionDislayed(wrappingOption));

        verifyEquals(checkoutPage.getOrderSubTotalSummary(), newTotalPriceOrder);
        verifyEquals(checkoutPage.getOrderTotalSummary(), newTotalPriceOrder);


        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 15: Click to 'Confirm' button");
        checkoutPage.clickToConfirmButton();


        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 16: Verify the 'Thank you' message and 'Order Number' have been shown properly");
        verifyTrue(checkoutPage.isOrderSuccessMessagDisplayed());
        orderNumber = checkoutPage.getCurrentOrderNumber();

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 17: Click to 'My account' link at User page");
        customerInfoPage = checkoutPage.openMyAccountPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 18: Navigate to Order page by clicking to 'Order' tab");
        customerInfoPage.openDynamicPageAtMyAccountByName(driver, "Orders");
        orderDetailPage = PageGeneratorManager.getOrderPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 19: Verify the order information has been shown properly");
        verifyTrue(orderDetailPage.isOrderNumberDisplayed(orderNumber));

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 20: Click to 'Details' button");
        orderDetailPage.clickToDetailButtonByOrderNumber(orderNumber);

        ExtentTestManager.getTest().log(Status.INFO, "Reorder Product - Step 21: Verify the product information has been shown properly at Order details page");
        verifyTrue(orderDetailPage.isOrderNumberTitleDisplayed(orderNumber));
        verifyEquals(orderDetailPage.getCurrentOrderStatusAtOrderInforamtion(), "Pending");
        verifyEquals(orderDetailPage.getTotalOrder(), newTotalPriceOrder);


        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(fullName));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(newPhoneNumberShip));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(newAddress1Ship));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(newProvinceShip));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(newCityShip));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(newCountryShip));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(newZipCodeShip));
        verifyTrue(orderDetailPage.isPaymentMethodDisplayed(paymentMethod));
        verifyTrue(orderDetailPage.isPaymentStatusPendingDisplayed());

        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(email));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(newPhoneNumberShip));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(newAddress1Ship));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(newCityShip));
        verifyTrue(orderDetailPage.isBillingAddressInformationDisplayed(newProvinceShip));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(newCountryShip));
        verifyTrue(orderDetailPage.isShippingAddressInformationDisplayed(newZipCodeShip));
        verifyTrue(orderDetailPage.isShippingMethodDisplayed(newShippingMethod));
        verifyTrue(orderDetailPage.isShippingStatusNotYetDisplayed());


        verifyEquals(orderDetailPage.getTotalPriceOrderAtOrderTable(productNameCheckout), newTotalPriceOrder);
        verifyEquals(orderDetailPage.getCurrentQuantityAtOrderTable(productNameCheckout), "10");
        verifyTrue(orderDetailPage.isWrappingOptionDislayed(wrappingOption));
        verifyEquals(orderDetailPage.getOrderSubTotalSummary(), newTotalPriceOrder);
        verifyEquals(orderDetailPage.getOrderTotalSummary(), newTotalPriceOrder);


    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

}
