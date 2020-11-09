package com.sbs.example.easytextboard.dao;

import java.util.ArrayList;
import java.util.List;

import com.sbs.example.easytextboard.dto.Article;
import com.sbs.example.easytextboard.dto.Board;

public class ArticleDao {
	private List<Article> articles;
	private int lastId;
	private int lastBoardId;
	private List<Board> boards;

	public ArticleDao() {
		articles = new ArrayList<>();
		lastId = 0;

		boards = new ArrayList<>();
		lastBoardId = 0;
	}

	public int write(int boardId, int memberId, String title, String body) {
		Article article = new Article();
		article.id = lastId + 1;
		article.boardId = boardId;
		article.memberId = memberId;
		article.title = title;
		article.body = body;
		articles.add(article);

		lastId = article.id;

		return article.id;
	}

	public List<Article> getForPrintArticles() {
		return articles;
	}

	public int makeBoard(String name) {
		Board board = new Board();
		board.id = lastBoardId + 1;
		board.name = name;
		boards.add(board);

		lastBoardId = board.id;

		return board.id;

	}

	public Board getBoardById(int boardId) {
		for ( Board board : boards ) {
			if ( board.id == boardId ) {
				return board;
			}
		}
		
		return null;
	}

	public List<Board> getBoards() {
		return boards;
	}

}
