package br.com.sulimann.composite;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CompositeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompositeApplication.class, args);
	}

	@Bean
	CommandLineRunner run() {
		return args -> {
			// Criar estrutura de arquivos
			Directory root = new Directory("root");

			Directory docs = new Directory("docs");
			docs.addComponent(new File("resume.pdf", 1024));
			docs.addComponent(new File("cover_letter.docx", 2048));

			Directory images = new Directory("images");
			images.addComponent(new File("vacation.jpg", 5120));
			images.addComponent(new File("family.png", 3072));

			Directory work = new Directory("work");
			work.addComponent(new File("project.xlsx", 4096));

			// Adicionar subdiretórios ao diretório raiz
			root.addComponent(docs);
			root.addComponent(images);
			root.addComponent(work);

			// Adicionar um arquivo diretamente na raiz
			root.addComponent(new File("notes.txt", 512));

			// Imprimir toda a estrutura
			root.print("");

			// Obter tamanho total do sistema de arquivos
			System.out.println("\nTamanho total do sistema de arquivos: " + root.getSize() + " bytes");

			// Obter tamanho de um único subdiretório
			System.out.println("Tamanho do diretório 'images': " + images.getSize() + " bytes");
		};
	}

}
