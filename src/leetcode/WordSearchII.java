package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

	/**
	 * HashMap
	 * 
	 * @param board
	 * @param words
	 * @return
	 */
	public static List<String> findWords1(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		if (board == null || board.length == 0 || words == null || words.length == 0) {
			return null;
		}
		Set<String> dict = new HashSet<String>(Arrays.asList(words));
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(dict, board, visited, i, j, new StringBuffer(), res);
			}
		}
		return res;
	}

	private static void dfs(Set<String> dict, char[][] board, boolean[][] visited, int i, int j, StringBuffer sb,
			List<String> res) {
		if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j] == true) {
			return;
		}
		sb.append(board[i][j]);
		visited[i][j] = true;
		if (dict.contains(sb.toString())) {
			res.add(sb.toString());
		}
		dfs(dict, board, visited, i - 1, j, sb, res);
		dfs(dict, board, visited, i + 1, j, sb, res);
		dfs(dict, board, visited, i, j - 1, sb, res);
		dfs(dict, board, visited, i, j + 1, sb, res);

		// 恢复原样
		sb.deleteCharAt(sb.length() - 1);
		visited[i][j] = false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };
		List<String> res = new ArrayList<String>();
		res = findWords1(board, words);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
	}
}
