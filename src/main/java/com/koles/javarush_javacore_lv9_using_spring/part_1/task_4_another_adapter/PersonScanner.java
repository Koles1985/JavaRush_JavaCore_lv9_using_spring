/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_1.task_4_another_adapter;

import java.io.IOException;

/**
 *
 * @author User
 */
public interface PersonScanner {
    Person read() throws IOException;
    void close() throws IOException;
}
