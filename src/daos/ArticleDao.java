package daos;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Connection.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Article;

public class ArticleDao {

	ArrayList<Article> articles = new ArrayList<>();

	//récupérer une connexion à partir d'une url + id + pwd
	String url = "jdbc:mariadb://127.0.0.1:3306/shop";
	String login = "root";
	String password = "?Root!123@PmA";

	public List<Article> findAll () {

		List<Article> articles = new ArrayList<Article>();

		String allArticlefounded = "SELECT * FROM t_articles";

		try (Connection connection = DriverManager.getConnection(url, login, password)) {
			PreparedStatement prepareStatement = connection.prepareStatement(allArticlefounded);
			try(ResultSet resultSet = prepareStatement.executeQuery()){
				while(resultSet.next()) {
					articles.add(
							new Article(
									resultSet.getInt(1), 
									resultSet.getString(2), 
									resultSet.getString(3), 
									resultSet.getDouble(4)
									)
							);
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return articles;
	}

	public Article findById(int id) {

		Article article = null;

		String articleFindedById = "SELECT t_articles.IdArticle, t_articles.description, t_articles.brand, t_articles.unitaryPrice FROM t_articles WHERE t_articles.IdArticle = ?;";

		try(Connection connection = DriverManager.getConnection(url, login, password)){
			PreparedStatement prepareStatement = connection.prepareStatement(articleFindedById);

			prepareStatement.setInt(1, id);
			try(ResultSet resultSet = prepareStatement.executeQuery()){

				article = new Article(
						resultSet.getInt(1), 
						resultSet.getString(2), 
						resultSet.getString(3), 
						resultSet.getDouble(4)
						);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	public void createArticle (Article article) {


		String articleInsert = "INSERT INTO t_articles (Description, Brand, UnitaryPrice) VALUES (?, ?, ?);";

		try(Connection connection = DriverManager.getConnection(url, login, password)){
			PreparedStatement preparedStatement = connection.prepareStatement(articleInsert);

			preparedStatement.setString(1, article.getDescription());
			preparedStatement.setString(2, article.getBrand());
			preparedStatement.setDouble(3, article.getPrice());

			int row = preparedStatement.executeUpdate(articleInsert);		
			if(row == 1) {
				System.out.println("insertion OK");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateArticle (Article article) {
		String articleToUpdate = "UPDATE t_articles SET t_articles.Description = ?,"
				+ " t_articles.brand = ?, "
				+ "t_articles.UnitaryPrice = ? "
				+ "WHERE t_articles.IdArticle = ?;";

		try(Connection connection = DriverManager.getConnection(url, login, password)){
			PreparedStatement preparedStatement = connection.prepareStatement(articleToUpdate);
			
			preparedStatement.setString(1, article.getDescription());
			preparedStatement.setString(2, article.getBrand());
			preparedStatement.setDouble(3, article.getPrice());
			preparedStatement.setInt(4, article.getId());
			
			int row = preparedStatement.executeUpdate();		
			if(row == 1) {
				System.out.println("Mise à jour OK");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
