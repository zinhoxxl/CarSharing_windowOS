package model.payment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;

public class PaymentDAO {
	private static PaymentDAO instance;
	 private PaymentDAO() {};
	   public static PaymentDAO getInstance(){
		   if(instance==null) instance = new PaymentDAO();
  
		   return instance;
	   }
	 
	
	
	//payment테이블에 결제 정보 저장
	public void insertBoard(PaymentDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		  
	    String sql="insert into payment values(?,?,?,?,?,?,?,?)";
		  
   try {
	    //Mysql 접속용 DBConnection객체 
	    conn=database.DBConnection.getConnection();
	    pstmt=conn.prepareStatement(sql);
	    
	    pstmt.setInt(1, dto.getReservationNo()); 
	    pstmt.setString(2,dto.getName()); 
	    pstmt.setString(3,dto.getMemberId()); 
	    pstmt.setString(4,dto.getBirth()); 
	    pstmt.setString(5,dto.getPhone()); 
	    pstmt.setInt(6, dto.getRentalFeePerDay()); 
	    pstmt.setInt(7, dto.getTotalRentalFee()); 
	    pstmt.setInt(8, dto.getRentalDate()); 
	    
	    pstmt.executeUpdate();
    
  }catch(Exception e) {
	  System.out.println("에러:"+e);
  }finally {
	  try {
		    if(pstmt!=null) pstmt.close();
		    if(conn!=null)conn.close();
	  }catch(Exception e) {
		  throw new RuntimeException(e.getMessage());
	  }
  	}
	}
	//예약취소 버튼에 의해 payment  및 reservation 테이블에서 정보 삭제처리
	public void deleteResvNPayment(String reservationNo) {
		  Connection conn=null;
		  PreparedStatement pstmt=null;
	  
		  String sql="delete from reservation where reservationNo=?";
  
   try {
	    conn=database.DBConnection.getConnection();
	    pstmt=conn.prepareStatement(sql);
	    pstmt.setString(1, reservationNo);
	    pstmt.executeUpdate();
	    
	    sql="delete from payment where reservationNo=?";
	    pstmt=conn.prepareStatement(sql);
	    pstmt.setString(1, reservationNo);
	    pstmt.executeUpdate();
	
  }catch(Exception e) {
	  System.out.println("에러:"+e);
  }finally {
	  try {
		    if(pstmt!=null) pstmt.close();
		    if(conn!=null)conn.close();
	  }catch(Exception e) {
		  throw new RuntimeException(e.getMessage());
	  }
  }
		
	}//deleteResvNPayment 끝
}
	   