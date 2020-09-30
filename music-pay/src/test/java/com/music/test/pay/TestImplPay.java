package com.music.test.pay;

import com.music.pay.MusicPayApplication;
import com.music.pay.bean.PayBO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MusicPayApplication.class)
public class TestImplPay {
   private Logger logger = LoggerFactory.getLogger(TestImplPay.class);
    @Test
    public void test() {
        logger.info("---test---");
    }
    @Test
    public void testObj() throws Exception {
        PayBO payBO = PayBO.class.newInstance();
        Field field = PayBO.class.getDeclaredField("userId");
        field.setAccessible(true);
        field.set(payBO, "123");
        Method method = PayBO.class.getMethod("getUserId");
        logger.info((String) method.invoke(payBO));
        ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(""));
        objectInput.readObject();
        ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(""));
        objectOutput.writeObject(payBO);

    }
}
