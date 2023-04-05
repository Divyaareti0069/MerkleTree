import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5FileHash {

	public static String generateHashFile(String filePath) {
		String checksum = null;
		try (InputStream is = new FileInputStream(filePath)) {
			checksum = DigestUtils.md5Hex(is);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return checksum;
	}
	
	public static String generateHashText(String text) {
		String checksum = null;
		try  {
			checksum = DigestUtils.md5Hex(text);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return checksum;
	}

}
