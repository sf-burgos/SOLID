import java.util.List;

public class AreaCalculator {

  private double computeAreaCalculator (List<Rectangule> rectangles) {
    return rectangles.stream().mapToDouble(rectangle -> rectangle.getHeight()*rectangle.getWidth().doubleValue()).sum();
  }
}
