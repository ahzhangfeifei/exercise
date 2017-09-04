package annotion;

import com.java.annotion.DealIne;
import com.java.annotion.Inde;
import org.junit.Test;

/**
 * annotion测试类
 * Created by zhangfeifei on 2017/9/4.
 */

public class DealIneTest {

    @Test
    public void test(){
        DealIne dealIne = new DealIne();
        dealIne.execAnn(Inde.class);
    }


}
