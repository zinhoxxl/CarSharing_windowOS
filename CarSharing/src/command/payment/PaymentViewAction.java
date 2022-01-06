package command.payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.MainCommand;
import model.payment.PaymentDAO;
import model.payment.PaymentDTO;
import model.reservation.ReservationDAO;
import model.reservation.ReservationDTO;

public class PaymentViewAction implements MainCommand{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int reservationNo=Integer.parseInt(request.getParameter("reservationNo"));
		
		ReservationDTO resvDto = new ReservationDTO();
		ReservationDAO resvDao = ReservationDAO.getInstance();
		
		resvDto = resvDao.getRentCarUsingDate(reservationNo);
	

		request.setAttribute("resvDto", resvDto);
		
		return "/view/payment/paymentView.jsp";
	}
}