package vn.edu.ptit;

import java.util.ArrayList;

public class Invoice {
	private Rule rule;
	private Student st;
	private ArrayList<Subject> alSubject;
	private double amount;
	
	public Invoice(Rule rule) {
		super();
		setRule(rule);
	}

	public Rule getRule() {
		return rule;
	}
	public void setRule(Rule rule) {
		this.rule = rule;
	}
	public Student getSt() {
		return st;
	}
	public void setSt(Student student) {
		this.st = student;
	}
	public ArrayList<Subject> getAlSubject() {
		return alSubject;
	}
	public void setAlSubject(ArrayList<Subject> alSubject) {
		this.alSubject = alSubject;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
