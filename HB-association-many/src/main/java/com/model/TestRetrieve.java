package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
public class TestRetrieve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction tr= null;
		try(Session ses=HBUtil.getSesFactory().openSession()){
			tr = ses.beginTransaction();
			Query<Question> qu= ses.createQuery("from Question",Question.class);
			List<Question> li = qu.list();
			for(Question q: li) {
				System.out.println(q.getQuestion());
			
			Query<Answer> ans = ses.createQuery("from Answer",Answer.class);
			List<Answer> li1=ans.list();
			for(Answer a : li1) {
				System.out.println(a.getAnswername());
			}
			}
			tr.commit();
			ses.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
