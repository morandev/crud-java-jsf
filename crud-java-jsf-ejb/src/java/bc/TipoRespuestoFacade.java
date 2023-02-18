package bc;

import be.TipoRespuesto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TipoRespuestoFacade extends AbstractFacade<TipoRespuesto> implements TipoRespuestoFacadeLocal {

    @PersistenceContext(unitName = "crud-java-jsf-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoRespuestoFacade() {
        super(TipoRespuesto.class);
    }
    
}
