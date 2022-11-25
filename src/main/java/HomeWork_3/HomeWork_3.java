package HomeWork_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomeWork_3 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup(); //проверка драйвера если драйвера нет попробует скачать
        ChromeOptions options = new ChromeOptions();//создаём хром опции и указываем опции с которыми мы его запускаем
        options.addArguments("--incognito"); //опция запуск в режими инкогнито без кеша
        //options.addArguments("--headless"); позволяет запускать браузер в фоновом режиме сам браузер не запускается
        options.addArguments("start-maximized"); //открытие окна браузера на полный экран

        //Создаём webDriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS); // нне явное ожидание
        driver.get("https://yandex.ru/pogoda/?lat=43.785049&lon=131.971069&win=564");

        //Регистрация
        WebElement loginButton = driver.findElement(By.xpath("//span[text()='Войти']"));
        loginButton.click();

        WebElement inputEmail =driver.findElement(By.id("passp-field-login"));
        inputEmail.click();
        inputEmail.sendKeys("AnTONTON111");
        WebElement signIn = driver.findElement(By.id("passp:sign-in"));
        signIn.click();

        WebElement passowrd = driver.findElement(By.id("passp-field-passwd"));
        passowrd.sendKeys("Anton111anton");
        WebElement signIn2 = driver.findElement(By.id("passp:sign-in"));
        signIn2.click();
        try {
            Thread.sleep(3000); //заснуть на 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Работа с картой,
        //Открыли карту
        WebElement maps =driver.findElement(By.xpath(".//div[text()='Показать на карте']"));
        maps.click();

        //Смотрим осадки
        WebElement rainfall = driver.findElement(By.xpath(".//input[@value='nowcast']"));
        rainfall.click();
        try {
            Thread.sleep(3000); //заснуть на 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Смотрим глубину снега
        WebElement nowcast = driver.findElement(By.xpath(".//input[@value='snow']"));
        nowcast.click();
        try {
            Thread.sleep(3000); //заснуть на 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Смотрим температуру
        WebElement temperature = driver.findElement(By.xpath(".//input[@value='temperature']")); //.//label/span/a/span/span
        temperature.click();
        try {
            Thread.sleep(3000); //заснуть на 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Смотрим ветер
        WebElement wind = driver.findElement(By.xpath(".//input[@value='wind']"));
        wind.click();
        try {
            Thread.sleep(3000); //заснуть на 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Смотрим ветер
        WebElement pressure = driver.findElement(By.xpath(".//input[@value='pressure']"));
        pressure.click();


        //Возвращаемся на главную
        WebElement yandex = driver.findElement(By.xpath(".//span[text()='Прогноз на 10 дней']"));
        yandex.click();

        //Подробный прогноз погоды на 10 дней
        WebElement tenDay = driver.findElement(By.xpath(".//a[text()='Подробный прогноз на 10 дней']"));
        tenDay.click();
        //Скролим до 10го дня
        WebElement iframe = driver.findElement(By.xpath(".//h3[text()='Партнёрам']"));
        new Actions(driver)
                .scrollToElement(iframe)
                .perform();


        driver.navigate().back();

        //Поиск города
        WebElement search= driver.findElement(By.cssSelector(".mini-suggest__input"));
        search.click();
        search.sendKeys("Мурманск");
        search.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(3000); //заснуть на 10 секунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        //Завершаем работу с ресурсом
        driver.quit();
    }
}
