package tetris_4_wide;

import java.util.ArrayList;
import java.util.List;

public class Tetris_4_wide {
    public static boolean[][] LeftIField = {
        {true, true, true, false},
        {false, false, false, false},
        {false, false, false, false},
        {false, false, false, false},
        {false, false, false, false},
        {false, false, false, false},
        {false, false, false, false},
        {false, false, false, false}
    };
    
    public static void main(String[] args) {
        //Pieces.printPieces();
        
        Game game1 = new Game(LeftIField, new boolean[][][][] {
            Pieces.I, 
            Pieces.Z, 
            Pieces.J, 
            Pieces.L, 
            Pieces.T, 
            Pieces.C, 
            Pieces.S, 
            Pieces.L, 
            Pieces.I, 
            Pieces.J, 
            Pieces.Z, 
            Pieces.S, 
            Pieces.T, 
            Pieces.C, 
            Pieces.L, 
            Pieces.I, 
            Pieces.C, 
            Pieces.S            
        } );
        
        
        Game game3 = new Game(LeftIField, new boolean[][][][] {
            Pieces.T, 
            Pieces.C,
            Pieces.J, 
            Pieces.L,
            Pieces.I,
            Pieces.S,
            Pieces.Z, 
            Pieces.S, 
            Pieces.I, 
            Pieces.L, 
            Pieces.T, 
            Pieces.J
        } );
        
        //BFTest(game1);
        BFTest(randomGame(40));
        bestGame.drawField();
        
        Frame f = new Frame();
        f.setVisible(true);
    }
    
    public static Game randomGame(int n){
        boolean[][][][] p = new boolean[n][][][];
        for(int i=0 ; i<n ; i++)
            p[i] = Utility.clone(Pieces.pieces[(int)(7*Math.random())]);
        return new Game(LeftIField, p);
    }
    
    public static int bestCombo;
    public static Game bestGame;
    public static boolean done = false;
    public static void BFTest( Game game ){
            // Break if finished
        if( done ) return;
        
        if( game.combo > bestCombo ) {
            bestGame = game;
            bestCombo = game.combo;
            System.out.println("Current best combo: " + bestCombo);
        }
        
            // No more piece to proceed.
        if(game.toCome.isEmpty()){
            done = true;
            return;
        }
        
            // If not already swaped, do the swap
        if(!game.isSwaped)
            BFTest(new Game(game));
        
            // Process to check if the piece can make a line
        List<Game> toProcess = tryToMakeALine(game, game.field, game.toCome.get(0));
        for(Game g : toProcess)
            BFTest(g);
    }
    
    public static List<Game> tryToMakeALine(Game game, boolean[][] field, boolean[][][] piece){
        List<Game> gameList = new ArrayList<Game>();
        
        for(boolean[][] position : piece)
            for(int x = 0 ; x <= field.length - position.length ; x++)
                for(int y = 0 ; y <= field[0].length - position[0].length ; y++)
                    if( isLegit(field, position, x, y ) ){
                        boolean[][] newField = addPieceToField( field, position, x, y );
                        int doneLine = isThereALine(newField);
                        if( doneLine != -1 )
                            gameList.add(new Game(game, removeLine(newField, doneLine) ));
                    }
        return gameList;
    }
    
    public static boolean isLegit(boolean[][] field, boolean[][] position, int x, int y){
            // Check if the piece is not in an already occupied space
        for(int px = 0 ; px < position.length ; px++)
            for(int py = 0 ; py < position[0].length ; py++)
                if( field[px+x][py+y] && position[px][py] )
                    return false;
        
            // Check if the piece is not floating / levitating
            // If x == 0: The piece is on the ground, i.e. actually ON something
        if(x == 0) return true;
        
        for(int px = 0 ; px < position.length ; px++)
            for(int py = 0 ; py < position[0].length ; py++)
                if( field[px+x-1][py+y] && position[px][py] )
                    return true;

        return false;
    }
    
    public static boolean[][] addPieceToField(boolean[][] oldField, boolean[][] position, int x, int y){
        boolean[][] newField = Utility.clone(oldField);
        for(int px = 0 ; px < position.length ; px++)
            for(int py = 0; py < position[0].length ; py++)
                if(position[px][py])
                    newField[px+x][py+y] = true; 
        return newField;
    }
    
    public static int isThereALine( boolean[][] field ){
        //drawField(field);
        for(int line = 0 ; line < field.length ; line++ ){
            boolean flag = true;
            for(boolean b : field[line])
                if(!b) flag = false;
            if(flag) return line;
        }
        return -1;
    }
    
    public static boolean[][] removeLine(boolean[][] field, int doneLine){
        boolean[][] newField = new boolean[field.length][field[0].length];
        for(int i = 0 ; i<doneLine ; i++)
            newField[i] = field[i].clone();
        for(int i=doneLine+1 ; i<field.length ; i++)
            newField[i-1] = field[i].clone();
        return newField;
    }
    
    public static void drawField(boolean[][] field ){
        System.out.println("Field:");
        for(int iLine = field.length-1 ; iLine >=0  ; iLine--){
            for(boolean b : field[iLine])
                System.out.print(b ? "X" : " ");
            System.out.println();
        }
        System.out.println();
    }
}
