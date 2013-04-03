import com.juvenxu.mvnbook.helloworld.HelloWorld;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: keer
 * Date: 13-4-3
 * Time: 下午9:37
 */
public class HelloWorldTest {
    @Test
    public void tsetSayHello() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        Assert.assertEquals("Hello Maven", result);
    }
}
