package top.syy.redis;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;


@SpringBootTest
@TestPropertySource(locations = "classpath:application.yml")
@Slf4j
public class LoginTest {

    @Test
    public void testLoginFlow() {
        log.info("登录接口测试");
        log.info("1. 先调用发送短信接口: GET /api/sms/send?phone=13800138000");
        log.info("2. 再调用登录接口: POST /api/login");
        log.info("   请求体示例:");
        log.info("   {");
        log.info("     \"phone\": \"13800138000\",");
        log.info("     \"code\": \"123456\"");
        log.info("   }");
    }
}
