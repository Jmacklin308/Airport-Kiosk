import java.util.Scanner;

public class Airliner
{
    public String flightName;
    public Person[] peopleOnPlane = new Person[11];
    public boolean[] seats = new boolean[11];
    
    //called from airport.
    public void createReservation(int seatRequest, Person person)
    {
        Scanner scan = new Scanner(System.in);
        boolean seatFound = false;

        while (!seatFound)
        {
             //if seat empty
            if(!seats[seatRequest])
            {
                person.chooseSeat(seatRequest);
                System.out.println("Seat avalable! " + person.passengerName + " is assigned to " + seatRequest);
                seatFound = true;
            }
            else
            {
                System.out.println("Sorry! Looks like seat " + seatRequest +" is taken!\n Please enter an new seat number:\n");
                seatRequest = scan.nextInt();
            }
        }
    }
    
    
    public void setRandomFlightName()
    {
        String[] prefixLetter = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","X","Y","Z"};
        String ranLetter = prefixLetter[randomRange(0,prefixLetter.length)];
        String ranLetterTwo = prefixLetter[randomRange(0,prefixLetter.length)];
        this.flightName = ranLetter + ranLetterTwo + String.valueOf(randomRange(22,58));
        
    }
    
    
    public static int randomRange(int min, int max)
    {
       return (int) ((Math.random() * (max - min)) + min);
    }
}
