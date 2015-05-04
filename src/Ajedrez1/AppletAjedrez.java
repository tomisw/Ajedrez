package Ajedrez1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;


public class AppletAjedrez extends JFrame {
	Tablero t;
	int margen=80;
        Ficha fichas[][];
	final int N=8;
	private Image imagenDB;
	private Graphics gDB;
        int comidasBlanc;
        int comidasNegr;
        Ficha fichaAct;
	int ganador;
        
        public static void main(String args[]){
            AppletAjedrez a = new AppletAjedrez();
            
        }
        
	AppletAjedrez() {
                super("Ajedrez");
                setBounds(100,100,700,700);
                comidasBlanc=0;
                comidasNegr=0;
                ganador=0;
                Font f= new Font("SansSerif", Font.BOLD, 40);
                setFont(f);
                fichas = new Ficha[N][4];
                fichaAct=null;
		t=new Tablero(this,N);
                crearFichas();
                setVisible(true);
                addWindowListener(new WindowAdapter(){
                    public void windowClosing(WindowEvent e){
                        dispose();
                    }
                });
                addMouseListener(new Controlador(this));
                addMouseMotionListener(new Controlador(this));
	}
        private void crearFichas(){
                fichas[0][0]= new Torre(0,0,this);
                fichas[7][0]= new Torre(7,0,this);
                fichas[1][0]= new Caballo(1,0,this);
                fichas[6][0]= new Caballo(6,0,this);
                fichas[2][0]= new Alfil(2,0,this);
                fichas[5][0]= new Alfil(5,0,this);
                fichas[3][0]= new Rey(3,0,this);
                fichas[4][0]= new Reina(4,0,this);
                for(int i=0;i<N;i++){
                            fichas[i][1] = new Peon(i,1,this);
                }
                for(int i=0;i<N;i++){
                            fichas[i][3] = new Peon(i,3,this);
                }
                fichas[0][2]= new Torre(0,2,this);
                fichas[7][2]= new Torre(7,2,this);
                fichas[1][2]= new Caballo(1,2,this);
                fichas[6][2]= new Caballo(6,2,this);
                fichas[2][2]= new Alfil(2,2,this);
                fichas[5][2]= new Alfil(5,2,this);
                fichas[3][2]= new Rey(3,2,this);
                fichas[4][2]= new Reina(4,2,this);
                for(int i = 0; i < 2;i++ ){
                        for (int j = 0; j < N; j++) {
				t.casillas[j][i].f=fichas[j][i];
			}
                }
                int aux=3;
                for(int i = 6; i < N;i++ ){
                        for (int j = 0; j < N; j++) {
				t.casillas[j][i].f=fichas[j][aux];
			}
                        aux--;
                }
        }
        public int[] buscarCasilla(int x, int y){
            int fx;
            int fy;
            fx=(x-margen)/t.tamaño;
            fy=(y-margen)/t.tamaño;
            int f[]=new int[2];
            f[0]=99;
            for(int i=0;i<N;i++){
                    for(int j=0;j<2;j++){
                        if(fichas[i][j].getX()==fx && fichas[i][j].getY()==fy){
                            f[0]=i;
                            f[1]=j;
                        }
                    }
                }
                for(int i=0;i<N;i++){
                    for(int j=2;j<4;j++){
                        if(fichas[i][j].getX()==fx && fichas[i][j].getY()==fy){
                            f[0]=i;
                            f[1]=j;
                        }
                    }
                }
            return f;
        }
        public Casilla buscarCasilla2(int x, int y){
            int fx;
            int fy;
            fx=(x-margen)/t.tamaño;
            fy=(y-margen)/t.tamaño;
            if(fx>7)
                fx=7;
            if(fy>7)
                fy=7;
            Casilla c=t.casillas[fx][fy];
            return c;
        }
        public Casilla buscarCasilla3(int x, int y){
            Casilla c;
            if(x >=8 || y >= 8 || x < 0 || y < 0)
                c=null;
            else
                c=t.casillas[x][y];
            return c;
        }
        public void coronacion(Peon p){
            Ficha f=t.casillas[p.getX()][p.getY()].f=new Reina(p.getX(),p.getY(),this,p.equipo);
            for(int i=0;i<N;i++){
                            if(fichas[i][1].equals(p))
                                fichas[i][1]=f;
                }
                for(int i=0;i<N;i++){
                            if(fichas[i][3].equals(p))
                                fichas[i][3]=f;
                }
        }
        public void finPartida(Rey r){
            ganador=r.equipo+1;
            repaint();
        }

	@Override
	public void paint(Graphics g) {
            if(ganador==0)
		t.pintar_tablero(g);
            else{
                g.setColor(Color.red);
                if(ganador==1)
                    g.drawString("Ganador equipo Blanco", (getHeight()-g.getFontMetrics().stringWidth("Ganador equipo Blanco"))/2, getWidth()/2);
                else
                    g.drawString("Ganador equipo Negro", (getHeight()-g.getFontMetrics().stringWidth("Ganador equipo Negro"))/2, getWidth()/2);
            }
	}
        
	@Override
	public void update(Graphics g) {
		if (imagenDB == null) {
			imagenDB = createImage(getWidth(), getHeight());
			gDB = imagenDB.getGraphics();
		}
		gDB.setColor(getBackground());
		gDB.fillRect(0, 0, getWidth(), getHeight());
		gDB.setColor(getForeground());
		paint(gDB);
		g.drawImage(imagenDB, 0, 0, this);
	}
}
