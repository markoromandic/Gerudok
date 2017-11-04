package model;

import java.awt.Graphics;

public class Shape {
	private int shapeType, x, y, width, height, realX, realY, pocX, pocY;
	public int getType() {
		return shapeType;
	}
	public void setType(int newType){
		shapeType = newType;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int newX){
		x = newX;
	}
	
	public int getY(){
		return y;
	}
	
	public void setY(int newY){
		y = newY;
	}
	
	public int getWidth(){
		return width;
		
	}
	
	public void setWidth(int newWidth){
		width = newWidth;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setHeight(int newHeight){
		height = newHeight;
	}
	public int getRealX() {
		return realX;
	}
	public void setRealX(int realX) {
		this.realX = realX;
	}
	public int getRealY() {
		return realY;
	}
	public void setRealY(int realY) {
		this.realY = realY;
	}
	public int getPocX() {
		return pocX;
	}
	public void setPocX(int pocX) {
		this.pocX = pocX;
	}
	public int getPocY() {
		return pocY;
	}
	public void setPocY(int pocY) {
		this.pocY = pocY;
	}
	
	
}
