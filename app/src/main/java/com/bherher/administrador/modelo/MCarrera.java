package com.bherher.administrador.modelo;

import java.io.Serializable;

public class MCarrera implements Serializable {
    private int idAsignatura;
    private String nombreCorto;
    private String nombreLargo;
    private String  clave;
    private int  idCarrera;

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

    public MCarrera() {
    }

    public MCarrera(int idAsignatura, String nombreCorto, String nombreLargo, String clave, int idCarrera, String apm, String app, String correo, String matricula, int idGrupo, int op, String edo, String muni, String col, String gen, String contrasenia) {
        this.idAsignatura = idAsignatura;
        this.nombreCorto = nombreCorto;
        this.nombreLargo = nombreLargo;
        this.clave = clave;
        this.idCarrera = idCarrera;
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

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
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

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "MCarrera{" +
                "idAsignatura=" + idAsignatura +
                ", nombreCorto='" + nombreCorto + '\'' +
                ", nombreLargo='" + nombreLargo + '\'' +
                ", clave='" + clave + '\'' +
                ", idCarrera=" + idCarrera +
                ", apm='" + apm + '\'' +
                ", app='" + app + '\'' +
                ", correo='" + correo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", idGrupo=" + idGrupo +
                ", op=" + op +
                ", edo='" + edo + '\'' +
                ", muni='" + muni + '\'' +
                ", col='" + col + '\'' +
                ", gen='" + gen + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }
}
