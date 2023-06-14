package com.iweb;

import com.iweb.pojo.User;
import com.iweb.view.MainView;

import java.util.List;

/**
 * @Author 娄志伟
 * @Create 2023/6/12 11:42
 */
public class Main {
    public static User currentUser = null;
    public static void main(String[] args) {
        MainView.mainView();
    }
}
