/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lqm.services;

import com.lqm.pojo.Choice;
import com.lqm.pojo.JdbcUtils;
import com.lqm.pojo.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionsServices {
    public List<Question> getQuestions(int limit) throws SQLException {
        List<Question> result = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()){
            String sql = "SELECT * FROM Question ORDER BY rand() LIMIT ?";
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setInt(1, limit);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id"));
                
                result.add(q);
            }
        }
        
        return result;
    }
    
    public List<Choice> getChoices(String question_id) throws SQLException {
        List<Choice> result = new ArrayList<>();
        try (Connection conn = JdbcUtils.getConn()){
            String sql = "SELECT * FROM Choice WHERE question_id = ?";
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, question_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Choice c = new Choice(rs.getString("id"), rs.getString("content"), rs.getBoolean("is_correct"), rs.getString("question_id"));
                
                result.add(c);
            }
        }
        
        return result;
    }
}
