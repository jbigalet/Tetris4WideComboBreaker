package tetris_4_wide;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends javax.swing.JFrame {
    
    public Game[] games;
    public int iGame;
    
    public JPanel[][] jField = new JPanel[11][4];
    public JPanel[][] jHold = new JPanel[4][4];
    public JPanel[] jPanelPieces = new JPanel[5];
    public JPanel[][][] jPieces = new JPanel[5][4][4];
    
    
    public Frame() {
        initComponents();
        
        List<Game> lGames = new ArrayList<Game>();
        Game tmp = Tetris_4_wide.bestGame;
        while(tmp != null){
            lGames.add(tmp);
            tmp = tmp.previousGame;
        }
        games = new Game[lGames.size()];
        games[games.length-1] = Tetris_4_wide.bestGame;
        for(int i=games.length-2 ; i>=0 ; i--)
            games[i] = games[i+1].previousGame;
        iGame = 0;

        for(int i=0 ; i<11 ; i++)
            for(int j=0 ; j<4 ; j++){
                jField[i][j] = new JPanel();
                jField[i][j].setBackground(Color.WHITE);
                jPanel1.add(jField[i][j]);
            }

        for(int i=0 ; i<4 ; i++)
            for(int j=0 ; j<4 ; j++){
                jHold[i][j] = new JPanel();
                jHold[i][j].setBackground(Color.WHITE);
                jPanel2.add(jHold[i][j]);
            }
        
        for(int a=0 ; a<5 ; a++){
            jPanelPieces[a] = new JPanel();
            jPanel3.add(jPanelPieces[a]);
            for(int i=0 ; i<4 ; i++)
                for(int j=0 ; j<4 ; j++){
                    jPieces[a][i][j] = new JPanel();
                    jPieces[a][i][j].setBackground(Color.WHITE);
                    jPanelPieces[a].add(jPieces[a][i][j]);
                }
        }
        
        drawGame();
    }
    
    public void drawGame(){
        if(iGame < 0) iGame = 0;
        if(iGame >= games.length) iGame = games.length-1;
        setTitle("4-wide | Combo = " + games[iGame].combo);
        if(!games[iGame].toCome.isEmpty())
            drawCurrent(games[iGame].toCome.get(0)[0], true);
        else
            drawCurrent(emptyPiece, false);
        drawField(games[iGame].field);
        if(games[iGame].hold != null)
            drawHold(games[iGame].hold[0], true);
        else
            drawHold(emptyPiece, false);
        drawAllPieces(games[iGame].toCome);

    }
    
    private boolean[][] emptyPiece = 
    {
        {false,false,false, false},
        {false,false,false, false},
        {false,false,false, false},
        {false,false,false, false}
    };

    public void drawAllPieces(List<boolean[][][]> toCome){
        for(int i=1 ; i<6 ; i++)
            if( i < toCome.size() )
                drawPiece(toCome.get(i)[0], i-1, true);
            else
                drawPiece(emptyPiece, i-1, false);
    }
    
    public void drawPiece(boolean[][] piece, int pos, boolean clear){
        if(clear) drawPiece(emptyPiece, pos, false);
        for(int x=0 ; x<piece.length ; x++)
            for(int y=0 ; y<piece[0].length ; y++)
                jPieces[pos][x][y].setBackground(piece[piece.length-x-1][y] ? Color.BLACK : Color.WHITE);
    }
        
    public void drawHold(boolean[][] piece, boolean clear){
        if(clear) drawHold(emptyPiece, false);
        for(int x=0 ; x<piece.length ; x++)
            for(int y=0 ; y<piece[0].length ; y++)
                jHold[x][y].setBackground(piece[piece.length-x-1][y] ? Color.BLACK : Color.WHITE);
    }
    
    public void drawCurrent(boolean[][] piece, boolean clear){
        if(clear) drawCurrent(emptyPiece, false);
        for(int x=0 ; x<piece.length ; x++)
            for(int y=0 ; y<piece[0].length ; y++)
                jField[x][y].setBackground(piece[piece.length-x-1][y] ? Color.BLACK : Color.WHITE);
    }
    
    public void drawField(boolean[][] field){
        for(int x=0 ; x<7 ; x++)
            for(int y=0 ; y<4 ; y++)
                jField[4+x][y].setBackground(field[6-x][y] ? Color.BLACK : Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("4-wide");
        setName("4-wide"); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new java.awt.GridLayout(4, 4));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(11, 4));

        jButton1.setText("<-");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("->");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.GridLayout(5, 1, 10, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(263, 263, 263)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(264, 264, 264))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        iGame++;
        drawGame();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        iGame--;
        drawGame();
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
