package command.car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.MainCommand;
import model.car.CarDAO;
import model.car.CarDTO;

public class CarUpdateViewProcess implements MainCommand{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String carNumber = request.getParameter("carNumber");
		CarDAO dao = CarDAO.getInstance();
		CarDTO dto = new CarDTO();
				
		dto = dao.viewCarInfo(carNumber);
		request.setAttribute("dto", dto);

		return "/view/car/CarInfoUpdateView.jsp";
	}

}
