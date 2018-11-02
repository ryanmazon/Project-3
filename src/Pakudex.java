import java.util.Arrays;
import java.util.Comparator;

public class Pakudex
{
    public Pakuri[] pakudexArray;

    private int size;
    private int capacity;

    public Pakudex()
    {
        this.capacity = 20;
        this.size = 0;
    }

    public Pakudex(int capacity)
    {
        this.capacity = capacity;
        this.size = 0;
        pakudexArray = new Pakuri[capacity];
    }

    public int getSize()
    {
        return this.size;
    }

    public int getCapacity()
    {
        return  this.capacity;
    }

    public String[] getSpeciesArray()
    {
        if (size != 0)
        {
            String[] speciesArray = new String[size];
            for (int i = 0; i < size; i++)
            {
                speciesArray[i] = pakudexArray[i].getSpecies();
            }
            return speciesArray;
        }
        else
        {
            return null;
        }
    }
    public int[] getStats(String species)
    {
        int[] statsArray = new int[3];
        for(int i = 0; i < pakudexArray.length; i++)
        {
            if (pakudexArray[i].equals(species))
            {
                Pakuri myPakuri = new Pakuri(species);
                statsArray[0] = myPakuri.getAttack();
                statsArray[1] = myPakuri.getDefense();
                statsArray[2] = myPakuri.getSpeed();
            }
        }
        if (statsArray[0] != -0)
        {
            return statsArray;
        }
        else
        {
            return null;
        }
    }
    public void sortPakuri()
    {
        //how can I sort the pakudexArray using comparator without having nullPointerException errors?
        Arrays.sort(pakudexArray, new Comparator<Pakuri>() {
            @Override
            public int compare(Pakuri o1, Pakuri o2)
            {
                return o1.getSpecies().compareTo(o2.getSpecies());
            }
        });
    /*for (int i = 1; i < pakudexArray.length; i++)
        {
            if (pakudexArray[i] != null)
            {
                if (pakudexArray[i - 1].getSpecies().compareTo(pakudexArray[i].getSpecies()) > 0)
                {
                    Pakuri placeholder = pakudexArray[i - 1];
                    pakudexArray[i] = pakudexArray[i - 1];
                    pakudexArray[i - 1] = placeholder;
                }
            }
        }*/
    }

    public boolean addPakuri(String species)
    {
        try{
            pakudexArray[size] = new Pakuri(species);
            size++;
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public boolean evolveSpecies(String species)
    {
        try
        {
            for (int i = 0; i < pakudexArray.length; i++)
            {
                if(pakudexArray[i].equals(species))
                {
                    pakudexArray[i].evolve();
                }
            }
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
}
