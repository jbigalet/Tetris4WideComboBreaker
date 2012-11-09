package tetris_4_wide;

public class Utility {
    
    public static boolean[] clone(boolean[] toClone){
        return toClone.clone();
    }
    
    public static boolean[][] clone(boolean[][] toClone){
        boolean[][] newA = new boolean[toClone.length][];
        for(int i = 0 ; i < toClone.length ; i++)
            newA[i] = clone(toClone[i]);
        return newA;
    }

    public static boolean[][][] clone(boolean[][][] toClone){
        boolean[][][] newA = new boolean[toClone.length][][];
        for(int i = 0 ; i < toClone.length ; i++)
            newA[i] = clone(toClone[i]);
        return newA;
    }

}
