/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

public class Slider {

    private int sliderId;
    private String imageURL;
    private String linkURL;
    private String description;
    private Date createdDate;
    private Date modifyDate;
    private boolean status;
    private int marketerId;

    public Slider() {
    }

    public Slider(int sliderId, String imageURL, String linkURL, String description, Date createdDate, Date modifyDate, boolean status, int marketerId) {
        this.sliderId = sliderId;
        this.imageURL = imageURL;
        this.linkURL = linkURL;
        this.description = description;
        this.createdDate = createdDate;
        this.modifyDate = modifyDate;
        this.status = status;
        this.marketerId = marketerId;
    }

    public int getSliderId() {
        return sliderId;
    }

    public void setSliderId(int sliderId) {
        this.sliderId = sliderId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getLinkURL() {
        return linkURL;
    }

    public void setLinkURL(String linkURL) {
        this.linkURL = linkURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getMarketerId() {
        return marketerId;
    }

    public void setMarketerId(int marketerId) {
        this.marketerId = marketerId;
    }
}
