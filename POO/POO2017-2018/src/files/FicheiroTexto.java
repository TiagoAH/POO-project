package files;

import objectos.Convivio;
import objectos.locais.AreaDesportiva;
import objectos.locais.Bar;
import objectos.locais.Exposicao;
import objectos.locais.Jardim;
import objectos.pessoas.Aluno;
import objectos.pessoas.Funcionario;
import objectos.pessoas.Professor;

import java.io.*;

public class FicheiroTexto {

    private static BufferedReader bufferedReader;

    public static Convivio read() {
        Convivio convivio = new Convivio();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("pessoas.txt"),"ISO-8859-1"));
            int pessoas = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < pessoas; i++) {
                switch (bufferedReader.readLine().toLowerCase()) {
                    case "aluno":
                        convivio.add(new Aluno(bufferedReader.readLine().split("-")));
                        break;

                    case "professor":
                        convivio.add(new Professor(bufferedReader.readLine().split("-")));
                        break;

                    case "funcionario":
                        convivio.add(new Funcionario(bufferedReader.readLine().split("-")));
                        break;
                }
            }

            bufferedReader.close();

            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("locais.txt"),"ISO-8859-1"));

            int locais = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < locais; i++) {
                switch (bufferedReader.readLine().toLowerCase()) {
                    case "area desportiva":
                        convivio.add(new AreaDesportiva(bufferedReader.readLine().split("-")));
                        break;

                    case "bar":
                        convivio.add(new Bar(bufferedReader.readLine().split("-")));
                        break;

                    case "exposicao":
                        convivio.add(new Exposicao(bufferedReader.readLine().split("-")));
                        break;

                    case "jardim":
                        convivio.add(new Jardim(bufferedReader.readLine().split("-")));
                        break;
                }
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convivio;
    }

    public static void readPercentagemGuest() {
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("config.txt"),"ISO-8859-1"));
            Bar.setPercentagemGest(Double.parseDouble(bufferedReader.readLine()));
            bufferedReader.close();
        } catch (Exception e) {
            Bar.setPercentagemGest(0.2);
            e.printStackTrace();
        }
    }
}
