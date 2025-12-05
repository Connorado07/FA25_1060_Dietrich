public class Player {
    
    private String name;
    private Die die;

    public Player() {
        this.name = "none";
        this.die = new Die();
        this.die.setValue(-1);
    }

    public Player(String name, Die die) {
        this.name = name;
        this.die = die;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Die getDie(){
        return die;
    }

    public void setDie(Die die){
        this.die = die;
    }
}
