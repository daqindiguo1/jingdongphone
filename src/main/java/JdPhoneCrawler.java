import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanglele on 2017/7/26.
 */
public class JdPhoneCrawler {
    private String searchContent = null;
    private String indexUrl = null;
    public static void crawler(String indexUrl){
        //*[@id="J_goodsList"]/ul/li[1]/div/div[4]/a/em
        //*[@id="J_goodsList"]/ul/li[1]/div/div[7]/span/a

        List<WebElement> list_li = new ArrayList<WebElement>();
       List<String> list_href = new ArrayList<String>();
//        String searchcontent = searchContent;
        String indexurl = indexUrl;
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "D:/development/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(indexurl);
//        driver.findElement(By.xpath("//*[@id=\"key\"]")).clear();
//        driver.findElement(By.xpath("//*[@id=\"key\"]")).sendKeys(searchContent);

//        driver.findElement(By.xpath("//*[@id=\"search-2014\"]/div/button").findElement()
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"J_selector\"]/div[1]/div/div[3]/a[1]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        //list_li = driver.findElement(By.className("J_valueList v-fixed")).findElements(By.tagName("li"));
        WebElement web = driver.findElement(By.xpath("//*[@id=\"J_selector\"]/div[1]/div/div[2]/div[2]/ul"));
        list_li = web.findElements((By.tagName("li")));
        System.out.println(list_li.size());
//        list_li.get(7).click();
        for(int k=0;k<list_li.size();k++) {
            list_href.add(list_li.get(k).findElement(By.tagName("a")).getAttribute("href"));
        }
        //所有品牌数目
        for(int j = 0;j<list_href.size();j++) {
            List<WebElement> list_everypagenumber = new ArrayList<WebElement>();
//            List<String> list_href = new ArrayList<String>()
            driver.get(list_href.get(j));
//            JavascriptExecutor driver_js = (JavascriptExecutor) driver;
//            driver_js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
            System.out.println(list_href.get(j));
            String pageSize = null;
            try {

                pageSize = driver.findElement(By.xpath("//*[@id=\"J_bottomPage\"]/span[2]/em[1]/b")).getText();
            }
            catch(Exception e){

                 pageSize = "1";
            }
            //String pageSize = driver.findElement(By.className("p-skip")).getAttribute("b");
            int pageSizes = Integer.parseInt(pageSize);//每个品牌下的总页数
            //每一页的手机数目
            for (int m = 1; m < pageSizes+1; m++) {
                ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                list_everypagenumber = driver.findElement(By.xpath("//*[@id=\"J_goodsList\"]/ul")).findElements(By.tagName("li"));
               // WebElement geshu = driver.findElement(By.xpath("//*[@id=\"J_goodsList\"]/ul"));//每个品牌的第一页的所有手机
                List<WebElement> list1 = driver.findElement(By.xpath("//*[@id=\"J_goodsList\"]/ul")).findElements(By.className("gl-item"));
                for (int k = 1; k < list1.size() + 1; k++) {
//                    JavascriptExecutor driver_js = (JavascriptExecutor) driver;
//                    driver_js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
                    StringBuffer sbf1 = null;
                    StringBuffer sbf2 = null;
                    StringBuffer sbf3 = null;
//                    System.out.println(list_everypagenumber.size());
//                    sbf1.append(driver.findElement(By.xpath("//*[@id=\"J_goodsList\"]/ul/li[" + k + "]/div/div[3]/strong/i")).getText());
//                    sbf2.append(driver.findElement(By.xpath("//*[@id=\"J_goodsList\"]/ul/li[" + k + "]/div/div[4]/strong/i")).getText());
//                    sbf3.append(driver.findElement(By.xpath("//*[@id=\"J_goodsList\"]/ul/li[" + k + "]/div/div[7]/strong/i")).getText());
//                    System.out.println(sbf1.toString());
//                    System.out.println(sbf1.toString());k
//                    System.out.println(sbf1.toString());
                    //*[@id="J_goodsList"]/ul/li[38]/div/div[7]/span/a
                    System.out.println(k);
                    System.out.println("爬取第"+m+""+"页");
                    System.out.println("当页共有"+list1.size()+""+"个手机");
//                    try {
//                        //*[@id="J_goodsList"]/ul/li[40]/div/div[7]/span/a
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }curr-shop
//                      System.out.println(driver.findElement(By.xpath("//*[@id=\"J_goodsList\"]/ul/li[" + k + "]/div/div[3]/strong/i")).getText());
                    //System.out.println(driver.findElement(By.className("p-price")).getText());
                    System.out.println(driver.findElement(By.className("p-price")).getText());
                    System.out.println(driver.findElement(By.xpath("//*[@id=\"J_goodsList\"]/ul/li[" + k + "]/div/div[4]")).getText());




                        //*[@id="J_goodsList"]/ul/li[17]/div/div[7]/span/a

                        System.out.println(driver.findElement(By.className("p-shop")).getText());


                }
                try {
                    driver.findElement(By.className("pn-next")).click();//点击下一页
                }
                catch(Exception e){
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }





    }
        public static void main(String[] args){
           // https://search.jd.com/Search?keyword=%E5%9B%BE%E4%B9%A6&enc=utf-8&pvid=c333ec64c0c84e379e64c81d27966d25
            //https://search.jd.com/Search?keyword=%E7%94%B5%E8%84%91&enc=utf-8&wq=%E7%94%B5%E8%84%91&pvid=8f85c07214a84ae5b865b4d3de3d8960
            crawler("https://search.jd.com/search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&qrst=1&rt=1&stop=1&vt=2&cid2=653&cid3=655&uc=0#J_searchWrap");
            //crawler("https://search.jd.com/Search?keyword=%E5%9B%BE%E4%B9%A6&enc=utf-8&pvid=c333ec64c0c84e379e64c81d27966d25");
            //crawler("https://search.jd.com/Search?keyword=%E7%94%B5%E8%84%91&enc=utf-8&wq=%E7%94%B5%E8%84%91&pvid=8f85c07214a84ae5b865b4d3de3d8960");
    }
}
