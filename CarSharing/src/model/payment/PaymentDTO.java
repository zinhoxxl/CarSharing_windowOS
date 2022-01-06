package model.payment;

public class PaymentDTO {
	
	private int reservationNo;//예약번호
	private String name;//이름
    private String memberId;//아이디
    private String birth;//생년월일
    private String phone;//전화번호
    private int rentalFeePerDay; //일일 렌트비
    private int totalRentalFee; // 총렌트비
    private int rentalDate; // 렌트기간(일)
    
    
	public int getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(int reservationNo) {
		this.reservationNo = reservationNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRentalFeePerDay() {
		return rentalFeePerDay;
	}
	public void setRentalFeePerDay(int rentalFeePerDay) {
		this.rentalFeePerDay = rentalFeePerDay;
	}
	public int getTotalRentalFee() {
		return totalRentalFee;
	}
	public void setTotalRentalFee(int totalRentalFee) {
		this.totalRentalFee = totalRentalFee;
	}
	public int getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(int rentalDate) {
		this.rentalDate = rentalDate;
	}
}
