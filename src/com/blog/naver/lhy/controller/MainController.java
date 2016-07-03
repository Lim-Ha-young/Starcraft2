package com.blog.naver.lhy.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.blog.naver.lhy.model.Marine;
import com.blog.naver.lhy.model.Unit;



public class MainController {
	static List <Unit> unitList = new ArrayList<Unit>();
	static Scanner scanner= new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		while(true){
			System.out.println("1. 마린생성");
			System.out.println("2. 파이어뱃생성");
			System.out.println("3. 유닛 현황 보기");
			
			int input = scanner.nextInt();
			
			switch(input){
			case 1:
				requestUnitName();
				makeMarine();
				
				//new marine
				break;
			case 2:
				//new firebaet
				break;
			case 3:
				printUnits();
				break;
				
				
			case 4:
				Unit selectUnit=selectUnit(unitList);
				selectUnit.inform();
				
				postProcessSelectUnit(selectUnit);				
				break;
			
				
				
			}
		
		}

	}
	private static void postProcessSelectUnit(Unit selectUnit) {
		System.out.println("1.공격");
		System.out.println("2.이동");
		
		int input2=scanner.nextInt();		
		switch(input2){
			case 1:
				List<Unit> attacakableUnits=new ArrayList<Unit>();
				for(Unit target:unitList){
					if(target == selectUnit){
						continue;
					}
					
					if(selectUnit.isAttackable(target)){
						attacakableUnits.add(target);
					}
					
				}
				if (attacakableUnits.size() == 0 ) {
					System.out.println("공격 가능한 유닛 없");
				}				
				
				Unit targetUnit=selectUnit(attacakableUnits);
				selectUnit.attack(targetUnit);
				targetUnit.inform();
				break;
				
				
			case 2:
				System.out.println("이동할 x좌표 입력해주셔요");
				int dx=scanner.nextInt();
				System.out.println("이동할 y좌표 입력해주셔요");
				int dy=scanner.nextInt();
				
				selectUnit.move(dx,dy);
				selectUnit.inform();
				break;
				
		}
	}
	
	
	//이걸 이용하기 
	
	private static Unit selectUnit(List<Unit> unitList){
		for(Unit unit: unitList){
			System.out.println(unitList.indexOf(unit));
			unit.inform();
		}
		int input = scanner.nextInt();
		Unit unit=unitList.get(input-1);
		
		return null;
	}
	
	
	
	
	//alt shift m
	private static String requestUnitName() {
		System.out.println("이름을 입력하세요.");
		String name = scanner.next();		
		return name;
	}
	
	private static void makeMarine(){
		String name=requestUnitName();
		Marine marine=new Marine(name);
		unitList.add(marine);
		
	}
	private static void printUnits(){
		for(Unit unit : unitList){
			unit.inform();
		}
		
		
	}

}
