public class Pakuri
{
    private String species;
    private int attack;
    private int defense;
    private int speed;

    public Pakuri(String species)
    {
        this.species = species;
        this.attack = (species.length() * 7) + 9;
        this.defense = (species.length() * 5) + 17;
        this.speed = (species.length() * 6) + 13;
    }
    public String getSpecies()
    {
        return this.species;
    }
    public int getAttack()
    {
        return this.attack;
    }
    public int getSpeed()
    {
        return this.speed;
    }
    public int getDefense()
    {
        return this.defense;
    }
    public void setAttack(int newAttack)
    {
        this.attack = newAttack;
    }
    public void evolve()
    {
        this.attack *= 2;
        this.defense *= 4;
        this.speed *= 3;
    }
}
