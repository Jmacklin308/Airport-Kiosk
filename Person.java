import java.util.Scanner;

public class Person
{
    public Passport passport;
    public int seatNumber;
    public Airliner flight;
    public String passengerName;
    
    
    
    public void createPassport()
    {
        Scanner scan = new Scanner(System.in);
        //empty passport
        this.passport = new Passport();
    
        System.out.println("Hello! Lets get you setup with a passport\n. What is your first name?\n");
        this.passport.firstName = scan.nextLine();
        
        System.out.println("Hello there " + this.passport.firstName + "! What is your last name?");
        this.passport.lastName = scan.nextLine();
    
        //setup full name
        this.passengerName = passport.firstName + " " + passport.lastName;
        
        
        System.out.println(this.passengerName+ " ... Got it. What is your Nationality " + this.passport.firstName + "?");
        this.passport.nationality = scan.nextLine();
        
    
        System.out.println(this.passport.nationality + ". Got it and thank you. I'll need your Day of birth. Just type it out in this format mm dd yy (include spaces)\n");
        scan.nextLine();
        this.passport.dobM = scan.nextInt(2);
        this.passport.dobD = scan.nextInt(2);
        this.passport.dobY = scan.nextInt(2);
    
        System.out.println("Your date of birth: "+ this.passport.dateOfBirth+ ". Okay I think were good to go.");
        System.out.println("Heres your info:\n");
        passport.showPassport();
        System.out.println("-------END OF PASSPORT CREATION----------");
        scan.close();
 
    }
    
    
     public void createPassport(String fname, String lname, String nationality, int dobM, int dobD, int dobY)
    {
        System.out.println("-------Passenger Passport: "+ fname + " " + lname + "----------");
        //empty passport
        this.passport = new Passport();
    
        this.passport.firstName = fname;
        this.passport.lastName = lname;
        this.passengerName = passport.firstName + " " + passport.lastName;
        this.passport.nationality = nationality;
        this.passport.dobM = dobM;
        this.passport.dobD = dobD;
        this.passport.dobY = dobY;
        this.passport.dateOfBirth = String.valueOf(dobM)+"/"+String.valueOf(dobD)+"/"+String.valueOf(dobY);
    
        System.out.println("Pasport info:\n");
        passport.showPassport();
 
    }
    
    
    
    public void chooseSeat(int seatChoice)
    {
        Scanner scan = new Scanner(System.in);
        
        //guard if no flight assigned
        if(flight == null)
        {
            System.out.println("Flight not assigned for " + this + "!!!!");
            return;
        }
        
        //ease of use
        boolean[] seats = this.flight.seats;
    
        
        //search for vacant seat. Compare to others
        for (int seat = 0; seat < seats.length; seat++) {
            
            if(seats[seat] && seat == seatChoice)
            {
                System.out.println("SEAT TAKEN!!!!!!!!!!!!!!!!");
                seat++;
            }
            
            //if the current seat is free (false) and the one the passenger picked
            if(!seats[seat] && seat == seatChoice)
            {
                //set the passenger seat value to this
                this.seatNumber = seat;
                
                //Set the passenger seat to occupied (true)
                flight.seats[seat] = true;
                
                //add the person to the plane roster
                flight.peopleOnPlane[seat] = this;
                break;
            }
            
            if(seats[seat])
            {
                //set the passenger seat value to this
                this.seatNumber = seat;
                
                //Set the passenger seat to occupied (true)
                flight.seats[seat] = true;
                
                //add the person to the plane roster
                flight.peopleOnPlane[seat] = this;
            }
        }
        
        //clean up
        scan.close();
        
        //log it
        System.out.println("Picked seat #"+seatChoice+"... \nFlight: "+ this.flight.flightName+" Responded with seat number "+this.seatNumber);
    }
}
