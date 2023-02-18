package be;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "respuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Respuesto.findAll", query = "SELECT r FROM Respuesto r")
    , @NamedQuery(name = "Respuesto.findByPkId", query = "SELECT r FROM Respuesto r WHERE r.pkId = :pkId")
    , @NamedQuery(name = "Respuesto.findByNombre", query = "SELECT r FROM Respuesto r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Respuesto.findByDescripcion", query = "SELECT r FROM Respuesto r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Respuesto.findByFechaRegistro", query = "SELECT r FROM Respuesto r WHERE r.fechaRegistro = :fechaRegistro")})
public class Respuesto implements Serializable {

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
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "fk_tipo_respuesto", referencedColumnName = "pk_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoRespuesto tipoRespuesto;

    public Respuesto() {
    }

    public Respuesto(Integer pkId) {
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

    public TipoRespuesto getTipoRespuesto() {
        return tipoRespuesto;
    }

    public void setTipoRespuesto(TipoRespuesto tipoRespuesto) {
        this.tipoRespuesto = tipoRespuesto;
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
        if (!(object instanceof Respuesto)) {
            return false;
        }
        Respuesto other = (Respuesto) object;
        if ((this.pkId == null && other.pkId != null) || (this.pkId != null && !this.pkId.equals(other.pkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Respuesto[ pkId=" + pkId + " ]";
    }
    
}
