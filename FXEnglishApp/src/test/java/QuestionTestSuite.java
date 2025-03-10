/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.lqm.pojo.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import com.lqm.services.QuestionsServices;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author admin
 */
public class QuestionTestSuite {
    @Test
    public void test() throws SQLException {
        QuestionsServices s = new QuestionsServices();
        try {
                    List<Question> questions = s.getQuestions(2);
        Assertions.assertEquals(questions.size(), 2);
        questions.forEach(s1 -> System.out.println(s1));
        }catch (SQLException ex) {
            Logger.getLogger(QuestionTestSuite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
