package entities;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AddRealTimeParkingRequest implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String parkinglot;
    
    private LocalDateTime startDateTime;
    
    private LocalDateTime exiDateTime;
    
    private String carNumber;
    
    public AddRealTimeParkingRequest(String parkinglot, LocalDateTime startDateTime, LocalDateTime exiDateTime,
	    String carNumber)
    {
	this.parkinglot = parkinglot;
	this.startDateTime = startDateTime;
	this.exiDateTime = exiDateTime;
	this.carNumber = carNumber;
    }
    
    @Override
    public String toString()
    {
	return "parkinglot: " + parkinglot + "\ncar: " + carNumber + "\nfrom: " + startDateTime.toString() + "\nto: "
		+ exiDateTime.toString();
    }
    
    public String getCarNumber()
    {
	return carNumber;
    }
    
    public LocalDateTime getExiDateTime()
    {
	return exiDateTime;
    }
    
    public String getParkinglot()
    {
	return parkinglot;
    }
    
    public LocalDateTime getStartDateTime()
    {
	return startDateTime;
    }
}
