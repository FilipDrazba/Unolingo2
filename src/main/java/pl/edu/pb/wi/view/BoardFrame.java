package pl.edu.pb.wi.view;

import pl.edu.pb.wi.model.Level;
import pl.edu.pb.wi.model.creator.ClosedQuestionFactory;
import pl.edu.pb.wi.model.creator.OpenQuestionFactory;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import static pl.edu.pb.wi.shared.Static.FONT;
import static pl.edu.pb.wi.shared.Static.FONT_SIZE;

public class BoardFrame extends MyJFrame {

    private JLabel jLabel;
    JLabel amountOfPointsText;
    double amountOfPoints = 0d;
    int fileCount;

    public BoardFrame(Integer amountOfDifficultyLevels,
                      Integer amountOfLevelsInEachDifficultyLevel) {
        super();
        File directory = new File("C:\\Users\\fdraz\\Repositories\\Unolingo");
        try {
            fileCount = directory.list().length - 6;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JPanel jPanel = new JPanel();
        amountOfPointsText = new JLabel();
        setAmountOfPointsText(amountOfPoints);
        amountOfPointsText.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
        jPanel.add(amountOfPointsText);
        add(jPanel);

        setLayout(new GridLayout(5,
                fileCount / 2, 10, 10));
        for (int i = 1; i <= amountOfDifficultyLevels; i++) {
            jLabel = new JLabel("Poziom trudności %d:".formatted(i));
            jLabel.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
            add(jLabel);
            JPanel jPanel2 = new JPanel();
            for (int j = 1; j <= fileCount / 2; j++) {
                JButton button = new JButton("%d.%d".formatted(i, j));
                button.setFont(new Font(FONT, Font.PLAIN, FONT_SIZE));
                jPanel2.add(button);

                button.addActionListener(e -> {
                    String key = button.getText();
                    Level level;
                    switch (key.substring(0, 1)) {
                        case "1":
                            level = new Level(key, ClosedQuestionFactory.getInstance(key));
                            new ClosedQuestionFrame(this, level.getQuestions(), 0);
                            break;

                        case "2":
                            level = new Level(key, OpenQuestionFactory.getInstance(key));
                            new OpenQuestionFrame(this, level.getQuestions(), 0);
                            break;
                    }
                });
            }
//            jPanel2.setBackground(Color.lightGray);
            add(jPanel2);
        }

        setVisible(true);
    }

    private void setAmountOfPointsText(double amountOfPoints) {
        amountOfPointsText.setText("Ilość punktów: " + amountOfPoints + " / " + fileCount * 5);
    }

    public void addAmountOfPoints(double thatAmountOfPoints) {
        this.amountOfPoints += thatAmountOfPoints;
        setAmountOfPointsText(amountOfPoints);
    }
}
