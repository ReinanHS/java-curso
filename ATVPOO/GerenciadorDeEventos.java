package CadastroEventos;

import java.util.Arrays;

public class GerenciadorDeEventos {
	private Participantes Participantes[];
	private Evento Eventos[];
	private Recurso Recursos[];

	public GerenciadorDeEventos() {
	}

	public boolean cadastroDePartipantes(Participantes participante) {
		try {

			Participantes participantes[] = new Participantes[this.Participantes.length + 1];

			for (int i = 0; i < this.Participantes.length; i++) {
				participantes[i] = this.Participantes[i];
			}

			participantes[this.Participantes.length] = participante;
			this.Participantes = participantes;
			return true;

		} catch (NullPointerException exe) {
			Participantes participantes[] = new Participantes[1];
			participantes[0] = participante;

			this.Participantes = participantes;
			return true;
		}
	}

	public String listarParticipantesToString() {

		String print = "";

		try {
			for (Participantes y : this.Participantes) {
				print += "Matricula: [" + y.getMatricula() + "]\n";
				print += "Nome: [" + y.getNome() + "]\n";
				print += "Curso: [" + y.getCurso() + "]\n";
				print += "Instituição: [" + y.getInstituicao() + "]\n\n";
			}
		} catch (NullPointerException exe) {
			print = "Não existe nenhum participante";
		}
		return print;
	}
	
	public boolean removerParticipante(Participantes participante) {

		try {
			if (this.Participantes.length > 0) {
				Participantes participantes[] = new Participantes[this.Participantes.length - 1];
				int qtd = 0;
				for (Participantes x : this.Participantes) {
					if (!x.equals(participante)) {
						participantes[qtd] = x;
						qtd++;
					}
				}
				this.Participantes = participantes;
				return true;
			}
			return false;
		} catch (NullPointerException exe) {
			return false;
		}
	}

	public boolean cadastroDeRecursos(Recurso recurso) {
		try {

			Recurso recursos[] = new Recurso[this.Recursos.length + 1];
			for (int i = 0; i < this.Recursos.length; i++) {
				recursos[i] = this.Recursos[i];
			}
			recursos[this.Recursos.length] = recurso;
			this.Recursos = recursos;
			return true;
		} catch (NullPointerException exe) {
			Recurso recursos[] = new Recurso[1];
			recursos[0] = recurso;
			this.Recursos = recursos;
			return true;
		}
	}

	public boolean removerRecurso(Recurso recurso) {

		try {
			if (this.Recursos.length > 0) {
				Recurso recursos[] = new Recurso[this.Recursos.length - 1];
				int qtd = 0;
				for (Recurso x : this.Recursos) {
					if (!x.equals(recurso)) {
						recursos[qtd] = x;
						qtd++;
					}
				}
				this.Recursos = recursos;
				return true;
			}
			return false;
		} catch (NullPointerException exe) {
			return false;
		}
	}

	public String listarRecurosToString() {

		String print = "";

		try {
			for (Recurso y : this.Recursos) {
				print += "Código: [" + y.getCodigo() + "]\n";
				print += "Nome: [" + y.getNome() + "]\n";
				print += "Descrição do recurso: [" + y.getDescricao() + "]\n";
				print += "Quantidade disponível: [" + y.getQuantitativo() + "]\n\n";
			}
		} catch (NullPointerException exe) {
			print = "Não tem Recusos";
		}
		return print;
	}

	public boolean cadastroDeEventos(Evento evento) {
		try {

			Evento eventos[] = new Evento[this.Eventos.length + 1];

			for (int i = 0; i < this.Eventos.length; i++) {
				eventos[i] = this.Eventos[i];
			}

			eventos[this.Eventos.length] = evento;
			this.Eventos = eventos;
			return true;

		} catch (NullPointerException exe) {
			Evento eventos[] = new Evento[1];
			eventos[0] = evento;

			this.Eventos = eventos;
			return true;
		}
	}

	public boolean removerEventos(Evento evento) {

		try {

			if (this.Eventos.length > 0) {
				Evento eventos[] = new Evento[this.Eventos.length - 1];
				int qtd = 0;

				for (Evento x : this.Eventos) {
					if (!x.equals(evento)) {
						eventos[qtd] = x;
						qtd++;
					}
				}

				this.Eventos = eventos;
				return true;
			}
			return false;
		} catch (NullPointerException exe) {
			return false;
		}
	}

	public Palestra[] listarPalestrar() {

		Palestra palestras[] = new Palestra[this.getTamanhoPalestra()];
		int qtdPalestras = 0;

		try {
			for (Evento y : this.Eventos) {
				if (y instanceof Palestra) {
					palestras[qtdPalestras] = (Palestra) y;
					qtdPalestras++;
				}
			}
			return palestras;
		} catch (NullPointerException exe) {
			return null;
		}
	}

	public String listarPalestrarToString() {

		Palestra palestras[] = new Palestra[this.getTamanhoPalestra()];
		String print = "";

		try {
			for (Evento y : this.Eventos) {
				if (y instanceof Palestra) {

					Palestra u = ((Palestra) y);

					print += "Palestrante: [" + u.getPalestrante() + "]\n";
					print += "Publico Alvo: [" + u.getPublicoAlvo() + "]\n";
					print += "Metodologia: [" + u.getMetodologia() + "]\n";
					print += "Recursos: [" + u.recursosToString() + "]\n\n";
				}
			}
		} catch (NullPointerException exe) {
			print = "Não tem palestra no vetor";
		}

		return print;
	}

	public Minicurso[] listarMinicursos() {

		Minicurso minicursos[] = new Minicurso[this.getTamanhoMinicurso()];
		int qtdPalestras = 0;

		try {
			for (Evento y : this.Eventos) {
				if (y instanceof Minicurso) {
					minicursos[qtdPalestras] = (Minicurso) y;
					qtdPalestras++;
				}
			}
			return minicursos;
		} catch (NullPointerException exe) {
			return null;
		}
	}

	protected int getTamanhoPalestra() {

		int qtdTotal = 0;

		try {
			for (Evento x : this.Eventos) {
				if (x instanceof Palestra) {
					qtdTotal++;
				}
			}
		} catch (NullPointerException exe) {
			return 0;
		}
		return qtdTotal;
	}

	public String listarMinicursosToString() {

		Minicurso minicursos[] = new Minicurso[this.getTamanhoMinicurso()];
		String print = "";

		try {
			for (Evento y : this.Eventos) {
				if (y instanceof Minicurso) {

					Minicurso u = ((Minicurso) y);

					print += "Ministrantes: [" + u.ministrantesToString() + "]\n";
					print += "Publico Alvo: [" + u.getPublicoAlvo() + "]\n";
					print += "Metodologia: [" + u.getMetodologia() + "]\n";
					print += "Recursos: [" + u.recursosToString() + "]\n\n";
				}
			}
		} catch (NullPointerException ex) {
			print = "Não existem minicursos";
		}

		return print;
	}

	public String listarEventosToString() {

		String print = "";

		try {
			for (Evento y : this.Eventos) {
				print += "Titulo: [" + y.getTitulo() + "]\n";
				print += "Resumo: [" + y.getResumo() + "]\n";
				print += "Recursos: [" + y.recursosToString() + "]\n";
				if (y instanceof Palestra) {
					print += "Tipo: [Palestra]\n";
				} else if (y instanceof Minicurso) {
					print += "Tipo: [Minicurso]\n";
				} else {
					print += "Tipo: [Evento]\n";
				}
			}
		} catch (NullPointerException ex) {
			print = "Não foi cadastrado";
		}

		return print;
	}

	public Evento[] listarEventos() {
		return this.Eventos;
	}

	protected int getTamanhoMinicurso() {

		int qtdTotal = 0;

		for (Evento x : this.Eventos) {
			if (x instanceof Minicurso) {
				qtdTotal++;
			}
		}
		return qtdTotal;
	}

	public Participantes[] getParticipantes() {
		return Participantes;
	}

	public void setParticipantes(Participantes[] participantes) {
		Participantes = participantes;
	}

	public Evento[] getEventos() {
		return Eventos;
	}

	public void setEventos(Evento[] eventos) {
		Eventos = eventos;
	}

	public Recurso[] getRecursos() {
		return Recursos;
	}

	public void setRecursos(Recurso[] recursos) {
		Recursos = recursos;
	}
}
