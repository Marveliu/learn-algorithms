import java.util.*;

public class Solution {

    class context {
        strategy s;

        context(strategy _s) {
            this.s = _s;
        }

        public int algorithm() {
            return s.algorithm();
        }
    }

    interface strategy {
        int algorithm();
    }

    class s1 implements strategy {
        public int algorithm() {
            // do somehting
            return 1;
        }
    }

    class s2 implements strategy {
        public int algorithm() {
            // do somehting
            return 2;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // s1 st1 = s.new s1();
        s2 st2 = s.new s2();
        context c = s.new context(st2);
        System.out.println(c.algorithm());
    }
}
