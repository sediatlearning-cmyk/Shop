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
		testsArticleDao.testDeleteArticle();

	}
	
	