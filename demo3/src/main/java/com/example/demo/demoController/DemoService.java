package com.example.demo.demoController;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DemoService {
    //执行计算
    public  ArrayList<String> doexcute(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if (digits == null)
            return res;
        String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};//对应0-9 数字键
        StringBuilder current = new StringBuilder();
        int index = 0;
        dohelper(index, digits, res, current, keyboard);
        return res;
    }

    private static void dohelper(int index, String digits, ArrayList<String> res, StringBuilder current, String[] keyboard) {
        if (index == digits.length()) { //跳出递归出口
            res.add(current.toString());
            return;
        }
        int num = digits.charAt(index) - '0';//获取ASSCI码
        for (int i = 0; i < keyboard[num].length(); i++) {
            current.append(keyboard[num].charAt(i));
            dohelper(index + 1, digits, res, current, keyboard); //递归调用
            current.deleteCharAt(current.length() - 1);//保证 可以加入本数字表示的下个字符
        }
    }
}
