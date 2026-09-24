package tests;

import java.util.List;

import daos.ArticleDao;
import models.Article;

/** 
 * Test class for the ArticleDao CRUD operations. 
 */
public class TestsArticleDao {

	/** 
	 * Entry point of the test class. 
	 * Executes all ArticleDao tests in sequence: 
	 * create, find all, find by ID, update and delete.
	 * 
	 * @param args command-line arguments 
	 */
	public static void main(String[] args) {
	
		TestsArticleDao testsArticleDao = new TestsArticleDao();
		
		testsArticleDao.testCreateArticle();
		testsArticleDao.testFindAll();
		testsArticleDao.testFindById();
		testsArticleDao.testUpdateArticle();

	}
	
	/** 
	 * Tests the creation of a new article. 
	 * Creates an ArticleDao and an Article object, then calls 
	 * the createArticle() method to insert the article into the database. 
	 * The findById() method is then used to verify that the article 
	 * has been successfully inserted. 
	 */
	public void testCreateArticle() {
		
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article(99, "LaptopTest", "Test", 599.99);
		
		articleDao.createArticle(article);
		
		System.out.println(articleDao.findById(99)); 
		
	}
	
	/** 
	 * Tests the retrieval of all articles.  
	 * Calls the findAll() method to retrieve the articles from the database. 
	 * If the returned list is not null or empty, each article is displayed. 
	 * Otherwise, a message indicating that no article was found is displayed. 
	 */
	public void testFindAll() {
		
		ArticleDao articleDao = new ArticleDao();
		
		List<Article> articles = articleDao.findAll();
		
		if(articles != null && !articles.isEmpty()) {
			
			for (Article article : articles) {
				System.out.println(article);
			}
		}
		else {
			System.out.println("pas d'article trouvé");
		}	
	}

	/** 
	 * Tests the retrieval of an article by its ID. 
	 * Calls the findById() method with a specific ID and displays 
	 * the corresponding article. 
	 */	
	
	public void testFindById() {
		
		ArticleDao articleDao = new ArticleDao();
		int id = 7;
		
		Article article = articleDao.findById(id);
		System.out.println(article);
	}

	/** 
	 * Tests the update of an existing article. 
	 * Creates an Article object with modified information, then calls 
	 * the updateArticle() method to update the corresponding article 
	 * in the database. 
	 * The findById() method is then used to verify that the article 
	 * has been successfully updated. 
	 */
	public void testUpdateArticle() {
		
		ArticleDao articleDao = new ArticleDao();
		Article article = new Article(99, "LaptopTest2", "Test2", 599.99);
		
		articleDao.updateArticle(article);
		
		System.out.println(articleDao.findById(99)); 
	}

}
