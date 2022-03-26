import java.util.Random;
import java.util.Scanner;

public class Airport
{
  
    public static void main(String[] args)
    {
        Random random = new Random();
        Scanner scan  = new Scanner(System.in);
        
        //create 3 flights
        Airliner[] flights = new Airliner[3];
        
        //assign random flight names
        for (int i = 0; i < flights.length; i++) {
            flights[i] = new Airliner();
            flights[i].setRandomFlightName();
        }
        
        boolean processRun = true;
    
        System.out.println("***********************************************");
        System.out.println("*********JAVA AIRLINERS ***********************");
        System.out.println("***********************************************");
        
        
        FillPlanes(flights,randomRange(4,11));
        System.out.println("********************FLIGHT INFO**********************");
        for (int i = 0; i < flights.length; i++) {
            getFlightInfo(flights[i]);
        }
    }
    
    
    private static void getFlightInfo(Airliner flight)
    {
        System.out.println("-----------------Flight name: "+ flight.flightName+"---------------------");

        int freeSeats = 0;
        int takenSeats = 0;
        int totalSeats = flight.seats.length;
    
    
        for (int i = 0; i < flight.seats.length; i++) {
            if(!flight.seats[i]) freeSeats++;
            if(flight.seats[i]) takenSeats++;
        }
        
        System.out.println("TOTAL SEATS AVAILABLE: " + totalSeats + " FREE SEATS: "+freeSeats+" TAKEN SEATS: "+ takenSeats);
    
        for (int i = 0; i < flight.seats.length; i++) {
            
            System.out.println("Seat availablility: " + flight.seats[i]);
            if(flight.peopleOnPlane[i] == null) System.out.println("Person at seat: N/A");
            else System.out.println("Person at seat: " + flight.peopleOnPlane[i].passengerName);
            
            System.out.println("*****************************");
        }
    }
    
    
    private static void FillPlanes(Airliner[] flights,int numberOfSeatsToFill)
    {
        for (int flight = 0; flight < flights.length; flight++) {
            //max out if over
            if(numberOfSeatsToFill > flights[flight].seats.length) numberOfSeatsToFill = flights[flight].seats.length;
            
            for (int seat = 0; seat < numberOfSeatsToFill; seat++) {
                flights[flight].seats[seat] = true;
                flights[flight].peopleOnPlane[seat] = createPassenger(flights[flight]);
            }
        }
    }
    
    
    
    private static Person createPassenger(Airliner flight)
    {
        String[] randomFirstNames = {"Bob", "James", "Sally", "Steve", "Jon", "Justin", "Dylan"};
        String[] randomLastNames = {"Stewart", "Macklin", "Headly", "Tharp", "Johannson", "Whisley", "Stevens"};
        String[] randomNationality = {"American", "Russian", "Chineese", "African", "Spanish","French"};
        //create passenger
        Person passenger = new Person();
        String randomFirstName = randomFirstNames[randomRange(0,randomFirstNames.length)];
        String randomLastName = randomLastNames[randomRange(0,randomLastNames.length)];
        String randomNat = randomNationality[randomRange(0,randomNationality.length)];
        
        //create passport
        passenger.createPassport(randomFirstName,randomLastName,randomNat,randomRange(1,12),randomRange(1,29),randomRange(0,90));
        
        //pick random flight
        passenger.flight = flight;
        
        //pick random seat
        passenger.chooseSeat(randomRange(0,passenger.flight.seats.length-1));
        
        return passenger;
        
    }
    
    public static int randomRange(int min, int max)
    {
       return (int) ((Math.random() * (max - min)) + min);
    }
}
