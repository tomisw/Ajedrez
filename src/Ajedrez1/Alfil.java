package Ajedrez1;

public class Alfil extends Ficha{
    Alfil(int x, int y, AppletAjedrez applet){
    super(x,y,applet);
    alfil();
    }
    private void alfil(){
            imagen=applet.getToolkit().getImage(getClass().getResource("Imagenes/alfilblanco.jpg"));
            nombre="alfilblanco";
            actualizarPos();
            if(equipo==0){
                imagen=applet.getToolkit().getImage(getClass().getResource("Imagenes/alfilnegro.jpg"));
                nombre="alfilnegro";}
    }
    @Override
    void actualizarPos(){
        posiciones = new int[calcularLimiteXY()+calcularLimiteXnY()+calcularLimiteXnYn()+calcularLimiteXYn()][2];
        int j=0;
        for(int i=1;i<=calcularLimiteXY();i++){
            posiciones[j][0]=getX()+i;
            posiciones[j][1]=getY()+i;
            j++;
        }
        for(int i=1;i<=calcularLimiteXnY();i++){
            posiciones[j][0]=getX()-i;
            posiciones[j][1]=getY()+i;
            j++;
        }
        for(int i=1;i<=calcularLimiteXnYn();i++){
            posiciones[j][0]=getX()-i;
            posiciones[j][1]=getY()-i;
            j++;
        }
        for(int i=1;i<=calcularLimiteXYn();i++){
            posiciones[j][0]=getX()+i;
            posiciones[j][1]=getY()-i;
            j++;
        }
    }
    int calcularLimiteXY(){
        boolean limite=true;
        int contador=0;
        Ficha aux;
        while(limite){
            if((getX()+contador+1)<=7 && (getY()+contador+1)<=7){
                if((aux=applet.buscarCasilla3(getX()+contador+1,getY()+contador+1).f)==null)
                    contador++;
                else{
                    if(aux.equipo!=this.equipo)
                        contador++;
                    limite=false;
                }
            }
            else
                limite=false;
        }
        return contador;
    }
    int calcularLimiteXnY(){
        boolean limite=true;
        int contador=0;
        Ficha aux;
        while(limite){
            if((getX()-contador-1)>=0 && (getY()+contador+1)<=7){
                if((aux=applet.buscarCasilla3(getX()-contador-1,getY()+contador+1).f)==null)
                    contador++;
                else{
                    if(aux.equipo!=this.equipo)
                        contador++;
                    limite=false;
                }
            }
            else
                limite=false;
        }
        return contador;
    }
    int calcularLimiteXnYn(){
        boolean limite=true;
        int contador=0;
        Ficha aux;
        while(limite){
            if((getY()-contador-1)>=0 && (getX()-contador-1)>=0 ){
                if((aux=applet.buscarCasilla3(getX()-contador-1,getY()-contador-1).f)==null)
                    contador++;
                else{
                    if(aux.equipo!=this.equipo)
                        contador++;
                    limite=false;
                }
            }
            else
                limite=false;
        }
        return contador;
    }
    int calcularLimiteXYn(){
        boolean limite=true;
        int contador=0;
        Ficha aux;
        while(limite){
            if((getY()-contador-1)>=0 && (getX()+contador+1)<=7 ){
                if((aux=applet.buscarCasilla3(getX()+contador+1,getY()-contador-1).f)==null)
                    contador++;
                else{
                    if(aux.equipo!=this.equipo)
                        contador++;
                    limite=false;
                }
            }
            else
                limite=false;
        }
        return contador;
    }
}