package com.youaotu.template.common.entity.pojo.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author youao.du@gmail.com
 * @time 2019-12-29 16:37
 */
@Data
public class AdminLoginDto {

    @NotBlank(message = "账号不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String pwd;

    public static void main(String[] args) {

        System.out.println("不给定长度 开始 === ");
        long startTime = System.currentTimeMillis();
        List<Integer> array1 = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            array1.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("不给定长度 结束 === ");
        System.out.println("不给定长度耗时（毫秒） >>> " + (endTime - startTime));

        System.out.println();

        System.out.println("给定长度 开始 === ");
        long startTime1 = System.currentTimeMillis();
        List<Integer> array2 = new ArrayList<>(10000000);
        for (int i = 0; i < 10000000; i++) {
            array2.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("给定长度 结束 === ");
        System.out.println("不给定长度耗时（毫秒） >>> " + (endTime1 - startTime1));
    }
}
