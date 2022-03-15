package forAjob;

import java.io.Serializable;

public final class Test  implements Comparable,CharSequence, Serializable {
    private final char value[];
    private final int hash;

    public Test() {
        value = "".toCharArray();
        hash = 0;
    }
    public Test(Test test) {
        value = test.value;
        hash = test.hash;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object instanceof Test) {
            Test str = (Test) object;
            int n = this.value.length;
            if (n == str.value.length) {
                char[] v1 = this.value;
                char[] v2 = str.value;
                int i = 0;
                while (n-- != 0) {
                    if(v1[i]!=v2[i]){
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    public  int hashCode(){
        int h=hash;
        if (h == 0 && value.length > 0) {
            char[] val = value;
            for (int i = 0; i < value.length; i++) {
                h=31*h+val[i];
            }
            return h;
        }
        return h;

    }

    public int length() {
        return 0;
    }

    public char charAt(int index) {
        return 0;
    }

    public CharSequence subSequence(int start, int end) {
        return null;
    }

    public int compareTo(Object o) {
        return 0;
    }
}
