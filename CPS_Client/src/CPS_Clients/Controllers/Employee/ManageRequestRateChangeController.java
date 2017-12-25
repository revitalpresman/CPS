package CPS_Clients.Controllers.Employee;

import java.util.ArrayList;

import clientServerCPS.RequestsSender;
import clientServerCPS.ServerResponse;
import entities.ChangeRatesRequest;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ManageRequestRateChangeController extends EmployeeBaseController {
	
	 @FXML
	 private TableView<ChangeRatesRequest> myTable;
	   
	public ManageRequestRateChangeController()
	{
		super();
		ServerResponse<ArrayList<ChangeRatesRequest>>RequestsRes= RequestsSender.GetAllChangeRatesRequests();
		ArrayList<ChangeRatesRequest> Requests=RequestsRes.GetResponseObject();
		myTable = new TableView<ChangeRatesRequest>(FXCollections.observableArrayList(Requests));
		//ObservableList<ChangeRatesRequest> oRequests = FXCollections.observableArrayList(Requests);
		//myTable.setItems(oRequests);
	}

    @FXML
    private TableColumn<?, ?> newInAdvancePrice;

    @FXML
    private TableColumn<?, ?> parkingLot;

    @FXML
    private TableColumn<?, ?> newGuestPrice;

    @FXML
    void OnMouseClicked(ActionEvent event) {

    }

}
