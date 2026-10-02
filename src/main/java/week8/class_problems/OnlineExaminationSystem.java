package main.java.week8.class_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Question {
    private String id;
    private String prompt;
    private int points;

    public Question(String id, String prompt, int points) {
        this.id = id;
        this.prompt = prompt;
        this.points = points;
    }

    public String getId() { return id; }
    public String getPrompt() { return prompt; }
    public int getPoints() { return points; }

    public abstract boolean evaluate(String answer);
}

class MultipleChoiceQuestion extends Question {
    private String correctOption;

    public MultipleChoiceQuestion(String id, String prompt, int points, String correctOption) {
        super(id, prompt, points);
        this.correctOption = correctOption;
    }

    @Override
    public boolean evaluate(String answer) {
        return correctOption.equalsIgnoreCase(answer);
    }
}

class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    public TrueFalseQuestion(String id, String prompt, int points, boolean correctAnswer) {
        super(id, prompt, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public boolean evaluate(String answer) {
        return String.valueOf(correctAnswer).equalsIgnoreCase(answer);
    }
}

class Examination {
    private String examId;
    private String title;
    private List<Question> questions = new ArrayList<>();

    public Examination(String examId, String title) {
        this.examId = examId;
        this.title = title;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public String getTitle() { return title; }
    public List<Question> getQuestions() { return questions; }

    public int getTotalPossibleScore() {
        int total = 0;
        for (Question q : questions) {
            total += q.getPoints();
        }
        return total;
    }
}

class Student {
    private String id;
    private String name;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() { return name; }
}

class Attempt {
    private Student student;
    private Examination exam;
    private Map<Question, String> answers = new HashMap<>();
    private boolean submitted = false;

    public Attempt(Student student, Examination exam) {
        this.student = student;
        this.exam = exam;
        System.out.println(exam.getTitle() + " started by " + student.getName() + ".");
    }

    public void recordAnswer(Question question, String answer) {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }
        answers.put(question, answer);
        System.out.println("Answer recorded for Question " + question.getId() + ".");
    }

    public void submit() {
        if (submitted) {
            System.out.println("Cannot change answers for a submitted examination.");
            return;
        }
        submitted = true;
        System.out.println(exam.getTitle() + " submitted by " + student.getName() + ".");

        int totalScore = 0;
        StringBuilder resultLog = new StringBuilder("Result: ");
        int count = 0;

        for (Question q : exam.getQuestions()) {
            String ans = answers.get(q);
            boolean isCorrect = ans != null && q.evaluate(ans);
            int earned = isCorrect ? q.getPoints() : 0;
            totalScore += earned;

            if (count > 0) resultLog.append(", ");
            resultLog.append("Question ").append(q.getId()).append(": ")
                     .append(isCorrect ? "Correct (" + earned + " points)" : "Incorrect (0 points)");
            count++;
        }
        System.out.println(resultLog.toString() + ". Total score: " + totalScore + "/" + exam.getTotalPossibleScore() + ".");
    }
}

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        Student student1 = new Student("S1", "Student 1");
        Examination examA = new Examination("E101", "Exam A");

        Question q1 = new MultipleChoiceQuestion("1", "MCQ Prompt", 5, "C");
        Question q2 = new TrueFalseQuestion("2", "TF Prompt", 5, false);
        examA.addQuestion(q1);
        examA.addQuestion(q2);

        Attempt attempt = new Attempt(student1, examA);
        attempt.recordAnswer(q1, "C");
        attempt.recordAnswer(q2, "True");
        attempt.submit();
        attempt.recordAnswer(q1, "A");
    }
}