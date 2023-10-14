package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class CourseWorkSteps extends BaseTest {


    @Test
    @Given("I am an anonymous customer with clear cookies")
    public void i_am_an_anonymous_customer_with_clear_cookies() {
    }

    @Test(dependsOnMethods = "i_am_an_anonymous_customer_with_clear_cookies")
    @And("I open the Home page")
    public void i_open_the_home_page() {
    }

    @Test(dependsOnMethods = "i_open_the_home_page")
    @And("I search for Thinking in Java")
    public void i_search_for_thinking_in_java() {
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Thinking in Java");
        driver.findElement(By.xpath("(//*[@class='ui-btn-primary'])[1]")).click();
    }

    @Test(dependsOnMethods = "i_search_for_thinking_in_java")
    @And("I am redirected to a Search results page")
    public void i_am_redirected_to_a_search_results_page() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Результати пошуку')]")).isDisplayed());
    }

    @Test(dependsOnMethods = "i_am_redirected_to_a_search_results_page")
    @And("Search results contain 35 items")
    public void search_results_contain_items() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), \"35 товарів\")]")).isDisplayed());
    }

    @Test(dependsOnMethods = "search_results_contain_items")
    @And("I sort Search results from newest")
    public void i_sort_search_results_from_newest() {
        driver.findElement(By.xpath("(//*[contains(text(), \"За популярністю\")])[1]")).click();
        driver.findElement(By.xpath("//*[contains(text(), \"За новизною\")]")).click();
    }

    @Test(dependsOnMethods = "i_sort_search_results_from_newest")
    @And("search results contain Thinking in Pictures: Adventures in Trying to be Smart")
    public void search_result_contain_thinking_in_pictures_adventures_in_trying_to_be_smart() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), \"Thinking in Pictures: " +
                "Adventures in Trying to be Smart\")]")).isDisplayed());

    }

    @Test(dependsOnMethods = "search_result_contain_thinking_in_pictures_adventures_in_trying_to_be_smart")
    @And("I apply the following search filters")
    public void i_apply_the_following_search_filters() throws InterruptedException {

//      не видаляти, поки не придумаю як закрити банер в разі появі
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[@class=\"cl-floating-box-close-icon\"]"))).click();

        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='ui-filter-checkbox__text'])[2]")).isDisplayed());
        driver.findElement(By.xpath("(//span[@class='ui-filter-checkbox__text'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='ui-filter-checkbox__text'])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains (text(), \"Англійська\")]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class = \"ui-base-input prefix\"])[1]")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//*[@class = \"ui-base-input prefix\"])[1]")).sendKeys("1160");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains (text(), \"Застосувати\")]")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), \"6 товарів\")]")).isDisplayed());
    }

    @Test(dependsOnMethods = "i_apply_the_following_search_filters")
    @And("Search results contain only the following products")
    public void search_results_contain_the_following_products() throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.linkText("Human Frontiers. The Future of Big Ideas in an Age of " +
                "Small Thinking")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("Assessing and Developing Communication and Thinking Skills " +
                "in People with Autism and Communication Difficulties")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("Re-thinking Children’s Work in Churches")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("3D Thinking in Design and Architecture")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("Exact Thinking in Demented Times")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("59 Paintings. In which the artist considers the process of " +
                "thinking about and making work")).isDisplayed());
        driver.findElement(By.xpath("//*[contains (text(), \"Thames and Hudson\")]")).click();
        Thread.sleep(2000);

    }

    @Test(dependsOnMethods = "search_results_contain_the_following_products")
    @And("I click Add to basket button for product wit name 3D Thinking in Design and Architecture")
    public void i_click_add_to_basket_button_for_product_wit_name_3d_thinking_in_design_and_architecture() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(4000);
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), \"3D Thinking in Design and Architecture\")]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        Thread.sleep(2000);

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[contains (text(), \"До кошика\")]"))).click();
    }

    @Test(dependsOnMethods = "i_click_add_to_basket_button_for_product_wit_name_3d_thinking_in_design_and_architecture")
    @And("I select Basket Checkout in basket pop-up")
    public void i_select_basket_checkout_in_basket_pop_up() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[contains (text(), \"Оформити замовлення\")]"))).click();
    }

    @Test(dependsOnMethods = "i_select_basket_checkout_in_basket_pop_up")
    @And("I am redirected to a Basket page")
    public void i_am_redirected_to_a_basket_page() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("(//*[contains (text(), \"Оформлення замовлення\")])[2]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//*[contains (text(), \"Контактні дані\")])[1]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("(//*[contains (text(), \"Доставка\")])[2]")).isDisplayed());
    }

    @Test(dependsOnMethods = "i_am_redirected_to_a_basket_page")
    @And("I fill in personal and delivery information manually")
    public void i_fill_in_personal_and_delivery_information_manually() throws InterruptedException {
        driver.findElement(By.name("first name")).sendKeys("Michael");
        driver.findElement(By.name("last name")).sendKeys("Keeton");
        driver.findElement(By.xpath("//*[@type=\"tel\"]")).sendKeys("0962352783");
        driver.findElement(By.name("email")).sendKeys("test4life@yaka.boo");

        driver.findElement(By.xpath("(//*[@name=\"base-select-search\"])[2]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[contains (text(), \"Київ\")]"))).click();

        driver.findElement(By.xpath("//*[contains (text(), \"Відділення Нова Пошта\")]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@placeholder=\"Адреса відділення\"]")).sendKeys("99");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[contains (text(), \"Відділення №99: вул. Салютна, 5б\")]"))).click();
    }

    @Test(dependsOnMethods = "i_fill_in_personal_and_delivery_information_manually")
    @When("I press Pay button")
    public void i_press_pay_button() throws InterruptedException {
        WebElement PayOut = driver.findElement(By.xpath("(//div[@class=\"order-submit__submit\"])[2]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", PayOut);

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath
                ("(//div[@class=\"order-submit__submit\"])[2]"))).isDisplayed();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class=\"order-submit__submit\"])[2]")).click();
    }

    @Test(dependsOnMethods = "i_press_pay_button")
    @And("I am redirected to Checkout")
    public void i_am_redirected_to_checkout() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//*[contains (text(), \"Разом до оплати\")]"))).isDisplayed();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains (text(), \"Разом до оплати\")]")).isDisplayed());
    }

    @Test(dependsOnMethods = "i_am_redirected_to_checkout")
    @And("I fill in invalid payment information")
    public void i_fill_in_valid_payment_information() throws InterruptedException {
        WebElement cardNumber = driver.findElement(By.xpath("//input[@id=\"create[n]\"]"));
        WebElement cardIssueMonth = driver.findElement(By.xpath("//input[@id=\"create[m]\"]"));
        WebElement cardIssueYear = driver.findElement(By.xpath("//input[@id=\"create[y]\"]"));
        WebElement cardCVV = driver.findElement(By.xpath("//input[@id=\"create[c]\"]"));
        WebElement submitPayment = driver.findElement(By.xpath("//*[@tabindex=\"7\"]"));
        cardNumber.sendKeys("5409530000000077");
        cardIssueMonth.sendKeys("02");
        cardIssueYear.sendKeys("23");
        cardCVV.sendKeys("123");
        Thread.sleep(1000);
        Assert.assertTrue(submitPayment.isEnabled());
    }

    @Test(dependsOnMethods = "i_fill_in_valid_payment_information")
    @And("I click Submit button")
    public void i_click_submit_button() throws InterruptedException {
        driver.findElement(By.xpath("//*[@tabindex=\"7\"]")).click();
        Thread.sleep(5000);
    }

    @Test(dependsOnMethods = "i_click_submit_button")
    @And("I am redirected to payment provider page")
    public void i_am_redirected_to_payment_provide_page() {
        Assert.assertTrue(driver.findElement(By.xpath("(//*[contains (text(), \"Статус операції\")])[2]")).isDisplayed());
    }

    @Test(dependsOnMethods = "i_am_redirected_to_payment_provide_page")
    @Then("I receive error notification")
    public void i_receive_error_notification() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains (text(), \"☹ Статус операції\")]")).isDisplayed());
    }
}
