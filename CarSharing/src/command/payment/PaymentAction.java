package command.payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import command.MainCommand;
import model.payment.PaymentDAO;
import model.payment.PaymentDTO;
import model.reservation.ReservationDAO;
import model.reservation.ReservationDTO;

public class PaymentAction implements MainCommand{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 
		PaymentDTO dto = new PaymentDTO();
		PaymentDAO dao = PaymentDAO.getInstance();
		ReservationDTO resvDto = new ReservationDTO();
		ReservationDAO resvDao = ReservationDAO.getInstance();
				
	  
		int reservationNo = Integer.parseInt(request.getParameter("reservationNo"));
		dto.setReservationNo(reservationNo);
		
		dto.setName(request.getParameter("name"));
		dto.setMemberId(request.getParameter("memberId"));
		String memberId = request.getParameter("memberId");
		dto.setBirth(request.getParameter("birth"));
	 	dto.setPhone(request.getParameter("phone"));
		int totalRentalFee= Integer.parseInt(request.getParameter("totalRentalFee"));
		dto.setTotalRentalFee(totalRentalFee);
		int rentalDate= Integer.parseInt(request.getParameter("rentalDate"));
		dto.setRentalDate(rentalDate);
		dto.setRentalFeePerDay(totalRentalFee/rentalDate);
		
		resvDto.setMemberId(request.getParameter("memberId"));
				
	    dao.insertBoard(dto);
	    resvDto=resvDao.getRentCarUsingDate(reservationNo);
	    
	    
	    request.setAttribute("dto", dto);
	    request.setAttribute("resvDto", resvDto);
	     
	     return "/view/payment/paymentConfirm.jsp"; 
	     
	  
	    }
}
