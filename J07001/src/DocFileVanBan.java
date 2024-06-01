import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class DocFileVanBan {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("DATA.in");
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			br.close();
			isr.close();
			fis.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
