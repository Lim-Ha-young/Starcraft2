package com.blog.naver.lhy.model;

public class Unit {
	private int hp;
	private int power;
	private int depence;
	private int attackRange;
	private Location loc;
	
	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}
	
	

	public Unit(int power, int depence){
		this.power=power;
		this.depence=depence;
		
	}
	
	public void inform(){
		System.out.println("inform");
	}

	public boolean isAttackable(Unit target){
		Location myLoc =this.loc;
		Location targetLoc=target.getLoc();
		
		double distance=myLoc.getDistance(targetLoc);
		
		return distance <= this.attackRange;
	}
	public void attack(Unit target) {
		target.attacked(this.power);
	}

	public void attacked(int power) {
		int amount;
		
		amount=power-this.depence;
		this.hp-=amount;
	}
	
	public void move(int x,int y){
		this.loc.move(x,y);
		
	}
}
