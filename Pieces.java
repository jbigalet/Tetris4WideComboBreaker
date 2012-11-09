package tetris_4_wide;

public class Pieces {
    
    public static boolean[][][] I = {
        {{ true, true, true, true }},
        { 
            {true},
            {true},
            {true},
            {true}
        }
    }; 
    
    public static boolean[][][] C = {
        {
            {true, true},
            {true, true}
        }
    };
    
    public static boolean[][][] S = {
        {
            {true, true, false},
            {false, true, true}
        },
        {
            {false, true},
            {true, true},
            {true, false}
        }
    };
    
    public static boolean[][][] Z = {
        {
            {false, true, true},
            {true, true, false}
        },
        {
            {true, false},
            {true, true},
            {false, true}
        }
    };
    
    public static boolean[][][] L = {
        {
            {true, true, true},
            {false, false, true}
        },
        {
            {true, false, false},
            {true, true, true}
        },
        {
            {true, true},
            {true, false},
            {true, false}
        },
        {
            {false, true},
            {false, true},
            {true, true}
        }
    };

    public static boolean[][][] J = {
        {
            {true, true, true},
            {true, false, false}
        },
        {
            {false, false, true},
            {true, true, true},
        },
        {
            {true, true},
            {false, true},
            {false, true}
        },
        {
            {true, false},
            {true, false},
            {true, true}
        }
        
    };

    public static boolean[][][] T = {
        {
            {true, true, true},
            {false, true, false}
        },
        {
            {false, true, false},
            {true, true, true}
        },
        {
            {false, true},
            {true, true},
            {false, true}
        },
        {
            {true, false},
            {true, true},
            {true, false}
        }
    };
    
    public static boolean[][][][] pieces = {I,C,S,Z,L,J,T};

    
    public static void printPieces(){
        System.out.println("Piece I:");
        printPiece(I);
        System.out.println("Piece C:");
        printPiece(C);
        System.out.println("Piece S:");
        printPiece(S);
        System.out.println("Piece Z:");
        printPiece(Z);
        System.out.println("Piece L:");
        printPiece(L);
        System.out.println("Piece J:");
        printPiece(J);
        System.out.println("Piece T:");
        printPiece(T);
    }
    
    public static void printPiece(boolean[][][] piece){
        for(boolean[][] move : piece){
            for(int iLine = move.length-1 ; iLine >=0  ; iLine--){
                for(boolean b : move[iLine])
                    System.out.print(b ? "X" : " ");
                System.out.println();
            }
            System.out.println();
        }
    }
}
