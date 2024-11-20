package com.bherher.administrador.modelo;

import java.io.Serializable;

public class MDocente implements Serializable {
    private String nombre;
    private String carrera;
    private String periodo;

    private int idAsignatura;
    private String nombreCorto;
    private String nombreLargo;
    private String  clave;
    private int  idDocente;

    private String apm;
    private String app;
    private String correo;
    private String matricula;
    private int idGrupo;
    private int op;
    private String edo;
    private String muni;
    private String col;
    private String gen;
    private String contrasenia;

    public MDocente() {
    }

    public MDocente(int idAsignatura,String nombre, String periodo, String carrera, String nombreCorto, String nombreLargo, String clave, int idDocente, String apm, String app, String correo, String matricula, int idGrupo, int op, String edo, String muni, String col, String gen, String contrasenia) {
        this.idAsignatura = idAsignatura;
        this.nombreCorto = nombreCorto;
        this.carrera = carrera;
        this.nombreLargo = nombreLargo;
        this.periodo = periodo;
        this.nombre = nombre;
        this.clave = clave;
        this.idDocente = idDocente;
        this.apm = apm;
        this.app = app;
        this.correo = correo;
        this.matricula = matricula;
        this.idGrupo = idGrupo;
        this.op = op;
        this.edo = edo;
        this.muni = muni;

        this.col = col;
        this.gen = gen;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }

    public String getNombreLargo() {
        return nombreLargo;
    }

    public void setNombreLargo(String nombreLargo) {
        this.nombreLargo = nombreLargo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getApm() {
        return apm;
    }

    public void setApm(String apm) {
        this.apm = apm;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public String getEdo() {
        return edo;
    }

    public void setEdo(String edo) {
        this.edo = edo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMuni() {
        return muni;
    }

    public void setMuni(String muni) {
        this.muni = muni;
    }

    public String getCol() {
        return col;
    }

    public void setCol(String col) {
        this.col = col;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "MDocente{" +
                "idAsignatura=" + idAsignatura +
                ", nombreCorto='" + nombreCorto + '\'' +
                ", nombreLargo='" + nombreLargo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", clave='" + clave + '\'' +
                ", idDocente=" + idDocente +
                ", apm='" + apm + '\'' +
                ", carrera='" + carrera + '\'' +
                ", app='" + app + '\'' +
                ", correo='" + correo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", idGrupo=" + idGrupo +
                ", op=" + op +
                ", edo='" + edo + '\'' +
                ", periodo='" + periodo + '\'' +
                ", muni='" + muni + '\'' +
                ", col='" + col + '\'' +
                ", gen='" + gen + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }
}
