package com.application.booktravel.model;


public class MyBook_model {

private Integer mybookid;

private Integer userid;

private String collection;

private String reading;

private String readed;

private String toevaluate;

public MyBook_model()
{}

public MyBook_model(Integer userid,String collection,String reading,String readed ,String toevaluate)
{
	this.userid = userid;
	this.collection = collection;
	this.reading = reading;
	this.readed = readed;
	this.toevaluate = toevaluate;
}

public Integer getMyBookid() {
	return this.mybookid;
}

public void setMyBookid(Integer userid) {
	this.mybookid = mybookid;
}

public Integer getUserid() {
	return this.userid;
}

public void setUserid(Integer userid) {
	this.userid = userid;
}

public String getCollection() {
	return this.collection;
}

public void setCollection(String collection) {
	this.collection = collection;
}

public String getReading() {
	return this.reading;
}

public void setReading(String reading) {
	this.reading = reading;
}

public String getReaded() {
	return this.readed;
}

public void setReaded(String readed) {
	this.readed = readed;
}

public String getToEvaluate() {
	return this.toevaluate;
}

public void setToEvaluate(String toevaluate) {
	this.toevaluate = toevaluate;
}
@Override
public String toString() {
	return "MyBook [mybookid="+mybookid+",userid=" + userid + ",collection="+collection+",reading="+reading+",readed="+readed+",toevaluate="+toevaluate+"]";
}
}

