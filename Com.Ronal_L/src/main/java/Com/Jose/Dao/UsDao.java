package Com.Jose.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Com.Jose.Modelo.TbUsuariop;



public class UsDao {

public List<TbUsuariop> usuario(TbUsuariop us){
		
		List<TbUsuariop>listaus = new ArrayList();
		
		EntityManager em;
		EntityManagerFactory emf;
		emf= Persistence.createEntityManagerFactory("Com.Ronal_L");
		em=emf.createEntityManager();
		
		
		try {
			em.getTransaction().begin();
			listaus= em.createQuery("from TbUsuariop as u where u.usuario = '"+us.getUsuario()+"' and u.contrasenia='"+ us.getContrasenia()+"'").getResultList();
			em.getTransaction().commit();
			
for(TbUsuariop idDatos:listaus){
				
				us.setIdUsuarios(idDatos.getIdUsuarios());
				
				}
			
		} catch (Exception e) {
			System.out.println(e+"Error");
		}
		
		
		
		return listaus;
	}
}
