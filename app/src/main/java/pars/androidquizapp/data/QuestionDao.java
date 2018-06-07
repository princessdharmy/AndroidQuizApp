package pars.androidquizapp.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;


@Dao
public interface QuestionDao {

    @Insert(onConflict = REPLACE)
    long insert(Question question);

    @Query("SELECT * FROM questions_table")
    List<Question> getAllQuestions();

    @Query("SELECT * FROM questions_table WHERE questionCategory = :questionCategory")
    List<Question> queryQuestion(String questionCategory);

    @Query("SELECT * FROM questions_table WHERE id = :id")
    Question queryQuestion(long id);

    @Update
    void updateQuestion(Question question);

    @Delete
    void deleteQuestion(Question question);

}
