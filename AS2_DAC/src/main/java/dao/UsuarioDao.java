package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import entidade.Usuario;
import util.JPAUtil;

public class UsuarioDao {

	public Usuario getUsuario(String nomeUsuario, String senha) {
		EntityManager em = JPAUtil.criarEntityManager();
		try {
			Usuario usuario = (Usuario) em
					.createQuery("SELECT u from Usuario u where u.usuario = :name and u.senha = :senha")
					.setParameter("name", nomeUsuario).setParameter("senha", senha).getSingleResult();
			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}

	public static void salvar(Usuario meuUsuario) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(meuUsuario);
		em.getTransaction().commit();
		em.close();
	}

	public static void editar(Usuario meuUsuario) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.merge(meuUsuario);
		em.getTransaction().commit();
		em.close();
	}

	public static void excluir(Usuario meuUsuario) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		meuUsuario = em.find(Usuario.class, meuUsuario.getId());
		em.remove(meuUsuario);
		em.getTransaction().commit();
		em.close();
	}

	public static List<Usuario> listar() {
		EntityManager em = JPAUtil.criarEntityManager();
		Query query = em.createQuery("select meuUsuario from Usuario meuUsuario");
		List<Usuario> meuUsuario = query.getResultList();
		em.close();
		return meuUsuario;
	}
}
