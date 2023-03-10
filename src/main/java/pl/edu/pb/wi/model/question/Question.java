package pl.edu.pb.wi.model.question;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.edu.pb.wi.model.Prototype;

@Getter
@NoArgsConstructor
public abstract class Question implements Prototype {
    protected QuestionType questionType;
    protected String content;
    protected boolean pointAwarded;
    protected boolean cloned=false;

    public String getContent() {
        return content;
    }

    public Question(String content,
                    QuestionType questionType) {
        this.content = content;
        this.questionType=questionType;
        this.pointAwarded=false;
    }

    public abstract boolean checkAnswer(Object givenAnswer);

    @Override
    public abstract Prototype clone();
}
