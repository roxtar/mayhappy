public class Series {
    public static void main(String[] args) {
	    new Ser().run();
    }
}

class Ser {


	public int setsize;

	// Declare class data.

	public int array_rows;
	public double [:rank==2] testArray;  // Array of arrays.

	/**
	 * buildTestData.
	 * Instantiate array(s) to hold fourier coefficients.
	 */

	public void setSize(int setsize) {
		this.setsize = setsize;
	}

	public void initialise(int n) {
		array_rows = n;
		this.buildTestData();
	}

	public void kernel() {
		this.Do();
	}

    public void initRefArray(double [:rank==2] ref)
    {
           ref[0, 0] = 2.8729524964837996;
           ref[0, 1] = 0.0; 
           ref[1, 0] = 1.1161046676147888;
           ref[1, 1] = -1.8819691893398025;
           ref[2, 0] = 0.34429060398168704;
           ref[2, 1] = -1.1645642623320958;
           ref[3, 0] =  0.15238898702519288;
           ref[3, 1] = -0.8143461113044298;
    }

	public void validate() {

        final region(:rank==2) r = [0:3, 0:1];
        final dist (:rank==2) vd =  r->here; 
	    final double [:rank==2]  ref = new double[vd] (point(:rank==2) [p0]) { 
            return 0.0; 
        };
                           
        this.initRefArray(ref);

        for (point (:rank==2) [i, j] : vd)
        {
            final int ii = i;
            final int jj = j;
            double cval = 0 ;

            final place curr_place = here; 

            final region(:rank==1) tempr = [0:0];
            final dist (:rank==1) tempvd =  tempr->here; 
            final double [:rank==1]  tempref = new double[tempvd] (point(:rank==1) [p0]) { 
                return 0.0;
            };

            final dist(:rank==2) di = testArray.distribution;
            finish async (di[j, i])
            {
                final double temp = testArray[jj, ii];
                async ( curr_place ) 
                {
                    tempref[0] = temp;
                }
            }
            
            cval = tempref[0];
             
            double error = Math.abs(cval - ref[i, j]);
            if (error > 1.0e-12) {
                System.out.println("Validation failed for coefficient " + j);
                System.out.println("and for " + i);
                System.out.println("Computed value = " + cval);
                System.out.println("Reference value = " + ref[i, j]);
                throw new RuntimeException("Validation failed");
            }
        }
    }

	public void tidyup() {
		this.freeTestData();
	}

	public void run() {
		//JGFInstrumentor.addTimer("Section2:Series:Kernel", "coefficients", setsize);
        final region(:rank==1) tempregion = [0:0];
        final dist(:rank==1) tempdist = tempregion->here;
        int j = 10000;
        for (point (:rank==1) [i] : tempdist) 
        {
            
            this.setSize(i);
            final double xx = Math.pow(100,i);
            double aux = j*xx;
            final int ii = (int)aux;
            this.initialise(ii);
            this.kernel();
            this.validate();
        }
        this.tidyup();

		//JGFInstrumentor.addOpsToTimer("Section2:Series:Kernel", (double) (array_rows * 2 - 1));
		//JGFInstrumentor.printTimer("Section2:Series:Kernel");
	}

	public void buildTestData()
	{
		// Allocate appropriate length for the double array of doubles.
		final region (:rank==2) R = [0:1,0:array_rows-1];
        final dist (:rank==2) d = (dist (:rank==2))dist.factory.block(R);
		testArray = (double [:rank==2])new double [d];
	}

	/**
	 * Do.
	 *
	 * This consists of calculating the
	 * first n pairs of fourier coefficients of the function (x+1)^x on
	 * the interval 0,2. n is given by array_rows, the array setsize.
	 * NOTE: The # of integration steps is fixed at 1000.
	 */
	public void Do()
	{
		// Start the stopwatch.
		// JGFInstrumentor.startTimer("Section2:Series:Kernel");
		// Calculate the fourier series. Begin by calculating A[0].

                final double a1 = (double)0.0;
                final double a2 = (double)2.0;
                final double re = this.TrapezoidIntegrate(a1, // Lower bound.
                                a2,            // Upper bound.
                                1000,                    // # of steps.
                                a1,            // No omega*n needed.
                                0);
		testArray[0,0] = re / (double)2.0;       // 0 = term A[0].

		// Calculate the fundamental frequency.
		// (2 * pi) / period...and since the period
		// is 2, omega is simply pi.

		final double omega = (double) 3.1415926535897932;
		final dist(:rank==1) U = (dist (:rank==1))dist.UNIQUE;
		finish {
			for (point(:rank==1) [p]: U) {
                          final dist(:rank==1) dU = (dist(:rank==1)) U.distribution;
                          async(dU[p]) {
                           
				int ilow = 0;

                                final place pl = U[p];
				if (pl.isFirst()) {
					ilow = 1;
				} else {
					ilow = 0;
				}
                                final dist(:rank==2) dd = testArray.distribution;
                                final dist(:rank==2) rr = dd|here;
				for (point (:rank==2) [n,i] : rr) {
					if (i > ilow-1) {

						// Calculate A[i] terms. Note, once again, that we
						// can ignore the 2/period term outside the integral
						// since the period is 2 and the term cancels itself
						// out.
						if (n == 0) {
							testArray[0,i] = this.TrapezoidIntegrate((double)0.0,
									(double)2.0,
									1000,
									omega * (double)i,
									1);                       // 1 = cosine term.
						} else {
							// Calculate the B[i] terms.

							testArray[n,i] = this.TrapezoidIntegrate((double)0.0,
									(double)2.0,
									1000,
									omega * (double)i,
									2);                       // 2 = sine term.
						}
					}
				}
			}
                    }
		}

		//JGFInstrumentor.stopTimer("Section2:Series:Kernel");
	}

	/**
	 * TrapezoidIntegrate.
	 *
	 * Perform a simple trapezoid integration on the function (x+1)**x.
	 * x0,x1 set the lower and upper bounds of the integration.
	 * nsteps indicates # of trapezoidal sections.
	 * omegan is the fundamental frequency times the series member #.
	 * select = 0 for the A[0] term, 1 for cosine terms, and 2 for
	 * sine terms. Returns the value.
	 */
	public double TrapezoidIntegrate (double x0,     // Lower bound.
									   double x1,     // Upper bound.
									   int nsteps,    // # of steps.
									   double omegan, // omega * n.
									   int select)    // Term type.
	{
		double x = 0.0;               // Independent variable.
		double dx = 0.0;              // Step setsize.
		double rvalue = 0.0;          // Return value.

		// Initialize independent variable.

		x = x0;

		// Calculate stepsetsize.

                double aux = x1 - x0;
		dx = aux / (double)nsteps;

		// Initialize the return value.

                final double dd = this.thefunction(x0, omegan, select);
		rvalue = dd / (double)2.0;

		// Compute the other terms of the integral.

		if (nsteps != 1)
		{
			//--nsteps;               // Already done 1 step.
			nsteps = nsteps - 1;               // Already done 1 step.
			while (nsteps-1 > 0)
			{
				x = x + dx;
                                final double ddd = this.thefunction(x, omegan, select);
				rvalue = rvalue + ddd;
                                nsteps = nsteps - 1;
			}
		}

		// Finish computation.

                final double d1 = this.thefunction(x1, omegan, select);
                final double d2 = d1 / (double)2.0;
		double aux2 = rvalue + d2;
		rvalue =  aux2 * dx;
		return rvalue;
	}

	/**
	 * thefunction.
	 *
	 * This routine selects the function to be used in the Trapezoid
	 * integration. x is the independent variable, omegan is omega * n,
	 * and select chooses which of the sine/cosine functions
	 * are used. Note the special case for select = 0.
	 */
	public double thefunction(double x,      // Independent variable.
							   double omegan, // Omega * term.
							   int select)    // Choose type.
	{
		// Use select to pick which function we call.

		if   (select==0) {
                     return Math.pow(x+(double)1.0, x);
                }
                else {
                  if (select==1) {
                     double temp0 = x+(double)1.0;
                     double temp1 = Math.pow(temp0, x);
                     double temp2 = Math.cos(omegan*x);
                     return temp1 * temp2;
                  }
                  else { // (select==2)
                     double temp0 = x+(double)1.0;
                     double temp1 = Math.pow(temp0, x);
                     double temp2 = Math.sin(omegan*x);
                     return temp1 * temp2;
                  }
                }
	}

	/**
	 * freeTestData
	 *
	 * Nulls array that is created with every run and forces garbage
	 * collection to free up memory.
	 */
	public void freeTestData()
	{
        //testArray = null;
		//testArray = (double [:rank==2])null;    // Destroy the array.
        //final region(:rank==2) r1 = [0:3, 0:1];
        //final dist (:rank==2) vd1 =  r1->here; 
        //testArray = new double [vd1] (point (:rank==2) p) {
        //    return 0.0;
        //};
		//System.gc();         // Force garbage collection.
	}
}

