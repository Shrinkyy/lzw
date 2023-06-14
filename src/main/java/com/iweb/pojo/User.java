package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 娄志伟
 * @Create 2023/6/11 16:27
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String tel;
    private String sex;
    private String part;
    private String passName;
    private String passWord;
}
