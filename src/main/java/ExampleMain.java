import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExampleMain {

    public static void main(String[] args) {

/*                System.setProperty( //Классическиц способ если не использовать webdriver
                "webdriver.chrome.driver", "src/main/resources/chromedriver"
        );*/

        WebDriverManager.chromedriver().setup(); //проверка драйвера если драйвера нет попробует скачать
        ChromeOptions options = new ChromeOptions();//создаём хром опции и указываем опции с которыми мы его запускаем
        options.addArguments("--incognito"); //опция запуск в режими инкогнито без кеша
        //options.addArguments("--headless"); позволяет запускать браузер в фоновом режиме сам браузер не запускается
        options.addArguments("start-maximized"); //открытие окна браузера на полный экран

        //Создаём webDriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // нне явное ожидание
        driver.get("https://google.com");

        WebElement webElement1 = driver.findElement(By.name("q")); //Указываем что ищем элемент через имя и укказываем имя
        WebElement webElement2 = driver.findElement(By.cssSelector("input.gLFyf"));
        WebElement webElement3 = driver.findElement(By.xpath(".//input[@name='q']"));

        try {
            WebElement webElementError = driver.findElement(By.name("error"));// попытались найти элемент но не нашли
        } catch (NoSuchElementException e){ // Получаем ошибку NoSuchElementException
            System.out.println(e.getSupportUrl());
        }

        List<WebElement> webElements = driver.findElements(By.name("error"));//Если знаем что элемент динамический и не всегда есть на сайте то возвращаем все элементы
        if(webElements.size()>1){
            //todo
        }

        webElement1.click(); //кликнули
        webElement2.sendKeys("Поиск");  //ввели текст


        try {
            Thread.sleep(10000); //заснуть на 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // new WebDriverWait(driver,5).until(ExpectedConditions.urlContains("google"));//задаём 5 секунд и задаём условие  until(ExpectedConditions.urlContains("google")

        driver.navigate().to("https://google.com");

        try {
            webElement3.sendKeys("Привет");
        } catch (StaleElementReferenceException e){ //он не доступен элементы лучше находить перед использование
            System.out.println(e.getSupportUrl());
        }

        try {
            driver.findElement(By.xpath(".//textarea")).click();
        } catch (ElementNotInteractableException e){ //не можем пользоваться элементом
            System.out.println(e.getSupportUrl());
        }

        //Thread.sleep(10000l);
        //Завершаем работу с ресурсом
        //driver.quit();
    }
}