import java.io.*;
import com.google.gson.*;
import java.util.*;
public class CourseEvalParser
{
	public static void main(String args[]) {

		// uses curl to get the json from the api
		String command = "curl -o courses.json http://www.uakron.edu/academics_majors/class-search/data/courses.json";
		try {
			Process p = Runtime.getRuntime().exec(command);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		// reads the file into a string called json
		String json = null;
		try {
			FileReader fileReader = new FileReader("courses.json");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			json = bufferedReader.readLine();
			bufferedReader.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		Response response = gson.fromJson(json, Response.class);
		String name = response.getDescriptor().get("3000:501:001:4177").getId();

	}
}
class Response {
    Map<String, Course> descriptor;
    // standard getters & setters...
}
class Course
{
	public String Id;
	public String End_Date;
	public String Term;
	public String Description;
	public String Prerequisite;
	public String Title;
	public String Career;
	public String Section;
	public String Days;
	public String End_Time;
	public String Location;
	public String Department;
	public String Instructor_Email;
	public String Start_Date;
	public String Instructor;
	public String Instruction_Mode;
	public String Campus;

	public String getId() {
		return Id;
	}
}