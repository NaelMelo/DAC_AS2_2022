package bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import dao.UsuarioDao;
import entidade.Usuario;

@ManagedBean
public class UsuarioBean {

	private Usuario meuUsuario = new Usuario();
	private UsuarioDao usuarioDao = new UsuarioDao();

	public Usuario getMeuUsuario() {
		return meuUsuario;
	}

	public void setMeuUsuario(Usuario meuUsuario) {
		this.meuUsuario = meuUsuario;
	}

	private List<Usuario> listar;

	public List<Usuario> getListar() {
		if (listar == null) {
			listar = UsuarioDao.listar();
		}
		return listar;
	}

	public void setListar(List<Usuario> listar) {
		this.listar = listar;
	}

	public String salvar() {
		UsuarioDao.salvar(meuUsuario);
		meuUsuario = new Usuario();
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "PRONTO", "O Usuario foi salvo!"));
		return null;
	}

	public String editar() {
		UsuarioDao.editar(meuUsuario);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "EDITADO", "A edicao foi realizada!"));
		return "listagemUsuario";
	}

	public String excluir() {
		UsuarioDao.excluir(meuUsuario);
		listar.remove(meuUsuario);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "DELETADO", "O Usuario foi apagado :("));
		return null;
	}

	public String envia() {
		meuUsuario = usuarioDao.getUsuario(meuUsuario.getUsuario(), meuUsuario.getSenha());
		if (meuUsuario == null) {
			meuUsuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Erro no Login!"));
			return null;
		} else {
			return "/opcoes";

		}

	}
}
