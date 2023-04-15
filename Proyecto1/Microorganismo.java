import javax.swing.JPanel;
import java.awt.*;

public class Microorganismo extends JPanel {
//inicializacion de las variables//.
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
        //instanciacion de variables.
        this.tipo = tipo;
        this.energia = energia;
        this.velocidad = velocidad;
        this.minEnergia=minEnergia;
        this.maxEnergia=maxEnergia;
        this.minVelocidad=minVelocidad;
        this.maxVelocidad=maxVelocidad;
        this.minVision=minVision;
        this.maxVision=maxVision;
        this.vision = vision;
        this.posX = posX;
        this.posY = posY;
        this.tamano = tamano;
        this.identificador=identificador;
    }
   //Genera organismos//
    public void generarOrganismo(int jposX ,int jposY)
    {
        boolean existe=false;
        int X=(int)(Math.abs(Math.random()*720));
        int Y=(int)(Math.abs(Math.random()*500));
        if(jposX==X && jposY==Y){
            existe=true;
            generarOrganismo(jposX, jposY);

    }else{
                if(!existe){
                    this.posX=X;
                    this.posY=Y;
                }
            }
}   //da prioridad a la busqueda de alimentos tipo energia
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
    }//Da prioridad a la busqueda de alimentos tipo velocidad;
    public void buscarPrioridadVelocidad(AlimentoEnergia[] listaE,AlimentoVelocidad[]listaV,AlimentoVision[]listaVi,Microorganismo[] listaM) {
        for(int i=0;i<3;i++)
        {
          if(listaV[i].posX>(this.posX-this.vision)&&listaV[i].posX<(this.posX+this.vision) 
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
          }else if(listaE[i].posX>(this.posX-this.vision)&&listaE[i].posX<(this.posX+this.vision) 
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
      } //da prioridad a la busqueda de alimentos tipo vision.
          public void buscarPrioridadVision(AlimentoEnergia[] listaE,AlimentoVelocidad[]listaV,AlimentoVision[]listaVi,Microorganismo[] listaM) {
      for(int i=0;i<3;i++)
      {
        if(listaVi[i].posX>(this.posX-this.vision)&&listaVi[i].posX<(this.posX+this.vision) 
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
        }else if(listaE[i].posX>(this.posX-this.vision)&&listaE[i].posX<(this.posX+this.vision) 
        && listaE[i].posY>(this.posY-this.vision)&&listaE[i].posY<(this.posY+this.vision))
        { if(this.energia>this.minEnergia){
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
        }else{
             movimientoOrganismo();
        }
        
      }
    }    //funcion que permite huir organismos de otros organismos.
    public void huirMismaEspecie(Microorganismo listaM[]) 
{   
        for (int i=0;i<6;i++)
    {
        if(this.tipo!=listaM[i].tipo){
            if(listaM[i].posX>(this.posX-this.vision)&&listaM[i].posX<(this.posX+this.vision) 
        && listaM[i].posY>(this.posY-this.vision)&&listaM[i].posY<(this.posY+this.vision))
        {
            if (listaM[i].energia>this.energia)
            
            {
                if(this.posX<=750 && this.posY<=750&&this.posX>=0&&this.posY>=0)
                {
                    if(listaM[i].posX>this.posX && listaM[i].posY>this.posY){
                        if (this.posX>10){
                            this.posX-=this.velocidad;
                        }else if(this.posX>0){
                            this.posY-=this.velocidad;
                        } this.energia-=1;
                        this.tamano+=1;
                    }else if(listaM[i].posX<this.posX && listaM[i].posY>this.posY){
                        if (this.posX<740){
                            this.posX+=this.velocidad;
                        }else if(this.posY<750){
                            this.posY+=this.velocidad;
                        } this.energia-=1;
                        this.tamano+=1;
                    }else if(listaM[i].posY>this.posY && listaM[i].posX>this.posX)
                    {
                        if (this.posY>10){
                            this.posX-=this.velocidad;
                        }else if(this.posY>0){
                            this.posY-=this.velocidad;
                        }else if(listaM[i].posY<this.posY && listaM[i].posX>this.posX){
                            if (this.posY<740){
                                this.posX+=this.velocidad;
                            }else if(this.posY<750){
                                this.posX+=this.velocidad;
                            }  
                       }
                       this.energia-=1;
                       this.tamano+=1;
                    }

                }
            }
        }
    }
    }     
}//funcion que permite huir a los organismos del jugador
public void huirJugador(Jugador jugador){
    if(jugador.posX>(this.posX-this.vision)&&jugador.posX<(this.posX+this.vision) 
    && jugador.posY>(this.posY-this.vision)&&jugador.posY<(this.posY+this.vision))
    {
        if (jugador.energia>this.energia)
        
        {
            if(this.posX<=750 && this.posY<=750&&this.posX>=0&&this.posY>=0)
            {
                if(jugador.posX>this.posX && jugador.posY>this.posY){
                    if (this.posX>10){
                        this.posX-=this.velocidad;
                    
                    }else if(this.posX>0){
                        this.posY-=this.velocidad;
                    }
                    this.energia-=1;
                    this.tamano+=1;
                }else if(jugador.posX<this.posX && jugador.posY>this.posY){
                    if (this.posX<490){
                        this.posX+=this.velocidad;
                    }else if(this.posX<500){
                        this.posY+=this.velocidad;
                    } 
                    this.energia-=1;
                    this.tamano+=1;
                }else if(jugador.posY>this.posY && jugador.posX>this.posX)
                {
                    if (this.posY>10){
                        this.posX-=this.velocidad;
                        this.energia-=1;
                    }else if(this.posY>0){
                        this.posY-=this.velocidad;
                        this.energia-=1;
                    }else if(jugador.posY<this.posY && jugador.posX>this.posX){
                        if (this.posY<490){
                            this.posX+=this.velocidad;
                        }else if(this.posY<500){
                            this.posX+=this.velocidad;
                        } 
                        this.energia-=1; 
                    
                   }
                   this.tamano+=1;
                }

            }
        }
    }
}//funcion que permite el movimiento del organismo.
    public void movimientoOrganismo() 
    {
        
       if (this.energia>this.minEnergia){
            if((this.posX<20 && this.posY>480)){
                
                this.posY=Math.floorMod(this.posY-=this.velocidad, 30);
                this.energia-=1;
                this.tamano+=1;
            }else if(this.posX>470&& this.posY>=0)
            {
                this.posY+=this.velocidad;
                this.energia-=1;
                this.tamano+=1;
            }else if(this.posX>0&&this.posX<=500 && this.posY<500)
            {   if(this.posX<=3){
                this.posX=500;
                this.posX-=this.velocidad;
            }else{
                this.posX-=this.velocidad;
            }
                this.tamano+=1;
                this.energia-=1;
            }else if(this.posX<=480 && this.posY>20){
                if(this.posX<=3){
                    this.posX=480;
                    this.posX-=this.velocidad;
                }else{
                    this.posX-=this.velocidad;
                }
                this.energia-=1;
                this.tamano+=1;

            }else if(this.posX<=480 && this.posY>20 &&this.posX>30&&this.posY<480){
                this.posX+=this.velocidad;
                this.energia-=1;
                this.tamano+=1;
            }
            System.out.println("identificador"+this.tipo+" x "+this.posX+" Y "+this.posY);
       }
    
    }   
    public void comer() {
      
    }
    public void atacar() {
       
    }
   
}