/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import Vargas.BaseBllCrud;
import Vargas.BasePersistencia;
import Vargas.Util;
import beu.Curso;
import beu.Estado;
import beu.Estudiante;
import beu.Matricula;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author labctr
 */
public class Gestion_Matricula extends BasePersistencia<Matricula>implements BaseBllCrud<Matricula>{
    private Matricula matricula;
    private final String directorio = "matriculas";

    public Gestion_Matricula() {
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
   
    public String calificar(float valor){
        int numero=this.matricula.addCalificacion(valor);
        String mensaje="";
        switch (numero){
            case 0:
                mensaje = "Todas las notas enstan registradas";break;
            case 1: 
                mensaje = "Calificar d ela Unidad I ingresada correctamente";break;
            case 2: 
                mensaje = "Calificar d ela Unidad II ingresada correctamente";break;
            case 3: 
                mensaje = "Calificar d ela Unidad III ingresada correctamente";break;
            default:
              
                mensaje = "Hubo un error al registrar la calificacion";break;
        
        }
        return mensaje;
    }
    public void promediar(){
        this.matricula.CalcularPromedio();
    }
    public String imprimir (){
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiate: ");
        sb.append(matricula.getEstudiante()).append("\n");
        sb.append("Curso: ");
        sb.append(matricula.getCurso()).append("\n");
        sb.append("Promedio: ").append("\n");
        sb.append(matricula.getPromedio());
        return sb.toString();
        
    
    
    }
    public void anularMatricula(boolean anular){
        if(anular==true)
        matricula.setEstado(Estado.Anulado);
        Util.imprimir("\nMATRICULA ANULADA CORRECTAMENTE\n");
        float num = matricula.getCurso().getCosto()*0.10f;
        Util.imprimir("\n El 10% de rubro que debe pagar es : "+num);
    
    }
    public void archivar () throws IOException{
       this.escribir(directorio, this.matricula.getNumero(), matricula);
    
    }
    public void configurar(Curso cr, Estudiante est){
        this.matricula.setCurso(cr);
        this.matricula.setEstudiante(est);
    
    }
    public List<Matricula> reportar(String titulo) throws IOException{
        List<Matricula> resultado = new ArrayList<>();
        List<String>  contenidos = this.leerDirectorio(directorio,titulo);
        for (String texto : contenidos){
            GsonBuilder gb = new GsonBuilder();
            gb.setPrettyPrinting();
            Gson gson = gb.create();
            try {
                Matricula m = gson.fromJson(texto, Matricula.class);
                resultado.add(m);  
            } catch (JsonSyntaxException ex) {
                Util.imprimir("El texto no se pudo convertir en matricula ");
                Util.imprimir(ex.toString()+"\n");
            }
            

        }
        return resultado;
    }

    @Override
    public void crear() {
        matricula = new Matricula();
    }

    @Override
    public void consultar(String id) throws IOException {
        String archivo= id+".json";
        String contenido = this.leer(directorio, archivo);
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        matricula = gson.fromJson(contenido, Matricula.class);
    }

    @Override
    public void actualizar(Matricula objeto) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
