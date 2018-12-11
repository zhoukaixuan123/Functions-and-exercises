import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;


/**
 * @Auther: Mr.zhoukx
 * @Date: 2018/12/11 14:08
 * @Description: 描述
 *   接口调用  httpclent 调用
 *     所用的包：commons-codec-1.11.jar
 *             commons-httpclient-3.0.jar
 *             commons-logging-1.1.1.jar
 *             commons-logging-api-1.1.jar
 *
 *
 */
public class Httpcl {

    public static void main(String[] args) {
        System.out.println("调用这个了吗");
        String result = httpClientTest();
        System.out.println(result);
    }


    public  static String httpClientTest(){
        //创建httpclent对象
        HttpClient client = new HttpClient() ;
        //请求的方法  get  和post的
        PostMethod method = null;//post 方式   get 方式 GetMethod gMethod
        String result = "" ;
        try {
            method = new PostMethod("http://localhost:8080/jiekou.do") ;
            //setParameter  get  post  都可以接受  如果指定单个 setEntity
            method.setParameter("param","1111");//设置参数
            //post 请求方法
            client.executeMethod(method);
            //返回的状态吗   这个是 被调方发送过来的 状态
           int  num = method.getStatusCode();
            if(num == HttpStatus.SC_OK){//响应成功
                result = method.getResponseBodyAsString();//调用返回结果
            }else{//不成功组装结果
                System.out.println("调用失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //无论成功或者失败都要释放资源
            method.releaseConnection();

        }
        return result ;
    }
}
