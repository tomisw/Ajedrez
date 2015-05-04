package Ajedrez1;

public class Caballo extends Ficha{
    Caballo(int x, int y, AppletAjedrez applet){
    super(x,y,applet);
    caballo();
    }
    private void caballo(){
            imagen=applet.getToolkit().getImage(getClass().getResource("Imagenes/caballoblanco.jpg"));
            
            nombre="caballoblanco";
            actualizarPos();
            if(equipo==0){
                imagen=applet.getToolkit().getImage(getClass().getResource("Imagenes/caballonegro.jpg"));
                nombre="caballonegro";}
    }
    @Override
    void actualizarPos(){
        posiciones = new int[8][2];
        Casilla c;
        Ficha f;
        for(int i=0;i<posiciones.length;i++){
            posiciones[i][0]=8;
            posiciones[i][1]=8;
        }
        if((c=applet.buscarCasilla3(getX()+2,getY()+1))!=null){
            if((f=c.f)==null){
                posiciones[0][0]=getX()+2;
                posiciones[0][1]=getY()+1;
            }
            else{
                if(f.equipo!=equipo){
                    posiciones[0][0]=getX()+2;
                    posiciones[0][1]=getY()+1;
                }
            }
        }
        if((c=applet.buscarCasilla3(getX()+2,getY()-1))!=null){
            if((f=c.f)==null){
                posiciones[1][0]=getX()+2;
                posiciones[1][1]=getY()-1;
            }
            else{
                if(f.equipo!=equipo){
                    posiciones[1][0]=getX()+2;
                    posiciones[1][1]=getY()-1;
                }
            }
        }
        if((c=applet.buscarCasilla3(getX()-2,getY()+1))!=null){
            if((f=c.f)==null){
                posiciones[2][0]=getX()-2;
                posiciones[2][1]=getY()+1;
            }
            else{
                if(f.equipo!=equipo){
                    posiciones[2][0]=getX()-2;
                    posiciones[2][1]=getY()+1;
                }
            }
        }
        if((c=applet.buscarCasilla3(getX()-2,getY()-1))!=null){
            if((f=c.f)==null){
                posiciones[3][0]=getX()-2;
                posiciones[3][1]=getY()-1;
            }
            else{
                if(f.equipo!=equipo){
                    posiciones[3][0]=getX()-2;
                    posiciones[3][1]=getY()-1;
                }
            }
        }
        if((c=applet.buscarCasilla3(getX()+1,getY()+2))!=null){
            if((f=c.f)==null){
                posiciones[4][0]=getX()+1;
                posiciones[4][1]=getY()+2;
            }
            else{
                if(f.equipo!=equipo){
                    posiciones[4][0]=getX()+1;
                    posiciones[4][1]=getY()+2;
                }
            }
        }
        if((c=applet.buscarCasilla3(getX()-1,getY()+2))!=null){
            if((f=c.f)==null){
                posiciones[5][0]=getX()-1;
                posiciones[5][1]=getY()+2;
            }
            else{
                if(f.equipo!=equipo){
                    posiciones[5][0]=getX()-1;
                    posiciones[5][1]=getY()+2;
                }
            }
        }
        if((c=applet.buscarCasilla3(getX()+1,getY()-2))!=null){
            if((f=c.f)==null){
                posiciones[6][0]=getX()+1;
                posiciones[6][1]=getY()-2;
            }
            else{
                if(f.equipo!=equipo){
                    posiciones[6][0]=getX()+1;
                    posiciones[6][1]=getY()-2;
                }
            }
        }
        if((c=applet.buscarCasilla3(getX()-1,getY()-2))!=null){
            if((f=c.f)==null){
                posiciones[7][0]=getX()-1;
                posiciones[7][1]=getY()-2;
            }
            else{
                if(f.equipo!=equipo){
                    posiciones[7][0]=getX()-1;
                    posiciones[7][1]=getY()-2;
                }
            }
        }
    }
    
}
