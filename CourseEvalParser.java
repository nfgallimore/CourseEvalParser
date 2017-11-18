import java.io;
import com.google.gson.Gson;

public class CourseEvalParser
{
	public static void main(String args[]) {
		String command = "curl -o courses.json http://www.uakron.edu/academics_majors/class-search/data/courses.json";
		try {
			Process p = Runtime.getRuntime().exec(command);
		}
		catch (Exception e) {

		}
		File file = new File("courses.json");
		Gson gson = new Gson();


	}
}