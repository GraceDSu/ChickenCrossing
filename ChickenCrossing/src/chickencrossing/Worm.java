package chickencrossing;

import java.awt.Color;

import processing.core.PApplet;
import processing.core.PImage;

public class Worm {
	private float xPos;
	private float yPos;
	private float xSpeed;
	private float wormHeight;
	private float wormWidth;
	private PApplet wormApplet;
	private PImage wormImage;
	public Worm (PApplet tempApplet, float tempXpos, float tempYpos, float tempXSpeed){
		wormApplet = tempApplet;
		xPos=tempXpos;
		yPos=tempYpos;
		wormHeight=10;
		wormWidth=15;
		xSpeed=tempXSpeed;
		wormImage=wormApplet.loadImage("worm.png");
	}
	public void display(){
		wormApplet.image(wormImage, xPos, yPos);
	}
	public void move(){
		xPos-=xSpeed;
		if(xPos<0){
			xPos=wormApplet.width;
		}
	}
	public float getxPos() {
		return xPos;
	}
	public float getyPos() {
		return yPos;
	}
	public float getWormHeight() {
		return wormHeight;
	}
	public float getWormWidth() {
		return wormWidth;
	}
	public void setxPos(float xPos) {
		this.xPos = xPos;
	}
	public void setyPos(float yPos) {
		this.yPos = yPos;
	}
	public void setWormHeight(float wormHeight) {
		this.wormHeight = wormHeight;
	}
	public void setWormWidth(float wormWidth) {
		this.wormWidth = wormWidth;
	}
	public float getxSpeed() {
		return xSpeed;
	}
	public void setxSpeed(float xSpeed) {
		this.xSpeed = xSpeed;
	}
}
