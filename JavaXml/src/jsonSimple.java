package com.phenom.org;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class jsonSimple
{
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("Name","Siva");
        obj.put("Age",new Integer(20));
        obj.put("Id",new Integer(131));
//        String string = obj.toJSONString();
//        System.out.println(string);
        System.out.println(obj);

        JSONArray arr = new JSONArray();
        arr.add("Siva");
        arr.add("Ganesh");
        arr.add("Manyam");
//        String st = arr.toJSONString();
//        System.out.println(st);
        System.out.println(arr);


        String s="{\"name\":\"Siva\",\"salary\":600000.0,\"age\":20}";
        Object obj1=JSONValue.parse(s);
        JSONObject jsonObject = (JSONObject) obj1;

        String name = (String) jsonObject.get("name");
        double salary = (Double) jsonObject.get("salary");
        long age = (Long) jsonObject.get("age");
        System.out.println(name+" "+salary+" "+age);
    }
}
