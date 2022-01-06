package model.car;

public class CarDTO {
	private int num;
	private String carNumber;
	private String carSort;
	private String carName;
	private int retalFeePerDay;
	private String carPic;
	
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public String getCarSort() {
		return carSort;
	}
	public void setCarSort(String carSort) {
		this.carSort = carSort;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getRetalFeePerDay() {
		return retalFeePerDay;
	}
	public void setRetalFeePerDay(int retalFeePerDay) {
		this.retalFeePerDay = retalFeePerDay;
	}
	public String getCarPic() {
		return carPic;
	}
	public void setCarPic(String carPic) {
		this.carPic = carPic;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

}
