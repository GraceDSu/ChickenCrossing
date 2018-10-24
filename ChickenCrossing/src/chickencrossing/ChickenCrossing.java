package chickencrossing;

import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;


public class ChickenCrossing extends PApplet {
	private Car car1;
	private Car car2;
	private Car car3;
	private Car car4;
	private Car car5;
	private Car car6;
	private Car car7;
	private Car car8;
	private ArrayList<Car> carList = new ArrayList<Car>();
	private ArrayList<Worm> wormList = new ArrayList<Worm>();
	private ImageBall chickBall;
	
	public void setup() {
		size(600,600);
		constructCars();
		constructWorms();
		chickBall= new ImageBall(this, width-200, height-30, 30,
				Color.BLACK, 3, 3);
		chickBall.setyPos(580);
		chickBall.setxPos(width/2);
	}
	
	public void draw() {
		background(255);
		MakeLandscape();
		for(int i=0; i<wormList.size();i++){
			wormList.get(i).display();
		}
		for(Worm w:wormList){
			w.move();
		}
		for(Car c:carList){
			c.display();
		}
		for(Car c :carList){
			c.move();
		}
		if(gameOver==true){
			fill(255,0,0);
			textSize(34);
			text("GAME OVER", 200, 300);
			chickBall.setVy(0);
			chickBall.setVx(0);
		}
		fill(255,0,0);
		textSize(20);
		text("Score:"+score, 500, 550);
		text("Lives:"+chickBall.getLife(),50, 550);
		chickBall.display();
		moveChick();
		gamePlay();
	}
	public void MakeLandscape(){
		fill(25,209,59);
		rect(0,500, 600,100);
		fill(115,104,104);
		rect(0,200,600,300);
		fill(25,209,59);
		rect(0,0,600,200);
		//stripes
		fill(230,230,96);
		//rect();
	}
	public void constructCars(){
		car1= new Car(this, width/2, height/2, 4, Color.GREEN);
		
		carList.add(car1);
		car2= new Car(this, width/2, height/2-75, 6, Color.BLUE);
		
		carList.add(car2);
		car3= new Car(this, width/2, height/2+75, 3, Color.RED);
		
		carList.add(car3);
		car4= new Car(this, width/2-100, height/2+150, 5, Color.MAGENTA);
		
		carList.add(car4);
		car5= new Car(this, width/2-100, height/2+150, 4.5f, Color.CYAN);
		
		carList.add(car5);
		car6= new Car(this, width/2-100, height/2+75, 3.5f, Color.ORANGE);
		
		carList.add(car6);
		car7= new Car(this, width/2-100, height/2-75, 2, Color.GRAY);
		
		carList.add(car7);
		car8= new Car(this, width/2-100, height/2, 6.5f, Color.PINK);
		
		carList.add(car8);
	}
	
	private void constructWorms(){
		for(int i=0;i<10;i++){
			wormList.add(new Worm(this, random(15, width-15), random(height/2-100, height/2+175), random(.5f,3)));
		}
	}
	private void gamePlay(){
		//if chick eats worm, make worm disappear
		for(int i=0;i<wormList.size();i++){
			if(chickEatsWorm(chickBall,wormList.get(i))==true){
				wormList.remove(i);
				score++;
			}
		}
		if(wormList.size()<=0&& chickBall.getyPos()>=100 && gameOver==false){
			fill(255,0,0);
			textSize(34);
			text("YOU WIN",200,300);

		}
		for(int i=0;i<carList.size();i++){
			if(carHitsChick(chickBall, carList.get(i))==true&& chickBall.getLife()>0){
				fill(255,0,0);
				text("YOU DIED",250,300);
				//how to add splat noise???
				chickBall.setyPos(580);
				chickBall.setxPos(width/2);
				chickBall.setLife(chickBall.getLife()-1);
			}
			if(chickBall.getLife()<=0){
				gameOver=true;
			}
		}
	}
	public boolean gameOver= false;
	public int score = 0;
	private void chickBoundary(){
		//keep chick inside game, x left x right, y up y down
		if(chickBall.getxPos()-chickBall.getSize()<0){
			chickBall.setxPos(30);
		}
		if(chickBall.getxPos()+chickBall.getSize()>width){
			
		}
		if(chickBall.getyPos()+chickBall.getSize()<0){
			
		}
		if(chickBall.getyPos()-chickBall.getSize()>height){
			
		}
	}
	private boolean carHitsChick(ImageBall chick, Car car1){
		if(chick.getxPos()+chick.getSize()/2>car1.getxPos()
				&&chick.getxPos()-chick.getSize()/2<car1.getxPos()+car1.getCarWidth()
				&&chick.getyPos()+chick.getSize()/2>car1.getyPos()
				&&chick.getyPos()-chick.getSize()/2<car1.getyPos()+car1.getCarHeight()){
			return true;
		} else {
			return false;
		}
	}
	private boolean chickEatsWorm(ImageBall chick, Worm worm1){
		//4 cases: 1-ball touch left of rect, 2-ball touch right of rect, 3-ball touch top, 4-ball touch bottom
		if(chick.getxPos()+chick.getSize()/2>worm1.getxPos()
				&&chick.getxPos()-chick.getSize()/2<worm1.getxPos()+worm1.getWormWidth()
				&&chick.getyPos()+chick.getSize()/2>worm1.getyPos()
				&&chick.getyPos()-chick.getSize()/2<worm1.getyPos()+worm1.getWormHeight()){
			return true;
		} else {
			return false;
		}	
	}
	public void restart(){
		chickBall.setyPos(580);
		chickBall.setxPos(width/2);
		
	}
	public void moveChick(){
		//move chick with arrow keys
		//make chick move when up is pressed
		if(keyPressed==true&& key== CODED && keyCode== UP){
			chickBall.setyPos(chickBall.getyPos() - chickBall.getVy());
		}
		if(keyPressed==true&& key== CODED && keyCode== DOWN){
			chickBall.setyPos(chickBall.getyPos() + chickBall.getVy());
		}
		if(keyPressed==true&& key== CODED && keyCode== RIGHT){
			chickBall.setxPos(chickBall.getxPos() + chickBall.getVx());
		}
		if(keyPressed==true&& key== CODED && keyCode== LEFT){
			chickBall.setxPos(chickBall.getxPos() - chickBall.getVx());
		}
	}
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "chickencrossing.ChickenCrossing" });
	}
}
