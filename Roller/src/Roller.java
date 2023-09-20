import javax.xml.transform.Result;

public class Roller {
    private int Sum; // Cent!
    private int Div;
    public Roller(double CNY, int Div) {
        double Cent = CNY * 100;
        if (Math.floor(Cent) != Cent) throw new AssertionError("CNY should only have 2 digits after point");
        if (Math.floor(Cent) < Div) throw new AssertionError("CNY should not be smaller than Div");
        this.Sum = (int)Cent;
        this.Div = Div;
    }
    public double Roll() {
        if(this.Div == 0) return 0;
        int Result = (int)(Math.random() * this.Sum / this.Div) + 1;
        this.Sum -= Result;
        this.Div -= 1;
        return Result / 100.0;
    }

    public double[] RollAll() {
        double[] ResultArr = new double[this.Div];
        while(this.Div != 0) {
            ResultArr[ResultArr.length - this.Div] = Roll();
        }
        return ResultArr;
    }
}
