package calabreso.corp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);

				// Criando um HashMap
				Map<String, Integer> idadePorNome = new HashMap<>();

				// Adicionando pares chave-valor
				idadePorNome.put("João", 30);
				idadePorNome.put("Maria", 25);
				idadePorNome.put("Pedro", 35);


				// Obtendo o valor associado a uma chave
				System.out.println("Idade do João: " + idadePorNome.get("Maria") + "NOME: "+ idadePorNome.containsValue(true));

				// Iterando sobre as entradas do Map
				for (Map.Entry<String, Integer> entry : idadePorNome.entrySet()) {
					System.out.println(entry.getKey() + " tem " + entry.getValue() + " anos.");
				}
			}
		}


