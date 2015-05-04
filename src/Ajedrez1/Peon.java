/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Ajedrez1;

import java.net.URL;

public class Peon extends Ficha{
    boolean movida;
    Peon(int x, int y, AppletAjedrez applet){
    super(x,y,applet);
    peon();
    }
    private void peon(){
            posiciones = new int[4][2];
            actualizarPos();
            System.out.println("");
            imagen=applet.getToolkit().getImage(getClass().getResource("./Imagenes/peonblanco.jpg"));
            nombre="peonblanco";
            posiciones[1][0]=getX();
            posiciones[1][1]=getY()-2;
            movida = false;
            if(equipo==0){   
                posiciones[1][1]=getY()+2;
                imagen=applet.getToolkit().getImage(getClass().getResource("./Imagenes/peonnegro.jpg"));
                
                nombre="peonnegro";}
    }
    @Override
    void actualizarPos(){
        for(int i=0;i<posiciones.length;i++){
            posiciones[i][0]=8;
            posiciones[i][1]=8;
        }
        if(!movida){
            if(equipo==1){
                if(calcularLimiteYn(2)==2){
                    posiciones[1][0]=getX();
                    posiciones[1][1]=getY()-2;
                }
                else{
                    posiciones[1][0]=8;
                    posiciones[1][1]=8;
                }
            }
            else{
                if(calcularLimiteY(2)==2){
                    posiciones[1][0]=getX();
                    posiciones[1][1]=getY()+2;
                }
                else{
                    posiciones[1][0]=8;
                    posiciones[1][1]=8;
                }
            }
        }
        if(equipo==1){
            if(calcularLimiteYn(1)==1){
                posiciones[0][0]=getX();
                posiciones[0][1]=getY()-1;
            }
            if(calcularPosibilidadComer(-1,-1)){
                posiciones[2][0]=getX()-1;
                posiciones[2][1]=getY()-1;
            }
            if(calcularPosibilidadComer(1,-1)){
                posiciones[3][0]=getX()+1;
                posiciones[3][1]=getY()-1;
            }
        }
        else{
            if(calcularLimiteY(1)==1){
                posiciones[0][0]=getX();
                posiciones[0][1]=getY()+1;
            }
            if(calcularPosibilidadComer(-1,1)){
                posiciones[2][0]=getX()-1;
                posiciones[2][1]=getY()+1;
            }
            if(calcularPosibilidadComer(1,1)){
                posiciones[3][0]=getX()+1;
                posiciones[3][1]=getY()+1;
            }
        }
    }
    int calcularLimiteY(int num){
        int contador=0;
        boolean limite=true;
        do{
            if(applet.buscarCasilla3(getX(),getY()+contador+1).f==null)
                contador++;
            else
                limite=false;
            if(contador==num)
                limite=false;
        }while(limite);
        return contador;
    }
    int calcularLimiteYn(int num){
        int contador=0;
        boolean limite=true;
        do{
            if(applet.buscarCasilla3(getX(),getY()-contador-1).f==null)
                contador++;
            else
                limite=false;
            if(contador==num)
                limite=false;
        }while(limite);
        return contador;
    }
    boolean calcularPosibilidadComer(int numx, int numy){
        boolean pos=false;
        Ficha aux;
        if((getX()+numx)>=0 && (getY()+numy)<=7 && (getX()+numx)<=7 && (getY()+numy)>=0){
            if((aux=applet.buscarCasilla3(getX()+numx,getY()+numy).f)!=null)
                if(aux.equipo!=this.equipo)
                    pos=true;
            }
        return pos;
    }
    @Override
    public boolean permitirMovimiento(int x, int y ,int comida){
        boolean permitir=false;
        boolean permitirx=false;
        boolean permitiry=false;
        actualizarPos();
            if(comida==1){
                permitirx=x==posiciones[2][0];
                permitiry=y==posiciones[2][1];
                permitir=permitirx && permitiry;
                permitirx=x==posiciones[3][0];
                permitiry=y==posiciones[3][1];
                permitir=permitirx && permitiry || permitir;
            }
            else{
                permitirx=x==posiciones[0][0];
                permitiry=y==posiciones[0][1];
                permitir=permitirx && permitiry;
                permitirx=x==posiciones[1][0];
                permitiry=y==posiciones[1][1];
                permitir=permitirx && permitiry || permitir;
            }
            if(permitir==true && movida==false){
                posiciones[1][0]=0;
                posiciones[1][1]=0;
                posiciones[1][1]=0;
                movida = true;
            }
        return permitir;
    }
    @Override
    public void cambiarPos(Casilla c){
        applet.t.casillas[getX()][getY()].f=null;
        setX(c.x);
        setY(c.y);
        c.f=this;
        if(equipo==0 && getY()==7 || equipo==1 && getY()==0 )
        applet.coronacion(this);
    }
}
