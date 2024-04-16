import java.util.ArrayList;

public class GradeList {
  private ArrayList<Float> grades;
  GradeList() {
    this.grades = new ArrayList<>();
  }
  public void addGrade(Float grade) {
    this.grades.add(grade);
  }
  public Float avgGrade() {
    float sum = 0;
    for (float grade : this.grades) {
      sum += grade;
    }
    return sum / this.grades.size();
  }
  public Float printMaxGrade() {
    if (this.grades.size() == 0) {
      return Float.NaN;
    } else {
      float max = grades.get(0);
      for (float grade : this.grades) {
        if (grade > max) {
          max = grade;
        }
      }
      return max;
    }
  }
  public Float printMinGrade() {
    if (this.grades.size() == 0) {
      return Float.NaN;
    } else {
      float min = grades.get(0);
      for (float grade : this.grades) {
        if (grade < min) {
          min = grade;
        }
      }
      return min;
    }
  }
}
