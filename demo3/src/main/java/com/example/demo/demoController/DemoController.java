package com.example.demo.demoController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DemoController {

    @Autowired
    DemoService demoService;

    private static Logger log = LoggerFactory.getLogger(DemoController.class);

    /**
     * 输入的手机键值 0-9   如 2   2,3   8,9,6   10,99,12 形式
     * @param
     * @return
     */

    @RequestMapping(value = "/letterbynum",method = RequestMethod.GET)
        public Map getletterbynum(String digitstr){ //没有封装Bean,对数组传值不友好，暂时采用string 规则传值
        Map map=new HashMap();
        List<String> ls;
        map.put("list",null);
        map.put("code",200);
        map.put("message","返回成功！");
        try {
            if(digitstr.length()==0){
                map.put("code",200);
                map.put("message","参数为空！");
                return map;
            }
            String[] digits=digitstr.split(",");
            StringBuilder digitsstr=new StringBuilder();
            for(String d: digits){
                int i=Integer.parseInt(d);
                if(i>=0&&i<=9){ //过滤不属于 0-9的参数
                    digitsstr.append(d);
                }else{
                    return map;//10-99都输出null
                }
            }
            ls=demoService.doexcute(digitsstr.toString());

            map.put("list",ls);
            return map;
        }catch (Exception e){
            map.put("code",500);
            map.put("message","出错了 "+e.getMessage());
            return map;
        }
    }
}
