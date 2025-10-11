package top.syy.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class StudentTest {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    void test() {
        Address address = Address.builder()
                .province("南京")
                .city("江苏")
                .build();
        Student student = Student.builder()
                .id("1")
                .name("syy")
                .address(address)  // 修复后这里应该能正常编译
                .build();
        redisTemplate.opsForValue().set("student", student,10, TimeUnit.SECONDS);

    }
}
