package beans;

import java.io.Serializable;
import java.util.Collection;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bc.TipoRespuestoFacadeLocal;
import be.TipoRespuesto;

@ManagedBean
@SessionScoped
public class ManagedBeanTipoRespuesto implements Serializable {

    /*
        alt + insert -> call enterprise bean
    */
    @EJB
    private TipoRespuestoFacadeLocal tipoRespuestoFacade;
    
    public ManagedBeanTipoRespuesto() {
    }
    
    /**
     * Busca todos los registros de TipoRespuesto
     * 
     * @return 
     */
    public Collection<TipoRespuesto> getAll() {
        return this.tipoRespuestoFacade.findAll();
    }
    
}
