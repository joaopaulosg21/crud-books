package aprendendo.api.crudbooks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import aprendendo.api.crudbooks.model.Book;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CrudBooksApplicationTests {

	@Autowired
	private WebTestClient webClient;

	@Test
	public void createBookTest() {
		Book book = new Book("test title","test author","test description");

		webClient.post()
				.uri("/books/")
				.bodyValue(book)
				.exchange()
				.expectStatus().isCreated();
	}

	@Test
	public void findAllBooksTest() {

		webClient.get()
				.uri("/books/")
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$[0].title").isEqualTo("test title")
				.jsonPath("$[0].author").isEqualTo("test author")
				.jsonPath("$[0].description").isEqualTo("test description");
	}

	@Test
	public void updateBookTest() {
		Book book = new Book("updated title","updated author","updated description");

		Book expected = new Book(8L,"updated title","updated author","updated description");

		webClient.patch()
				.uri("/books/8")
				.bodyValue(book)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.toString().equals(expected.toString());
	}
}
