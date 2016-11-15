package com.company;

/**
 * Created by flmbrk on 07.11.2016.
 */
public enum Color {

    WHITE("\\u001B[37m"),
    GREY("\\u001B[30m"),
    GREEN("\\u001B[32m"),
    ORANGE("\\u001B[33m"),
    PURPLE("\\u001B[35m"),
    BLUE("\\u001B[34m"),
    RED("\\u001B[31m");

    private String colorPattern;
    Color(String colorPattern){
            this.colorPattern = colorPattern;
        }

    public String getColor(){
        return this.colorPattern;
    }

}
