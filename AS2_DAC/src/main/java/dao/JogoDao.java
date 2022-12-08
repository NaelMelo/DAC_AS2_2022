package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import entidade.Jogo;
import util.JPAUtil;

public class JogoDao {
	
	public static void salvar(Jogo meuJogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(meuJogo);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Jogo meuJogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(meuJogo);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void excluir(Jogo meuJogo) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		meuJogo = em.find(Jogo.class,meuJogo.getId());
		em.remove(meuJogo);
		em.getTransaction().commit();
		em.close();
	}
	
	public static List<Jogo> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query query = em.createQuery("select meuJogo from Jogo meuJogo");
		List<Jogo> meuJogo = query.getResultList();
		em.close();
		return meuJogo;
	}
	
	public static List<Integer> numPares(Jogo meuJogo){
		EntityManager em = JPAUtil.criarEntityManager();
		TypedQuery<Jogo> query = em.createQuery("from Jogo meuJogo where meuJogo.id = :id", Jogo.class).setParameter("id", meuJogo.getId());
		List<Integer> par = query.getSingleResult().pares();
		em.close();
		return par;
	}
	
}
