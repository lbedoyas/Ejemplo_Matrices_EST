/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomatrizestudiantes;

import java.awt.*;

public class MatrizEstudiantes {
    //*******************************************************
    // MATRIZ DE TIPO ESTUDIANTE 
    //*******************************************************

    private String nombre;
    private Estudiante mat[][];
    int N;
    int M;
    //*********************************************************
    // CONSTRUCTOR  QUE RECIBE EL NOMBRE Y EL NUMERO DE  
    // POSICIONES DEL VECOTOR *
    //*********************************************************

    public MatrizEstudiantes(String nombre, int N, int M) {
        this.nombre = nombre;
        this.N = N;
        this.M = M;
        mat = new Estudiante[N][M];
    }
    //***********************************************
    // PARA ASIGNAR UN ESTUDIANTE EN EL VECTOR,
    // EN LA POSICION RECIBIDA COMO PARAMETRO
    //***********************************************

    public void asignarEstudiante(Estudiante q, int f, int c) {
        mat[f][c] = q;
    }
    //***************************************************
    // METODO QUE PINTA EL VECTOR, SI EN LA POSICION    *
    // NO HAY  ESTUDIANTE PINTA UN CUADRO VACIO DE      *
    // FONDO BLANCO EN CASO CONTARIO PINTA EL ESTUDIANTE*
    //***************************************************

    public void pintar(Graphics g, int c, int f) {
        int f1 = f, c1 = c, i, j;
        //f1=f1+20;
        g.setColor(Color.blue);
        g.drawString(nombre, c1, f1);
        f1 = f1 + 20;
        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                if (mat[i][j] == null) {
                    g.setColor(Color.white);
                    g.fillRect(c1, f1, 170, 80);
                    g.setColor(Color.blue);
                    g.drawRect(c1, f1, 170, 80);
                    c1 = c1 + mat[i][j].obtenerAltoNodo();;
                } else {
                    mat[i][j].pintar(g, c1, f1);
                    c1 = c1 + mat[i][j].obtenerAnchoNodo();
                }
            }
            c1 = c;
            f1 = f1 + mat[i][0].obtenerAltoNodo();
        }
    }
    //**************************************************************************
    // METODO QUE REGRESA UN STRING CON EL NOMBRE Y EDAD DE LOS ESTUDIANTES
    // MAYORES DE EDAD
    //**************************************************************************

    public String mayoresDeEdad(Color x) {
        String respuesta = "los mayores de edad son: \n\n\n";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mat[i][j].obtenerEdad() >= 18) {
                    mat[i][j].asignarColorRegistro(x);

                    respuesta = respuesta + mat[i][j].obtenerNombre() + "  " + mat[i][j].obtenerEdad() + "\n";
                }
            }
        }
        return respuesta;
    }

    //**************************************************************************
    // METODO QUE REGRESA UN STRING CON EL NOMBRE Y LA CANTIDAD DE NOTAS GANADAS
    // DE CADA ESTUDIANTE DE LA MATRIZ
    //**************************************************************************
    public String notasGanadas(Color x) {
        int f, c = 0, i;
        String respuesta = "la cantidad de notas ganadas es: \n\n\n";
        for (i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                int cont = 0;
                for (f = 0; f < 4; f++) {
                    for (c = 0; c < 5; c++) {

                        if (mat[i][j].obtenerNota(f, c) >= 3.0) {
                            cont = cont + 1;
                            mat[i][j].asignarColorNota(x, f, c);
                        }
                    }
                }
                respuesta = respuesta + mat[i][j].obtenerNombre() + "  gano " + cont + " notas\n";
            }
        }
        return respuesta;
    }
    //**************************************************************************
    // METODO QUE RECORRE EL VECTOR Y LLAMA EL METODO LIMPIAR DE CADA ESTUDIANTE
    //**************************************************************************

    public void limpiar() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mat[i][j].limpiar();
            }
        }
    }
    //**************************************************************************
    // METODO QUE REGRESA STRING CON EL NOMBRE DE CADA ESTUDIANTE LAS MATERIAS
    // Y SU PROMEDIO.
    //**************************************************************************  

    public String promedioMateriasEstudiantes() {
        String respuesta = "";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                respuesta = respuesta + mat[i][j].promedioMaterias();
            }
        }
        return respuesta;
    }

    //1.	Mostrar la cedula, el nombre y  la edad de los 
    //estudiantes que ganan la materia física(pintarlos).
    public String Notas_ganadas_fisica(Color x) {
        String resp = "la cantidad de personas que ganan fisica son:  \n";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int f = 0; f < 1; f++) {
                    for (int c = 0; c < 5; c++) {
                        if (mat[i][j].obtenerNota(f, c) >= 3.0) {
                            mat[i][j].asignarColorNota(x, f, c);
                        }
                    }
                }
                resp = resp + mat[i][j].obtenerNombre() + " con C.C.   " + mat[i][j].obtenerCedula() + " y tiene   " + mat[i][j].obtenerEdad() + "  de edad\n";
            }
        }
        return resp;
    }

    // 2.	Pintar la nota mayor de cada estudiante.
    public String nota_mayor_cada_estudiante(Color x) {
        String rs = "la mayor nota de cada estudiante es:  \n";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                for (int f = 0; f < 4; f++) {
                    float mayor = mat[i][j].obtenerNota(0, 0);
                    for (int c = 0; c < 5; c++) {
                        if (mat[i][j].obtenerNota(f, c) > mayor) {
                            mayor = mat[i][j].obtenerNota(f, c);
                        }
                    }
                    rs = rs + "\n la mayor nota de " + mat[i][j].obtenerNombre() + " es " + mayor + "  " + mat[i][j].obtenerMaterias()[f];
                }

            }

        }
        return rs;
    }
    //3.	Para cada estudiante pintar la nota mayor y menor de cada materia.
    //Observacion falta agregar cada materia

    public String Nota_mayor_nota_menor_materias(Color x) {
        String materia = "";
        String res = "la nota mayor y menor de cada estudiante es:";

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                for (int f = 0; f < 4; f++) {
                    float mayor = mat[i][j].obtenerNota(0, 0);
                    float menor = mat[i][j].obtenerNota(0, 0);

                    for (int c = 0; c < 5; c++) {
                        if (mat[i][j].obtenerNota(f, c) > mayor) {
                            mayor = mat[i][j].obtenerNota(f, c);
                        }
                        if (mat[i][j].obtenerNota(f, c) < menor) {
                            menor = mat[i][j].obtenerNota(f, c);
                        }

                    }
                    res = res + "\n el nombre del estudiante es: " + mat[i][j].obtenerNombre() + " su nota mayor es " + mayor + "su nota menor es " + menor + " de la materia    " + mat[i][j].obtenerMaterias()[f];
                }

            }

        }
        return res;
    }

    //4.	Para  cada estudiante mostrar  el nombre de la materia  
    //y la cantidad de notas perdidas para la materia.
    public String Notas_perdidas_materias(Color x) {
        String materia = "";
        int cont;
        String res = "la cantidad de notas perdidas de los estudiantes es::";

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                for (int f = 0; f < 4; f++) {

                    cont = 0;

                    for (int c = 0; c < 5; c++) {

                        if (mat[i][j].obtenerNota(f, c) < 3.0) {
                            cont++;
                            mat[i][j].asignarColorNota(x, f, c);
                        }
                    }

                    res = res + "\n el nombre del estudiante es:   " + mat[i][j].obtenerNombre() + " la cantidad de notas perdidas son:   " + cont + "  " + mat[i][j].obtenerMaterias()[f];

                }

            }

        }
        return res;
    }

    //Mostrar el nombre de los estudiantes que tienen el mayor promedio en química (pintarlos).
    public String nom_prom_quimica(Color x) {
        float prom = 0;
        String res = "los estudiantes que mayor promedio tienen en quimica son:  \n";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int f = 0; f < 4; f++) {
                    float acum = mat[i][j].obtenerNota(0, 0);
                    for (int c = 0; c < 5; c++) {
                        acum = acum + mat[i][j].obtenerNota(f, c);
                        prom = acum / 5;
                    }
                }
                if (prom > 3.0) {
                    mat[i][j].asignarColorRegistro(x);
                }

                res = res + "\n los estudiantes con mayor promedio en quimica son:  " + mat[i][j].obtenerNombre() + " su promedio es:  " + prom;
            }

        }
        return res;
    }

    //6. Mostrar el nombre de los estudiantes que pierden 2 materias (pintarlos).
    public String nom_est_pierden2_mat(Color x) {
        String perdio;
        float prom;
        int cont = 0;
        String res = "los estudiantes que pierden dos materias son:  \n";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int f = 0; f < 4; f++) {
                    prom = 0;
                    perdio = " ";
                    float acum = 0;
                    for (int c = 0; c < 5; c++) {
                        acum = acum + mat[i][j].obtenerNota(f, c);

                    }
                    prom = acum / 5;
                    if (prom < 3.0) {
                        cont++;

                    }
                 
                    if (cont == 2) {

                    res = res + "\n El estudiante:  " + mat[i][j].obtenerNombre() + "   "+ mat[i][j].obtenerMaterias()[f];
                    mat[i][j].asignarColorRegistro(x);

                }
                }
                
            }
        }

        return res;

    }
    
    //segundo intento del metodo
    public String perdioMaterias(Color x){
       String res = "los estudiantes que pierden dos materias son:  \n";
       float prom ;
       
       for(int f = 0; 2 > f ; f ++){ 

            for (int c = 0; 3 > c ; c++){
              int per_est = 0; 

            for (int f_m = 0; 4 > f_m ; f_m++){
                 float suma_notas = 0;

                for (int c_m = 0; 5 > c_m ; c_m++){
                    suma_notas = suma_notas + mat[f][c].obtenerNota(f_m, c_m); 
                }

                prom = suma_notas / 5; 
                if (prom < 3.0){
                    per_est++;

                }
            }
            if (per_est == 2){ 
                 mat[f][0].asignarColorRegistro(x);
                 res = res +  mat[f][c].obtenerNombre() + " \n";
            }    
             
           }
         
           
       }
       return res;
    }
  
    //tercer intento
    
    
public String perdiodosmaterias(Color x)
{
    int f,c =0;
    float div = 5, resultados=0;
    String respuesta ="los estudiantes que pierden dos materias son:";
            for(int i = 0; i<N; i++){
                for(int j=0;j<M;j++){
                    int cuenta =0;
                    for(f=0;f<4;f++){
                        float cont=0;
                        for(c=0;c<5;c++){
                            if(mat[i][j].obtenerNota(f, c)>=0)
                            {
                                cont=cont+mat[i][j].obtenerNota(f, c);
                            }
                        }
                        if(cont>0){
                            resultados=(cont/div);
                        }
                        if(resultados<3.0){
                            cuenta=cuenta+1;
                        }
                    }
                    if(cuenta>2){
                        respuesta=respuesta+mat[i][j].obtenerNombre()+" perdio "+cuenta+" Materias \n";
                        mat[i][j].asignarColorRegistro(x);
                    }
                    
                }
            }
            return respuesta;   
}

//7.	Mostrar el nombre de los estudiantes que pierden la mayor cantidad de notas (pintarlos).

public String perdiomas10notas(Color x){
    int cont;
    String resp="los Estudiantes que perdieron mas de 10 notas son:";
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            cont=0;
            for(int f=0;f<4;f++){
                for(int c=0;c<5;c++){
                    if(mat[i][j].obtenerNota(f, c)<3.0){
                      cont++;
                      mat[i][j].asignarColorNota(x, f, c);
                    }
                }
                
            }
            if(cont>10){
                resp=resp+mat[i][j].obtenerNombre()+" perdio  " + cont + "   notas \n";
            }
            
        }
    
        
}
return resp;
    
}


//8.	Mostrar el nombre de cada estudiante y su promedio total 
//(promedio total es el promedio de todas sus materias.

public String promediototalmaterias(Color x){
    String resp="El promedio total de los estudiantes es: \n";
    for(int i=0; i<N; i++){
        for(int j=0; j<M; j++){
            resp=resp+mat[i][j].PromedioMateriasTotal();
        }
    }
    return resp;
}

//9.	Pintar los estudiantes que tienen el mayor promedio total.
 public String Mayorpromediototal(Color x){
     String resp="Los estudiantes que tienen mayor promedio son: \n NOTA: Si no sale ningun alumno es que su promedio no fue alto \n \n ";
     for(int i=0; i<N; i++){
         for(int j=0;j<M;j++){
             if(mat[i][j].PromedioMateriasEst()>3.0){
                 resp=resp+mat[i][j].PromedioMateriasTotal();
                 mat[i][j].asignarColorRegistro(x);
             }
         }
     }
     return resp;
 }  
 
 
 //10.	Mostrar el nombre y el promedio total de cada estudiante ordenados por promedio total ( de mayor a menor).
 
/* public String ordenarpromediosmayores(){
     Float ordenar;
     int i,j;
     String resp ="Promedios mayores de estudiantes ordenados";
     for(i=0; i<N; i++){
         for(j=0; j<M; j++){
             if(mat[i][j].PromedioMateriasEst()>3.0){
                 resp=resp+mat[i][j].PromedioMateriasTotal();
         }
             ordenar = mat[i][j].ordenar();
     }
         resp=resp+mat[i][j].obtenerNombre()+"  " + mat[i][j].ordenar();
 }
     return resp;
 }
*/
 
 /*
 public String ordenamiento_promedios(){
     float aux, aux2;
    String resp="Los estudiantes que tienen mayor promedio son:(informacion ordenada \n  \n \n ";
     for(int i=0; i<N; i++){
         for(int j=0;j<M;j++){
             if(mat[i+1][j].PromedioMateriasEst()<mat[i][j].PromedioMateriasEst()){
                 aux=mat[i][j].PromedioMateriasEst();
                 mat[i+1][j].PromedioMateriasEst() = mat[i][j].PromedioMateriasEst();
                 mat[i-1][j].PromedioMateriasEst()=aux;
                                
                 
             }
         }
     }
     return resp;
}
*/
 
 public String Ordenamiento_promedios1(){
     String resp="Los estudiantes que tienen mayor promedio son: \n NOTA: Si no sale ningun alumno es que su promedio no fue alto \n \n ";
     for(int i=0; i<N; i++){
         for(int j=0;j<M;j++){
             if(mat[i][j].PromedioMateriasEst()>3.0){
                 resp=resp+mat[i][j].PromedioMateriasTotal();
                 
             }
         }
     }
     return resp;
 } 

public String ordenarpromediosmayores(){

     int i,j;
     Estudiante eAux;
     String resp ="Promedios mayores de estudiantes ordenados  \n";
     
     //variable de control del while
     boolean ordenado= false;
     int max=0;

     //mientras no este ordenado y no me pase de la cantidad maxima de elementos
     while (!ordenado && max<N*M){
        max++; 
        ordenado=true;
        //recorro la matriz de estudiantes...
        for(i=0; i<mat.length; i++){
            //...comparo promedios hasta la anteultima columna..
            for(j=0; j<mat[i].length-1; j++){
                if (mat[i][j].PromedioMateriasEst()< mat[i][j+1].PromedioMateriasEst()){
                    eAux=mat[i][j];
                    mat[i][j]=mat[i][j+1];
                    mat[i][j+1]=eAux;
                    ordenado=false;
                } 
            }
            //...si tengo proxima fila...
            if (i+1<N){
                //...comparo el promedio de la ultia columna con el promedio de la primera columna de la proxima fila
                if (mat[i][j].PromedioMateriasEst()< mat[i+1][0].PromedioMateriasEst()){
                    eAux=mat[i][j];
                    mat[i][j]=mat[i+1][0];
                    mat[i+1][0]=eAux;
                    ordenado=false;
                }
            }
        }
    }
    
     
     for(i=0; i<N; i++){
         for(j=0;j<M;j++){
             
             resp=resp+"\n" + mat[i][j].obtenerNombre()+ "    "+ mat[i][j].PromedioMateriasEst();
         }
     } 
     
     
     return resp;
 } 
 
 
//13. 	Ordenar todos  los estudiantes de la matriz por  cedula.

public String ordenarnotasxmateria(){

     int i,j;
     Estudiante eAux;
     String resp ="Ordenamiento de cedulas x matriz";
     
     //variable de control del while
     boolean ordenado= false;
     int max=0;

     //mientras no este ordenado y no me pase de la cantidad maxima de elementos
     while (!ordenado && max<N*M){
        max++; 
        ordenado=true;
        //recorro la matriz de estudiantes...
        for(i=0; i<mat.length; i++){
            //...comparo promedios hasta la anteultima columna..
            for(j=0; j<mat[i].length-1; j++){
                if (mat[i][j].obtenerCedula()< mat[i][j+1].obtenerCedula()){
                    eAux=mat[i][j];
                    mat[i][j]=mat[i][j+1];
                    mat[i][j+1]=eAux;
                    ordenado=false;
                } 
            }
            //...si tengo proxima fila...
            if (i+1<N){
                //...comparo el promedio de la ultia columna con el promedio de la primera columna de la proxima fila
                if (mat[i][j].obtenerCedula()< mat[i+1][0].obtenerCedula()){
                    eAux=mat[i][j];
                    mat[i][j]=mat[i+1][0];
                    mat[i+1][0]=eAux;
                    ordenado=false;
                }
            }
        }
    }
    
     //System.Out----- Borrar
     for(i=0; i<N; i++){
         for(j=0;j<M;j++){
             resp=resp+"\n" + mat[i][j].obtenerNombre()+ "    "+ mat[i][j].obtenerCedula();
         }
     } 
     
     return resp;
 }
 

//12.	Ordenar los estudiantes de cada columna por cedula.

public String ordenarxcolumna1(){

     int i,j;
     Estudiante eAux;
     String resp ="Ordenamiento de cedulas por columnas";
     
     //variable de control del while
     boolean ordenado= false;
     int max=0;

     //mientras no este ordenado y no me pase de la cantidad maxima de elementos
     while (!ordenado && max<N*M){
        max++; 
        ordenado=true;
        //recorro la matriz de estudiantes...
        for(i=0; i<mat.length; i++){
            //...comparo promedios hasta la anteultima columna..
            for(j=0; j<mat[i].length-1; j++){
                if (mat[i][j].obtenerCedula()< mat[i][j+1].obtenerCedula()){
                    eAux=mat[i][j];
                    mat[i][j]=mat[i][j+1];
                    mat[i][j+1]=eAux;
                    ordenado=false;
                } 
            }
            //...si tengo proxima fila...
            if (i+1<N){
                //...comparo el promedio de la ultia columna con el promedio de la primera columna de la proxima fila
                if (mat[i][j].obtenerCedula()< mat[i+1][0].obtenerCedula()){
                    eAux=mat[i][j];
                    mat[i][j]=mat[i+1][0];
                    mat[i+1][0]=eAux;
                    ordenado=false;
                }
            }
        }
    }
    
     
     for(j=0; j<M; j++){
         for(i=0;i<N;i++){
             resp=resp+"\n" + mat[i][j].obtenerNombre()+ "    "+ mat[i][j].obtenerCedula();
         }
     } 
     
     return resp;

     
}

//15. Mostrar el nombre de cada estudiante, la materia y su promedio correspondiente, ordenados por promedio.

public String nombremateriapromedioordenado(){

     int i,j;
     Estudiante eAux;
     String resp ="Promedios mayores de estudiantes ordenados  \n";
     
     //variable de control del while
     boolean ordenado= false;
     int max=0;

     //mientras no este ordenado y no me pase de la cantidad maxima de elementos
     while (!ordenado && max<N*M){
        max++; 
        ordenado=true;
        //recorro la matriz de estudiantes...
        for(i=0; i<mat.length; i++){
            //...comparo promedios hasta la anteultima columna..
            for(j=0; j<mat[i].length-1; j++){
                if (mat[i][j].promedioMaterias()< mat[i][j+1].promedioMaterias()){
                    eAux=mat[i][j];
                    mat[i][j]=mat[i][j+1];
                    mat[i][j+1]=eAux;
                    ordenado=false;
                } 
            }
            //...si tengo proxima fila...
            if (i+1<N){
                //...comparo el promedio de la ultia columna con el promedio de la primera columna de la proxima fila
                if (mat[i][j].PromedioMateriasEst()< mat[i+1][0].PromedioMateriasEst()){
                    eAux=mat[i][j];
                    mat[i][j]=mat[i+1][0];
                    mat[i+1][0]=eAux;
                    ordenado=false;
                }
            }
        }
    }
    
     
     for(i=0; i<N; i++){
         for(j=0;j<M;j++){
             
             resp=resp+"\n" + mat[i][j].obtenerNombre()+ "    "+ mat[i][j].PromedioMateriasEst();
         }
     } 
     
     
     return resp;
 } 



//15. Mostrar el nombre de cada estudiante, la materia y su promedio correspondiente, ordenados por promedio.


 public String nom_mat_promedio_orden() {
        float prom;
        int i,j;
        Estudiante eAux;
        boolean ordenado= false;
        int max=0;
        String res = "Se muestra el estudiante,materia,promedio:  \n";
        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                for (int f = 0; f < 4; f++) {
                    prom = 0;
                    float acum = 0;
                    for (int c = 0; c < 5; c++) {
                        acum = acum + mat[i][j].obtenerNota(f, c);

                    }
                    prom = acum / 5;
                    
                }
                
            }
        }

        return res;

    }


 
 
 //Para cada estudiante mostrar el nombre, y su mayor nota en la materia
 public String nom_nota_quimica() {
        String res = "los estudiantes que mayor nota tienen en quimica son:  \n";
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                float acum = mat[i][j].obtenerNota(0, 0);
                for (int f = 1; f == 1; f++) {
                    for (int c = 0; c < 5; c++) {
                        if(mat[i][j].obtenerNota(f, c)>mat[i][j].obtenerNota(i, c))
                        acum = acum+mat[i][j].obtenerNota(f, c);    
                    }
                }
                res = res + "\n los estudiantes con mayor nota en quimica son:  " + mat[i][j].obtenerNombre() + " su nota es:  " + acum;   
            }
        }
        return res;
    }

 
 
 
 
 
}