public class Lieutenant {
    private String name;
    private boolean isTraitor;
    private boolean isAttack;
    private String attackSt;

    public Lieutenant(String name, boolean isTraitor) {
        this.name = name;
        this.isTraitor = isTraitor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTraitor() {
        return isTraitor;
    }

    public void setTraitor(boolean traitor) {
        isTraitor = traitor;
        isAttack();
    }

    public void setAttack(boolean attack) {
        isAttack = attack;
        isAttack();
    }

    public boolean isAttack(){
        if(isTraitor){
            isAttack = !isAttack;
        }
        if(isAttack){
            attackSt = "ATTACK";
        }else{
            attackSt = "RETREAT";
        }
        return isAttack;
    }

    public String toString(){
        String text = "";
        if(isTraitor){
            text+="traitor. ";
        }else{
            text+="not traitor. ";
        }
        text+="He claims that General said: "+attackSt;
        return text;
    }
}
