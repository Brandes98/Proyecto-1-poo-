import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;

public class Microorganismo extends JPanel {
    private ArrayList<String> prioridades;
    private ArrayList<String> personalidad;
    private ArrayList<String> acciones;
    String tipo;
    int energia;
    int velocidad;
    int vision;
    int posX;
    int posY;
    int tamano;
    int maxEnergia;
    int minEnergia;
    int maxVision;
    int minVision;
    int maxVelocidad;
    int minVelocidad;
    Color identificador;
    int i=0;
    public Microorganismo(String tipo, int energia, int velocidad, int vision, int posX, int posY, int tamano, Color identificador,int minEnergia,int maxEnergia,int minVelocidad,int maxVelocidad,int minVision,int maxVision) {
        this.tipo = tipo;
        this.energia = energia;
        this.velocidad = velocidad;
        this.minEnergia=minEnergia;
        this.maxEnergia=maxEnergia;
        this.minVelocidad=minEnergia;
        this.maxVelocidad=maxEnergia;
        this.minVision=minVision;
        this.maxVision=maxVision;
        this.vision = vision;
        this.posX = posX;
        this.posY = posY;
        this.tamano = tamano;
        this.identificador=identificador;
    }
   
    public void generarOrganismo(int jposX ,int jposY)
    {
        boolean existe=false;
        int X=(int)(Math.random()*500);
        int Y=(int)(Math.random()*500);
        if(jposX==X && jposY==Y){
            existe=true;
            generarOrganismo(jposX, jposY);

    }else{
                if(!existe){
                    this.posX=X;
                    this.posY=Y;
                }
            }
}
    public void buscarPrioridadEnergia(AlimentoEnergia[] listaE,AlimentoVelocidad[]listaV,AlimentoVision[]listaVi,Microorganismo[] listaM) {
      for(int i=0;i<3;i++)
      {
        if(listaE[i].posX>(this.posX-this.vision)&&listaE[i].posX<(this.posX+this.vision) 
        && listaE[i].posY>(this.posY-this.vision)&&listaE[i].posY<(this.posY+this.vision))
        {if (this.energia>this.minEnergia){
            if(listaE[i].posX>this.posX){
                this.posX+=this.velocidad;
               
    
            }else if(listaE[i].posX<this.posX){
                this.posX-=this.velocidad;
                
        
            }else if(listaE[i].posY>this.posY){
                this.posY+=this.velocidad;

            }else if(listaE[i].posX<this.posY){
                this.posY-=this.velocidad;
            }
        this.energia-=1;
        }
        }else if(listaV[i].posX>(this.posX-this.vision)&&listaV[i].posX<(this.posX+this.vision) 
        && listaV[i].posY>(this.posY-this.vision)&&listaV[i].posY<(this.posY+this.vision))
        {if (this.energia>this.minEnergia){
            if(listaV[i].posX>this.posX){
                this.posX+=this.velocidad;
               
    
            }else if(listaV[i].posX<this.posX){
                this.posX-=this.velocidad;
                
        
            }else if(listaV[i].posY>this.posY){
                this.posY+=this.velocidad;

            }else if(listaV[i].posX<this.posY){
                this.posY-=this.velocidad;
            }
        this.energia-=1;
        }
        }else if(listaVi[i].posX>(this.posX-this.vision)&&listaVi[i].posX<(this.posX+this.vision) 
        && listaVi[i].posY>(this.posY-this.vision)&&listaVi[i].posY<(this.posY+this.vision))
        {if (this.energia>this.minEnergia){
            if(listaVi[i].posX>this.posX){
                this.posX+=this.velocidad;
               
    
            }else if(listaVi[i].posX<this.posX){
                this.posX-=this.velocidad;
                
        
            }else if(listaVi[i].posY>this.posY){
                this.posY+=this.velocidad;

            }else if(listaVi[i].posX<this.posY){
                this.posY-=this.velocidad;
            }
        this.energia-=1;
        }
        }else{
             movimientoOrganismo();
        }
        
      }
    }
    
    public void huir(Microorganismo listaM[]) 
{   
        for (int i=0;i<6;i++)
    {
        if(this.tipo!=listaM[i].tipo){
            if(listaM[i].posX>(this.posX-this.vision)&&listaM[i].posX<(this.posX+this.vision) 
        && listaM[i].posY>(this.posY-this.vision)&&listaM[i].posY<(this.posY+this.vision))
        {
            if (listaM[i].energia>this.energia)
            
            {
                if(this.posX<=500 && this.posY<=500&&this.posX>=0&&this.posY>=0)
                {
                    if(listaM[i].posX>this.posX && listaM[i].posY>this.posY){
                        if (this.posX>10){
                            this.posX-=this.velocidad;
                        }else if(this.posX>0){
                            this.posY-=this.velocidad;
                        }
                    }else if(listaM[i].posX<this.posX && listaM[i].posY>this.posY){
                        if (this.posX<490){
                            this.posX+=this.velocidad;
                        }else if(this.posX<500){
                            this.posY+=this.velocidad;
                        } 
                    }else if(listaM[i].posY>this.posY && listaM[i].posX>this.posX)
                    {
                        if (this.posY>10){
                            this.posX-=this.velocidad;
                        }else if(this.posY>0){
                            this.posY-=this.velocidad;
                        }else if(listaM[i].posY<this.posY && listaM[i].posX>this.posX){
                            if (this.posY<490){
                                this.posX+=this.velocidad;
                            }else if(this.posY<500){
                                this.posX+=this.velocidad;
                            }  
                       }
                    }

                }
            }
        }
    }
    }     
}
    public void movimientoOrganismo() 
    {
        
       if (this.energia>this.minEnergia){
            if((this.posX<30 && this.posY>470)){
                this.posY-=this.velocidad;
                this.energia-=1;
            }else if(this.posX>470&& this.posY<30)
            {
                this.posY+=this.velocidad;
                this.energia-=1;
            }else if(this.posX<=480 && this.posY>470)
            {
                this.posX-=this.velocidad;
                this.energia-=1;
            }else if(this.posX<=480 && this.posY>30){
                this.posX-=this.velocidad;
                this.energia-=1;

            }else if(this.posX<=480 && this.posY>30 &&this.posX>30&&this.posY<480){
                this.posX+=1;
                this.energia-=1;
               
            }
            System.out.println("identificador"+this.tipo+" x "+this.posX+" Y "+this.posY);
       }
    
    }   
    public void comer() {
      
    }
    public void atacar() {
       
    }
   
}