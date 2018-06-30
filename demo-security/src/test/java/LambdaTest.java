import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类名称：LambdaTest<br>
 * 类描述：<br>
 * 创建时间：2018年05月17日<br>
 *
 * @author 陈超
 * @version 1.0.0
 */
public class LambdaTest {
    public static void main(String[] args){
        //new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!")).start();
        /*List<Integer> alist = Arrays.asList(1,2,5,10,8,3,7,9);
        eval(alist,s->s>9);
        List<String> str = new ArrayList<>();
        str.add("hello");
        str.add("world");
        str.stream().filter(s -> {//惰性求值
            System.out.println(s);
            return s.equals("hello");
        }).count();//及早求值
        List<String> s = Stream.of("a","b","c").collect(Collectors.toList());
        System.out.println(s);
        System.out.println(Stream.of(1,2,3).reduce(0,(acc,element)->acc+element));*/
        String str = "aAsdKa97aKUI0ioQAZ";
        System.out.println(str.chars().filter(Character::isUpperCase).count());
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate){
        for(Integer n: list) {

            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }
}
