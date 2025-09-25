package top.syy.boot.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.syy.boot.mp.entity.Book;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
    Book selectByIdForUpdate(Long id);
}