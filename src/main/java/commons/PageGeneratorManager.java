package commons;

import org.openqa.selenium.WebDriver;
import pageObjects.nopCommerce.admin.AdminCustomersPageObject;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.admin.AdminProductPageObject;
import pageObjects.nopCommerce.user.*;

public class PageGeneratorManager {
    public static UserHomePageObject getUserHomePage(WebDriver driver) {
        return new UserHomePageObject(driver);
    }

    public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
        return new UserRegisterPageObject(driver);
    }

    public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
        return new UserLoginPageObject(driver);
    }

    public static UserCustomerInfoPageObject getUserCustomerInfoPage(WebDriver driver) {
        return new UserCustomerInfoPageObject(driver);
    }

    public static UserAddressPageObject getUserAddressPage(WebDriver driver) {
        return new UserAddressPageObject(driver);
    }

    public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver) {
        return new UserMyProductReviewPageObject(driver);
    }

    public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
        return new UserRewardPointPageObject(driver);
    }

    public static UserChangePasswordPageObject getUserChangePasswordPage(WebDriver driver) {
        return new UserChangePasswordPageObject(driver);
    }

    public static UserCategoryPageObject getCategoryPage(WebDriver driver) {
        return new UserCategoryPageObject(driver);
    }

    public static UserProductDetailPageObject getProductDetailPage(WebDriver driver) {
        return new UserProductDetailPageObject(driver);

    }

    public static UserProductReviewPageObject getProductReviewPage(WebDriver driver) {
        return new UserProductReviewPageObject(driver);
    }

    public static UserSearchPageObject getSearchPage(WebDriver driver) {
        return new UserSearchPageObject(driver);
    }

    public static UserWishlistPageObject getWishListPage(WebDriver driver) {
        return new UserWishlistPageObject(driver);
    }

    public static UserShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
        return new UserShoppingCartPageObject(driver);
    }

    public static UserCompareProductPageObject getCompareProductPage(WebDriver driver) {
        return new UserCompareProductPageObject(driver);
    }
    public static UserCheckoutPageObject getCheckoutPage(WebDriver driver) {
        return new UserCheckoutPageObject(driver);
    }

    public static UserOrderPageObject getOrderPage(WebDriver driver) {
        return new UserOrderPageObject(driver);
    }


    /* Admin Page */

    public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPageObject(driver);
    }

    public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPageObject(driver);
    }

    public static AdminProductPageObject getAdminProductPage(WebDriver driver) {
        return new AdminProductPageObject(driver);
    }

    public static AdminCustomersPageObject getAdminCustomerPage(WebDriver driver) {
        return new AdminCustomersPageObject(driver);
    }

}
