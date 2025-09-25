package top.syy.boot.mp.common.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author 小c
 */
@Data
public class BookUpdateDTO {
    @NotBlank(message = "书名不能为空")
    private String title;
    private String author;
    private String category;
    @NotBlank(message = "ISBN不能为空")
    private String isbn;
}
