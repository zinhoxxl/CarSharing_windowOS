package command.reservation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.MainCommand;
import model.reservation.ReservationDAO;
import model.reservation.ReservationDTO;

public class ReservationListProcess implements MainCommand{
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		 HttpSession session = request.getSession(); 
		 String memberId =(String)session.getAttribute("sessionId")==null?"null":(String)session.getAttribute("sessionId");
		 
		 if(memberId.equals("null")) {
				request.setAttribute("msg", "5");//sessionId가 없을때(로그인 상태 아닐때) result로그인을 해주세요 라고 안내 내역이 없다고 안내
				return "/view/member/resultMember.jsp";
			}else {
		 
		ReservationDAO dao = ReservationDAO.getInstance();
		List<ReservationDTO> dtoList = new ArrayList<ReservationDTO>();
		
		int total_record = dao.getListCount(memberId);
		dtoList = dao.getReservList(memberId);
		
		request.setAttribute("total_record", total_record); // 예약 전체 갯수
		request.setAttribute("dtoList", dtoList);
		
		return "/view/Reservation/reservationList.jsp";
			}
	}
}
