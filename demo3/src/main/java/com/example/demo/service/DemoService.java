package com.example.demo.service;

import com.example.demo.ExtraUtils.KeysArr;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;

@Service
public class DemoService  extends Comcalculate{
    //执行计算
    @Override
    public  ArrayList<String> doexcute(String orgindigitstr) {

        this.verifyinput(orgindigitstr);
        String[] digits=orgindigitstr.split(",");
        StringBuilder targetdigitsstr=new StringBuilder(); //目标字符串
        for(String d: digits){
            int i=Integer.parseInt(d);
            if(KeysArr.keyboard.length>i){
                targetdigitsstr.append(d);
            }
        }
        ArrayList<String> res = new ArrayList<String>();
        StringBuilder current = new StringBuilder();
        int index = 0;
        dohelper(index, targetdigitsstr, res, current, KeysArr.keyboard);
        return res;
    }

    private static void dohelper(int index, StringBuilder digits, ArrayList<String> res, StringBuilder current, String[] keyboard) {
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
    private void verifyinput(String digits){
        Assert.notNull(digits,"input can not be null");
    }


}
