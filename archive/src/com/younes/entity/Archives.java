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
public class Archives {
    private Integer id;
    private String title;
    private String numberarchive;
    private String datetime;
    private String image;
    private Integer cid;

    public Archives() {
    }

    public Archives(String title, String numberarchive, String datetime, String image, Integer cid) {
        this.title = title;
        this.numberarchive = numberarchive;
        this.datetime = datetime;
        this.image = image;
        this.cid = cid;
    }

    public Archives(Integer id, String title, String numberarchive, String datetime, String image, Integer cid) {
        this.id = id;
        this.title = title;
        this.numberarchive = numberarchive;
        this.datetime = datetime;
        this.image = image;
        this.cid = cid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumberarchive() {
        return numberarchive;
    }

    public void setNumberarchive(String numberarchive) {
        this.numberarchive = numberarchive;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Archives{" + "id=" + id + ", title=" + title + ", numberarchive=" + numberarchive + ", datetime=" + datetime + ", image=" + image + ", cid=" + cid + '}';
    }

}
