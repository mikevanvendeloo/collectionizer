package net.vanvendeloo.collections;

import net.vanvendeloo.collections.authentication.Account;
import net.vanvendeloo.collections.authentication.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CollectionizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollectionizerApplication.class, args);
	}


    @Bean
    CommandLineRunner init(final AccountRepository accountRepository) {

        return new CommandLineRunner() {

            @Override
            public void run(String... arg0) throws Exception {
                accountRepository.save(new Account("mike", "geheim"));

            }

        };
    }
}
