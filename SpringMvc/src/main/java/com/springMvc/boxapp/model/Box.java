package com.springMvc.boxapp.model;

public class Box {
private int id;
private String name;
private float weight;
private String color;
private String country;
private double cost;

public Box(){
}
public Box(String name,float weight,String color,String country,double cost){
	this.name=name;
	this.weight=weight;
	this.color=color;
	this.country=country;
	this.cost=cost;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getWeight() {
	return weight;
}
public void setWeight(float weight) {
	this.weight = weight;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public double getCost() {
	return cost;
}
public void setCost(double cost) {
	this.cost = cost;
}

}
