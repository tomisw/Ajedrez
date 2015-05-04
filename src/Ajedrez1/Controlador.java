package Ajedrez1;

import java.awt.event.*;

public class Controlador implements MouseMotionListener, MouseListener{
    private AppletAjedrez a;
    private int f[];
    private int turno;
    
    Controlador(AppletAjedrez a){
        this.a=a;
        f=new int[2];
        turno=1;
    }
    public void mouseClicked(MouseEvent e){
        if(a.fichaAct==null){
            f=a.buscarCasilla(e.getX(), e.getY());
            if(f[0]!=99){
                if(a.fichas[f[0]][f[1]].equipo==turno)
                    a.fichaAct=a.fichas[f[0]][f[1]];
            }
        }
        else{
            int f1[]=a.buscarCasilla(e.getX(), e.getY());
            Casilla c=a.buscarCasilla2(e.getX(), e.getY());
            if(f1[0]==99)
                cambiarFicha(a.fichaAct,c,0,null);
            else{
                Ficha ficha=a.fichas[f1[0]][f1[1]];
                if(!ficha.equals(a.fichaAct)){
                    if(ficha.equipo!=a.fichaAct.equipo){
                        cambiarFicha(a.fichaAct,c,1,ficha);                       
                    }
                }
                else{
                    a.fichaAct=null;
                }
            }
        }
        a.repaint();
    }
    void cambiarFicha(Ficha f, Casilla c, int comida, Ficha f2){
        if(f.permitirMovimiento(c.x, c.y, comida)){
            if(comida==1)
                f2.matarFicha();
            f.cambiarPos(c);
            if(turno==0)
                turno=1;
            else
                turno=0;
            a.fichaAct=null;
        }
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){
    }
    public void mouseReleased(MouseEvent e){
        
    }
    public void mouseMoved(MouseEvent e){
        /*
        CODIGO PARA RECONOCIMIENTO DE FICHAS
        f=a.buscarCasilla(e.getX(), e.getY());
        Ficha ficha=null;
        if(f[0]!=99)
            ficha=a.fichas[f[0]][f[1]];
        if(ficha==null)
            System.out.println("Sin Ficha");
        else{
            System.out.println(ficha.nombre);
        }
        try{
            Thread.sleep(1);
        }catch(InterruptedException ie){}
        */
    }
    public void mouseDragged(MouseEvent e){}
    
}
