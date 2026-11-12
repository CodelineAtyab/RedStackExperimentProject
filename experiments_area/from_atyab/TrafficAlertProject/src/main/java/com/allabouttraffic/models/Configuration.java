package com.allabouttraffic.models;

public class Configuration {
    private static Configuration controlledConfigurationObj = null;
    private Configuration () {}

    public static Configuration getControlledObject() {
        if (controlledConfigurationObj == null) {
            controlledConfigurationObj = new Configuration();
        }
        return controlledConfigurationObj;
    }

    public String theme = "Dark";
}
