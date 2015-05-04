package Ajedrez1;

import java.awt.*;
public class Tablero {

	private int N;
	Casilla casillas[][];
	private AppletAjedrez applet;
	private int margen;
	int tamaño;

	Tablero(AppletAjedrez applet,int N) {
		this.applet = applet;
                this.N=N;
		casillas = new Casilla[this.N][this.N];
		margen=applet.margen;
		tamaño = (menor(applet.getWidth(), applet.getHeight()) - margen * 2) / this.N;
                crear_casillas();
	}

	private void crear_casillas() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				casillas[i][j] = new Casilla(i, j);
			}
		}
        }

	int menor(int x, int y) {
		if (x < y) {
			return x;
		} else {
			return y;
		}
	}
        

	void pintar_tablero(Graphics g) {
		for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
				g.setColor(casillas[i][j].c);
				g.fillRect(margen+i*tamaño, margen+j*tamaño,tamaño,tamaño);
                                
			}
                    
		}
                if(applet.fichaAct!=null){
                    applet.fichaAct.pintar_indicador(g,margen,tamaño,N);
                }
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < 4; j++) {
                                    applet.fichas[i][j].pintar_imagen(g,margen,tamaño,N);
                                    applet.fichas[i][j].pintar_imagen(g,margen,tamaño,N);
			}
		}
	}
}
