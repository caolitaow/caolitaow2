package com.md02;

public class MyPoint {
  public int x;
  public int y;
  MyPoint(int x,int y){
  this.x=x;
  this.y=y;
  }
 
  MyPoint(){}
  public void setX(int x){
   this.x=x;
  }
  public void setY(int y){
    this.y=y;
  }
  public String toString() {
    return ("[" + x + "," + y + "]");
  }
}

