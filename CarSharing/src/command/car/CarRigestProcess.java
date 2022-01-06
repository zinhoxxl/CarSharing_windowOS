package command.car;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import command.MainCommand;
import model.car.CarDAO;
import model.car.CarDTO;

public class CarRigestProcess implements MainCommand{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CarDAO dao = CarDAO.getInstance();
		CarDTO dto = new CarDTO();
		
		 //upload처리
	     String filename="";
	     String realFolder = "c:\\upload\\carPic";//웹 어플리케이션상의 절대 경로
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
		
	     dto.setCarNumber(multi.getParameter("carNumber"));
	     dto.setCarSort(multi.getParameter("carSort"));
	     dto.setCarName(multi.getParameter("carName"));
	     dto.setRetalFeePerDay(Integer.parseInt(multi.getParameter("retalFeePerDay")));
	     dto.setCarPic(fileName);
	     
	     dao.insertNewCarInfo(dto);
		
		
		return "/CarManagementAction.car";
	}

}
