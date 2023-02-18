package be;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "tipo_respuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoRespuesto.findAll", query = "SELECT t FROM TipoRespuesto t")
    , @NamedQuery(name = "TipoRespuesto.findByPkId", query = "SELECT t FROM TipoRespuesto t WHERE t.pkId = :pkId")
    , @NamedQuery(name = "TipoRespuesto.findByNombre", query = "SELECT t FROM TipoRespuesto t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoRespuesto.findByDescripcion", query = "SELECT t FROM TipoRespuesto t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "TipoRespuesto.findByFechaRegistro", query = "SELECT t FROM TipoRespuesto t WHERE t.fechaRegistro = :fechaRegistro")})
public class TipoRespuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_id")
    private Integer pkId;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @OneToMany(mappedBy = "tipoRespuesto", fetch = FetchType.LAZY)
    private Collection<Respuesto> respuestoCollection;

    public TipoRespuesto() {
    }

    public TipoRespuesto(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @XmlTransient
    public Collection<Respuesto> getRespuestoCollection() {
        return respuestoCollection;
    }

    public void setRespuestoCollection(Collection<Respuesto> respuestoCollection) {
        this.respuestoCollection = respuestoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkId != null ? pkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoRespuesto)) {
            return false;
        }
        TipoRespuesto other = (TipoRespuesto) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoRespuesto[ pkId=" + pkId + " ]";
    }
    
}
