/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.younes.entity;

/**
 *
 * @author BOUKHTACHE
 */
public class Categories {
    private Integer id;
    private String name;

    public Categories() {
    }

    public Categories(String name) {
        this.name = name;
    }

    public Categories(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Categories{" + "id=" + id + ", name=" + name + '}';
    }
    
}
