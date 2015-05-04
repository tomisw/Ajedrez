package Ajedrez1;

public class Rey extends Ficha{
    Rey(int x, int y, AppletAjedrez applet){
    super(x,y,applet);
    rey();
    }
    private void rey(){
            imagen=applet.getToolkit().getImage(getClass().getResource("Imagenes/reyblanco.jpg"));
            nombre="reyblanco";
            actualizarPos();
            if(equipo==0){
                imagen=applet.getToolkit().getImage(getClass().getResource("Imagenes/reynegro.jpg"));
                nombre="reynegro";}
    }
    void actualizarPos(){
        posiciones = new int[8][2];
        int j=0;
        for(int i=0;i<posiciones.length;i++){
            posiciones[i][0]=8;
            posiciones[i][1]=8;
        }
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
        for(int i=1;i<=calcularLimiteX();i++){
            posiciones[j][0]=getX()+i;
            posiciones[j][1]=getY();
            j++;
        }
        for(int i=-1;i>=calcularLimiteXn();i--){
            posiciones[j][0]=getX()+i;
            posiciones[j][1]=getY();
            j++;
        }
        for(int i=1;i<=calcularLimiteY();i++){
            posiciones[j][0]=getX();
            posiciones[j][1]=getY()+i;
            j++;
        }
        for(int i=-1;i>=calcularLimiteYn();i--){
            posiciones[j][0]=getX();
            posiciones[j][1]=getY()+i;
            j++;
        }
    }
    int calcularLimiteXY(){
        int contador=0;
        Ficha aux;
        if((getX()+contador+1)<=7 && (getY()+contador+1)<=7){
            if((aux=applet.buscarCasilla3(getX()+contador+1,getY()+contador+1).f)==null)
                contador++;
            else{
                if(aux.equipo!=this.equipo)
                    contador++;
            }
        }
        return contador;
    }
    int calcularLimiteXnY(){
        int contador=0;
        Ficha aux;
        if((getX()-contador-1)>=0 && (getY()+contador+1)<=7){
            if((aux=applet.buscarCasilla3(getX()-contador-1,getY()+contador+1).f)==null)
                contador++;
            else{
                if(aux.equipo!=this.equipo)
                    contador++;
            }
        }
        return contador;
    }
    int calcularLimiteXnYn(){
        int contador=0;
        Ficha aux;
        if((getY()-contador-1)>=0 && (getX()-contador-1)>=0 ){
            if((aux=applet.buscarCasilla3(getX()-contador-1,getY()-contador-1).f)==null)
                contador++;
            else{
                if(aux.equipo!=this.equipo)
                    contador++;
            }
        }
        return contador;
    }
    int calcularLimiteXYn(){
        int contador=0;
        Ficha aux;
        if((getY()-contador-1)>=0 && (getX()+contador+1)<=7 ){
            if((aux=applet.buscarCasilla3(getX()+contador+1,getY()-contador-1).f)==null)
                contador++;
            else{
                if(aux.equipo!=this.equipo)
                    contador++;
            }
        }
        return contador;
    }
    int calcularLimiteX(){
        int contador=0;
        Ficha aux;
        if((getX()+contador+1)<=7){
            if((aux=applet.buscarCasilla3(getX()+contador+1,getY()).f)==null)
                contador++;
            else{
                if(aux.equipo!=this.equipo)
                    contador++;
            }
        }
        return contador;
    }
    int calcularLimiteXn(){
        int contador=0;
        Ficha aux;
        if((getX()-contador-1)>=0){
            if((aux=applet.buscarCasilla3(getX()-contador-1,getY()).f)==null)
                contador++;
            else{
                if(aux.equipo!=this.equipo)
                    contador++;
            }
        }
        return -contador;
    }
    int calcularLimiteY(){
        int contador=0;
        Ficha aux;
        if((getY()+contador+1)<=7){
            if((aux=applet.buscarCasilla3(getX(),getY()+contador+1).f)==null)
                contador++;
            else{
                if(aux.equipo!=this.equipo)
                    contador++;
            }
        }
        return contador;
    }
    int calcularLimiteYn(){
        int contador=0;
        Ficha aux;
        if((getY()-contador-1)>=0){
            if((aux=applet.buscarCasilla3(getX(),getY()-contador-1).f)==null)
                contador++;
            else{
                if(aux.equipo!=this.equipo)
                    contador++;
            }
        }
        return -contador;
    }
    void matarFicha(){
        applet.finPartida(this);
    }
}