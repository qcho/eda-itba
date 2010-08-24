package lab.util;

import java.math.BigInteger;

public interface SystematicGenerator {

    public void reset();

    public BigInteger getTotal();

    public BigInteger getNumLeft();

    public boolean hasMore();

    public int[] getNext();
    
}
