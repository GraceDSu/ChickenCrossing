package chickencrossing;

import java.awt.Color;

import processing.core.PApplet;
import processing.core.PImage;

public class ImageBall {
	private PApplet bApplet;
	private float xPos;
	private float yPos;
	private float size;
	private Color bColor;
	private float vx;
	private float vy;
	private int life;
	private PImage ballImage;
	public ImageBall(PApplet bApplet, float xPos, float yPos, float size,
			Color bColor, float vx, float vy) {
		this.bApplet = bApplet;
		this.xPos = xPos;
		this.yPos = yPos;
		this.size = size;
		this.bColor = bColor;
		this.vx = vx;
		this.vy = vy;
		ballImage=bApplet.loadImage("chick.png");
		this.life=3;
	}
	
	public void display(){
		bApplet.noStroke();
		bApplet.fill(bColor.getRGB(),30f);
		bApplet.ellipse(xPos, yPos, size, size);
		bApplet.image(ballImage, xPos-18, yPos-12);
	}


	public float getxPos() {
		return xPos;
	}

	public float getyPos() {
		return yPos;
	}

	public float getSize() {
		return size;
	}

	public Color getbColor() {
		return bColor;
	}

	public float getVx() {
		return vx;
	}

	public float getVy() {
		return vy;
	}

	public void setxPos(float xPos) {
		this.xPos = xPos;
	}

	public void setyPos(float yPos) {
		this.yPos = yPos;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public void setbColor(Color bColor) {
		this.bColor = bColor;
	}

	public void setVx(float vx) {
		this.vx = vx;
	}

	public void setVy(float vy) {
		this.vy = vy;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	
}
