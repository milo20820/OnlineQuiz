/*
 * Question.java
 * 
 * All Rights Reserved 
 * Copyright (c) 2020 FPT University
 */
package model;


public class Question {
    /** Store id */
    private int id;
    /** Store question name */
    private String q_name;
    /** Store date created */
    private String date_created;
    /** Store the answer1, answer2, answer 3, answer 4 */
    private String ans_1, ans_2, ans_3, ans_4;
    /** Store true answer */
    private String true_ans;
    /** Store author */
    private String author;
    /** Store score */
    private int score;

    /**
     * Constructor.<br>
     */
    public Question() {
    }

    /**
     * Constructor.<br>
     * 
     * @param q_name
     * @param date_created
     * @param ans_1
     * @param ans_2
     * @param ans_3
     * @param ans_4
     * @param true_ans
     * @param author 
     */
    public Question(String q_name, String date_created, String ans_1, String ans_2, String ans_3, String ans_4, String true_ans, String author) {
        this.q_name = q_name;
        this.date_created = date_created;
        this.ans_1 = ans_1;
        this.ans_2 = ans_2;
        this.ans_3 = ans_3;
        this.ans_4 = ans_4;
        this.true_ans = true_ans;
        this.author = author;
    }
    
    /**
     * Constructor.<br>
     * 
     * @param id
     * @param q_name
     * @param date_created
     * @param ans_1
     * @param ans_2
     * @param ans_3
     * @param ans_4
     * @param true_ans
     * @param author 
     */
    public Question(int id, String q_name, String date_created, String ans_1, String ans_2, String ans_3, String ans_4, String true_ans, String author) {
        this.score = 0;
        this.id = id;
        this.q_name = q_name;
        this.date_created = date_created;
        this.ans_1 = ans_1;
        this.ans_2 = ans_2;
        this.ans_3 = ans_3;
        this.ans_4 = ans_4;
        this.true_ans = true_ans;
        this.author = author;
    }
    
    /**
     * setScore.<br>
     * 
     * @param score 
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    /**
     * getScore.<br>
     * 
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * setId.<br>
     * 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getId.<br>
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * getQ_name.<br>
     * 
     * @return the q name
     */
    public String getQ_name() {
        return q_name;
    }
    
    /**
     * setQ_name.<br>
     * 
     * @param q_name 
     */
    public void setQ_name(String q_name) {
        this.q_name = q_name;
    }

    /**
     * getDate_created.<br>
     * 
     * @return the date created
     */
    public String getDate_created() {
        return date_created;
    }

    /**
     * getAns_1.<br>
     * 
     * @return the answer 1
     */
    public String getAns_1() {
        return ans_1;
    }

    /**
     * getAns_2.<br>
     * 
     * @return the answer 2
     */
    public String getAns_2() {
        return ans_2;
    }

    /**
     * getAns_3.<br>
     * 
     * @return the answer 3
     */
    public String getAns_3() {
        return ans_3;
    }

    /**
     * getAns_4.<br>
     * 
     * @return the answer 4
     */
    public String getAns_4() {
        return ans_4;
    }

    /**
     * getTrue_ans.<br>
     * 
     * @return the true answer
     */
    public String getTrue_ans() {
        return true_ans;
    }

    /**
     * getAuthor.<br>
     * 
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * setDate_created.<br>
     * 
     * @param date_created 
     */
    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    /**
     * setAns_1.<br>
     * 
     * @param ans_1 
     */
    public void setAns_1(String ans_1) {
        this.ans_1 = ans_1;
    }

    /**
     * setAns_2.<br>
     * 
     * @param ans_2 
     */
    public void setAns_2(String ans_2) {
        this.ans_2 = ans_2;
    }

    /**
     * setAns_3.<br>
     * 
     * @param ans_3 
     */
    public void setAns_3(String ans_3) {
        this.ans_3 = ans_3;
    }

    /**
     * setAns_4.<br>
     * 
     * @param ans_4 
     */
    public void setAns_4(String ans_4) {
        this.ans_4 = ans_4;
    }

    /**
     * setTrue_ans.<br>
     * 
     * @param true_ans 
     */
    public void setTrue_ans(String true_ans) {
        this.true_ans = true_ans;
    }

    /**
     * setAuthor.<br>
     * 
     * @param author 
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    

    
}
