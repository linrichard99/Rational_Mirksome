/* RICHARD KIM - Richard Lin, Sungbin Kim
   APCS1 pd10
   HW33 -- Do you even add, bruh?
   2015-11-18 */

public class Rational {
   
    private int numer;
    private int denom;

    // Default Setting
    public Rational() {
	numer = 0;
	denom = 1;
    }

    public Rational(int n, int d) {
	this();
	// denominator cannot be zero
	if (d == 0) {
	    System.out.println("Invalid. Setting to 0/1");
	}
	else {
	    numer=n;
	    denom=d;
	}
    }

    public String toString() {
	return numer + "/" + denom;
    }

    // returns the most precise float version of the rational
    public double floatValue() {
	return ((double)numer)/denom;
    }

    //The next four are kind of self explanatory.
    public void multiply(Rational factor) {
	numer *= factor.numer;
	denom *= factor.denom;
    }

    public void divide(Rational factor) {
	denom *= factor.numer;
	numer *= factor.denom;
    }

    public void add(Rational factor) {
	numer = numer*factor.denom + denom*factor.numer;
	denom *= factor.denom;
    }
	
    public void subtract(Rational factor) {
	numer = numer*factor.denom - denom*factor.numer;
	denom *= factor.denom;
    }

    //We kind of did part of Phase 3 before Phase 2, in that we implemented a static gcd method. But this gcd method doesn't take parameters. Objects can call it to get the gcd between their numerator and denominator. 
    public int gcd() {
	int gcdVal = 0;
	
	if (numer > denom) {
	    gcdVal = gcd(numer, denom);
	}
	else {
	    gcdVal = gcd(denom, numer);
	}      
	
	return gcdVal;
    }

    //It divides the numerator and denominator by the gcd. 
    public void reduce() {
	int gcdVal = gcd();
	numer /= gcdVal;
	denom /= gcdVal;
    }

    //This is the static version of the gcd. It's just Euclid's algo.
    public static int gcd(int p, int q) {
        while (q != 0) {
	    int temp = q;
	    q = p % q;
	    p = temp;
	}
	return Math.abs(p);
    }

    // Instead of using LCD to compare, this method simply utilizes floatValue() to compare float values of the rationals.
    public int compareTo(Rational factor) {
	if(floatValue() == factor.floatValue()) {
	    return 0;
	}
	else if(floatValue() > factor.floatValue()) {
	    return 1;
	}
	else {
	    return -1;
	}
    }   

    public static void main(String[] args) {
	Rational r = new Rational (2,3);
	Rational s = new Rational (1,2);
	Rational t = new Rational (4,0);

	System.out.println("Testing floatValue()");
	System.out.println("s: " + s.floatValue());
	System.out.println("r: " + r.floatValue());

	System.out.println("Testing toString()");
	System.out.println("s:" + s);
	System.out.println("r:" + r);
	System.out.println("t:" + t);

	System.out.println("Testing multiply()");
	r.multiply(s);
	System.out.println("s:" + s);
	System.out.println("r:" + r);

	System.out.println("Testing divide()");
	r.divide(s);
	System.out.println("s:" + s);
	System.out.println("r:" + r);

	System.out.println("Testing add()");
	r.add(s);
	System.out.println("s:" + s);
	System.out.println("r:" + r);

	System.out.println("Testing subtract()");
	r.subtract(s);
	System.out.println("s:" + s);
	System.out.println("r:" + r);

	System.out.println("Testing reduce()");
	r.reduce();
	s.reduce();
	System.out.println("s:" + s);
	System.out.println("r:" + r);

	System.out.println("Testing compareTo()");
	System.out.println("r.compareTo(s): " + r.compareTo(s));
	System.out.println("s.compareTo(r): " + s.compareTo(r));
	System.out.println("t.compareTo(r): " + t.compareTo(r));
	System.out.println("r.compareTo(r): " + r.compareTo(r));	
    }


}
	
	
    
