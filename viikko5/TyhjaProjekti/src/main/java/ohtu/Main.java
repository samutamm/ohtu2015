package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    public static void main(String[] args) throws IOException {
        String studentNr = "013976176";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats-2015.herokuapp.com/students/"+studentNr+"/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        int totalTasks = 0;
        int totalHours = 0;
        System.out.println("Oliot:");
        for (Submission submission : subs) {
            final int tasks = countTasks(submission);
            final String hours = submission.getHours();
            System.out.println("viikko " + submission.getWeek() + ": tehtyjä tehtäviä yhteensä: " + tasks);
            System.out.println("  Aikaa kului: " + hours + ", tehdyt tehtävät: " + doneTasksAsString(submission));
            totalTasks += tasks;
            totalHours += Integer.parseInt(hours);
        }
        System.out.println("yhtensä: " + totalTasks + " tehtävää " + totalHours + " tuntia");

    }
    
    private static List<String> tasksDone(Submission sub) {
        ArrayList<String> tasks = new ArrayList<String>();
        for (int i = 1; i <= 21; i++) {
            try {
                String methodName = "isA" + i;
                Class<?> c = Submission.class;
                Method method = c.getDeclaredMethod(methodName);
                boolean ret = (Boolean)method.invoke(sub);
                if (ret) {
                    tasks.add(""+i);
                }
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return tasks;
    }
    
    private static int countTasks(Submission sub) {
        return tasksDone(sub).size();
    }
    
    private static String doneTasksAsString(Submission sub) {
        String ret = "";
        for (String s : tasksDone(sub)) {
            ret += " " + s;
        }
        return ret;
    }
}