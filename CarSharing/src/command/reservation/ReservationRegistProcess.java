package command.reservation;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import command.MainCommand;
import model.reservation.ReservationDAO;
import model.reservation.ReservationDTO;

public class ReservationRegistProcess implements MainCommand{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReservationDTO dto = new ReservationDTO();
		ReservationDAO dao = ReservationDAO.getInstance();
		HttpSession session = request.getSession();
		
		 //upload처리
	     String filename="";
	     String realFolder = "c:\\upload\\driverLicense";//웹 어플리케이션상의 절대 경로
	     int maxSize = 10 * 1024 * 1024;//5mb - 전송될 파일의 최대 크기
	     String encType = "utf-8";
	     
	     //MultipartRequest객체 생성
	     MultipartRequest multi 
	      = new MultipartRequest(request,
	    		                 realFolder,
	    		                 maxSize, 
	    		                 encType, 
	    		                 new DefaultFileRenamePolicy());
	  
	     //전송된 파일정보 얻기
	     Enumeration files = multi.getFileNames();
	     String fname =(String)files.nextElement();
	     String fileName = multi.getFilesystemName(fname);//전송되어서 서버로 넘어온파일명
		
	     String birth1 = multi.getParameter("birthyy");
	     String birth2 = multi.getParameter("birthmm");
	     String birth3 =  multi.getParameter("birthdd");
	     String birth = birth1+"/"+birth2+"/"+birth3;
	     
	     String phone1 = multi.getParameter("phone1");
	     String phone2 =  multi.getParameter("phone2");
	     String phone3 = multi.getParameter("phone3");
	     String phone = phone1+"-"+phone2+"-"+phone3;
	     

		//mulitipart로 파라미터받아서  처리예정
		
		dto.setCarNumber(multi.getParameter("carNumber"));
		dto.setCarName(multi.getParameter("carName"));
		dto.setRetalFeePerDay(Integer.parseInt(multi.getParameter("retalFeePerDay")));
		
		String CarPickupDate = multi.getParameter("carPickupDate");
		String CarReturnDate = multi.getParameter("carReturnDate");
		dto.setCarPickupDate(CarPickupDate);
		dto.setCarReturnDate(CarReturnDate);		
		
		dto.setMemberId((String)session.getAttribute("sessionId"));
		dto.setName(multi.getParameter("name"));
		dto.setBirth(birth);
		dto.setPhone(phone);
		dto.setDriverLicence(fileName);
		
		
		String msg = dao.registReservation(dto);
		
		request.setAttribute("msg", msg);
		
		return "/view/member/resultMember.jsp";
	}

}
