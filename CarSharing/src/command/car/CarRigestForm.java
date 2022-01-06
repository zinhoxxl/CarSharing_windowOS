package command.car;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import command.MainCommand;

public class CarRigestForm implements MainCommand{
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		return "/view/car/CarRegistForm.jsp";
	}
}
