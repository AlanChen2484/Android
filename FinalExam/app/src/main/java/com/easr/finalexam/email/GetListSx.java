package com.easr.finalexam.email;

import android.content.Context;

import com.easr.finalexam.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by easr on 2017/6/9.
 */

public class GetListSx {

    public static List<InfoSx> lists = new ArrayList<InfoSx>();

    public static String getNumber(Context context){

        String[] title = {"小明","小红","小白","小钱", "小李", "小陈",
                "小明","小红","小白","小钱", "小李", "小陈"};
        String[] texts = {"你好啊","嘿嘿嘿","哈哈哈","呵呵呵", "嘻嘻嘻", "啧啧啧",
                "你好啊","嘿嘿嘿","哈哈哈","呵呵呵", "嘻嘻嘻", "啧啧啧"};
        int[] resIds = {R.mipmap.imga , R.mipmap.imgb, R.mipmap.imgc, R.mipmap.imgd, R.mipmap.imge, R.mipmap.imgf,
                R.mipmap.imga , R.mipmap.imgb, R.mipmap.imgc, R.mipmap.imgd, R.mipmap.imge, R.mipmap.imgf};

        for(int i = 0 ; i < title.length ; i++){
            InfoSx infoSx = new InfoSx(title[i], texts[i], resIds[i]);
            lists.add(infoSx);
        }
        return null;
    }
}
