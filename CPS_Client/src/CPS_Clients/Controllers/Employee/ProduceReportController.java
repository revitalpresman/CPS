package CPS_Clients.Controllers.Employee;

import CPS_Clients.ConstsEmployees;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ProduceReportController extends EmployeeBaseController 
{

    @FXML
    void OnReservationReport(ActionEvent event) 
    {

    }

    @FXML
    void OnComaplaintsReport(ActionEvent event) 
    {
    	myControllersManager.SetScene(ConstsEmployees.Table,ConstsEmployees.ProduceReport);
    }

    @FXML
    void OnDisabledParkingSpotReport(ActionEvent event) 
    {

    }

    @FXML
    void OnPerformanceReport(ActionEvent event) 
    {

    }

    @FXML
    void OnActivityReport(ActionEvent event) 
    {

    }

    @FXML
    void OnBack(ActionEvent event) 
    {
    	myControllersManager.Back(PreviousScene,ConstsEmployees.ProduceReport );

    }

    @FXML
    void OnStatusReport(ActionEvent event) 
    {	

    }

}
