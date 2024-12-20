package com.carmangement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Car name is required")
    private String name;

    @NotBlank(message = "Model is required")
    private String model;

    @Min(value = 1886, message = "Year must be valid") // Cars were invented in 1886
    private int year;

    @Min(value = 0, message = "Price must be non-negative")
    private double price;

    @NotBlank(message = "Color is required")
    private String color;

    @NotBlank(message = "Fuel type is required")
    private String fuelType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public Car(Long id, @NotBlank(message = "Car name is required") String name,
			@NotBlank(message = "Model is required") String model,
			@Min(value = 1886, message = "Year must be valid") int year,
			@Min(value = 0, message = "Price must be non-negative") double price,
			@NotBlank(message = "Color is required") String color,
			@NotBlank(message = "Fuel type is required") String fuelType) {
		super();
		this.id = id;
		this.name = name;
		this.model = model;
		this.year = year;
		this.price = price;
		this.color = color;
		this.fuelType = fuelType;
	}

	public Car() {
		super();
	}
    
    
    
}