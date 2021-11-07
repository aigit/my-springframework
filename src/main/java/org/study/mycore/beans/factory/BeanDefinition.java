package org.study.mycore.beans.factory;

import org.springframework.beans.BeanMetadataElement;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.AttributeAccessor;

public class BeanDefinition {

    private String id;
    private String name;
    private MulitablePropertyValue propertyValues;


    public BeanDefinition(){
        propertyValues = new MulitablePropertyValue();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MulitablePropertyValue getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(MulitablePropertyValue propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getBeanClassName(){
        return name;
    }
}
