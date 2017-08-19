import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by zhanglele on 2017/7/26.
 */
public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:/development/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://kibana.ql.corp/app/kibana#/visualize/edit/df00cf70-501f-11e7-a937-3fcce3fa7d3a?_g=()&_a=(filters:!(),linked:!f,query:(query_string:(analyze_wildcard:!t,query:%27sellId%3D!%27chinaunicom!%27%20AND%20method%3D!%27getPhone!%27%20AND%20methondType:%22response%22%20AND%20timeStamp.keyword:%5B%222017-07-19%2009:30:00%22%20TO%20%222018-06-16%2022:00:00%22%5D%27)),uiState:(vis:(params:(sort:(columnIndex:!n,direction:!n)))),vis:(aggs:!((enabled:!t,id:%271%27,params:(customLabel:%E6%80%BB%E6%95%B0),schema:metric,type:count),(enabled:!t,id:%272%27,params:(customLabel:%E7%9C%81%E4%BB%BD,field:province.keyword,order:desc,orderBy:%271%27,size:30),schema:bucket,type:terms),(enabled:!t,id:%273%27,params:(filters:!((input:(query:(query_string:(analyze_wildcard:!t,query:%27status:4%27))),label:%E6%88%90%E5%8A%9F),(input:(query:(query_string:(analyze_wildcard:!t,query:%27status:1%27))),label:%E7%94%A8%E6%88%B7%E5%90%8D%E5%AF%86%E7%A0%81%E4%B8%8D%E5%8C%B9%E9%85%8D),(input:(query:(query_string:(analyze_wildcard:!t,query:%27status:14%27))),label:%E9%AA%8C%E8%AF%81%E7%A0%81%E4%B8%8D%E5%8C%B9%E9%85%8D),(input:(query:(query_string:(analyze_wildcard:!t,query:%27status:0%20AND%20-message:%22%E8%B6%85%E6%97%B6%22%27))),label:%E5%A4%B1%E8%B4%A5),(input:(query:(query_string:(analyze_wildcard:!t,query:%27status:16%27))),label:%E7%9B%AE%E6%A0%87%E7%BD%91%E7%AB%99%E9%94%99%E8%AF%AF),(input:(query:(query_string:(analyze_wildcard:!t,query:%27status:9%27))),label:%E9%87%8D%E7%BD%AE%E5%AF%86%E7%A0%81),(input:(query:(query_string:(analyze_wildcard:!t,query:%27message:%22%E8%B6%85%E6%97%B6%22%27))),label:%E8%AF%B7%E6%B1%82worker%E8%B6%85%E6%97%B6)),row:!f),schema:split,type:filters)),listeners:(),params:(perPage:30,showMeticsAtAllLevels:!f,showPartialRows:!f,showTotal:!t,sort:(columnIndex:!n,direction:!n),totalFunc:sum),title:chinaunicom_20170613,type:table))");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String str = driver.findElement(By.xpath("//*[@id=\"kibana-body\"]/div/div/div/div[3]/visualize-app/div/div[2]/visualize/div/div/div/div/kbn-agg-table-group/table/tbody/tr/td[1]/kbn-agg-table-group/table/tbody/tr/td/kbn-agg-table/paginated-table/paginate/div[1]/table/tfoot/tr/th[2]")).getText();
        System.out.println(str);
    }
}
