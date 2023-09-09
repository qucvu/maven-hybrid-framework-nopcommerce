package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);		
	}
	
	public static AdminDashboardPO getAdminDashbpardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);		
	}
	
	public static AdminPostAddNewPO getAdminPostAddNewPage(WebDriver driver) {
		return new AdminPostAddNewPO(driver);		
	}
	
	public static AdminPostSearchPO getAdminSearchPage(WebDriver driver) {
		return new AdminPostSearchPO(driver);		
	}



	
	
	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);		
	}

	public static UserPostDetailPO getUserPostDetailPage(WebDriver driver) {
		return new UserPostDetailPO(driver);		
	}
	
	public static UserPostSearchPO getUserPostSearchPage(WebDriver driver) {
		return new UserPostSearchPO(driver);		
	}

	
	




}
