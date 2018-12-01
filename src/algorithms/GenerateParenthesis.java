package algorithms;

import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        generateParenthesis(n, 0, 0, "", result);
        return result;
    }

    private void generateParenthesis(int n, int nleft, int nright, String current, List<String> result) {
        if (nleft != n) {
            if (nleft == nright) {
                //can only add '(
                generateParenthesis(n, nleft + 1, nright, current + '(', result);
            } else if (nleft > nright) {
                //can add either '(' or ')'
                generateParenthesis(n, nleft + 1, nright, current + '(', result);
                generateParenthesis(n, nleft, nright + 1, current + ')', result);
            }
        } else {
            //can only add ')'
            while (nright < nleft) {
                current += ')';
                nright += 1;
            }
            result.add(current);
        }
    }

    public static void main(String args[]) {
        GenerateParenthesis g = new GenerateParenthesis();
        System.out.println(g.generateParenthesis(4));
    }
}
