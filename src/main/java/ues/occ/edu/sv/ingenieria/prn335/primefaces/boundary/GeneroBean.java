/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.primefaces.boundary;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import ues.occ.edu.sv.ingenieria.prn335.cineData.entity.Genero;
import ues.occ.edu.sv.ingenieria.prn335.primefaces.controller.AbstractFacade;
import ues.occ.edu.sv.ingenieria.prn335.primefaces.controller.GeneroFacade;

/**
 *
 * @author melvin
 */
@Named(value = "generoBean")
@ViewScoped
public class GeneroBean extends BackingBean<Genero> implements Serializable{
    
    @Inject
    private GeneroFacade Generofacade;
    private Genero genero;
    private List<Genero> generoList;
    String mensaje="";


    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Genero> getGeneroList() {
        return generoList;
    }

    public void setGeneroList(List<Genero> generoList) {
        this.generoList = generoList;
    }
    
    @PostConstruct
    @Override
    public void iniciar() {
        super.iniciar(); //To change body of generated methods, choose Tools | Templates.
        iniciarRelaciones();
        
    }
    
    public void iniciarRelaciones(){
        if(Generofacade !=null){
            generoList=Generofacade.findAll();
        }
    }
    
    

    @Override
    public Object clavePorDatos(Genero object) {
        if (object != null) {
                    return object.getIdGenero();
                }
                return null;
    }

 

    @Override
    public Genero datosPorClave(String rowKey) {
        if (rowKey != null && !rowKey.isEmpty()) {
            try {
                Integer search = new Integer(rowKey);
                for (Genero tu : this.List) {
                    if (tu.getIdGenero().compareTo(search) == 0) {
                        return tu;
                    }
                }
            } catch (NumberFormatException e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
            }
        }
        return null;
    }

    @Override
    protected AbstractFacade<Genero> getFacade() {
        return Generofacade;
    }

    @Override
    public LazyDataModel<Genero> getModelo() {
        return super.getModelo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Genero getRegistro() {
        if (this.registro == null) {
            this.registro = new Genero();
        }
        return super.getRegistro(); //To change body of generated methods, choose Tools | Templates.
    }

   


  
    
    
    
    
    
}
