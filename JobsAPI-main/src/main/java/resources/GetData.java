
package resources;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
//import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;



public class GetData {

    static final String BASE_URL = "https://www.indeed.com/jobs?q=computer%20science%20intern&start=90&vjk=1313f750f8f981be";

public static JsonObject scraper(){
  Document document = new Document(BASE_URL);
  Elements mainTableData = new Elements();

  JsonArray individualJobData = new JsonArray();//the 
  Gson gson = new GsonBuilder().create();
  JsonObject individualJsonObject = new JsonObject();
  JsonObject allJobs = new JsonObject();
  try {
    PrintStream outStream = new PrintStream(new File("outFile.txt"));
    System.setOut(outStream);
    
    //This is where the current web DOM is currently held
    document = Jsoup.connect(BASE_URL).get();
    mainTableData = document.select("div#mosaic-zone-jobcards");
    Elements individualJobs = mainTableData.select("a.tapItem");
    //System.out.println(mainTableData.size());

    for (int i = 0; i < individualJobs.size(); i++) {
     //for each, find 
     //Job title:  <h2 class="jobTitle jobTitle-color-purple"><span title="2022 Data Science Intern">2022 Data Science Intern</span></h2>
     Element element = individualJobs.get(i);
     String absoluteURL= element.absUrl("href");
     String jobTitle = element.select("h2.jobTitle").text();
     String location = element.select("div.companyLocation").text();
     String companyName  = element.select("span.companyName").text();
     String jobsnippet  = element.select("div.job-snippet").text();
     String days = element.select("span.date").text();
     Job job  = new Job(jobTitle, location, companyName, jobsnippet, days, absoluteURL);
     individualJobData.add(gson.toJsonTree(job));
     individualJsonObject.add("IndividualJobData", individualJobData);
    }
  } catch (IOException e) {
    e.printStackTrace();
   }

   allJobs.add("AllJobs", individualJsonObject);
   return allJobs;

   
}



}
