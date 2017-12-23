package CPS_Clients.Controllers.Employee;



//import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import CPS_Clients.ConstsEmployees;
import CPS_Clients.Controllers.BaseController;
//import CPS_Clients.ConstsWeb;
import CPS_Utilities.Consts;
import CPS_Utilities.DialogBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert.AlertType;

public class ParkingLotWorkerEnteryController extends BaseController {
	
	//private ArrayList<String> DisableParkingLotInputs = new ArrayList<>();
	private ArrayList<String> DisableParkingSpotInputs = new ArrayList<>();
	public ParkingLotWorkerEnteryController()
	{
		super();
		DisableParkingSpotInputs.add("Parking Spot Number:");
	}
	
    @FXML
    void OnInitializeParkingLot(ActionEvent event) 
    {
    	//Check if empty(first time?)
    	//initialize. do we have to insert here size?
    	DialogBuilder.AlertDialog(AlertType.INFORMATION, "", ConstsEmployees.ParkingLotWasinitialized, null,false);
    	
    }

    @FXML
    void OnRegisterDisabeledParkingLot(ActionEvent event) 
    {
    	String result =DialogBuilder.AlertDialog(AlertType.CONFIRMATION,"" , ConstsEmployees.ConfirmParkingLotDisabled, null,false);
    	if (result.equals("OK"))
    	{
    		//submit disabled parking lot in DB
    		DialogBuilder.AlertDialog(AlertType.INFORMATION, "", ConstsEmployees.ParkingLotDisabled, null,false);
    	}
    }

    @FXML
    void OnReserveParkingSpot(ActionEvent event) 
    {
    	Dialog<List<String>> dialog = DialogBuilder.InputsDialog(Consts.FillRequest, DisableParkingSpotInputs, Consts.Submit);
    	Optional<List<String>> result = dialog.showAndWait();
		/////////////////check if submit was clicked
		{
		//save in DB
		DialogBuilder.AlertDialog(AlertType.INFORMATION, "", ConstsEmployees.ParkingSpotReserved, null,false);
		}
    	
    	
    }

    @FXML
    void OnRegisterDisabeledParkingSpot(ActionEvent event) 
    {
    	Dialog<List<String>> dialog = DialogBuilder.InputsDialog(Consts.FillRequest, DisableParkingSpotInputs, Consts.Submit);
    	Optional<List<String>> result = dialog.showAndWait();
    	/////////////////check if submit was clicked
    	{
    	//save in DB
    	DialogBuilder.AlertDialog(AlertType.INFORMATION, "", ConstsEmployees.ParkingSpotDisabled, null,false);
    	}
    }

    @FXML
    void onBack(ActionEvent event) 
    {
    	myControllersManager.Back(PreviousScene,ConstsEmployees.ParkingLotWorkerEntery );
    }

}
