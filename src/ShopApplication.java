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
		
		System.out.println("Creation d'un article");
		testsArticleDao.testCreateArticle();
		
		System.out.println("Liste de tous les articles");
		testsArticleDao.testFindAll();
		
		System.out.println("Recherche d'un article par son id");
		testsArticleDao.testFindById();
		
		System.out.println("Modification d'un article");
		testsArticleDao.testUpdateArticle();
		
		System.out.println("Suppression d'un article");
		testsArticleDao.testDeleteArticle();
		
	}
}
