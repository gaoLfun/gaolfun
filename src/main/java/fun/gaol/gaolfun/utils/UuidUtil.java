package fun.gaol.gaolfun.utils;

import java.util.UUID;

public class UuidUtil {
    public String  getUuid(){
        String uuid = "";
        for (int i = 0; i < 5; i++) {
            //注意replaceAll前面的是正则表达式
            uuid = UUID.randomUUID().toString().replaceAll("-","");
        }
        return uuid;
    }
}
