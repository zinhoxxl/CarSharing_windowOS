package command.car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.MainCommand;
import model.car.CarDAO;

public class CarDeleteProcess implements MainCommand{

	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(request.getParameter("num"));
		
		CarDAO dao = CarDAO.getInstance();
		String num1 = request.getParameter("num");
		int num = Integer.parseInt(num1);
		
		
		dao.deleteCarInfo(num);	
		
		return "/CarManagementAction.car";
	}

}
