package com.blog.naver.lhy.model;

public class Location {
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Location() {
		this.x = 0;
		this.y = 0;
	}

	public double getDistance(Location target) {
		double dx = Math.pow(this.x - target.getX(), 2);
		double dy = Math.pow(this.y - target.getY(), 2);
		return Math.sqrt(dx + dy);
	}

	public void move(int x, int y) {
		this.x += x;
		this.y += y;

	}
}
