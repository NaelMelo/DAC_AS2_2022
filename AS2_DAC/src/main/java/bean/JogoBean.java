package bean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;
import dao.JogoDao;
import entidade.Jogo;

@ManagedBean
public class JogoBean {
	
	private Jogo meuJogo = new Jogo();
	
	public Jogo getMeuJogo() {
		return meuJogo;
	}

	public void setMeuJogo(Jogo meuJogo) {
		this.meuJogo = meuJogo;
	}

	private List<Jogo> listar;
	
	public List<Jogo> getListar() {
		if (listar == null) {
			listar = JogoDao.listar();
		}	
		return listar;
	}

	public void setListar(List<Jogo> listar) {
		this.listar = listar;
	}

	public String salvar() {
		JogoDao.salvar(meuJogo);
		meuJogo = new Jogo();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "PRONTO", "O jogo foi salvo!"));
		return null;
	}
	
	public String editar() {
		JogoDao.editar(meuJogo);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "EDITADO", "A edicao foi realizada!"));
		return "listagem";
	}
	
	public String excluir() {
		JogoDao.excluir(meuJogo);
		listar.remove(meuJogo);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "DELETADO", "O jogo foi apagado :("));
		return null;
	}
	
	public String numPares() {
		List<Integer> j = JogoDao.numPares(meuJogo);
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atencao", "Os números pares são: " + j + ".");
		PrimeFaces.current().dialog().showMessageDynamic(mensagem);
		return null;
	}
}
