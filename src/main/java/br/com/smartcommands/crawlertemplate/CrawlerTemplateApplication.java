package br.com.smartcommands.crawlertemplate;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.nio.file.Paths;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrawlerTemplateApplication {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
			Page page = browser.newPage();
			page.navigate("https://playwright.dev/");
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
		}

		SpringApplication.run(CrawlerTemplateApplication.class, args);
	}

}
