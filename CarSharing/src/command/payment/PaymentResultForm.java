package command.payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import command.MainCommand;

public class PaymentResultForm implements MainCommand{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("msg", "7");
		
		return "/view/member/resultMember.jsp";
	}

}
