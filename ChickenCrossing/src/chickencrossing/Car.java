package chickencrossing;

import java.awt.Color;

import processing.core.PApplet;

public class Car {
	//global variables
	private float xPos;
	private float yPos;
	private float xSpeed;
	private Color carColor;
	private float carHeight;
	private float carWidth;
	private PApplet carApplet;
	
	//constructor - special function that creates a basic obj
	public Car (PApplet tempApplet, float tempXpos, float tempYpos, float tempXSpeed, Color tempCarColor){
		carApplet = tempApplet;
		xPos=tempXpos;
		yPos=tempYpos;
		xSpeed=tempXSpeed;
		carColor=tempCarColor;
		carHeight=15;
		carWidth=30;
	}
	public void display(){
		carApplet.fill(carColor.getRGB());
		carApplet.rect(xPos, yPos, carWidth, carHeight);
		carApplet.fill(0);
		carApplet.ellipse(xPos+5, yPos+15, 5, 5);
		carApplet.ellipse(xPos+25, yPos+15, 5, 5);
		
	}
	public void move(){
		xPos+=xSpeed;
		if(xPos>carApplet.width){
			xPos=0;
		}
	}
	public float getxPos() {
		return xPos;
	}
	public float getyPos() {
		return yPos;
	}
	public float getxSpeed() {
		return xSpeed;
	}
	public Color getCarColor() {
		return carColor;
	}
	public float getCarHeight() {
		return carHeight;
	}
	public float getCarWidth() {
		return carWidth;
	}
	public void setxPos(float xPos) {
		this.xPos = xPos;
	}
	public void setyPos(float yPos) {
		this.yPos = yPos;
	}
	public void setxSpeed(float xSpeed) {
		this.xSpeed = xSpeed;
	}
	public void setCarColor(Color carColor) {
		this.carColor = carColor;
	}
	public void setCarHeight(float carHeight) {
		this.carHeight = carHeight;
	}
	public void setCarWidth(float carWidth) {
		this.carWidth = carWidth;
	}
	
}
