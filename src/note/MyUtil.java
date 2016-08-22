package note;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MyUtil {

	private MyUtil() {
		throw new AssertionError();
	}

	/**
	 * 文件拷贝方法1
	 * 
	 * @param source
	 * @param target
	 * @throws IOException
	 */
	public static void fileCopy(String source, String target) throws IOException {
		try (InputStream in = new FileInputStream(source)) {
			try (OutputStream out = new FileOutputStream(target)) {
				byte[] buffer = new byte[4096];
				int bytesToRead;
				while ((bytesToRead = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytesToRead);
				}
			}
		}
	}

	/**
	 * 文件拷贝方法2
	 * 
	 * @param source
	 * @param target
	 * @throws IOException
	 */
	public static void fileCopyNIO(String source, String target) throws IOException {
		try (FileInputStream in = new FileInputStream(source)) {
			try (FileOutputStream out = new FileOutputStream(target)) {
				FileChannel inChannel = in.getChannel();
				FileChannel outChannel = out.getChannel();
				ByteBuffer buffer = ByteBuffer.allocate(4096);
				while (inChannel.read(buffer) != -1) {
					buffer.flip();
					outChannel.write(buffer);
					buffer.clear();
				}
			}
		}
	}

	/**
	 * 统计给定文件中给定字符串的出现次数
	 * 
	 * @param filename
	 *            文件名
	 * @param word
	 *            字符串
	 * @return 字符串在文件中出现的次数
	 */
	public static int countWordInFile(String filename, String word) {
		int counter = 0;
		try (FileReader fr = new FileReader(filename)) {
			try (BufferedReader br = new BufferedReader(fr)) {
				String line = null;
				while ((line = br.readLine()) != null) {
					int index = -1;
					while (line.length() >= word.length() && (index = line.indexOf(word)) >= 0) {
						counter++;
						line = line.substring(index + word.length());
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return counter;
	}
}
