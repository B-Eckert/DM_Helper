package dieRolling;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Attack extends DieRoll {
    // protected String damageTypes[] = {"defaulto"};
    protected ArrayList<String> damageTypes = new ArrayList<>();
    public Attack(){
        super();
    }

    public Attack(int dieNum, int dieFace, String dmgType){
        super(dieNum, dieFace);
        damageTypes.add(dmgType);
    }

    public Attack(int[] dieNums, int[] dieFaces, String[] dmgTypes){
        super(dieNums, dieFaces);
        for(String i : dmgTypes)
            damageTypes.add(i);
    }

    public String getAttack(){
        String end = "";
        int sum = 0;
        for(int i = 0; i < numbers.size(); i++) {
            int roll = DieRolling.rollDice(faces.get(i), numbers.get(i));
            sum += roll;
            end += roll + " " + damageTypes.get(i);
            if(i != numbers.size() - 1)
                end += " + ";
            else
                end += " damage";
        }
        end += "\nTotal: " + sum + " damage.";
        return end;
    }

    @Override
    public void addDie(int dieNum, int dieFace){
        numbers.add(dieNum);
        faces.add(dieFace);
        damageTypes.add("default");
    }

    public void addDie(int dieNum, int dieFace, String damageType){
        numbers.add(dieNum);
        faces.add(dieFace);
        damageTypes.add(damageType);
    }

    public String toString(){
        String end = "";
        for(int i = 0; i < numbers.size(); i++){
            end += numbers.get(i) + "d" + faces.get(i) + " " + damageTypes.get(i);
            if(i != numbers.size() - 1)
                end += " + ";
            else
                end += " damage.";
        }
        return end;
    }
}
