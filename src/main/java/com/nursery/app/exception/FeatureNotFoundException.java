package com.nursery.app.exception;

public class FeatureNotFoundException extends RuntimeException{

    public FeatureNotFoundException(String feature, Integer id){
        super("The feature "+feature+" with ID: "+id+" not found");
    }
}
