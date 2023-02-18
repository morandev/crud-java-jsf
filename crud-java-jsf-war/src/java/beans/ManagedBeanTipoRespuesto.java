package beans;

import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bc.TipoRespuestoFacadeLocal;
import be.TipoRespuesto;
import java.util.Date;

@ManagedBean
@SessionScoped
public class ManagedBeanTipoRespuesto implements Serializable {


    /*
     * CREAR to add a new record
     */
    private final int CREAR = 1;
    private final String CREAR_TEXT = "Crear";
    /*
     * ACTUALIZAR to edit a existing record
     */
    private final int ACTUALIZAR = 2;
    private final String ACTUALIZAR_TEXT = "Actualizar";
    /*
       ELIMINAR to delete a record
     */
    private final int ELIMINAR = 3;
    private final String ELIMINAR_TEXT = "Eliminar";
    /*
        alt + insert -> call enterprise bean
     */
    @EJB
    private TipoRespuestoFacadeLocal tipoRespuestoFacade;
    private TipoRespuesto _actualTipoRespuesto;
    private int tipoAccion;
    private String accionHeader;

    /**
     * CONSTRUCTOR
     */
    public ManagedBeanTipoRespuesto() {
        this._actualTipoRespuesto = new TipoRespuesto();
        this.tipoAccion = CREAR;
    }

    /*
        ****************JAVA METHODS****************
     */
    public int getTipo_accion() {
        return this.tipoAccion;
    }

    public void setTipo_accion(int tipo_accion) {
        this.tipoAccion = tipo_accion;
    }

    public TipoRespuesto getActualTipoRespuesto() {
        return _actualTipoRespuesto;
    }

    public void setActualTipoRespuesto(TipoRespuesto _tipoRespuesto) {
        this._actualTipoRespuesto = _tipoRespuesto;
    }

    public String getAccionHeader() {
        return accionHeader;
    }

    public void setAccionHeader(String accionHeader) {
        this.accionHeader = accionHeader;
    }        

    /**
     * FIND ALL
     *
     * @return COLLECTION OF TipoRespuesto
     */
    public Collection<TipoRespuesto> getAll() {
        return this.tipoRespuestoFacade.findAll();
    }

    /**
     * ACTIONS PROCESSOR
     */
    public void procesar() {

        if (this.tipoAccion == this.CREAR) {
            if(this._actualTipoRespuesto.getFechaRegistro() == null)
                this._actualTipoRespuesto.setFechaRegistro(new Date());
            this.tipoRespuestoFacade.create(_actualTipoRespuesto);
            return;
        }

        if (this.tipoAccion == this.ACTUALIZAR) {
            this.tipoRespuestoFacade.edit(_actualTipoRespuesto);
            return;
        }

        if (this.tipoAccion == this.ELIMINAR) {
            this.tipoRespuestoFacade.remove(_actualTipoRespuesto);
            return;
        }
    }

    /*
        ****************VIEW METHODS****************
     */
    public void updateActualAndAction(TipoRespuesto newActual, int action) {
        this.setActualTipoRespuesto(newActual);
        this.setTipo_accion(action);
    }

    /**
     * Reset this _actualTipoRespuesto to successfully package a new item data
     */
    public void resetActualItem() {
        this.setAccionHeader(CREAR_TEXT);
        this.updateActualAndAction(new TipoRespuesto(), CREAR);
    }

    /**
     * Set the current clicked item-row into this _actualTipoRespuesto to
     * perform a correct edit
     *
     * @param itm
     */
    public void setActualItem(TipoRespuesto itm) {
        this.setAccionHeader(ACTUALIZAR_TEXT);
        this.updateActualAndAction(itm, ACTUALIZAR);
    }

    /**
     * Set the current clicked item-row to perform a correct delete
     *
     * @param itm
     */
    public void setDeleteItem(TipoRespuesto itm) {
        this.setAccionHeader(ELIMINAR_TEXT);
        this.updateActualAndAction(itm, ELIMINAR);
    }

}
