package Ajedrez1;

public class Torre extends Ficha{
    Torre(int x, int y, AppletAjedrez applet){
    super(x,y,applet);
    torre();
    }
    private void torre(){
            imagen=applet.getToolkit().getImage(getClass().getResource("Imagenes/torreblanco.jpg"));
            nombre="torreblanco";
            actualizarPos();
            if(equipo==0){
                imagen=applet.getToolkit().getImage(getClass().getResource("Imagenes/torrenegro.jpg"));
                nombre="torrenegro";}
    }
    @Override
    void actualizarPos(){
        posiciones = new int[calcularLimiteX()-calcularLimiteXn()+calcularLimiteY()-calcularLimiteYn()][2];
        int j=0;
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
    int calcularLimiteX(){
        boolean limite=true;
        int contador=0;
        Ficha aux;
        while(limite){
            if((getX()+contador+1)<=7){
                if((aux=applet.buscarCasilla3(getX()+contador+1,getY()).f)==null)
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
    int calcularLimiteXn(){
        boolean limite=true;
        int contador=0;
        Ficha aux;
        while(limite){
            if((getX()-contador-1)>=0){
                if((aux=applet.buscarCasilla3(getX()-contador-1,getY()).f)==null)
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
        return -contador;
    }
    int calcularLimiteY(){
        boolean limite=true;
        int contador=0;
        Ficha aux;
        while(limite){
            if((getY()+contador+1)<=7){
                if((aux=applet.buscarCasilla3(getX(),getY()+contador+1).f)==null)
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
    int calcularLimiteYn(){
        boolean limite=true;
        int contador=0;
        Ficha aux;
        while(limite){
            if((getY()-contador-1)>=0){
                if((aux=applet.buscarCasilla3(getX(),getY()-contador-1).f)==null)
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
        return -contador;
    }
}