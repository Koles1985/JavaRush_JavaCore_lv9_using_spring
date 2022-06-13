/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring;

/**
 *
 * @author User
 */
public interface Tasks {
    
    default void print(){
        System.out.println("This is default method from Tasks interface");
    }
    
}
