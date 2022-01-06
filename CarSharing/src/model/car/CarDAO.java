package model.car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CarDAO {
	private static CarDAO instance;
	 private CarDAO() {};
	   public static CarDAO getInstance(){
		   if(instance==null) instance = new CarDAO();

		   return instance;
	   }
	   
	 //차량테이블에 등록된 모든 차량 화면에 뿌리기
	public ArrayList<CarDTO> getAvailableCarList() {
			ArrayList<CarDTO> dtolist = new ArrayList<>();

			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;

			  String sql="select * from car order by carNumber";
	 try {
		    conn=database.DBConnection.getConnection();
		    pstmt=conn.prepareStatement(sql);
		    rs=pstmt.executeQuery();
		    
		    while(rs.next()) {
		    	CarDTO dto = new CarDTO();
		    	dto.setNum(rs.getInt(1));
		    	dto.setCarNumber(rs.getString(2));
		    	dto.setCarSort(rs.getString(3));
		    	dto.setCarName(rs.getString(4));
		    	dto.setRetalFeePerDay(rs.getInt(5));
		    	dto.setCarPic(rs.getString(6));

		    	dtolist.add(dto);
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
			System.out.println("dtolist의 길이"+dtolist.size());
			return dtolist;
		}
		
		
		//예약 페이지로 차량번호에 다른 차량정보 넘기기
	public CarDTO getCarInfo(String carNumber) {
			CarDTO dto = new CarDTO();
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;

			  String sql="select * from car where carNumber=?";
	 try {
		    conn=database.DBConnection.getConnection();
		    pstmt=conn.prepareStatement(sql);
		    pstmt.setString(1, carNumber);
		    rs=pstmt.executeQuery();
		    
		    while(rs.next()) {
		    	dto.setNum(rs.getInt(1));
		    	dto.setCarNumber(rs.getString(2));
		    	dto.setCarSort(rs.getString(3));
		    	dto.setCarName(rs.getString(4));
		    	dto.setRetalFeePerDay(rs.getInt(5));
		    	dto.setCarPic(rs.getString(6));
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
}// getCarInfo끝
		
	
	//전체 차량리스트 페이지로 전달
	public List<CarDTO> getCarList() {
		List<CarDTO> dtoList = new ArrayList<CarDTO>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		  String sql="select * from car order by carNumber";
 try {
	    conn=database.DBConnection.getConnection();
	    pstmt=conn.prepareStatement(sql);
	    rs=pstmt.executeQuery();
	    
	    while(rs.next()) {
	    	CarDTO dto = new CarDTO();
	    	
	    	dto.setNum(rs.getInt(1));
	    	dto.setCarNumber(rs.getString(2));
	    	dto.setCarSort(rs.getString(3));
	    	dto.setCarName(rs.getString(4));
	    	dto.setRetalFeePerDay(rs.getInt(5));
	    	dto.setCarPic(rs.getString(6));
	    	
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
			return dtoList;
		}
	
	//선택된 차량의 정보 수정
	public CarDTO viewCarInfo(String carNumber) {
		CarDTO dto = new CarDTO();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		  String sql="select * from car where carNumber=?";
 try {
	    conn=database.DBConnection.getConnection();
	    pstmt=conn.prepareStatement(sql);
	    pstmt.setString(1, carNumber);
	    rs = pstmt.executeQuery();
	    
	    while(rs.next()) {
	    	dto.setNum(rs.getInt("num"));
	    	dto.setCarNumber(rs.getString("carNumber"));
	    	dto.setCarSort(rs.getString("carSort"));
	    	dto.setCarName(rs.getString("carName"));
	    	dto.setRetalFeePerDay(rs.getInt("retalFeePerDay"));
	    	dto.setCarPic(rs.getString("carPic"));
	    }
	}catch(Exception e) {
		  System.out.println("에러:"+e);
	}finally {
		  try {
			  	if(rs!=null) rs.close();
			    if(pstmt!=null) pstmt.close();
			    if(conn!=null)conn.close();
		  }catch(Exception e) {
			  throw new RuntimeException(e.getMessage());
		  }
		}
 	return dto;		
	}//viewCarInfo끝
	
	
	public void updateCarInfo(CarDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		  String sql="update car set carNumber=?, carSort=?, carName=?, retalFeePerDay=?, carPic=? where num=?";
 try {
	    conn=database.DBConnection.getConnection();
	    pstmt=conn.prepareStatement(sql);
	    pstmt.setString(1, dto.getCarNumber());
	    pstmt.setString(2, dto.getCarSort());
	    pstmt.setString(3, dto.getCarName());
	    pstmt.setInt(4, dto.getRetalFeePerDay());
	    pstmt.setString(5, dto.getCarPic());
	    pstmt.setInt(6, dto.getNum());
	    
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
	}//updateCarInfo끝
	
	//신규차량정보 등록
	public void insertNewCarInfo(CarDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		  String sql="insert into car values(null,?,?,?,?,?)";
 try {
	    conn=database.DBConnection.getConnection();
	    pstmt=conn.prepareStatement(sql);
	    pstmt.setString(1, dto.getCarNumber());
	    pstmt.setString(2, dto.getCarSort());
	    pstmt.setString(3, dto.getCarName());
	    pstmt.setInt(4, dto.getRetalFeePerDay());
	    pstmt.setString(5, dto.getCarPic());
    
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
		
	}//insertNewCarInfo끝
	
	//차량정보 삭제
	public void deleteCarInfo(int num) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		  String sql="delete from car where num=?";
 try {
	    conn=database.DBConnection.getConnection();
	    pstmt=conn.prepareStatement(sql);
	    pstmt.setInt(1, num);
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
		
		
	}//deleteCarInfo끝
	
	

}
