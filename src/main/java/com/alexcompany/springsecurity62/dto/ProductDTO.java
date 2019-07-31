package com.alexcompany.springsecurity62.dto;

public class ProductDTO {

    private String name;
    private Integer price;
    private Integer amount;
    private String manufacturer;

    // error
    private String invalidName;
    private String invalidPrice;
    private String invalidAmount;
    private String invalidManufacturer;
    private String alreadyExists;

    public String getInvalidName() {
        return invalidName;
    }

    public void setInvalidName(String invalidName) {
        this.invalidName = invalidName;
    }

    public String getInvalidPrice() {
        return invalidPrice;
    }

    public void setInvalidPrice(String invalidPrice) {
        this.invalidPrice = invalidPrice;
    }

    public String getInvalidAmount() {
        return invalidAmount;
    }

    public void setInvalidAmount(String invalidAmount) {
        this.invalidAmount = invalidAmount;
    }

    public String getInvalidManufacturer() {
        return invalidManufacturer;
    }

    public void setInvalidManufacturer(String invalidManufacturer) {
        this.invalidManufacturer = invalidManufacturer;
    }

    public String getAlreadyExists() {
        return alreadyExists;
    }

    public void setAlreadyExists(String alreadyExists) {
        this.alreadyExists = alreadyExists;
    }

    public ProductDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
