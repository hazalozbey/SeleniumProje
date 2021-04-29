/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Hazal
 */


/**
 *
 * @author Hazal
 */
public class Browser {

    private String siteAdress;
    private WebDriver browser;

    public Browser() {
        this.browser = new ChromeDriver();

    }

    public Browser(String siteAdress) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Hazal\\Desktop\\seleniumjars\\chromedriver.exe");
        this.browser = new ChromeDriver();
        this.siteAdress = siteAdress;

        this.browser.get(siteAdress);
        this.browser.manage().window().maximize();
        anasayfakontrol(this.siteAdress);
        WebElement login = this.browser.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div[1]"));
        login.click();
        //login penceresi
        //WebElement loginIcon=this.browser.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div"));
        //loginIcon.click();

        this.browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.browser.get("https://www.gittigidiyor.com/uye-girisi");
        this.browser.manage().window().maximize();
        
       
        String mail = "hazalozbey1903@gmail.com";
        
        WebElement kullanicitext = this.browser.findElement(By.xpath("//*[@id=\"L-UserNameField\"]"));
        //maili yazdı
        kullanicitext.sendKeys(mail);
        this.browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement kullaniciparola = this.browser.findElement(By.xpath("//*[@id=\"L-PasswordField\"]"));
        //şifreyi yazdı
        kullaniciparola.sendKeys("Hazal.1998");
        this.browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement girisIcon = this.browser.findElement(By.xpath("//*[@id=\"gg-login-enter\"]"));
        //girişyapa tıkladı
        girisIcon.click();
          JavascriptExecutor js = (JavascriptExecutor) this.browser;
        this.browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement kullanicikontrol = this.browser.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div/div[1]/div"));
        //bilgilerim ayarlarım kısmına girdi
        kullanicikontrol.click();
        this.browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
        WebElement kullanicibilgi = this.browser.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div[7]/a"));
        kullanicibilgi.click();
        js.executeScript("window.scrollBy(0,500)");
        WebElement kayitlimail = this.browser.findElement(By.xpath("//*[@id=\"MainContainer\"]/div[2]/div[1]/div[3]/div/div[5]/div[1]/ul[1]/li[3]/a"));
        kayitlimail.click();
        this.browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       //this.browser.get("https://www.gittigidiyor.com/CEmail");
        WebElement dogrulamasifresi = this.browser.findElement(By.xpath("//*[@id=\"L-PasswordField\"]"));
        dogrulamasifresi.sendKeys("Hazal.1998");
        WebElement dogrulamasifresiIcon = this.browser.findElement(By.xpath("//*[@id=\"gg-login-enter\"]"));
        dogrulamasifresiIcon.click();
        
        
       WebElement kayitliemail = this.browser.findElement(By.xpath("//*[@id=\"MainContainer\"]/div[2]/table/tbody/tr[4]/td/table/tbody/tr[2]/td/font/form/b"));
       String kmail=kayitlimail.getText();
       loginkontrol(mail,kmail);
       // if(mail.equals(kmail)){
        WebElement anasayfa = this.browser.findElement(By.xpath("//*[@id=\"topContainer\"]/div/div/div/div[3]/a"));
        anasayfa.click();
        WebElement SearchBox = this.browser.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input"));
        SearchBox.sendKeys("bilgisayar");
        WebElement SearchIcon = this.browser.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button"));
        SearchIcon.click();
        js.executeScript("window.scrollBy(0,10000)");
        WebElement sayfa2 = this.browser.findElement(By.xpath("//*[@id=\"best-match-right\"]/div[5]/ul/li[2]/a"));
        sayfa2.click();
        ikincisayfakontrol(siteAdress);
        
        //SAYFA2 KONTROL URL AL YENİ SEKEMEDE AC AYNI SAYFA OLDUĞUNDAN EMİN OL
        js.executeScript("window.scrollBy(0,200)");
        WebElement urun = this.browser.findElement(By.xpath("//*[@id=\"item-info-block-576239506\"]/p/img"));
        urun.click();
        this.browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js.executeScript("window.scrollBy(0,500)");
        WebElement fiyat = this.browser.findElement(By.xpath("//*[@id=\"sp-price-discountPrice\"]"));
        String urunfiyat=fiyat.getText();
        WebElement sepetekle = this.browser.findElement(By.xpath("//*[@id=\"add-to-basket\"]"));
        sepetekle.click();
        WebElement sepetgit1 = this.browser.findElement(By.xpath("//*[@id=\"header_wrapper\"]/div[4]/div[3]/a/div[1]/div"));
        sepetgit1.click();
        WebElement sepettekifiyat = (WebElement) this.browser.findElements(By.xpath("//*[@id=\"cart-item-471718020\"]/div[1]/div[5]/div[1]/div[2]/strong[2]"));
        String sepetfiyat=sepettekifiyat.getText();
        fiyatkontrol(urunfiyat,sepetfiyat);
        /*
        int fsepet = Integer.parseInt(sepettekifiyat.getText());
        int sayfafiyat = Integer.parseInt(fiyat.getText());
        if (fsepet == sayfafiyat) {
            WebElement ürünarttirma = this.browser.findElement(By.xpath("//*[@id=\"cart-item-471718020\"]/div[1]/div[4]/div/div[2]/select"));

        }
*/
        WebElement silme = this.browser.findElement(By.xpath("//*[@id=\"cart-item-471720362\"]/div[4]/a[1]"));
        silme.click();
        //SEPETTE ÜRÜN YOK KONTOLÜ

        //his.browser.quit();
        }
        public  boolean anasayfakontrol(String website){
            
            String currentURL = browser.getCurrentUrl();
        if (siteAdress.equals(currentURL)) {
            return true;
        } 
         else
            return false;
        }
        public  boolean loginkontrol(String mail,String kayitlimail){
            if(mail==kayitlimail)
            return true;
            else
                return false;
        }
        public  boolean ikincisayfakontrol(String website){
            String currentURL = browser.getCurrentUrl();
            if(currentURL.equals("String currentURL = browser.getCurrentUrl();"))
                return true;
            else
                
                return false ;
        }
        public  boolean fiyatkontrol(String fiyat,String sepetfiyat){
            if(fiyat==sepetfiyat)
                return true;
            else
             
             return false;
            
        }
       /// public  boolean adetkontrol(){
            ///////////////////
            
       //// }
        public boolean sepetkontrol(String website){
        WebElement sepeturunsay= this.browser.findElement(By.xpath("  //*[@id=\"empty-cart-container\"]/div[1]/div[1]/div/div[2]/h2"));
        String mesaj=sepeturunsay.getText();
        if(mesaj.equals("Sepetinizde ürün bulunmamaktadır."))
            return true;
        else
            return false;
            
        }
    }
