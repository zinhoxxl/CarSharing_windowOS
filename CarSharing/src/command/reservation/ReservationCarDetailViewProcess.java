package command.reservation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.MainCommand;
import model.car.CarDAO;
import model.car.CarDTO;

public class ReservationCarDetailViewProcess implements MainCommand{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CarDTO dto = new CarDTO();
		CarDAO dao = CarDAO.getInstance();
		
		
		
		request.setAttribute("dto", dto);
		
		return "/view/Reservation/reservationDetailView.jsp";
	}

}
