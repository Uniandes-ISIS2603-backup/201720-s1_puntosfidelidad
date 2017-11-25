package co.edu.uniandes.csw.puntosfidelidad.ejb;

import co.edu.uniandes.csw.puntosfidelidad.entities.ComentarioEntity;
import co.edu.uniandes.csw.puntosfidelidad.persistence.ComentarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ja.manrique
 */
@Stateless
public class ComentarioLogic {
    @Inject
    private ComentarioPersistence persistence;
    
    /*
     * CRUD
     */
    
    public ComentarioEntity createComentario(ComentarioEntity nuevoEntity)
    {
        return persistence.create(nuevoEntity);
    }
    
    public ComentarioEntity getComentario(Long id)
    {
        ComentarioEntity cmnt = persistence.findWithId(id);
        cmnt.setFotos(persistence.getFotos(id));
        return cmnt;
    }
    
    public List<ComentarioEntity> getComentarios()
    {
        return persistence.findAll();
    }
    public void deleteComentario(Long id)   
    {
        persistence.delete(id);
    }
    public ComentarioEntity updateComentario(ComentarioEntity nuevoEntity)
    {
        return persistence.update(nuevoEntity);
    }
}
