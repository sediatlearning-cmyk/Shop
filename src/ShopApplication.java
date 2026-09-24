import tests.TestsArticleDao;

public class ShopApplication {

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
		testsArticleDao.testDeleteArticle();

	}
}
