package command.payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.MainCommand;
import model.payment.PaymentDAO;
import model.payment.PaymentDTO;

public class PaymentCancelAction implements MainCommand{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String reservationNo = request.getParameter("reservationNo");
		
		System.out.println("넘어온 reservationNo : "+reservationNo);
		
		PaymentDAO dao = PaymentDAO.getInstance();
		dao.deleteResvNPayment(reservationNo);
		
		
		request.setAttribute("msg", "6");
		
		return "/view/member/resultMember.jsp";
	}

}
