package com.app.service;

import com.model.Book;
import com.service.BookService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;



public class BookServiceTest {

    private static final Logger logger = LogManager.getLogger(BookServiceTest.class);
    private BookService bookService;

    @BeforeClass
    public static void beforeAll() {
        System.out.println("=== Starting BookService Tests ===");
    }

    @AfterClass
    public static void afterAll() {
        System.out.println("=== Finished BookService Tests ===");
    }

    @Before
    public void setUp() {
        bookService = new BookService();
        logger.info("Test setup completed");
    }

    @After
    public void tearDown() {
        bookService.clear();
        logger.info("Test cleanup completed");
    }

    // 1️⃣ addBook – positive
    @Test
    public void shouldAddBookSuccessfully() {
        logger.info("Starting addBook positive test");
        bookService.addBook(new Book(1, "Java", 500));
        assertEquals(1, bookService.count());
    }

    // 2️⃣ addBook – invalid price
    @Test
    public void shouldThrowExceptionForInvalidPrice() {
        logger.info("Starting addBook negative price test");
        try {
            bookService.addBook(new Book(2, "Spring", -100));
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    // 3️⃣ addBook – empty title
    @Test
    public void shouldThrowExceptionForEmptyTitle() {
        try {
            bookService.addBook(new Book(3, "", 300));
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    // 4️⃣ getBookById – valid
    @Test
    public void shouldReturnBookWhenIdExists() {
        bookService.addBook(new Book(4, "JUnit", 400));
        Book book = bookService.getBookById(4);
        assertNotNull(book);
        assertEquals("JUnit", book.getTitle());
    }

    // 5️⃣ getBookById – invalid
    @Test
    public void shouldThrowExceptionWhenBookNotFound() {
        try {
            bookService.getBookById(999);
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
    }

    // 6️⃣ updateBook – positive
    @Test
    public void shouldUpdateBookSuccessfully() {
        bookService.addBook(new Book(5, "Old", 200));
        bookService.updateBook(5, new Book(5, "New", 300));
        assertEquals("New", bookService.getBookById(5).getTitle());
    }

    // 7️⃣ updateBook – invalid data
    @Test
    public void shouldFailUpdateForInvalidData() {
        bookService.addBook(new Book(6, "Valid", 200));
        try {
            bookService.updateBook(6, new Book(6, "", -10));
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    // 8️⃣ deleteBook – positive
    @Test
    public void shouldDeleteBookSuccessfully() {
        bookService.addBook(new Book(7, "Delete Me", 150));
        bookService.deleteBook(7);
        assertEquals(0, bookService.count());
    }

    // 9️⃣ deleteBook – invalid
    @Test
    public void shouldThrowExceptionWhenDeletingNonExistingBook() {
        logger.error("Book not found for deletion");
        try {
            bookService.deleteBook(888);
            fail("Expected NoSuchElementException");
        } catch (NoSuchElementException e) {
            assertTrue(true);
        }
    }

    // 🔟 getAllBooks
    @Test
    public void shouldReturnAllBooks() {
        bookService.addBook(new Book(8, "Book1", 100));
        bookService.addBook(new Book(9, "Book2", 200));

        List<Book> books = bookService.getAllBooks();
        assertEquals(2, books.size());
    }
}
