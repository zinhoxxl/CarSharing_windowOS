package command.reservation;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.MainCommand;
import model.car.CarDAO;
import model.car.CarDTO;

public class ReservationCarListProcess implements MainCommand{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		CarDAO dao = CarDAO.getInstance();
		ArrayList<CarDTO> dtoList = new ArrayList<>();
		
		dtoList = dao.getAvailableCarList();

		request.setAttribute("dtoList", dtoList); //리스트형태로 이용가능 차량 정보화면으로 보내기
		return "/view/Reservation/reservationView.jsp";
	}

}
