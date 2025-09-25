package top.syy.boot.mp.Util;

import jakarta.annotation.Resource;
import net.datafaker.Faker;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import top.syy.boot.mp.Service.BookService;
import top.syy.boot.mp.entity.Book;

import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

/**
 @author 小c
 */
@Component
public class DataFakerUtil {

    private static final Faker ZH_FAKER = new Faker(Locale.CHINA);
    private static final Faker EN_FAKER = new Faker(Locale.ENGLISH);
    private static final String RAW_PASSWORD = "123456";
    private static final String ENCODED_PASSWORD = new BCryptPasswordEncoder().encode(RAW_PASSWORD);

    @Resource
    private BookService bookService;


    private Book generateOne(int i) {
        Book book = new Book();
        book.setTitle(ZH_FAKER.book().title());
        book.setAuthor(ZH_FAKER.book().author());
        book.setIsbn(EN_FAKER.code().isbn13());
        book.setCategory(ZH_FAKER.book().genre());
        book.setStock(EN_FAKER.number().numberBetween(0, 100));
        return book;
    }

    public void generateBatch() {
        int total = 1000;
        int step = 100;
        for (int start = 0; start < total; start += step) {
            List<Book> batch = IntStream.range(start, start + step)
                    .mapToObj(this::generateOne)
                    .toList();
            bookService.saveBatch(batch, step);

        }
    }
}
