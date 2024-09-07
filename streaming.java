package midia;

public class Audio {
    private String titulo;
    private int totalReproducoes;
    private int totalCurtidas;
    private int classificacao;

    public Audio(String titulo) {
        this.titulo = titulo;
        this.totalReproducoes = 0;
        this.totalCurtidas = 0;
        this.classificacao = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTotalReproducoes() {
        return totalReproducoes;
    }

    public int getTotalCurtidas() {
        return totalCurtidas;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public void curte() {
        totalCurtidas++;
    }

    public void reproduz() {
        totalReproducoes++;
    }

    public int getClassificacaoAudio() {
        return classificacao;
    }
}

package midia;

public class Musica extends Audio {
    private String album;
    private String cantor;
    private String genero;

    public Musica(String titulo, String album, String cantor, String genero) {
        super(titulo);
        this.album = album;
        this.cantor = cantor;
        this.genero = genero;
    }

    @Override
    public int getClassificacaoAudio() {
        if (getTotalReproducoes() > 2000) {
            setClassificacao(10);
        } else {
            setClassificacao(8);
        }
        return getClassificacao();
    }
}

package midia;

public class Podcast extends Audio {
    private String apresentador;
    private String descricao;

    public Podcast(String titulo, String apresentador, String descricao) {
        super(titulo);
        this.apresentador = apresentador;
        this.descricao = descricao;
    }

    @Override
    public int getClassificacaoAudio() {
        if (getTotalCurtidas() > 500) {
            setClassificacao(10);
        } else {
            setClassificacao(7);
        }
        return getClassificacao();
    }
}

package midia;

public class Preferencias {
    
    public void inclui(Audio audio) {
        int classificacao = audio.getClassificacaoAudio();
        if (classificacao >= 9) {
            System.out.println(audio.getTitulo() + " é considerado sucesso absoluto e um dos títulos preferidos da galera!");
        } else {
            System.out.println(audio.getTitulo() + " está ganhando popularidade, continue curtindo!");
        }
    }
}

package midia;

public class Principal {
    public static void main(String[] args) {
        Musica musica1 = new Musica("Forever", "Album X", "Artista Y", "Pop");
        Podcast podcast1 = new Podcast("BolhaDev", "João Silva", "Discussões sobre tecnologia");

        for (int i = 0; i < 2500; i++) {
            musica1.reproduz();
            if (i % 2 == 0) {
                musica1.curte();
            }
        }

        for (int i = 0; i < 600; i++) {
            podcast1.reproduz();
            if (i % 3 == 0) {
                podcast1.curte();
            }
        }

        Preferencias preferencias = new Preferencias();
        preferencias.inclui(musica1);
        preferencias.inclui(podcast1);
    }
}
