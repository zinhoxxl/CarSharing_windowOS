package command.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.MainCommand;
import model.car.CarDAO;
import model.car.CarDTO;

public class ReservationRegistForm implements MainCommand{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String carNumber = request.getParameter("carNumber");
		System.out.println("넘어온 차량 넘버"+carNumber);
		CarDTO dto = new CarDTO();
		CarDAO dao = CarDAO.getInstance();
		
		dto=dao.getCarInfo(carNumber);
		
		request.setAttribute("dto", dto);
		
		return "/view/Reservation/reservationRegistration.jsp";
	}
}
