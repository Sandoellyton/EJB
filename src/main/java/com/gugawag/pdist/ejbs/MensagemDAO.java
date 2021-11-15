package com.gugawag.pdist.ejbs;

import com.gugawag.pdist.model.Mensagem;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MensagemDAO {

    @PersistenceContext(unitName="default")
    private EntityManager manager;
    
    public void inserir(Mensagem mensagem) {
        manager.persist(mensagem);
    }
    
    public List<Mensagem> listar() {
        return manager.createQuery("FROM Mensagem").getResultList();
    }
    
    public Mensagem pesquisarPorId(long id) {
        return manager.find(Mensagem.class, id);
    }
}
