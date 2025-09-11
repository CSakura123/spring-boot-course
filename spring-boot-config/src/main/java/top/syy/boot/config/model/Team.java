package top.syy.boot.config.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author 小c
 */
@Data
@Component
public class Team {
    @Value("${team.name}")
    @NotNull(message = "团队名称不能为空")
    @NotEmpty(message = "团队名称不能为空字符串")
    @NotBlank(message = "团队名称不能包含空白字符")
    @Length(min = 3, max = 20, message = "团队名称长度必须在3-20个字符之间")
    private String name;

    @Value("${team.leader}")
    @NotNull(message = "团队领导不能为空")
    @NotEmpty(message = "团队领导不能为空字符串")
    @NotBlank(message = "团队领导不能包含空白字符")
    @Size(min = 3, max = 8, message = "团队领导姓名长度必须在3-8个字符之间")
    private String leader;

    @Value("${team.age}")
    @Min(value = 1, message = "团队年龄必须大于等于1")
    @Max(value = 4, message = "团队年龄必须小于等于4")
    private Integer age;

    @Value("${team.phone}")
    @Pattern(regexp = "^[0-9]{11}$", message = "电话号码必须是11位数字")
    private String phone;

    @Past(message = "创建时间必须是过去的日期")
    private LocalDate createTime;
}

