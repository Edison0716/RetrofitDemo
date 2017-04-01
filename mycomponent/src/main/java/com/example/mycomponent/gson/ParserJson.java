package com.example.mycomponent.gson;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${巴黎没有摩天轮Li} on 2017/3/28.
 */

public class ParserJson<T> {
    private List<T> list = new ArrayList<>();
    public List<T> getPrasedObj(String jsonData) {
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonArray jsonArray = parser.parse(jsonData).getAsJsonArray();
        Gson gson = new Gson();
        //加强for循环遍历JsonArray
        for (JsonElement user : jsonArray) {
            //使用GSON，直接t转成Bean对象
            T t= (T) gson.fromJson(user, this.getClass());
            list.add(t);
        }
        return list;
    }
}
