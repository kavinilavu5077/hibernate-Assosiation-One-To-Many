package com.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String args[]) {
		Transaction tr = null;
		try(Session ses=HBUtil.getSesFactory().openSession()){
			tr=ses.beginTransaction();
			Question q = new Question();
			q.setQuestion("What is your goal?");
			Question q1 = new Question();
			q1.setQuestion("Do you like the trainer?");
			Answer ans = new Answer();
			ans.setAnswername("HR is my goal");
			ans.setPostedBy("Kavinilavu");
			Answer ans1 = new Answer();
			ans1.setAnswername("Full Stack Developer is my goal");
			ans1.setPostedBy("Abi");
			Answer ans2=new Answer(1, "yes","Hema");
			Answer ans3= new Answer(2,"No","Krishna");
			
			List<Answer> li = new ArrayList<Answer>();
			li.add(ans1);
			li.add(ans);
			List<Answer> li1 = new ArrayList<Answer>();
			li1.add(ans2);
			li1.add(ans3);
			q.setAnswers(li);
			q1.setAnswers(li1);
			ses.merge(q);
			ses.merge(q1);
			tr.commit();
			ses.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
