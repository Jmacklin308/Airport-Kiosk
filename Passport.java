public class Passport
{
    public String firstName;
    public String lastName;
    public String nationality;
    public int dobM;
    public int dobD;
    public int dobY;
    public String dateOfBirth = dobM + "/" + dobD + "/" + dobY;
    
    
    
    //show info
    public void showPassport()
    {
        System.out.println("First Name: "+ this.firstName);
        System.out.println("Last Name: "+ this.lastName);
        System.out.println("Nationality: "+ this.nationality);
        System.out.println("date of birth: "+ this.dateOfBirth);
    }

    
}
