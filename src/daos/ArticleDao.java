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
}