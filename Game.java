package tetris_4_wide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    public Game previousGame;
    public boolean[][] field;
    public boolean[][][] hold;
    List<boolean[][][]> toCome;
    public int combo;
    public boolean isSwaped;
    
    public Game(boolean[][] field, boolean[][][][] AToCome){
        this.previousGame = null;
        this.field = field;
        this.toCome = new ArrayList<boolean[][][]>();
        this.toCome.addAll(Arrays.asList(AToCome));
        this.hold = null;
        this.combo = 0;
        this.isSwaped = false;
    }
    
    public Game(Game old){
        this.previousGame = old;
        this.field = Utility.clone(old.field);
        this.hold = Utility.clone(old.toCome.get(0));
        this.toCome = new ArrayList(old.toCome);
        if(old.hold != null)
            this.toCome.set(0, Utility.clone(old.hold.clone()));
        else
            this.toCome.remove(0);
        this.combo = old.combo;
        this.isSwaped = true;
    }
    
    public Game(Game old, boolean[][] newfield){
        this.previousGame = old;
        this.field = Utility.clone(newfield);
        this.toCome = new ArrayList(old.toCome);
        this.toCome.remove(0);
        this.combo = old.combo + 1;
        if(old.hold != null)
            this.hold = Utility.clone(old.hold.clone());
        this.isSwaped = false;
    }
    
    public void drawField(){
        System.out.println("Combo = " + this.combo);
        for(int iLine = this.field.length-1 ; iLine >=0  ; iLine--){
            for(boolean b : this.field[iLine])
                System.out.print(b ? "X" : " ");
            System.out.println();
        }
        System.out.println();
    }
}
