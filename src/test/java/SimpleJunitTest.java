import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;

public class SimpleJunitTest {



    @Test
    public void TestStrUtil(){
        System.out.println(StrUtil.format("hello {}","Java"));
    }
}
