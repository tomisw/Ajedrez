package Ajedrez1;
import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.MediaTracker;
import java.net.*;
public class Ficha{
    private int x;
    private int y;
    final int equipo;
    private int N;
    private final MediaTracker tracker;
    private int viva;
    protected int posiciones[][];
    protected String nombre;
    protected Image imagen;
    protected final AppletAjedrez applet;
    Ficha(int x, int y, AppletAjedrez applet){
        this.x=x;
        this.y=y;
        this.applet=applet;
        this.N=applet.N;
        viva=1;
        tracker=new MediaTracker(applet);
        if(y<2)
            equipo=0;
        else
            equipo=1;
        if(equipo==1)
            this.y=N-y+1;
    }
    Ficha(int x, int y, AppletAjedrez applet, int e){
        this.x=x;
        this.y=y;
        this.applet=applet;
        this.N=applet.N;
        viva=1;
        tracker=new MediaTracker(applet);
        equipo=e;
    }
    
    public void pintar_imagen(Graphics g,int margen,int tamaño, int N){
        try{
             tracker.waitForAll();
        }catch(InterruptedException ie){}
        if(viva==1)
            g.drawImage(imagen, (margen+x*tamaño)+tamaño/4, (margen+y*tamaño)+tamaño/4, tamaño/2, tamaño/2, applet);
        else
            g.drawImage(imagen,(tamaño/5+(tamaño/4)*x), (equipo*tamaño/5), tamaño/4, tamaño/4, applet);
        
    }
    
    public void pintar_indicador(Graphics g, int margen,int tamaño, int N){
        g.setColor(Color.red);
        g.fillRect(margen+x*tamaño+5, margen+y*tamaño+5, tamaño-10, tamaño-10);
        actualizarPos();
        g.setColor(Color.BLUE);
        for(int i=0;i<posiciones.length;i++){
            if(posiciones[i][0]<=7 && posiciones[i][1]<=7 && posiciones[i][0]>=0 && posiciones[i][1]>=0)
                
                g.fillRect(margen+posiciones[i][0]*tamaño+5, margen+posiciones[i][1]*tamaño+5, tamaño-10, tamaño-10);
        
        }
    }
    
    public void cambiarPos(Casilla c){
        applet.t.casillas[x][y].f=null;
        x=c.x;
        y=c.y;
        c.f=this;
    }
    
    void actualizarPos(){}
    
    void matarFicha(){
        viva=0;
        y=N+1;
        if(equipo==0){
            x=applet.comidasNegr;
            applet.comidasNegr++;
        }
        else{
            x=applet.comidasBlanc;
            applet.comidasBlanc++;
        }
    }
    
    public boolean permitirMovimiento(int x, int y ,int comida){
        boolean permitir=false;
        boolean permitirx=false;
        boolean permitiry=false;
        actualizarPos();
            
            for(int i=0;i<posiciones.length;i++){
                permitirx=x==posiciones[i][0];
                permitiry=y==posiciones[i][1] && permitirx;
                permitir=permitirx && permitiry || permitir;
            }
        
        return permitir;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    public void setX(int x){
        this.x=x;
    }
    
    public void setY(int y){
        this.y=y;
    }
}




