package org.duyhung.assignment.util;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class FieldReflection {
    private Class<?> className;
    public FieldReflection(Class<?> className){
        this.className = className;
    }
    public FieldReflection(){
    }
    public List<Field> getAllFields(){
        List<Field> fields = new ArrayList<>();
        Class<?> cl = this.className;
        if (cl != null){
            for (Field field : cl.getDeclaredFields()){
                field.setAccessible(true);
                fields.add(field);
            }
        }
        return fields;
    }
}
