package Ajedrez1;

import java.awt.Color;

public class Casilla {

	Color c;
	int x, y;
        Ficha f;

	Casilla(int x, int y) {
		this.x = x;
		this.y = y;
		if ((x + y) % 2 == 0) {
			c = new Color(255, 255, 255);
		} else {
			c = new Color(0, 0, 0);
		}
	}
}
