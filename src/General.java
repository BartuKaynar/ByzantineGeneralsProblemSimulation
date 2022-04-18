import java.util.Random;

public class General {
    private boolean isTraitor, isAttack;
    private String name;

    public General(String name){
        this.name = name;
        Random rand = new Random();
        isTraitor = rand.nextBoolean();
    }

    public boolean isTraitor() {
        return isTraitor;
    }

    public void setTraitor(boolean traitor) {
        isTraitor = traitor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeCommand(){
        if(isTraitor){
            Random rand = new Random();
            for(int i = 0; i < main.lts.size(); i++){
                main.lts.get(i).setAttack(rand.nextBoolean());
            }
        }
        else{
            Random rand = new Random();
            isAttack = rand.nextBoolean();
            for(int i = 0; i < main.lts.size(); i++){
                main.lts.get(i).setAttack(isAttack);
            }
        }
    }
    public String toString(){
        String text = "";
        if(isTraitor){
            text+= "Traitor. ";
        }else{
            text+= "not Traitor. ";
        }
        if(!isTraitor){
            if(isAttack){
                text+="I command: ATTACK";
            }else{
                text+="I command: RETREAT";
            }
        }
        return text;
    }
}
