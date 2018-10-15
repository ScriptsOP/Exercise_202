
package bl;

import java.util.Comparator;

public class SortByFrequenz implements Comparator<Sender> {

    @Override
    public int compare(Sender o1, Sender o2) {
        if(o1.getFrequenz()<o2.getFrequenz()){
            return -1;
        }else if(o1.getFrequenz()>o2.getFrequenz()){
            return 1;
        }
        return 0;
    }
    
}
