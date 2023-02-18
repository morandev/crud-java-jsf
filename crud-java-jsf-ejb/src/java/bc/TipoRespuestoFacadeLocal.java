package bc;

import be.TipoRespuesto;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TipoRespuestoFacadeLocal {

    void create(TipoRespuesto tipoRespuesto);

    void edit(TipoRespuesto tipoRespuesto);

    void remove(TipoRespuesto tipoRespuesto);

    TipoRespuesto find(Object id);

    List<TipoRespuesto> findAll();

    List<TipoRespuesto> findRange(int[] range);

    int count();
    
}
