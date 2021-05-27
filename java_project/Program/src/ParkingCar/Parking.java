package ParkingCar;

import java.util.ArrayList;
import java.util.Scanner;

public class Parking {
	Scanner sc = new Scanner(System.in);
	private int car;
	private String carNo;
	private int parkingT;
	private int parkingM;
	private ArrayList<Parking> parking = new ArrayList<Parking>();
	
	public int getCar() {
		return car;
	}
	public void setCar(int car) {
		this.car = car;
	}
	public String getCarNo() {
		return carNo;
	}
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	public int getParkingT() {
		return parkingT;
	}
	public void setParkingT(int parkingT) {
		this.parkingT = parkingT;
	}
	public int getParkingM() {
		return parkingM;
	}
	public void setParkingM(int parkingM) {
		this.parkingM = parkingM;
	}
	
	void showInfo() {
		while(true) {
			System.out.println("주차장관리시스템입니다.");
			System.out.println("[1]입차 [2]출차 [3]현재 주차장 상황 [4]요금정보 [5]종료" );
			int input = sc.nextInt();
			switch(input) {
			case 1:
				inCar();
				break;
			}
		}
	}
	
	void inCar() {
		
	}

	
}
