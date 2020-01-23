/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import Vargas.BasePersistencia;
import beu.Curso;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author labctr
 */
public class Gestion_Curso extends BasePersistencia<Curso> {
    private List<Curso> curso = new ArrayList<>();
    
    
    public Gestion_Curso(){
        
        
       
    }
    public List<Curso> getCurso() throws IOException{
        String contenido = this.leer("Cursos","Cursos.json");
        
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        
        Type listType = new TypeToken<ArrayList<Curso>>(){}.getType();//transforma la lista a java
        curso = gson.fromJson(contenido, listType);
        return curso;
    
    }
    
    
}
