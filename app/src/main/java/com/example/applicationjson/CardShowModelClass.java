package com.example.applicationjson;

public class CardShowModelClass
{
    private String title;
    private String description;
    private int price;
    private String thumbnail;

    public CardShowModelClass() {
    }

    public CardShowModelClass(String title, String description, int price, String thumbnail) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "CardShowModelClass{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
