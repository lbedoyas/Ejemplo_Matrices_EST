/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomatrizestudiantes;

import java.awt.*;
public class Estudiante
{
  //*********************************************************
  // ATRIBUTOS DE LA CLASE
  //*********************************************************
  private int cedula;
  private String nombre;
  private int edad;
  public float notas[][];
  private int N;							// GUARDA EL NUMERO DE MATERIAS
  private int M;							// GUARDA EL NUMERO DE NOTAS
  public String materias[]={ "física","química","calculo","etica"};
  private Color colorRegistro;			// PARA PINTAR EL FONDO DEL ESTUDIANTE
  private Color colorNotas[][];			// PARA PINTAR EL FONDO DE CADA NOTA
  private int anchoNodo;				// DIMENSION DEL NODO A PINTAR
  private int altoNodo;					// DIMENSION DEL NODO A PINTAR
  //***********************************************
  // CONSTRUCTOR SIN PARAMETROS                   *
  //***********************************************
  public Estudiante()
  {
  	this(0,"",0);
  }
  
   
  //***********************************************
  // CONSTRUCTOR QUE RECIBE LOS PARAMETROS        *
  //***********************************************
  public  Estudiante( int cedula, String nombre, int edad)
  {
  	  this.cedula=cedula;
  	  this.nombre= nombre;
	  this.edad = edad;
	  N = materias.length;
	  M = 5;
	  notas =new float[N][M];
   	  anchoNodo= 220;
  	  altoNodo= 160;
          this.materias=materias;
          
      llenarNotas();
     // colorRegistro= new Color(233,243,243);
      colorRegistro= Color.WHITE;
      colorNotas= new Color[N][M];
       for(int i = 0; i < colorNotas.length;i++)
      {
       	    for(int j = 0; j < colorNotas[i].length;j++)
      		{
       			colorNotas[i][j]=Color.lightGray;
      		}
      }
   }
  //***********************************************
  // METODO QUE LLENA EL VECTOR NOTAS CON VALORES *
  // ENTRE 0.0 Y 5.0                              *
  //***********************************************
  
  public void llenarNotas()
  {
  	for(int i=0; i< notas.length;i++)
  	{
       	    for(int j = 0; j < notas[i].length;j++)
      		{
                                            float  n = (int)(Math.random()*50)  ;	
                                            notas[i][j]=       n      /10;
      		}
  	}
  }
  //***********************************************
  // METODOS OBTENER QUE REGRESAN EL VALOR DE UN  *
  // ATRIBUTO                                     *
  //***********************************************
  public int obtenerCedula()
  {
	 return cedula;
  }
  public int obtenerEdad()
  {
	 return edad;
  }
  public String obtenerNombre()
  {
	 return nombre;
  }
 public float obtenerNota(int f,int c)
  {
	 return notas[f][c];
  }
  public int obtenerAltoNodo()
  {
	 return altoNodo;
  }
   public int obtenerAnchoNodo()
  {
	 return anchoNodo;
  }
  public Color obtenerColorRegistro()
  {
	 return colorRegistro;
  } 
  
  
  public String[] obtenerMaterias()
  {
      return materias;
  }
 
  //***********************************************
  // METODO QUE ASIGNAN UN NUEVO VALOR AL ATRIBUTO*
  //***********************************************
  public void asignarCedula(int d)
  {
	 cedula=d;
  }  
  public void  asignarEdad(int x)
  {
  	edad=x;
  }
  public void  asignarNombre(String x)
  {
  	nombre=x;
  } 
   public void  asignarNota(int f,int c, float n)
  {
  	notas[f][c]= n;
  } 
   public void  asignarColorRegistro(Color x)
  {
  	colorRegistro=x;
  } 
  public void  asignarColorNota(Color x,int f,int c)
  {
  	colorNotas[f][c]=x;
  } 
  
 
 
  //***********************************************
  // METODO ENCARGADO DE PINTAR EL NODO EN EL     *
  // CONTXTO GRAFICO RECIBIDO COMO PARAMETRO, EN  *
  // LA UBICACION RECIBIDA.                       *
  //***********************************************
   public void pintar(Graphics g, int c,int f)
  {
  //***********************************************
  // SE ASIGNA EL COLOR PARA EL FONDO DEL NODO     *
  //***********************************************
	g.setColor(colorRegistro);
  	//***********************************************
  	// SE PINTA EL FONDO DEL NODO CON EL COLOR      *
	// ASIGNADO AL ATRIBUTO COLORFONDO				*
	//***********************************************
	g.fillRect(c,f,anchoNodo,altoNodo);
	g.setColor(Color.red);
	//*********************************************************
 	// PARA PINTAR EL BORDE DEL NODO DE COLOR ROJO
 	//*********************************************************
	g.drawRect(c,f,anchoNodo,altoNodo);
 	//*********************************************************
 	//SE COLOCAN LOS ATRIBUTOS DEL NODO 
 	//*********************************************************
 	g.drawString("cedula ="+cedula,( c+5),(int)(f+20));
  	g.drawString("nombre ="+nombre,( c+5),(int)(f+40));
  	g.drawString("edad ="+edad,( c+5),(int)(f+60));
	//*********************************************************
 	// PARA PINTAR CADA UNA DE LAS NOTAS
 	//*********************************************************
         int f1,c1,alto=20,ancho=30;
        f1=(int)(f+70);
    
         for(int i=0; i< notas.length;i++)
        {
    	   	c1= c + 3; 
       	    g.setColor( Color.blue);
       	    g.drawString(materias[i],c1+5,f1+15);
       	    c1= c + 60; 	
       	    for(int j = 0; j < colorNotas[i].length;j++)
                       {
 		    	g.setColor( colorNotas[i][j]);// SE ASIGNA EL COLOR DE FONDO PARA CADA NOTA
		    	g.fillRect(c1,f1,ancho,alto);
		    	g.setColor( Color.blue);
				g.drawRect(c1,f1,ancho,alto);
				g.drawString(""+notas[i][j],c1+5,f1+15);
				c1= c1+ancho; 
                    }
	f1 = f1+ alto;
        }
  }
	//**************************************************************************
	// METODO QUE RECORRE EL VECTOR PARA ASIGNAR A TODOS LOS ESTUDIANTES UN 
	// MISMO COLOR DE FONTO ( BLANCO ), TAMBIEN RECORRE LAS NOTAS DE CADA  
	// ESTUDIANTE PARA ASIGNAR UN COLOR GRIS CLARO.
	//**************************************************************************
    public void limpiar()
   {
   		asignarColorRegistro(Color.WHITE);
       	for(int i = 0; i < colorNotas.length;i++)
      	{
      	    for(int j = 0; j < colorNotas[i].length;j++)
                        {
                            colorNotas[i][j]=Color.lightGray;
                        }
      	}
   }
 	//**************************************************************************
	// METODO QUE REGRESA UN VECTOR DE FLOTANTES, CON EL PROMEDIO DE  
	// CADA MATERIA
	//**************************************************************************  
   public float[] vectorPromedios ()
   {
   	   float promedio[]= new float[N];
   	   float suma= 0;
       	for(int i = 0; i < notas.length;i++)
      	{
      		suma= 0;
                                    for(int j = 0; j < notas[i].length;j++)
      		{
      			 suma=suma + notas[i][j];
      		}
      		promedio[i]=suma/M;
      	}  	  
   	  return promedio;
   }
  	//**************************************************************************
	// METODO QUE REGRESA STRING CON EL NOMBRE DEL ESTUDIANTE LAS MATERIAS
	// Y SU PROMEDIO.
	//**************************************************************************  
    public String promedioMaterias()
   {
   	   String respuesta="";
   	   float promedio[];
   	   respuesta = nombre +  "\n";
   	   promedio = vectorPromedios ();
       	for(int i = 0; i < promedio.length;i++)
      	{
      		respuesta = respuesta + materias[i ]+ " = "+ promedio[i]+"  , " ;
      	}  
      	respuesta = respuesta+ "\n";		    	   
   	  return respuesta;
   }
    
    
    
    
    
    //nombre de materias
    /*public String mat()
    {
        String res="";
        for (int i=0;i<N; i++)
        {
        materias[1]= "Fisica";
        materias[2]= "Quimica";
        materias[3]= " Calculo";
        materias[4]= "Etica";
        }
    return res,
    }
    */
    
    
    public float promediomaterias1(int mat)
    {
        float prom=0;
        int i=0;
        for(i=0;i<notas[mat].length;i++)
        {
            prom=prom+notas[mat][i];
        }
        return prom;
    }
    
    
    public String PromedioMateriasTotal(){
        String respuesta="";
        float promedio[], total =0, pfinal =0;
        respuesta = nombre+"\n";
        promedio=vectorPromedios();
        for(int i = 0; i < promedio.length; i++ )
        {
            total=total+promedio[i];
            
        }
        pfinal=total/4;
        respuesta = respuesta + pfinal + "\n";
        return respuesta;
    }
    
    public float PromedioMateriasEst(){
        float promedio[], total =0, pfinal =0;
        promedio=vectorPromedios();
        for(int i = 0; i < promedio.length; i++ )
        {
            total=total+promedio[i];
            
        }
        pfinal=total/4;
        return pfinal;
    }
    
public float ordenar(){
     float promedio[], total =0, pfinal =0;
     int i;
     float aux;
        promedio=vectorPromedios();
        for(i = 0; i < promedio.length; i++ )
        {
            for(int j = i+1; j<promedio.length; j++){
                if(promedio[i]<promedio[j]){
                    aux=promedio[j];
                    promedio[i]=promedio[j];
                    promedio[j]=aux;
                }
            }
        }
return i;
} 



public String mayornota(){
        String respuesta="";
        float promedio[], total =0, pfinal =0;
        respuesta = nombre+"\n";
        promedio=vectorPromedios();
        for(int i = 0; i < promedio.length; i++ )
        {
            if(promedio[i]<promedio[i-1])
            total=total+promedio[i];
            
        }
        respuesta = respuesta + pfinal + "\n";
        return respuesta;
    }
    
}