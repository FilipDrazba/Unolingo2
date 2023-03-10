package pl.edu.pb.wi.view;

import pl.edu.pb.wi.model.question.ClosedQuestion;
import pl.edu.pb.wi.model.question.Question;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;

import static pl.edu.pb.wi.shared.Static.FONT;
import static pl.edu.pb.wi.shared.Static.FONT_SIZE;

public class ClosedQuestionView extends JPanel {
    JLabel questionContent;

    public ClosedQuestionView(List<Question> closedQuestions) {
        super();
        Iterator<Question> iterator = closedQuestions.iterator();
        update((ClosedQuestion) iterator.next());
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> new ClosedQuestionView(closedQuestions));
        add(nextButton);
    }

    public void update(ClosedQuestion closedQuestion) {
        setLayout(new GridLayout(closedQuestion.getAnswers().size() + 2, 1, 10, 10));

        questionContent = new JLabel(closedQuestion.getContent());
        questionContent.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        add(questionContent);

        List<String> answers = closedQuestion.getAnswers();
        for (int i = 0; i < answers.size(); i++) {
            JRadioButton button = new JRadioButton("%s. %s".formatted((char) (65 + i), answers.get(i)));
            button.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
            add(button);
        }

        setVisible(true);
    }
}
