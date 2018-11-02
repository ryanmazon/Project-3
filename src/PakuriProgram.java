import java.util.*;
public class PakuriProgram
{
    public static void main(String[] args)
    {
        //initialize scanner & other variables
        Scanner scnr = new Scanner(System.in);
        int maxCap = 0;
        int size = 0;
        //startup message
        System.out.print("Welcome to Pakudex: Tracker Extraordinaire!\n");
        //keep trying to obtain user info for max cap of Pakudex until successful
        boolean init = true;
        while (init)
        {
            System.out.print("Enter max capacity of the Pakudex: ");
            try
            {
                maxCap = Integer.parseInt(scnr.next());
                init = false;
                System.out.println("The Pakudex can hold " + maxCap + " species of Pakuri\n");
            }
            catch (Exception e)
            {
                System.out.println("Please enter a valid size.");
            }
        }
        //create Pakudex object
        Pakudex myPakudex = new Pakudex(maxCap);
        //start loop for the actual program itself
        init = true;
        while (init)
        {
            displayMenu();
            int userSelect;
            try
            {
                userSelect = Integer.parseInt(scnr.next());
            }
            catch (Exception e)
            {
                System.out.println("Unrecognized menu selection!");
                continue;
            }

            switch(userSelect)
            {
                case 1:
                    try
                    {
                        if (myPakudex.pakudexArray[0] == null)
                        {
                            throw new Exception();
                        }
                        System.out.println("Pakuri in Pakudex: ");
                        System.out.println();
                        for (int i = 0; i < myPakudex.getSize(); i++)
                        {
                            System.out.println((i + 1) + ". " + myPakudex.pakudexArray[i].getSpecies());
                        }
                        System.out.println();
                    }
                    catch(Exception e)
                    {
                        System.out.println("\nNo Pakuri in Pakudex yet!\n");
                    }
                    break;
                case 2:
                    try{
                        System.out.print("Enter the name of the species to display: ");
                        String species = scnr.next();
                        for (int i = 0; i < myPakudex.getSize(); i++)
                        {
                            if (myPakudex.pakudexArray[i].getSpecies().equals(species))
                            {
                                System.out.println("\nSpecies: " + species + "\nAttack: " + myPakudex.pakudexArray[i].getAttack() + "\nDefense: " + myPakudex.pakudexArray[i].getDefense() + "\nSpeed: " + myPakudex.pakudexArray[i].getSpeed() + "\n");
                            }
                            if (i == myPakudex.getSize() - 1)
                            {
                                if (!myPakudex.pakudexArray[i].getSpecies().equals(species))
                                {
                                    throw new Exception();
                                }
                            }
                        }

                    }
                    catch(Exception e)
                    {
                        System.out.println("\nError: No such Pakuri!\n");
                    }
                    break;
                case 3:
                    System.out.print("Enter the name of the species to add: ");
                    String species = scnr.next();
                    System.out.println();
                    try
                    {
                        for (int i = 0; i < myPakudex.getSize(); i++)
                        {
                            if (myPakudex.pakudexArray[i].getSpecies().equals(species))
                            {
                                throw new RuntimeException();
                            }
                        }
                        if (myPakudex.getSize() == myPakudex.getCapacity())
                        {
                            throw new NullPointerException();
                        }
                        myPakudex.addPakuri(species);
                        System.out.println("Pakuri species " + species + " successfully added!\n");
                    }
                    catch (NullPointerException e)
                    {
                        System.out.println("Error: Pakudex is full!\n");
                    }
                    catch(RuntimeException e)
                    {
                        System.out.println("Error: Pakudex already contains this species!\n");
                    }
                    break;
                case 4:
                    try
                    {
                        System.out.print("\nEnter the name of the species to evolve: ");
                        String speciesToEvolve = scnr.next();
                        for (int i = 0; i < myPakudex.getSize(); i++)
                        {
                            if (myPakudex.pakudexArray[i].getSpecies().equals(speciesToEvolve))
                            {
                                myPakudex.pakudexArray[i].evolve();
                                System.out.println("\n" + speciesToEvolve + " has evolved!\n");
                            }
                            if (i == myPakudex.getSize() - 1)
                            {
                                if (!myPakudex.pakudexArray[i].getSpecies().equals(speciesToEvolve))
                                {
                                    throw new Exception();
                                }
                            }
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("\nError: No such Pakuri!\n");
                    }
                    break;
                case 5:
                    myPakudex.sortPakuri();
                    System.out.println("Pakuri have been sorted!");
                    break;
                case 6:
                    System.out.println("Thanks for using Pakudex! Bye!");
                    init = false;
                    break;
                default:
                    System.out.println("Unrecognized menu selection!");
                    break;
            }
        }
    }

    public static void displayMenu()
    {
        System.out.print("Pakudex Main Menu\n" +
                "-----------------\n" +
                "1. List Pakuri\n" +
                "2. Show Pakuri\n" +
                "3. Add Pakuri\n" +
                "4. Evolve Pakuri\n" +
                "5. Sort Pakuri\n" +
                "6. Exit\n" +
                "\n" +
                "What would you like to do? ");
    }
}
