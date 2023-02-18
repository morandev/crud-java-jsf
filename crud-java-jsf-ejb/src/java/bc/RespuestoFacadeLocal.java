package bc;

import be.Respuesto;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RespuestoFacadeLocal {

    void create(Respuesto respuesto);

    void edit(Respuesto respuesto);

    void remove(Respuesto respuesto);

    Respuesto find(Object id);

    List<Respuesto> findAll();

    List<Respuesto> findRange(int[] range);

    int count();
    
}
