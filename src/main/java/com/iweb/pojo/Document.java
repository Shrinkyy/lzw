package com.iweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 娄志伟
 * @Create 2023/6/11 16:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    private int id;
    private String content;
}
