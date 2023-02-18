package bc;

import be.Respuesto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RespuestoFacade extends AbstractFacade<Respuesto> implements RespuestoFacadeLocal {

    @PersistenceContext(unitName = "crud-java-jsf-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RespuestoFacade() {
        super(Respuesto.class);
    }
    
}
