import java.util.ArrayList;
import java.util.Random;

public class main {
    static ArrayList<Lieutenant> lts = new ArrayList<>();
    static Lieutenant lt1;
    static Lieutenant lt2;
    static Lieutenant lt3;
    static Lieutenant lt4;
    static Lieutenant lt5;
    public static void main(String[] args) {
        Random rand = new Random();
        General gn = new General("Gn1");
        if(gn.isTraitor()){
            lt1 = new Lieutenant("lt1", false);
            lt2 = new Lieutenant("lt2", false);
            lt3 = new Lieutenant("lt3", false);
            lt4 = new Lieutenant("lt4", false);
            lt5 = new Lieutenant("lt5", false);
        }else{
            lt1 = new Lieutenant("lt1", rand.nextBoolean());
            lt2 = new Lieutenant("lt2", rand.nextBoolean());
            lt3 = new Lieutenant("lt3", rand.nextBoolean());
            lt4 = new Lieutenant("lt4", rand.nextBoolean());
            lt5 = new Lieutenant("lt5", rand.nextBoolean());
        }
        lts.add(lt1);
        lts.add(lt2);
        lts.add(lt3);
        lts.add(lt4);
        lts.add(lt5);
        gn.makeCommand();
        if(gn.isTraitor()){
            int countTraitor = 0;
            for(int i = 0; i < lts.size(); i++){
                if(lts.get(i).isTraitor()){
                    countTraitor++;
                }
                if(countTraitor>=2){
                    lts.get(i).setTraitor(false);
                }
            }
        }
        if(!gn.isTraitor()){
            int countTraitor = 0;
            for(int i = 0; i < lts.size(); i++){
                if(lts.get(i).isTraitor()){
                    countTraitor++;
                }
                if(i+1 == lts.size() && !lts.get(i).isTraitor() && countTraitor==0){
                    lts.get(i).setTraitor(true);
                }
            }
        }
        getInfo(gn,lts);
    }

    public static void getInfo(General gn, ArrayList<Lieutenant> lts){
        System.out.println("General is " + gn.toString());
        int retreat = 0;
        int attack = 0;
        for(int i = 0; i < lts.size(); i++){
            System.out.println("Lieutenant"+(1+i)+"'s messager is "+lts.get(i).toString());
            if(lts.get(i).isAttack()){
                attack++;
            }else{
                retreat++;
            }
        }
        if(attack/3>=retreat){
            System.out.println("We will ATTACK!");
        }else{
            System.out.println("We will RETREAT!");
        }
    }
}
