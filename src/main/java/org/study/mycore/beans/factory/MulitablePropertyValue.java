package org.study.mycore.beans.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class MulitablePropertyValue implements Iterable<PropertyValue>{

    private final List<PropertyValue> propertyValueList;

    public MulitablePropertyValue(List<PropertyValue> propertyValueList) {
        if(propertyValueList==null){
            this.propertyValueList = new ArrayList<>();
        }else {
            this.propertyValueList = propertyValueList;
        }
    }

    public MulitablePropertyValue(){
        propertyValueList = new ArrayList<>();
    }

    public PropertyValue[] getPropertyValueArr(){
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    public boolean isEmpty(){
        return propertyValueList.isEmpty();
    }

    public MulitablePropertyValue add(PropertyValue pv){
        for (int i = 0; i < propertyValueList.size(); i++) {
            PropertyValue propertyValue = propertyValueList.get(i);
            if(pv.getName().equals(propertyValue.getName())){
                propertyValueList.set(i,pv);
                return this;
            }
        }
        propertyValueList.add(pv);
        return this;
    }

    public PropertyValue getPropertyByName(String name){
        for (PropertyValue propertyValue : propertyValueList) {
            if(propertyValue.getName().equals(name)){
                return propertyValue;
            }
        }
        return null;
    }

    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }

    @Override
    public void forEach(Consumer<? super PropertyValue> action) {
        Iterable.super.forEach(action);
    }
}
