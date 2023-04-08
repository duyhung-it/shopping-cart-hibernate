package org.duyhung.assignment.util;

import jakarta.servlet.http.HttpServletRequest;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class ObjectMapper {
    private static ObjectMapper objectMapper = null;
    public static ObjectMapper getInstance(){
        if(objectMapper == null){
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }
    public <T> T mapper(Class<T> tClass, HttpServletRequest request){
        Map<String,String[]> map = request.getParameterMap();
        List<Field> listFields = new FieldReflection(tClass).getAllFields();
//        Class<?>[] classes = new Class[listFields.size()];
//        for(int i = 0; i < listFields.size();i++){
//            classes[i] = listFields.get(i).getType();
//        }
        T t = null;
        try {
             t = tClass.getDeclaredConstructor().newInstance();
             for(Field field : listFields){
                 if(!field.getName().equals("id")) {
                     switch (field.getType().getName()) {
                         case "java.util.Date":
                             SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                             if (map.get(field.getName()) != null)
                                 field.set(t, format.parse(map.get(field.getName())[0]));
                             break;
                         case "java.lang.Integer":
                             if (map.get(field.getName()) != null)
                                 field.set(t, Integer.valueOf(map.get(field.getName())[0]));
                             break;
                         case "java.lang.Double":
                             if (map.get(field.getName()) != null)
                                 field.set(t, Double.valueOf(map.get(field.getName())[0]));
                             break;
                         case "java.lang.String":
                             if (map.get(field.getName()) != null)
                                 field.set(t, map.get(field.getName())[0]);
                             break;
                     }
                 }
             }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                 ParseException e) {
            throw new RuntimeException(e);
        }
        return t;
    }
}
