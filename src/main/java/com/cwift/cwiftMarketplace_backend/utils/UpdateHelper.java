package com.cwift.cwiftMarketplace_backend.utils;

import com.cwift.cwiftMarketplace_backend.model.Item;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import java.beans.FeatureDescriptor;

@Component
public class UpdateHelper {

    public void mergeObjects(Item oldItem, Item newItem) {
        BeanWrapper oldWrapper = new BeanWrapperImpl(oldItem);
        BeanWrapper newWrapper = new BeanWrapperImpl(newItem);
        for (FeatureDescriptor descriptor : newWrapper.getPropertyDescriptors()) {
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) { // Ignore the 'class' property
                Object newValue = newWrapper.getPropertyValue(propertyName);
                if (newValue != null) {
                    oldWrapper.setPropertyValue(propertyName, newValue);
                }
            }
        }
    }

}
