/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beu;

import Vargas.Persona;
import Vargas.Unidad;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author labctr
 */
public class Matricula {
    private final String numero;
    private Persona estudiante;
    private Calendar fecha;
    private Estado estado;
    private Curso curso;
    private final List<Calificacion> calificaciones= new ArrayList<>();
    //Informacion
    private float promedio;
    
    
    public Matricula() {
        fecha = Calendar.getInstance();
        estado= Estado.Registrado;
        UUID numeroAleatorio = UUID.randomUUID();
        this.numero = numeroAleatorio.toString();
    }

    public Persona getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Persona estudiante) {
        this.estudiante = estudiante;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNumero() {
        return numero;
    }

    
    public float getPromedio(){
        return promedio;
    }
    
    public void CalcularPromedio(){
        
        
        if(this.calificaciones.isEmpty()){
            return;
        }
        float suma =0;
        for(Calificacion c: calificaciones){
            suma+=c.valor;//sepuede acceder al atributo   
        }
        int divisor=this.calificaciones.size();
        promedio=(float)suma/(float)divisor;
        if(divisor ==3){
            if(promedio>14){
                this.estado=Estado.Aprobado;
            }else{
                this.estado=Estado.Reprobado;
            }
        }
    }
    //Este metodo registra una calificacion y retorna un numero 
    //1 si es la nota de la unidad I
    //2 si es la nota de la uinidad II
    //3 si es la nota de la uinidad III
    //0 si ya tiene todas las notas
    public int addCalificacion( float v){
        
        Calificacion cal = new Calificacion();
        int cuentanotas=this.calificaciones.size();
        
        switch(cuentanotas){
            case 0: cal.setUnidad(Unidad.I);break;
            case 1: cal.setUnidad(Unidad.II);break;
            case 2: cal.setUnidad(Unidad.III);break;
            //Caso de tener todas las notas
            default: return 0;
        }
        
        cal.setValor(v);
        cal.setFecha(Calendar.getInstance());
        this.calificaciones.add(cal);
        this.CalcularPromedio();
        return this.calificaciones.size();//Retorno el tamaño de la lista
    }
    @Override
    public String toString() {
        return estudiante.toString()+" # "+numero;
    }
    public String toSave(){
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        return gson.toJson(this);
    
    }
    public String imprimirDetalle(){
        String str = "\n\t"+this.estudiante;
        for (Calificacion c: this.calificaciones){
            str += "\t\t"+c.getValor();
        }
        str += "\t\t" + this.promedio+"\n";
        return str;
    
    }
    
    class Calificacion{
        private Calendar fecha;
        private float valor;
        private Unidad unidad;

        public Calificacion() {
        }
        

        public Calendar getFecha() {
            return fecha;
        }

        public void setFecha(Calendar fecha) {
            this.fecha = fecha;
        }

        public float getValor() {
            return valor;
        }

        public void setValor(float valor) {
            this.valor = valor;
        }

        public Unidad getUnidad() {
            return unidad;
        }

        public void setUnidad(Unidad unidad) {
            this.unidad = unidad;
        }
        
    
    }

}
    