package top.syy.boot.mp.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;
import top.syy.boot.mp.common.dto.BookCreateDTO;
import top.syy.boot.mp.common.dto.BookPageQuery;
import top.syy.boot.mp.common.dto.BookUpdateDTO;
import top.syy.boot.mp.common.dto.StockAdjustDTO;
import top.syy.boot.mp.common.result.PageResult;
import top.syy.boot.mp.common.vo.BookVO;
import top.syy.boot.mp.entity.Book;

/**
 * @author 小c
 */
@Service
public interface BookService extends IService<Book> {
    BookVO createBook(BookCreateDTO dto);
    BookVO updateBook(Long id, BookUpdateDTO dto);
    BookVO adjustStock(Long id, StockAdjustDTO dto);
    BookVO getBookById(Long id);
    boolean checkIsbnExists(String isbn);
    PageResult<BookVO> pageQuery(BookPageQuery query);
    boolean deleteBook(Long id);
    BookVO restoreBook(Long id);
}
