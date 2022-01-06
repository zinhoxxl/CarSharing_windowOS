package model.reservation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.car.CarDTO;

public class ReservationDAO {
	private static ReservationDAO instance;
	 private ReservationDAO() {};
	   public static ReservationDAO getInstance(){
		   if(instance==null) instance = new ReservationDAO();
 
		   return instance;
	   }
	   
	
	public ReservationDTO getRentCarUsingDate(int reservationNo) {
		ReservationDTO dto = new ReservationDTO();
		
		  Connection conn=null;
		  PreparedStatement pstmt=null;
		  ResultSet rs=null;
		  String carPickupDate = null;
		  String carReturnDate = null;
		  int retalFeePerDay = 0;
		  int rentaldate = 0;
		  

		  String sql="select * from reservation where reservationNo=?";
   try {
	    conn=database.DBConnection.getConnection();
	    pstmt=conn.prepareStatement(sql);
	    pstmt.setInt(1, reservationNo); 
	    rs=pstmt.executeQuery();
	    
	    if(rs.next()) {
	    	dto.setReservationNo(rs.getInt("reservationNo"));
	    	dto.setCarNumber((rs.getString("carNumber")));
	    	dto.setCarName(rs.getString("carName"));
	    	dto.setDriverLicence(rs.getString("driverLicence"));
	    	dto.setMemberId(rs.getString("memberId"));
	    	dto.setName(rs.getString("name"));
	    	dto.setBirth(rs.getString("birth"));
	    	dto.setPhone(rs.getString("phone"));

	    	Date PickupDate = rs.getDate("carPickupDate");
	    	Date ReturnDate = rs.getDate("carReturnDate");
	    	carPickupDate = PickupDate.toString();
	    	carReturnDate = ReturnDate.toString();
	    	dto.setCarPickupDate(carPickupDate);
	    	dto.setCarReturnDate(carReturnDate);
	    	
	    	retalFeePerDay = rs.getInt("retalFeePerDay");
	    	
		    sql="select datediff('"+carReturnDate+"','"+carPickupDate+"')";
		    System.out.println("렌트기간 조회 쿼리문"+sql);
		    
		    pstmt=conn.prepareStatement(sql);
		    
		    rs=pstmt.executeQuery();
		    if(rs.next()) {
		    	dto.setRentalDate(rs.getInt(1));
		    	rentaldate = rs.getInt(1);
		    	dto.setTotalRentalFee(rentaldate*retalFeePerDay);
		    }
	    }
  }catch(Exception e) {
	  System.out.println("에러:"+e);
  }finally {
	  try {
		    if(rs!=null) rs.close(); if(pstmt!=null) pstmt.close();
		    if(conn!=null)conn.close();
	  }catch(Exception e) {
		  throw new RuntimeException(e.getMessage());
	  }
  }
   	return dto;
	}//getRentCarUsingDate끝
	
	//예약FORM에서 받는 파라미터 DB에 등록처리
	public String registReservation(ReservationDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String carReturnDate = dto.getCarReturnDate();
		String carPickupDate = dto.getCarPickupDate();
		int diffDate = 0;
		
		String sql="select datediff('"+carReturnDate+"','"+carPickupDate+"')";
			 
 try {
	    conn=database.DBConnection.getConnection();
	    pstmt=conn.prepareStatement(sql);
	    rs = pstmt.executeQuery();
	    if(rs.next()) {
	    	diffDate = rs.getInt(1);
	    }

	    sql="insert into reservation values (null,?,?,?,?,?,?,?,?,?,?,?,?)"; 
	    pstmt=conn.prepareStatement(sql);
	    pstmt.setString(1, dto.getCarNumber());
	    pstmt.setString(2, dto.getCarName());
	    pstmt.setInt(3, dto.getRetalFeePerDay());
	    pstmt.setString(4, dto.getCarPickupDate());
	    pstmt.setString(5,dto.getCarReturnDate());
	    pstmt.setInt(6, diffDate);
	    pstmt.setInt(7,diffDate*dto.getRetalFeePerDay());
	    pstmt.setString(8, dto.getMemberId());
	    pstmt.setString(9, dto.getName());
	    pstmt.setString(10, dto.getBirth());
	    pstmt.setString(11, dto.getPhone());
	    pstmt.setString(12, dto.getDriverLicence());
	    
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
		
		return "8";
	}//registReservation끝
	

	//예약리스트 전체 갯수
	public int getListCount(String memberId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		
		String sql="select count(*) from reservation where memberId=?";
			 
 try {
	    conn=database.DBConnection.getConnection();
	    pstmt=conn.prepareStatement(sql);
	    pstmt.setString(1, memberId);
	    rs = pstmt.executeQuery();
	    
	    
	    if(rs.next())
	    	count = rs.getInt(1);

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
		return count;
	}//getListCount 끝
	
	//해당 아이디에 대한 예약 전체 리스트 리턴
	public List<ReservationDTO> getReservList(String memberId) {
		List<ReservationDTO> dtoList = new ArrayList<ReservationDTO>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		  String sql="select * from reservation where memberId=? order by reservationNo";
		  
 try {
	    conn=database.DBConnection.getConnection();
	    pstmt=conn.prepareStatement(sql);
	    pstmt.setString(1, memberId);
	    rs=pstmt.executeQuery();
	    
	    while(rs.next()) {
	    	ReservationDTO dto = new ReservationDTO();
	    	dto.setReservationNo(rs.getInt("reservationNo"));
	    	dto.setMemberId(rs.getString("memberId"));
	    	dto.setName(rs.getString("name"));
	    	Date PickupDate = rs.getDate("carPickupDate");
	    	Date ReturnDate = rs.getDate("carReturnDate");
	    	String carPickupDate = PickupDate.toString();
	    	String carReturnDate = ReturnDate.toString();
	    	dto.setCarPickupDate(carPickupDate);
	    	dto.setCarReturnDate(carReturnDate);
	    	dto.setCarName(rs.getString("carName"));
	    
	    	dtoList.add(dto);
	    }
}catch(Exception e) {
	  System.out.println("에러:"+e);
}finally {
	  try {
		    if(rs!=null) rs.close(); if(pstmt!=null) pstmt.close();
		    if(conn!=null)conn.close();
	  }catch(Exception e) {
		  throw new RuntimeException(e.getMessage());
	  }
}
		System.out.println("dtolist의 길이"+dtoList.size());

		return dtoList;
	}
}
