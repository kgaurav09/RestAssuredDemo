import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		
		JsonPath js= new JsonPath(Payload.CoursePrice());
		
		//1. Print No of courses returned by API
		
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		//Print Purchase Amount
		
		int purchaseTotalAmount=js.getInt("dashboard.purchaseAmount");
		
		System.out.println(purchaseTotalAmount);
		
		//3. Print Title of the first course
		
		String firstCourseTitle=js.get("courses[0].title");
		
		System.out.println(firstCourseTitle);
		
		String secondCourseTitle=js.get("courses[1].title");
		System.out.println(secondCourseTitle);
		
		
		String thirdCourseTitle=js.get("courses[2].title");
		System.out.println(thirdCourseTitle);
		
		//Print All course titles and their respective Prices
		
		
		for(int i=0;i<count;i++)
		{
			String courseTitles=js.getString("courses["+i+"].title");
			System.out.println(courseTitles);
			
			int CoursePrice=js.getInt("courses["+i+"].price");
			System.out.println(CoursePrice);
		}
		
		//5. Print no of copies sold by RPA Course
		for(int i=0;i<count;i++)
		{
			String courseTitles=js.getString("courses["+i+"].title");
			if(courseTitles.equalsIgnoreCase("RPA")) 
			{
				int noOfCoursesSold=js.getInt("courses["+i+"].copies");
				System.out.println(noOfCoursesSold +" RPA courses sold");
				
				break;
			}
		}
		
		
		
		//Verify if Sum of all Course prices matches with Purchase Amount
		
		
		
		
	}
	
	

}
