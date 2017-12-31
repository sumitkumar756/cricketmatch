package com.cricket.entity;

public enum Over {
	
     First(1),
     Second(2),
     Third(3),
     Fourth(4),
     Fifth(5),
     Sixth(6);
	Over(int ball){
	   	 this.ball = ball;
	    }
	private int ball;
	public int getBall() {
		return ball;
	}
  
}
  
