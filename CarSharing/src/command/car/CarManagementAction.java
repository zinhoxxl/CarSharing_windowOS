package command.car;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.MainCommand;
import model.car.CarDAO;
import model.car.CarDTO;

public class CarManagementAction implements MainCommand{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<CarDTO> dtoList = new ArrayList<CarDTO>();
		CarDAO dao = CarDAO.getInstance();
		
		dtoList = dao.getCarList();
		
		request.setAttribute("dtoList", dtoList);
		
		return "/view/car/CarManagementView.jsp";
	}
}
