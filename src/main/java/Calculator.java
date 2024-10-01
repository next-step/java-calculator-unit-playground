public class Calculator {
  int sum(int a, int b) {return a + b;}
  int sum(double a, double b) {return (int) (a + b);}

  int sub(int a, int b) {return a - b;}
  int sub(double a, double b) {return (int) (a - b);}

  int mul(int a, int b) {return a * b;}
  int mul(double a, double b) {return (int) (a * b);}

  int div(int a, int b) {return a / b;}
  int div(double a, double b) {return (int) (a / b);}
}